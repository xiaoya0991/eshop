package com.zhss.eshop.schedule.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	private ScheduleGoodsStockMapper goodsStockMapper;
	
	/**
	 * 根据商品sku id查询商品库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存
	 */
	public ScheduleGoodsStockDO getBySkuId(Long goodsSkuId) {
		return goodsStockMapper.getBySkuId(goodsSkuId) ;
	}
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	public void save(ScheduleGoodsStockDO goodsStock) {
		goodsStockMapper.save(goodsStock); 
	}
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	public void update(ScheduleGoodsStockDO goodsStock) {
		goodsStockMapper.update(goodsStock); 
	}

}
