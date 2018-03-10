package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;

/**
 * 商品sku属性值管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface GoodsSkuSalePropertyValueDAO {

	/**
	 * 新增商品sku销售属性值
	 * @param propertyValue 商品sku销售属性值
	 */
	void save(GoodsSkuSalePropertyValueDO propertyValue);
	
}
