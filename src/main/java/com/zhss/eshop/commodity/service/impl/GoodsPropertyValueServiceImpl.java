package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.GoodsPropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDTO;
import com.zhss.eshop.commodity.service.GoodsPropertyValueService;
import com.zhss.eshop.common.util.ObjectUtils;

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
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 */
	public List<GoodsPropertyValueDTO> listByGoodsId(Long goodsId) throws Exception {
		return ObjectUtils.convertList(propertyValueDAO.listByGoodsId(goodsId), 
				GoodsPropertyValueDTO.class);
	}
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	public void batchSave(List<GoodsPropertyValueDTO> propertyValues) throws Exception {
		for(GoodsPropertyValueDTO propertyValue : propertyValues) {
			propertyValueDAO.save(propertyValue.clone(GoodsPropertyValueDO.class));   
		}
	}
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 */
	public void removeByGoodsId(Long goodsId) throws Exception {
		propertyValueDAO.removeByGoodsId(goodsId); 
	}
	
}
