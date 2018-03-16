package com.zhss.eshop.schedule.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;
import com.zhss.eshop.schedule.mapper.ScheduleGoodsAllocationStockMapper;

/**
 * 货位库存管理dao组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ScheduleGoodsAllocationStockDAOImpl implements ScheduleGoodsAllocationStockDAO {
	
	/**
	 * 货位库存管理mapper组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockMapper goodsAllocationStockMapper;
	
	/**
	 * 根据商品sku id查询货位库存
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 */
	public ScheduleGoodsAllocationStockDO getBySkuId(Long goodsAllocationId, Long goodsSkuId) {
		return goodsAllocationStockMapper.getBySkuId(goodsAllocationId, goodsSkuId);
	}
	
	/**
	 * 新增货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	public void save(ScheduleGoodsAllocationStockDO goodsAllocationStock) {
		goodsAllocationStockMapper.save(goodsAllocationStock); 
	}
	
	/**
	 * 更新货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	public void update(ScheduleGoodsAllocationStockDO goodsAllocationStock) {
		goodsAllocationStockMapper.update(goodsAllocationStock); 
	}

}
