package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;

/**
 * 类目属性关系管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface CategoryPropertyRelationshipDAO {

	/**
	 * 新增类目属性关系
	 * @param relation 类目属性关系
	 */
	Boolean save(CategoryPropertyRelationshipDO relation);
	
}
