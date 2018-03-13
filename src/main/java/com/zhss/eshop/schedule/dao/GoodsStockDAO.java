package com.zhss.eshop.schedule.dao;

import com.zhss.eshop.schedule.domain.GoodsStockDO;

/**
 * 商品库存管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsStockDAO {

	/**
	 * 根据商品sku id查询商品库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存
	 */
	GoodsStockDO getBySkuId(Long goodsSkuId);
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	void save(GoodsStockDO goodsStock);
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	void update(GoodsStockDO goodsStock);
	
}
