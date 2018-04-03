package com.zhss.eshop.schedule.stock;

/**
 * 库存更新组件的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractScheduleStockUpdater implements ScheduleStockUpdater {
	
	/**
	 * 更新商品库存
	 */ 
	@Override
	public Boolean update() throws Exception {
		updateGoodsStock();
		updateGoodsAllocationStock();
		updateGoodsAllocationStockDetail();
		return true;
	}
	
	/**
	 * 更新商品库存
	 * @throws Exception
	 */
	protected abstract void updateGoodsStock() throws Exception;
	
	/**
	 * 更新货位库存
	 * @throws Exception
	 */
	protected abstract void updateGoodsAllocationStock() throws Exception;
	
	/**
	 * 更新货位库存明细
	 * @throws Exception
	 */
	protected abstract void updateGoodsAllocationStockDetail() throws Exception;
	
}
