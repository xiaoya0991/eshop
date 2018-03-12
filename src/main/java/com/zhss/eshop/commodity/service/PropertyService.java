package com.zhss.eshop.commodity.service;

import java.util.List;

import com.zhss.eshop.commodity.domain.PropertyDTO;
import com.zhss.eshop.commodity.domain.PropertyQuery;
import com.zhss.eshop.commodity.service.impl.Properties;

/**
 * 商品属性管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface PropertyService {

	/**
	 * 分页查询商品属性
	 * @param propertyQuery 查询条件
	 * @return 商品属性
	 */
	List<PropertyDTO> listPropertiesByPage(PropertyQuery propertyQuery);
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	Boolean saveProperty(PropertyDTO propertyDTO);
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 */
	PropertyDTO getPropertyById(Long id);
	
	/**
	 * 查询类目id对应的所有属性
	 * @param categoryId
	 * @return
	 */
	Properties getPropertiesByCategoryId(Long categoryId) throws Exception;
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	Boolean updateProperty(PropertyDTO propertyDTO);
	
}
