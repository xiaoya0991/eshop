package com.zhss.eshop.schedule.stock;

import java.util.List;
import java.util.Map;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.GoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.GoodsStockDAO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockId;
import com.zhss.eshop.schedule.domain.GoodsStockDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;

/**
 * 退货入库
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsInputStockUpdater extends AbstractStockUpdater {

	/**
	 * 采购入库单条目DTO集合
	 */
	private Map<Long, PurchaseInputOrderItemDTO> itemMap;
	/**
	 * 采购入库单条目DTO集合
	 */
	private Map<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO> putOnItemMap;
	
	/**
	 * 构造函数
	 * @param goodsStockDO 商品库存DO对象
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	public ReturnGoodsInputStockUpdater(
			List<GoodsStockDO> goodsStocks, 
			List<GoodsAllocationStockDO> goodsAllocationStocks,
			GoodsStockDAO goodsStockDAO,
			GoodsAllocationStockDAO goodsAllocationStockDAO,
			DateProvider dateProvider,
			Map<Long, PurchaseInputOrderItemDTO> itemMap,
			Map<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO> putOnItemMap) {
		super(goodsStocks, goodsAllocationStocks, 
				goodsStockDAO, goodsAllocationStockDAO, dateProvider);
		this.itemMap = itemMap;
		this.putOnItemMap = putOnItemMap;
	}

	@Override
	protected void updateGoodsAvailableStockQuantity() throws Exception {
		for(GoodsStockDO goodsStock : goodsStocks) {
			PurchaseInputOrderItemDTO item = itemMap.get(goodsStock.getGoodsSkuId());
			goodsStock.setAvailableStockQuantity(goodsStock.getAvailableStockQuantity()
					+ item.getArrivalCount()); 
		}
	}

	@Override
	protected void updateGoodsLockedStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsOutputStockQuantity() throws Exception {
		for(GoodsStockDO goodsStock : goodsStocks) {
			PurchaseInputOrderItemDTO item = itemMap.get(goodsStock.getGoodsSkuId());
			goodsStock.setOutputStockQuantity(goodsStock.getOutputStockQuantity()
					- item.getArrivalCount());  
		}
	}

	@Override
	protected void updateGoodsAllocationAvailableStockQuantity() throws Exception {
		for(GoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			PurchaseInputOrderPutOnItemDTO putOnItem = putOnItemMap.get(new GoodsAllocationStockId(
					goodsAllocationStock.getGoodsAllocationId(),
					goodsAllocationStock.getGoodsSkuId()));
			goodsAllocationStock.setAvailableStockQuantity(goodsAllocationStock.getAvailableStockQuantity()
					+ putOnItem.getPutOnShelvesCount()); 
		}
	}

	@Override
	protected void updateGoodsAllocationLockedStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsAllocationOutputStockQuantity() throws Exception {
		for(GoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			PurchaseInputOrderPutOnItemDTO putOnItem = putOnItemMap.get(new GoodsAllocationStockId(
					goodsAllocationStock.getGoodsAllocationId(),
					goodsAllocationStock.getGoodsSkuId()));
			goodsAllocationStock.setOutputStockQuantity(goodsAllocationStock.getOutputStockQuantity()
					- putOnItem.getPutOnShelvesCount()); 
		}
	}

}
