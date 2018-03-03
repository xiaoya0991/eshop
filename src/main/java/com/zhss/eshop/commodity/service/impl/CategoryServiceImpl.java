package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupRelationshipDAO;
import com.zhss.eshop.commodity.domain.CategoryDO;
import com.zhss.eshop.commodity.domain.CategoryDTO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDTO;
import com.zhss.eshop.commodity.domain.PropertyGroupDO;
import com.zhss.eshop.commodity.domain.PropertyGroupDTO;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDTO;
import com.zhss.eshop.commodity.service.CategoryService;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 类目管理service组件
 * @author zhonghuashishan
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	/**
	 * 类目管理dao组件
	 */
	@Autowired
	private CategoryDAO categoryDAO;
	/**
	 * 类目属性关系dao组件
	 */
	@Autowired
	private CategoryPropertyRelationshipDAO categoryPropertyRelationDAO;
	/**
	 * 属性分组dao组件
	 */
	@Autowired
	private PropertyGroupDAO propertyGroupDAO;
	/**
	 * 属性分组与属性关系dao组件
	 */
	@Autowired
	private PropertyGroupRelationshipDAO propertyGroupRelationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
 	public List<CategoryDTO> listRoots() {
 		try {
 			List<CategoryDO> categories = categoryDAO.listRoots(); 
 			List<CategoryDTO> resultCategories = ObjectUtils.convertList(
 					categories, CategoryDTO.class);
 			return resultCategories;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
 	}
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	public List<CategoryDTO> listChildren(Long id) {
		try {
 			List<CategoryDO> categories = categoryDAO.listChildren(id);
 			List<CategoryDTO> resultCategories = ObjectUtils.convertList(
 					categories, CategoryDTO.class);
 			return resultCategories;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 新增类目
	 * @param category 类目
	 * @return 处理结果
	 */
	public Boolean save(CategoryDTO category) {
		try {
			saveCategory(category);
			saveCategoryPropertyRelations(category); 
			savePropertyGroup(category); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 保存类目的基本信息
	 * @param category 类目
	 * @throws Exception
	 */
	private void saveCategory(CategoryDTO category) throws Exception {
		category.setGmtCreate(dateProvider.getCurrentTime()); 
		category.setGmtModified(dateProvider.getCurrentTime());  
		Long categoryId = categoryDAO.save(category.clone(CategoryDO.class));  
		category.setId(categoryId); 
	}
	
	/**
	 * 保存类目与属性之间的关联关系
	 * @param category 类目
	 */
	private void saveCategoryPropertyRelations(CategoryDTO category) throws Exception {
		if(category.getPropertyRelations() == null || 
				category.getPropertyRelations().size() == 0) {
			return;
		}
		
		for(CategoryPropertyRelationshipDTO relation : category.getPropertyRelations()) {
			relation.setCategoryId(category.getId()); 
			relation.setGmtCreate(dateProvider.getCurrentTime()); 
			relation.setGmtModified(dateProvider.getCurrentTime());  
			
			categoryPropertyRelationDAO.save(relation.clone(
					CategoryPropertyRelationshipDO.class));  
		}
	}
	
	/**
	 * 保存属性分组
	 * @param category 类目
	 * @throws Exception
	 */
	private void savePropertyGroup(CategoryDTO category) throws Exception {
		if(category.getPropertyGroups() == null ||
				category.getPropertyGroups().size() == 0) {
			return;
		}
		
		for(PropertyGroupDTO group : category.getPropertyGroups()) {
			group.setCategoryId(category.getId());
			group.setGmtCreate(dateProvider.getCurrentTime()); 
			group.setGmtModified(dateProvider.getCurrentTime()); 
			
			Long groupId = propertyGroupDAO.save(group.clone(PropertyGroupDO.class));  
			group.setId(groupId);  
			
			savePropertyGroupRelations(group); 
		}
	}
	
	/**
	 * 保存属性分组与属性的关联关系
	 * @param group 属性分组
	 * @throws Exception
	 */
	private void savePropertyGroupRelations(PropertyGroupDTO group) throws Exception {
		if(group.getRelations() == null || group.getRelations().size() == 0) {
			return;
		}
		
		for(PropertyGroupRelationshipDTO relation : group.getRelations()) {
			relation.setPropertyGroupId(group.getId()); 
			relation.setGmtCreate(dateProvider.getCurrentTime()); 
			relation.setGmtModified(dateProvider.getCurrentTime()); 
			
			propertyGroupRelationDAO.save(relation.clone(
					PropertyGroupRelationshipDO.class));
		}
	}
	
}
