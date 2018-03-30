package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.commodity.mapper.CategoryPropertyRelationshipMapper;

/**
 * 类目属性管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CategoryPropertyRelationshipDAOImpl 
		implements CategoryPropertyRelationshipDAO {
	
	/**
	 * 类目与属性关系管理mapper组件
	 */
	@Autowired
	private CategoryPropertyRelationshipMapper categoryPropertyRelationMapper;
	
	/**
	 * 新增类目属性关系
	 * @param relation 类目属性关系
	 */
	@Override
	public void save(CategoryPropertyRelationshipDO relation) throws Exception {
		categoryPropertyRelationMapper.save(relation); 
	}
	
	/**
	 * 根据类目id查询类目与属性的关联关系
	 * @param categoryId 类目id
	 * @return 类目与属性的关联关系
	 */
	@Override
	public List<CategoryPropertyRelationshipDO> listByCategoryId(Long categoryId) throws Exception {
		return categoryPropertyRelationMapper.listByCategoryId(categoryId);
	}
	
	/**
	 * 根据类目id查询类目与属性的关联关系
	 * @param categoryId 类目id
	 * @return 类目与属性的关联关系
	 */
	@Override
	public CategoryPropertyRelationshipDO getById(Long id) throws Exception {
		return categoryPropertyRelationMapper.getById(id);
	}
	
	/**
	 * 根据类目id删除类目与属性的关联关系
	 * @param categoryId 类目id
	 */
	@Override
	public void removeByCategoryId(Long categoryId) throws Exception {
		categoryPropertyRelationMapper.removeByCategoryId(categoryId); 
	}

}
