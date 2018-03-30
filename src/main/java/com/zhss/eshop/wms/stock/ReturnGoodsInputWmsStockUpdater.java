package com.zhss.eshop.wms.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.dao.GoodsAllocationStockDetailDAO;
import com.zhss.eshop.wms.dao.WmsGoodsAllocationStockDAO;
import com.zhss.eshop.wms.dao.WmsGoodsStockDAO;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDO;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.WmsGoodsAllocationStockDO;
import com.zhss.eshop.wms.domain.WmsGoodsStockDO;

/**
 * 退货入库库存更新组件
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype") 
public class ReturnGoodsInputWmsStockUpdater extends AbstractWmsStockUpdater {

	/**
	 * 退货入库单
	 */
	private ReturnGoodsInputOrderDTO returnGoodsInputOrder;
	/**
	 * 商品库存管理的DAO组件
	 */
	@Autowired
	private WmsGoodsStockDAO goodsStockDAO;
	/**
	 * 货位库存管理的DAO组件
	 */
	@Autowired
	private WmsGoodsAllocationStockDAO goodsAllocationStockDAO;
	/**
	 * 货位库存明细管理的DAO组件
	 */
	@Autowired
	private GoodsAllocationStockDetailDAO stockDetailDAO;
	
	/**
	 * 更新商品库存
	 */
	@Override
	protected void updateGoodsStock() throws Exception {
		List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItems = 
				returnGoodsInputOrder.getItems();
		
		for(ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItem : returnGoodsInputOrderItems) {
			WmsGoodsStockDO goodsStock = goodsStockDAO.getBySkuId(
					returnGoodsInputOrderItem.getGoodsSkuId());
			
			Long availableStockQuantity = goodsStock.getAvailableStockQuantity() 
					+ returnGoodsInputOrderItem.getArrivalCount();
			goodsStock.setAvailableStockQuantity(availableStockQuantity); 
			
			Long outputStockQuantity = goodsStock.getOutputStockQuantity()
					- returnGoodsInputOrderItem.getArrivalCount();
			goodsStock.setOutputStockQuantity(outputStockQuantity);
			
			goodsStockDAO.update(goodsStock); 
		}
	}

	/**
	 * 更新货位库存
	 */
	@Override
	protected void updateGoodsAllocationStock() throws Exception {
		List<ReturnGoodsInputOrderItemDTO> items = returnGoodsInputOrder.getItems();
		
		for(ReturnGoodsInputOrderItemDTO item : items) {
			List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems = item.getPutOnItems();
			
			for(ReturnGoodsInputOrderPutOnItemDTO putOnItem : putOnItems) {
				WmsGoodsAllocationStockDO goodsAllocationStock = goodsAllocationStockDAO
						.getBySkuId(putOnItem.getGoodsAllocationId(), putOnItem.getGoodsSkuId());
				
				Long availableStockQuantity = goodsAllocationStock.getAvailableStockQuantity() 
						+ putOnItem.getPutOnShelvesCount();
				goodsAllocationStock.setAvailableStockQuantity(availableStockQuantity);
				
				Long outputStockQuantity = goodsAllocationStock.getOutputStockQuantity() 
						- putOnItem.getPutOnShelvesCount();
				goodsAllocationStock.setOutputStockQuantity(outputStockQuantity); 
				
				goodsAllocationStockDAO.update(goodsAllocationStock); 
			}
		}
	}
	
	/**
	 * 更新货位库存明细
	 */
	@Override
	protected void updateGoodsAllocationStockDetail() throws Exception {
		List<ReturnGoodsInputOrderItemDTO> items = returnGoodsInputOrder.getItems();
		
		for(ReturnGoodsInputOrderItemDTO item : items) {
			List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems = item.getPutOnItems();
			List<GoodsAllocationStockDetailDO> stockDetails = new ArrayList<GoodsAllocationStockDetailDO>();
			
			for(ReturnGoodsInputOrderPutOnItemDTO putOnItem : putOnItems) {
				GoodsAllocationStockDetailDO stockDetail = new GoodsAllocationStockDetailDO();
				stockDetail.setGoodsAllocationId(putOnItem.getGoodsAllocationId());
				stockDetail.setGoodsSkuId(putOnItem.getGoodsSkuId()); 
				stockDetail.setPutOnQuantity(putOnItem.getPutOnShelvesCount()); 
				stockDetail.setPutOnTime(putOnItem.getGmtCreate());  
				stockDetail.setCurrentStockQuantity(stockDetail.getPutOnQuantity()); 
				stockDetail.setLockedStockQuantity(0L); 
				
				stockDetailDAO.save(stockDetail); 
				
				stockDetails.add(stockDetail);
			} 
			
			item.setStockDetails(ObjectUtils.convertList(stockDetails, 
					GoodsAllocationStockDetailDTO.class));  
		}
 	}
	
	/**
	 * 设置需要的参数
	 */
	@Override
	public void setParameter(Object parameter) {
		this.returnGoodsInputOrder = (ReturnGoodsInputOrderDTO) parameter;
	}

}
