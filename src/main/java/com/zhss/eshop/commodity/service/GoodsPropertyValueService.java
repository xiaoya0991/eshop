package com.zhss.eshop.commodity.service;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDTO;

/**
 * 商品属性值管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsPropertyValueService {

	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	void batchSave(List<GoodsPropertyValueDTO> propertyValues) throws Exception;
	
}
