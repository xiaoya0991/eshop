package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.GoodsPropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDTO;
import com.zhss.eshop.commodity.service.GoodsPropertyValueService;

/**
 * 商品属性值管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsPropertyValueServiceImpl implements GoodsPropertyValueService {

	/**
	 * 商品属性值管理DAO组件
	 */
	@Autowired
	private GoodsPropertyValueDAO propertyValueDAO;
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	public void batchSave(List<GoodsPropertyValueDTO> propertyValues) throws Exception {
		for(GoodsPropertyValueDTO propertyValue : propertyValues) {
			propertyValueDAO.save(propertyValue.clone(GoodsPropertyValueDO.class));   
		}
	}
	
}
