package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;

/**
 * 商品sku属性值管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface GoodsSkuSalePropertyValueDAO {
	
	/**
	 * 根据商品sku id查询属性值
	 * @param goodsSkuId 商品sku id
	 * @return 属性值
	 */
	List<GoodsSkuSalePropertyValueDO> listByGoodsSkuId(Long goodsSkuId);

	/**
	 * 新增商品sku销售属性值
	 * @param propertyValue 商品sku销售属性值
	 */
	void save(GoodsSkuSalePropertyValueDO propertyValue);
	
	/**
	 * 根据商品sku id删除属性值
	 * @param goodsSkuId 商品sku id
	 */
	void removeByGoodsSkuId(Long goodsSkuId);
	
}
