package com.zhss.eshop.schedule.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDetailDAO;
import com.zhss.eshop.schedule.dao.ScheduleGoodsStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDetailDO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsStockDO;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;

/**
 * 退货入库
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsInputScheduleStockUpdater extends AbstractScheduleStockUpdater {

	/**
	 * 采购入库单
	 */
	private PurchaseInputOrderDTO purchaseInputOrder;
	
	/**
	 * 商品库存管理的DAO组件
	 */
	@Autowired
	private ScheduleGoodsStockDAO goodsStockDAO;
	/**
	 * 货位库存管理的DAO组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockDAO goodsAllocationStockDAO;
	/**
	 * 货位库存明细管理的DAO组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockDetailDAO stockDetailDAO;
	
	/**
	 * 更新商品库存
	 */
	@Override
	protected void updateGoodsStock() throws Exception {
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItems = 
				purchaseInputOrder.getItems();
		for(PurchaseInputOrderItemDTO purchaseInputOrderItem : purchaseInputOrderItems) {
			ScheduleGoodsStockDO goodsStock = goodsStockDAO.getBySkuId(
					purchaseInputOrderItem.getGoodsSkuId());
			goodsStock.setAvailableStockQuantity(goodsStock.getAvailableStockQuantity()
					+ purchaseInputOrderItem.getArrivalCount()); 
			goodsStock.setOutputStockQuantity(goodsStock.getOutputStockQuantity()
					- purchaseInputOrderItem.getArrivalCount());
			goodsStockDAO.update(goodsStock); 
		}
	}

	/**
	 * 更新货位库存
	 */
	@Override
	protected void updateGoodsAllocationStock() throws Exception {
		List<PurchaseInputOrderItemDTO> items = purchaseInputOrder.getItems();
		
		for(PurchaseInputOrderItemDTO item : items) {
			List<PurchaseInputOrderPutOnItemDTO> putOnItems = item.getPutOnItemDTOs();
			
			for(PurchaseInputOrderPutOnItemDTO putOnItem : putOnItems) {
				ScheduleGoodsAllocationStockDO goodsAllocationStock = goodsAllocationStockDAO.getBySkuId(
						putOnItem.getGoodsAllocationId(), putOnItem.getGoodsSkuId());
				goodsAllocationStock.setAvailableStockQuantity(goodsAllocationStock.getAvailableStockQuantity() 
						+ putOnItem.getPutOnShelvesCount());
				goodsAllocationStock.setOutputStockQuantity(goodsAllocationStock.getOutputStockQuantity()
						- putOnItem.getPutOnShelvesCount()); 
				goodsAllocationStockDAO.update(goodsAllocationStock); 
			}
		}
	}
	
	/**
	 * 更新货位库存明细
	 */
	@Override
	protected void updateGoodsAllocationStockDetail() throws Exception {
		List<PurchaseInputOrderItemDTO> items = purchaseInputOrder.getItems();
		
		for(PurchaseInputOrderItemDTO item : items) {
			List<GoodsAllocationStockDetailDTO> stockDetails = item.getStockDetails();
			for(GoodsAllocationStockDetailDTO stockDetail : stockDetails) {
				stockDetailDAO.save(stockDetail.clone(ScheduleGoodsAllocationStockDetailDO.class));  
			}
		}
 	}
	
	/**
	 * 设置需要的参数
	 */
	@Override
	public void setParameter(Object parameter) {
		this.purchaseInputOrder = (PurchaseInputOrderDTO) parameter;
	}
	
}
