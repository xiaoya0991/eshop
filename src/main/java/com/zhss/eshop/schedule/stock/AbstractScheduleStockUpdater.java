package com.zhss.eshop.schedule.stock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.ScheduleGoodsStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsStockDO;

/**
 * 库存更新组件的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractScheduleStockUpdater implements ScheduleStockUpdater {
	
	private static final Logger logger = LoggerFactory.getLogger(
			AbstractScheduleStockUpdater.class);
	
	/**
	 * 商品库存
	 */
	protected List<ScheduleGoodsStockDO> goodsStocks;
	/**
	 * 货位库存
	 */
	protected List<ScheduleGoodsAllocationStockDO> goodsAllocationStocks;
	/**
	 * 商品库存管理DAO组件
	 */
	protected ScheduleGoodsStockDAO goodsStockDAO;
	/**
	 * 货位库存管理DAO组件
	 */
	protected ScheduleGoodsAllocationStockDAO goodsAllocationStockDAO;
	
	/**
	 * 日期辅助组件
	 */
	protected DateProvider dateProvider;
	
	public AbstractScheduleStockUpdater(
			List<ScheduleGoodsStockDO> goodsStocks,
			List<ScheduleGoodsAllocationStockDO> goodsAllocationStocks,
			ScheduleGoodsStockDAO goodsStockDAO,
			ScheduleGoodsAllocationStockDAO goodsAllocationStockDAO,
			DateProvider dateProvider) {
		this.goodsStocks = goodsStocks;
		this.goodsAllocationStocks = goodsAllocationStocks;
		this.goodsStockDAO = goodsStockDAO;
		this.goodsAllocationStockDAO = goodsAllocationStockDAO;
	}
	
	/**
	 * 更新商品库存
	 */
	public Boolean update() {
		try {
			updateGoodsAvailableStockQuantity();
			updateGoodsLockedStockQuantity();
			updateGoodsOutputStockQuantity();
			updateGoodsAllocationAvailableStockQuantity();
			updateGoodsAllocationLockedStockQuantity();
			updateGoodsAllocationOutputStockQuantity();
			updateGmtModified();
			executeUpdateStock();
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return true;
	}
	
	/**
	 * 更新商品的销售库存
	 */
	protected abstract void updateGoodsAvailableStockQuantity() throws Exception;
	
	/**
	 * 更新商品的锁定库存
	 */
	protected abstract void updateGoodsLockedStockQuantity() throws Exception;
	
	/**
	 * 更新商品的已销售库存
	 */
	protected abstract void updateGoodsOutputStockQuantity() throws Exception;
	
	/**
	 * 更新商品的销售库存
	 */
	protected abstract void updateGoodsAllocationAvailableStockQuantity() throws Exception;
	
	/**
	 * 更新商品的锁定库存
	 */
	protected abstract void updateGoodsAllocationLockedStockQuantity() throws Exception;
	
	/**
	 * 更新商品的已销售库存
	 */
	protected abstract void updateGoodsAllocationOutputStockQuantity() throws Exception;
	
	/**
	 * 设置库存的修改时间
	 */
	private void updateGmtModified() throws Exception {
		for(ScheduleGoodsStockDO goodsStock : goodsStocks) {
			goodsStock.setGmtModified(dateProvider.getCurrentTime());
		}
		for(ScheduleGoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			goodsAllocationStock.setGmtModified(dateProvider.getCurrentTime());
		}
	}
	
	/**
	 * 实际执行更新库存操作
	 * @throws Exception
	 */
	private void executeUpdateStock() throws Exception {
		for(ScheduleGoodsStockDO goodsStock : goodsStocks) {
			goodsStockDAO.update(goodsStock);
		}
		for(ScheduleGoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			goodsAllocationStockDAO.update(goodsAllocationStock);
		}
	}
	
}
