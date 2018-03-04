package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;

/**
 * 属性分组与属性关系管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PropertyGroupRelationshipDAO {

	/**
	 * 新增属性分组与属性关系
	 * @param relation 属性分组与属性关系
	 */
	Boolean save(PropertyGroupRelationshipDO relation);
	
	/**
	 * 根据属性分组id查询属性分组与属性的关联关系
	 * @param propertyGroupId 属性分组id
	 * @return 属性分组与属性的关联关系
	 */
	List<PropertyGroupRelationshipDO> listByPropertyGroupId(Long propertyGroupId);
	
}
