package com.zhss.eshop.Inventory.dao;

import com.zhss.eshop.Inventory.domain.GoodsStockDO;

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
	GoodsStockDO getGoodsStockBySkuId(Long goodsSkuId);
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	Boolean saveGoodsStock(GoodsStockDO goodsStockDO);
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	Boolean updateGoodsStock(GoodsStockDO goodsStockDO);
	
}
