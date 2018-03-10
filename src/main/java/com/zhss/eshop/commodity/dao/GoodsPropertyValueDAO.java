package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;

/**
 * 商品属性值管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsPropertyValueDAO {

	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	void save(GoodsPropertyValueDO goodsPropertyValue);
	
}
