package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsSkuSalePropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;
import com.zhss.eshop.commodity.mapper.GoodsSkuSalePropertyValueMapper;

/**
 * 商品sku销售属性值管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsSkuSalePropertyValueDAOImpl implements GoodsSkuSalePropertyValueDAO {

	/**
	 * 商品sku销售属性值管理mapper组件
	 */
	@Autowired
	private GoodsSkuSalePropertyValueMapper propertyValueMapper;
	
	/**
	 * 新增商品sku销售属性值
	 * @param propertyValue 商品sku销售属性值
	 */
	public void save(GoodsSkuSalePropertyValueDO propertyValue) {
		propertyValueMapper.save(propertyValue); 
	}
	
}
