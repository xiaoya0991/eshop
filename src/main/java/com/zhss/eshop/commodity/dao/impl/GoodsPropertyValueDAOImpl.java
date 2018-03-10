package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsPropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;
import com.zhss.eshop.commodity.mapper.GoodsPropertyValueMapper;

/**
 * 商品属性值管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsPropertyValueDAOImpl implements GoodsPropertyValueDAO {

	/**
	 * 商品属性值管理mapper组件
	 */
	@Autowired
	private GoodsPropertyValueMapper goodsPropertyValueMapper;
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	public void save(GoodsPropertyValueDO goodsPropertyValue) {
		goodsPropertyValueMapper.save(goodsPropertyValue);
	}
	
}
