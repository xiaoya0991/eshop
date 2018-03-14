package com.zhss.eshop.schedule.stock;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.GoodsAllocationStockDAO;
import com.zhss.eshop.schedule.dao.GoodsStockDAO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockId;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;
import com.zhss.eshop.schedule.domain.GoodsStockDO;

/**
 * 库存更新组件工厂的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractStockUpdaterFactory<T> 
		implements StockUpdaterFactory<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(
			AbstractStockUpdaterFactory.class);

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
	
	public AbstractStockUpdaterFactory(
			GoodsStockDAO goodsStockDAO,
			DateProvider dateProvider,
			GoodsAllocationStockDAO goodsAllocationStockDAO) {
		this.goodsStockDAO = goodsStockDAO;
		this.goodsAllocationStockDAO = goodsAllocationStockDAO;
		this.dateProvider = dateProvider;
	}
	
	/**
	 * 创建库存更新命令
	 */
	public StockUpdater create(T parameter) {
		try {
			List<Long> goodsSkuIds = getGoodsSkuIds(parameter);
			List<GoodsStockDO> goodsStockDOs = getGoodsStocks(goodsSkuIds);
			List<GoodsAllocationStockId> goodsAllocationSkuIds = getGoodsAllocationSkuIds(parameter);
			List<GoodsAllocationStockDO> goodsAllocationStocks = getGoodsAllocationStocks(
					goodsAllocationSkuIds);
			return create(goodsStockDOs, goodsAllocationStocks, parameter); 
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
	 * 创建商品库存DO对象集合
	 * @param goodsSkuIds 商品sku id集合
	 * @return 商品库存DO对象集合
	 */
	private List<GoodsStockDO> getGoodsStocks(List<Long> goodsSkuIds) throws Exception {
		List<GoodsStockDO> goodsStocks = new ArrayList<GoodsStockDO>(goodsSkuIds.size());
		
		for(Long goodsSkuId : goodsSkuIds) {
			GoodsStockDO goodsStock = goodsStockDAO.getBySkuId(goodsSkuId);
			if(goodsStock == null) {
				goodsStock = createGoodsStock(goodsSkuId);
 			}
			goodsStocks.add(goodsStock);
		}
		
		return goodsStocks;
	}
	
	/**
	 * 获取货位库存id集合
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	protected abstract List<GoodsAllocationStockId> getGoodsAllocationSkuIds(
			T parameter) throws Exception;
	
	/**
	 * 创建货位库存
	 * @param goodsAllocationSkuIds
	 * @return
	 * @throws Exception
	 */
	private List<GoodsAllocationStockDO> getGoodsAllocationStocks(
			List<GoodsAllocationStockId> goodsAllocationSkuIds) throws Exception { 
		List<GoodsAllocationStockDO> goodsAllocationStocks = 
				new ArrayList<GoodsAllocationStockDO>(goodsAllocationSkuIds.size());
		
		for(GoodsAllocationStockId goodsAllocationSkuId : goodsAllocationSkuIds) {
			GoodsAllocationStockDO goodsAllocationStock = goodsAllocationStockDAO.getBySkuId(
					goodsAllocationSkuId.getGoodsAllocationId(), goodsAllocationSkuId.getGoodsSkuId());
			if(goodsAllocationStock == null) {
				goodsAllocationStock = createGoodsAllocationStock(
						goodsAllocationSkuId.getGoodsAllocationId(),
						goodsAllocationSkuId.getGoodsSkuId()); 
 			}
			goodsAllocationStocks.add(goodsAllocationStock);
		}
		
		return goodsAllocationStocks;
	}
	
	/**
	 * 创建商品库存DO对象
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存DO对象
	 * @throws Exception
	 */
	private GoodsStockDO createGoodsStock(Long goodsSkuId) throws Exception {
		GoodsStockDO goodsStockDO = new GoodsStockDO();
		goodsStockDO.setGoodsSkuId(goodsSkuId);
		goodsStockDO.setAvailableStockQuantity(0L);
		goodsStockDO.setLockedStockQuantity(0L); 
		goodsStockDO.setOutputStockQuantity(0L);
		goodsStockDO.setGmtCreate(dateProvider.getCurrentTime());
		goodsStockDO.setGmtModified(dateProvider.getCurrentTime());  
		
		goodsStockDAO.save(goodsStockDO);
		
		return goodsStockDO;
	}
	
	/**
	 * 创建商品库存DO对象
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存DO对象
	 * @throws Exception
	 */
	private GoodsAllocationStockDO createGoodsAllocationStock(Long goodsAllocationId, 
			Long goodsSkuId) throws Exception {
		GoodsAllocationStockDO goodsAllocationStockDO = new GoodsAllocationStockDO();
		goodsAllocationStockDO.setGoodsAllocationId(goodsAllocationId); 
		goodsAllocationStockDO.setGoodsSkuId(goodsSkuId);
		goodsAllocationStockDO.setAvailableStockQuantity(0L);
		goodsAllocationStockDO.setLockedStockQuantity(0L); 
		goodsAllocationStockDO.setOutputStockQuantity(0L);
		goodsAllocationStockDO.setGmtCreate(dateProvider.getCurrentTime());
		goodsAllocationStockDO.setGmtModified(dateProvider.getCurrentTime());  
		
		goodsAllocationStockDAO.save(goodsAllocationStockDO);
		
		return goodsAllocationStockDO;
	}
	
	/**
	 * 创建库存更新命令
	 * @param goodsStockDOs 商品库存DO对象集合
	 * @return 库存更新命令
	 * @throws Exception
	 */
	protected abstract StockUpdater create(
			List<GoodsStockDO> goodsStockDOs, 
			List<GoodsAllocationStockDO> goodsAllocationStocks,
			T parameter) throws Exception;
	
}
