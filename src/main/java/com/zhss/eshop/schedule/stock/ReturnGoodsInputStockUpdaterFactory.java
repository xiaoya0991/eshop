package com.zhss.eshop.schedule.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.GoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.GoodsStockDAO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockId;
import com.zhss.eshop.schedule.domain.GoodsStockDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;

/**
 * 退货入库库存更新命令的工厂
 * @author zhonghuashishan
 *
 */
@Component
public class ReturnGoodsInputStockUpdaterFactory<T> 
		extends AbstractStockUpdaterFactory<T> {
	
	/**
	 * 构造函数
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	@Autowired
	public ReturnGoodsInputStockUpdaterFactory(
			GoodsStockDAO goodsStockDAO, 
			GoodsAllocationStockDAO goodsAllocationStockDAO,
			DateProvider dateProvider) {
		super(goodsStockDAO, dateProvider, goodsAllocationStockDAO);
	}

	/**
	 * 获取商品sku id集合
	 * @return 商品sku id集合
	 * @throws Exception
	 */
	@Override
	protected List<Long> getGoodsSkuIds(T parameter) throws Exception {		
		ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO = (ReturnGoodsInputOrderDTO) parameter;
		List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItemDTOs = 
				returnGoodsInputOrderDTO.getItems();
		
		if(returnGoodsInputOrderItemDTOs == null || returnGoodsInputOrderItemDTOs.size() == 0) {
			return new ArrayList<Long>();
		}
		
		List<Long> goodsSkuIds = new ArrayList<Long>(returnGoodsInputOrderItemDTOs.size());
		
		for(ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItemDTO : returnGoodsInputOrderItemDTOs) {
			goodsSkuIds.add(returnGoodsInputOrderItemDTO.getGoodsSkuId());
		}
		
		return goodsSkuIds;
	}
	
	@Override
	protected List<GoodsAllocationStockId> getGoodsAllocationSkuIds(T parameter) throws Exception {
		PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs = 
				purchaseInputOrderDTO.getItems();
		
		if(purchaseInputOrderItemDTOs == null || purchaseInputOrderItemDTOs.size() == 0) {
			return new ArrayList<GoodsAllocationStockId>();
		}
		
		List<GoodsAllocationStockId> goodsSkuIds = new ArrayList<GoodsAllocationStockId>(purchaseInputOrderItemDTOs.size());
		
		for(PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : purchaseInputOrderItemDTOs) {
			for(PurchaseInputOrderPutOnItemDTO putOnItem : purchaseInputOrderItemDTO.getPutOnItemDTOs()) {
				goodsSkuIds.add(new GoodsAllocationStockId(
						putOnItem.getGoodsAllocationId(), putOnItem.getGoodsSkuId())); 
			}
		}
		
		return goodsSkuIds;
	}

	/**
	 * 创建库存更新命令
	 * @param goodsStockDOs 商品库存DO对象集合
	 * @return 库存更新命令
	 * @throws Exception
	 */
	@Override
	protected StockUpdater create(
			List<GoodsStockDO> goodsStockDOs,
			List<GoodsAllocationStockDO> goodsAllocationStocks,
			T parameter) throws Exception {
		PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs = 
				purchaseInputOrderDTO.getItems();
		
		Map<Long, PurchaseInputOrderItemDTO> itemMap = 
				new HashMap<Long, PurchaseInputOrderItemDTO>();
		Map<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO> putOnItemMap = 
				new HashMap<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO>();
		
		if(purchaseInputOrderItemDTOs != null && purchaseInputOrderItemDTOs.size() > 0) {
			for(PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : purchaseInputOrderItemDTOs) {
				itemMap.put(purchaseInputOrderItemDTO.getGoodsSkuId(), purchaseInputOrderItemDTO);
				
				for(PurchaseInputOrderPutOnItemDTO putOnItem : purchaseInputOrderItemDTO.getPutOnItemDTOs()) { 
					putOnItemMap.put(new GoodsAllocationStockId(
							putOnItem.getGoodsAllocationId(), putOnItem.getGoodsSkuId()), putOnItem);
				}
			}
		}
		
		return new PurchaseInputStockUpdater(goodsStockDOs, goodsAllocationStocks, 
				goodsStockDAO, goodsAllocationStockDAO, dateProvider, itemMap, putOnItemMap);
	}

}
