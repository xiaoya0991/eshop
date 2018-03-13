package com.zhss.eshop.schedule.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.schedule.dao.GoodsAllocationStockDAO;
import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;
import com.zhss.eshop.schedule.mapper.GoodsAllocationStockMapper;

/**
 * 货位库存管理dao组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsAllocationStockDAOImpl implements GoodsAllocationStockDAO {
	
	/**
	 * 货位库存管理mapper组件
	 */
	@Autowired
	private GoodsAllocationStockMapper goodsAllocationStockMapper;
	
	/**
	 * 根据商品sku id查询货位库存
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 */
	public GoodsAllocationStockDO getBySkuId(Long goodsAllocationId, Long goodsSkuId) {
		return goodsAllocationStockMapper.getBySkuId(goodsAllocationId, goodsSkuId);
	}
	
	/**
	 * 新增货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	public void save(GoodsAllocationStockDO goodsAllocationStock) {
		goodsAllocationStockMapper.save(goodsAllocationStock); 
	}
	
	/**
	 * 更新货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	public void update(GoodsAllocationStockDO goodsAllocationStock) {
		goodsAllocationStockMapper.update(goodsAllocationStock); 
	}

}
