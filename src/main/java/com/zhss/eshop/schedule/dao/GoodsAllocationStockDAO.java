package com.zhss.eshop.schedule.dao;

import com.zhss.eshop.schedule.domain.GoodsAllocationStockDO;

/**
 * 货位库存管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsAllocationStockDAO {

	/**
	 * 根据商品sku id查询货位库存
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 */
	GoodsAllocationStockDO getBySkuId(Long goodsAllocationId, Long goodsSkuId);
	
	/**
	 * 新增货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	void save(GoodsAllocationStockDO goodsAllocationStock);
	
	/**
	 * 更新货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	void update(GoodsAllocationStockDO goodsAllocationStock);
	
}
