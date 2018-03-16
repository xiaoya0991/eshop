package com.zhss.eshop.schedule.stock;

import java.util.List;
import java.util.Map;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.ScheduleGoodsStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockId;
import com.zhss.eshop.schedule.domain.ScheduleGoodsStockDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;

/**
 * 采购入库库存更新组件
 * @author zhonghuashishan
 *
 */
public class SubmitOrderScheduleStockUpdater extends AbstractScheduleStockUpdater {

	/**
	 * 采购入库单条目
	 */
	private Map<Long, PurchaseInputOrderItemDTO> itemMap;
	/**
	 * 采购入库单上架条目
	 */
	private Map<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO> putOnItemMap;
	
	public SubmitOrderScheduleStockUpdater(
			List<ScheduleGoodsStockDO> goodsStocks, 
			List<ScheduleGoodsAllocationStockDO> goodsAllocationStocks,
			ScheduleGoodsStockDAO goodsStockDAO,
			ScheduleGoodsAllocationStockDAO goodsAllocationStockDAO,
			DateProvider dateProvider) {
		super(goodsStocks, goodsAllocationStocks, 
				goodsStockDAO, goodsAllocationStockDAO, dateProvider);
	}
	
	@Override
	protected void updateGoodsAvailableStockQuantity() throws Exception {
		for(ScheduleGoodsStockDO goodsStock : goodsStocks) {
			PurchaseInputOrderItemDTO item = itemMap.get(goodsStock.getGoodsSkuId());
			Long availableStockQuantity = goodsStock.getAvailableStockQuantity() 
					+ item.getArrivalCount();
			goodsStock.setAvailableStockQuantity(availableStockQuantity); 
		}
	}

	@Override
	protected void updateGoodsLockedStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsOutputStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsAllocationAvailableStockQuantity() throws Exception {
		for(ScheduleGoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			GoodsAllocationStockId id = new GoodsAllocationStockId(
					goodsAllocationStock.getGoodsAllocationId(), goodsAllocationStock.getGoodsSkuId());
			PurchaseInputOrderPutOnItemDTO putOnItem = putOnItemMap.get(id);
			
			Long availableStockQuantity = goodsAllocationStock.getAvailableStockQuantity() 
					+ putOnItem.getPutOnShelvesCount();
			
			goodsAllocationStock.setAvailableStockQuantity(availableStockQuantity); 
		}
	}
	
	@Override
	protected void updateGoodsAllocationLockedStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsAllocationOutputStockQuantity() throws Exception {
		
	}

	public void setItemMap(Map<Long, PurchaseInputOrderItemDTO> itemMap) {
		this.itemMap = itemMap;
	}
	public void setPutOnItemMap(Map<GoodsAllocationStockId, PurchaseInputOrderPutOnItemDTO> putOnItemMap) {
		this.putOnItemMap = putOnItemMap;
	}

	@Override
	protected void updateGoodsAllocationDetailLockedStockQuantity() throws Exception {
		
	}

	@Override
	protected void updateGoodsAllocationDetailCurrentStockQuantity() throws Exception {
		
	}
	
}
