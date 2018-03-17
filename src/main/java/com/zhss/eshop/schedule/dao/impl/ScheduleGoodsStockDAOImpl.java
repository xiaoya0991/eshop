package com.zhss.eshop.schedule.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.ScheduleGoodsStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsStockDO;
import com.zhss.eshop.schedule.mapper.ScheduleGoodsStockMapper;

/**
 * 商品库存管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ScheduleGoodsStockDAOImpl implements ScheduleGoodsStockDAO {
	
	/**
	 * 商品库存管理mapper组件
	 */
	@Autowired
	private ScheduleGoodsStockMapper stockMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 根据商品sku id查询商品库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存
	 */
	public ScheduleGoodsStockDO getBySkuId(Long goodsSkuId) throws Exception {
		ScheduleGoodsStockDO goodsStock = stockMapper.getBySkuId(goodsSkuId) ;
		
		if(goodsStock == null) {
			goodsStock = new ScheduleGoodsStockDO();
			goodsStock.setGoodsSkuId(goodsSkuId); 
			goodsStock.setAvailableStockQuantity(0L); 
			goodsStock.setLockedStockQuantity(0L); 
			goodsStock.setOutputStockQuantity(0L); 
			save(goodsStock);  
		}
		
		return goodsStock;
	}
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	public void save(ScheduleGoodsStockDO goodsStock) throws Exception {
		goodsStock.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsStock.setGmtModified(dateProvider.getCurrentTime()); 
		stockMapper.save(goodsStock); 
	}
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	public void update(ScheduleGoodsStockDO goodsStock) throws Exception {
		goodsStock.setGmtModified(dateProvider.getCurrentTime()); 
		stockMapper.update(goodsStock); 
	}

}
