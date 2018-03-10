package com.zhss.eshop.commodity.dao;

import java.util.List;

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
	Boolean save(CategoryPropertyRelationshipDO relation) throws Exception;
	
	/**
	 * 根据类目id查询类目与属性的关联关系
	 * @param categoryId 类目id
	 * @return 类目与属性的关联关系
	 */
	List<CategoryPropertyRelationshipDO> listByCategoryId(Long categoryId) throws Exception;
	
	/**
	 * 根据类目id查询类目与属性的关联关系
	 * @param categoryId 类目id
	 * @return 类目与属性的关联关系
	 */
	CategoryPropertyRelationshipDO getById(Long id);
	
	/**
	 * 根据类目id删除类目与属性的关联关系
	 * @param categoryId 类目id
	 */
	void removeByCategoryId(Long categoryId) throws Exception;
	
}
