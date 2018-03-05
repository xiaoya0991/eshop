package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupRelationshipDAO;
import com.zhss.eshop.commodity.domain.PropertyGroupDO;

/**
 * 类目删除操作
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype") 
public class CategoryRemoveOperation extends AbstractCategoryOperation<Boolean> {  

	/**
	 * 类目与属性关系管理DAO组件
	 */
	private CategoryPropertyRelationshipDAO categoryPropertyRelationDAO;
	/**
	 * 属性分组管理DAO组件
	 */
	private PropertyGroupDAO propertyGroupDAO;
	/**
	 * 属性分组与属性关系管理DAO组件
	 */
	private PropertyGroupRelationshipDAO propertyGroupRelationDAO;
	
	/**
	 * 构造函数
	 * @param categoryDAO 类目管理DAO组件
	 * @param categoryPropertyRelationDAO 类目与属性关系管理DAO组件
	 * @param propertyGroupDAO 属性分组管理DAO组件\
	 * @param categoryDAO 类目管理DAO组件
	 */
	@Autowired
	public CategoryRemoveOperation(CategoryDAO categoryDAO,
			CategoryPropertyRelationshipDAO categoryPropertyRelationDAO,
			PropertyGroupDAO propertyGroupDAO,
			PropertyGroupRelationshipDAO propertyGroupRelationDAO) {
		super(categoryDAO);
		this.categoryPropertyRelationDAO = categoryPropertyRelationDAO;
		this.propertyGroupDAO = propertyGroupDAO;
		this.propertyGroupRelationDAO = propertyGroupRelationDAO;
	}

	/**
	 * 执行实际的操作
	 */
	@Override
	protected void doRealExecute(Category category) throws Exception {
		removePropertyRelation(category); 
		removePropertyGroup(category); 
		removeCategory(category); 
	}
	
	/**
	 * 删除类目与属性的关联关系
	 * @param category 类目
	 * @throws Exception
	 */
	private void removePropertyRelation(Category category) throws Exception {
		categoryPropertyRelationDAO.removeByCategoryId(category.getCategoryId());  
	}
	
	/**
	 * 删除类目的属性分组
	 * @param category 类目
	 * @throws Exception
	 */
	private void removePropertyGroup(Category category) throws Exception {
		List<PropertyGroupDO> propertyGroups = propertyGroupDAO
				.listByCategoryId(category.getCategoryId());
		for(PropertyGroupDO propertyGroup : propertyGroups) {
			propertyGroupRelationDAO.removeByPropertyGroupId(propertyGroup.getId()); 
		}
		
		propertyGroupDAO.removeByCategoryId(category.getCategoryId()); 
	}
	
	/**
	 * 删除类目
	 * @param category 类目
	 * @throws Exception
	 */
	private void removeCategory(Category category) throws Exception {
		categoryDAO.remove(category.getCategoryId()); 
	}

	/**
	 * 获取操作的执行结果
	 */
	@Override
	protected Boolean getResult() throws Exception {
		return true;
	}

}
