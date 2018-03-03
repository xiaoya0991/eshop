package com.zhss.eshop.commodity.dao;

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
	
}
