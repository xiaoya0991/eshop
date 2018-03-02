package com.zhss.eshop.Inventory.updater;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.Inventory.constant.StockStatus;
import com.zhss.eshop.Inventory.dao.GoodsStockDAO;
import com.zhss.eshop.Inventory.domain.GoodsStockDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品库存更新命令的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractGoodsStockUpdater implements GoodsStockUpdater {

	private static final Logger logger = LoggerFactory.getLogger(
			AbstractGoodsStockUpdater.class);
	
	/**
	 * 商品库存DO对象
	 */
	protected List<GoodsStockDO> goodsStockDOs;
	
	/**
	 * 商品库存管理模块的DAD组件
	 */
	protected GoodsStockDAO goodsStockDAO;
	
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
	public AbstractGoodsStockUpdater(
			List<GoodsStockDO> goodsStockDOs,
			GoodsStockDAO goodsStockDAO,
			DateProvider dateProvider) {
		this.goodsStockDOs = goodsStockDOs;
		this.goodsStockDAO = goodsStockDAO;
		this.dateProvider = dateProvider;
	}
	
	/**
	 * 更新商品库存
	 */
	public Boolean updateGoodsStock() {
		try {
			updateSaleStockQuantity();
			updateLockedStockQuantity();
			updateSaledStockQuantity();
			updateStockStatus();
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
	protected abstract void updateSaleStockQuantity() throws Exception;
	
	/**
	 * 更新商品的锁定库存
	 */
	protected abstract void updateLockedStockQuantity() throws Exception;
	
	/**
	 * 更新商品的已销售库存
	 */
	protected abstract void updateSaledStockQuantity() throws Exception;
	
	/**
	 * 更新商品的库存状态
	 */
	private void updateStockStatus() throws Exception {
		for(GoodsStockDO goodsStockDO : goodsStockDOs) {
			if(goodsStockDO.getSaleStockQuantity() > 0L) {
				goodsStockDO.setStockStatus(StockStatus.IN_STOCK); 
			} else {
				goodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK); 
			}
		}
	}
	
	/**
	 * 更新商品库存的修改时间
	 */
	private void updateGmtModified() throws Exception {
		for(GoodsStockDO goodsStockDO : goodsStockDOs) {
			goodsStockDO.setGmtModified(dateProvider.getCurrentTime());
		}
	}
	
	/**
	 * 实际执行更新商品库存的操作
	 * @throws Exception
	 */
	private void executeUpdateGoodsStock() throws Exception {
		for(GoodsStockDO goodsStockDO : goodsStockDOs) {
			goodsStockDAO.updateGoodsStock(goodsStockDO);
		}
	}
	
}
