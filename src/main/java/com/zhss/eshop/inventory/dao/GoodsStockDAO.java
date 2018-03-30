package com.zhss.eshop.inventory.dao;

import com.zhss.eshop.inventory.domain.GoodsStockDO;

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
	 * @throws Exception
	 */
	GoodsStockDO getGoodsStockBySkuId(Long goodsSkuId) throws Exception;
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 * @throws Exception
	 */
	void saveGoodsStock(GoodsStockDO goodsStockDO) throws Exception;
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 * @throws Exception
	 */
	void updateGoodsStock(GoodsStockDO goodsStockDO) throws Exception;
	
}
