package com.zhss.eshop.Inventory.updater;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.Inventory.constant.StockStatus;
import com.zhss.eshop.Inventory.dao.GoodsStockDAO;
import com.zhss.eshop.Inventory.domain.GoodsStockDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 库存更新命令工厂的父类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractStockUpdaterFactory<T> 
		implements StockUpdaterFactory<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(
			AbstractStockUpdaterFactory.class);

	/**
	 * 商品库存管理模块的DAO组件
	 */
	protected GoodsStockDAO goodsStockDAO;
	
	/**
	 * 日期辅助组件
	 */
	protected DateProvider dateProvider;
	
	/**
	 * 构造函数
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	public AbstractStockUpdaterFactory(
			GoodsStockDAO goodsStockDAO,
			DateProvider dateProvider) {
		this.goodsStockDAO = goodsStockDAO;
		this.dateProvider = dateProvider;
	}
	
	/**
	 * 创建库存更新命令
	 */
	public StockUpdater create(T parameter) {
		try {
			List<Long> goodsSkuIds = getGoodsSkuIds(parameter);
			List<GoodsStockDO> goodsStockDOs = createGoodsStockDOs(goodsSkuIds);
			return create(goodsStockDOs, parameter); 
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
	/**
	 * 获取商品sku id集合
	 * @return 商品sku id集合
	 * @throws Exception
	 */
	protected abstract List<Long> getGoodsSkuIds(T parameter) throws Exception;
	
	/**
	 * 创建库存更新命令
	 * @param goodsStockDOs 商品库存DO对象集合
	 * @return 库存更新命令
	 * @throws Exception
	 */
	protected abstract StockUpdater create(
			List<GoodsStockDO> goodsStockDOs, T parameter) throws Exception;
	
	/**
	 * 创建商品库存DO对象集合
	 * @param goodsSkuIds 商品sku id集合
	 * @return 商品库存DO对象集合
	 */
	private List<GoodsStockDO> createGoodsStockDOs(List<Long> goodsSkuIds) throws Exception {
		List<GoodsStockDO> goodsStockDOs = new ArrayList<GoodsStockDO>(goodsSkuIds.size());
		
		for(Long goodsSkuId : goodsSkuIds) {
			GoodsStockDO goodsStockDO = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId);
			
			if(goodsStockDO == null) {
				goodsStockDO = new GoodsStockDO();
				goodsStockDO.setGoodsSkuId(goodsSkuId);
				goodsStockDO.setSaleStockQuantity(0L);
				goodsStockDO.setLockedStockQuantity(0L); 
				goodsStockDO.setSaledStockQuantity(0L);
				goodsStockDO.setStockStatus(StockStatus.NOT_IN_STOCK); 
				goodsStockDO.setGmtCreate(dateProvider.getCurrentTime());
				goodsStockDO.setGmtModified(dateProvider.getCurrentTime());  
				
				goodsStockDAO.saveGoodsStock(goodsStockDO);
 			}
			
			goodsStockDOs.add(goodsStockDO);
		}
		
		return goodsStockDOs;
	}
	
}
