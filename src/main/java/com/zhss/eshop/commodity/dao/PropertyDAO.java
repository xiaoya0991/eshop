package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.domain.PropertyQuery;

/**
 * 商品属性管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PropertyDAO {
	
	/**
	 * 分页查询商品属性
	 * @param propertyQuery 查询条件
	 * @return 商品属性
	 */
	List<PropertyDO> listPropertiesByPage(PropertyQuery propertyQuery);
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	Boolean saveProperty(PropertyDO propertyDO);
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 */
	PropertyDO getPropertyById(Long id);
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	Boolean updateProperty(PropertyDO propertyDO);
	
}
