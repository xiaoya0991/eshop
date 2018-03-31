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
	 * @throws Exception
	 */
	List<PropertyDO> listPropertiesByPage(PropertyQuery propertyQuery) throws Exception;
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 * @throws Exception
	 */
	void saveProperty(PropertyDO propertyDO) throws Exception;
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 * @throws Exception
	 */
	PropertyDO getPropertyById(Long id) throws Exception;
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 * @throws Exception
	 */
	void updateProperty(PropertyDO propertyDO) throws Exception;
	
}
