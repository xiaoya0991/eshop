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
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 * @throws Exception
	 */
	List<GoodsPropertyValueDTO> listByGoodsId(Long goodsId) throws Exception;

	/**
	 * 新增商品属性值
	 * @param propertyValues 商品属性值
	 * @throws Exception
	 */
	void batchSave(List<GoodsPropertyValueDTO> propertyValues) throws Exception;
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 * @throws Exception
	 */
	void removeByGoodsId(Long goodsId) throws Exception;
	
}
