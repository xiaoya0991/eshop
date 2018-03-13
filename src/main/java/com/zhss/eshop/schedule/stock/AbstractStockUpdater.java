package com.zhss.eshop.schedule.stock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.GoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.GoodsStockDAO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.GoodsStockDO;

/**
 * 商品库存更新命令的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractStockUpdater implements StockUpdater {
	
	private static final Logger logger = LoggerFactory.getLogger(
			AbstractStockUpdater.class);
	
	/**
	 * 商品库存
	 */
	protected List<GoodsStockDO> goodsStocks;
	
	/**
	 * 货位库存
	 */
	protected List<GoodsAllocationStockDO> goodsAllocationStocks;
	
	/**
	 * 商品库存管理DAO组件
	 */
	protected GoodsStockDAO goodsStockDAO;
	
	/**
	 * 货位库存管理DAO组件
	 */
	protected GoodsAllocationStockDAO goodsAllocationStockDAO;
	
	/**
	 * 日期辅助组件
	 */
	protected DateProvider dateProvider;
	
	/**
	 * 构造函数
	 * @param goodsStockDO 商品库存DO对象
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	public AbstractStockUpdater(
			List<GoodsStockDO> goodsStocks,
			List<GoodsAllocationStockDO> goodsAllocationStocks,
			GoodsStockDAO goodsStockDAO,
			GoodsAllocationStockDAO goodsAllocationStockDAO,
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
			executeUpdateGoodsStock();
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
	 * 更新商品库存的修改时间
	 */
	private void updateGmtModified() throws Exception {
		for(GoodsStockDO goodsStock : goodsStocks) {
			goodsStock.setGmtModified(dateProvider.getCurrentTime());
		}
		for(GoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			goodsAllocationStock.setGmtModified(dateProvider.getCurrentTime());
		}
	}
	
	/**
	 * 实际执行更新商品库存的操作
	 * @throws Exception
	 */
	private void executeUpdateGoodsStock() throws Exception {
		for(GoodsStockDO goodsStock : goodsStocks) {
			goodsStockDAO.update(goodsStock);
		}
		for(GoodsAllocationStockDO goodsAllocationStock : goodsAllocationStocks) {
			goodsAllocationStockDAO.update(goodsAllocationStock);
		}
	}
	
}
