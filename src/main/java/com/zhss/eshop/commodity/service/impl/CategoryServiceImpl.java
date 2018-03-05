package com.zhss.eshop.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.dao.CategoryPropertyRelationshipDAO;
import com.zhss.eshop.commodity.dao.PropertyDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupDAO;
import com.zhss.eshop.commodity.dao.PropertyGroupRelationshipDAO;
import com.zhss.eshop.commodity.domain.CategoryDO;
import com.zhss.eshop.commodity.domain.CategoryDTO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDTO;
import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.domain.PropertyDTO;
import com.zhss.eshop.commodity.domain.PropertyGroupDO;
import com.zhss.eshop.commodity.domain.PropertyGroupDTO;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDTO;
import com.zhss.eshop.commodity.service.CategoryService;
import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 类目管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
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
	 * 属性管理模块DAO组件
	 */
	@Autowired
	private PropertyDAO propertyDAO;
	/**
	 * Spring容器组件
	 */
	@Autowired
	private SpringApplicationContext context;

	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
 	public List<CategoryDTO> listRoots() throws Exception {
		List<CategoryDO> categories = categoryDAO.listRoots(); 
		List<CategoryDTO> resultCategories = ObjectUtils.convertList(
				categories, CategoryDTO.class);
		return resultCategories;
 	}
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	public List<CategoryDTO> listChildren(Long id) throws Exception {
		List<CategoryDO> categories = categoryDAO.listChildren(id);
		List<CategoryDTO> resultCategories = ObjectUtils.convertList(
				categories, CategoryDTO.class);
		return resultCategories;
	}
	
	/**
	 * 新增类目
	 * @param category 类目
	 * @return 处理结果
	 */
	public Boolean save(CategoryDTO category) throws Exception {
		saveCategory(category);
		saveCategoryPropertyRelations(category); 
		savePropertyGroup(category); 
		return true;
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
	 * 更新类目
	 * @param category 类目
	 * @throws Exception
	 */
	public void update(CategoryDTO category) throws Exception {
		updateCategory(category); 
		
		removeCategoryPropertyRelations(category); 
		saveCategoryPropertyRelations(category); 
		
		removePropertyGroupRelations(category); 
		savePropertyGroup(category); 
	}
	
	/**
	 * 更新类目
	 * @param category 类目
	 * @throws Exception
	 */
	private void updateCategory(CategoryDTO category) throws Exception {
		category.setGmtModified(dateProvider.getCurrentTime()); 
		categoryDAO.update(category.clone(CategoryDO.class));  
	}
	
	/**
	 * 删除类目与属性的关联关系
	 * @param category 类目
	 * @throws Exception
	 */
	private void removeCategoryPropertyRelations(CategoryDTO category) throws Exception {
		categoryPropertyRelationDAO.removeByCategoryId(category.getId());  
	}
	
	/**
	 * 删除类目的属性分组与属性的关联关系
	 * @param category 类目
	 * @throws Exception
	 */
	private void removePropertyGroupRelations(CategoryDTO category) throws Exception {
		List<PropertyGroupDO> propertyGroups = propertyGroupDAO.listByCategoryId(category.getId());

		for(PropertyGroupDO propertyGroup : propertyGroups) {
			propertyGroupRelationDAO.removeByPropertyGroupId(propertyGroup.getId()); 
		}
		
		propertyGroupDAO.removeByCategoryId(category.getId()); 
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
	
	/**
	 * 根据id查询类目
	 * @param id 类目id
	 * @return 类目
	 */
	public CategoryDTO getById(Long id) throws Exception {
		// 查询类目基本信息
		CategoryDTO category = categoryDAO.getById(id).clone(CategoryDTO.class);  
		
		// 查询类目与属性的关联关系
		List<CategoryPropertyRelationshipDO> relations = 
				categoryPropertyRelationDAO.listByCategoryId(id);
		category.setPropertyRelations(ObjectUtils.convertList(relations, 
				CategoryPropertyRelationshipDTO.class)); 
		 
		// 查询类目关联的属性
		List<PropertyDO> properties = new ArrayList<PropertyDO>();
		for(CategoryPropertyRelationshipDO relation : relations) {
			properties.add(propertyDAO.getPropertyById(relation.getPropertyId()));  
		}
		category.setProperties(ObjectUtils.convertList(properties, PropertyDTO.class));  
		
		// 查询类目关联的属性分组
		List<PropertyGroupDTO> propertyGroups = getPropertyGroupsByCategoryId(id);
		category.setPropertyGroups(propertyGroups); 
		
		return category;
	}
	
	/**
	 * 根据类目id查询属性分组
	 * @param categoryId 类目id
	 * @return 属性分组
	 * @throws Exception
	 */
	private List<PropertyGroupDTO> getPropertyGroupsByCategoryId(
			Long categoryId) throws Exception {
		List<PropertyGroupDTO> resultPropertyGroups = new ArrayList<PropertyGroupDTO>();
		
		// 查询类目关联的属性分组
		List<PropertyGroupDO> propertyGroups = propertyGroupDAO.listByCategoryId(categoryId); 
		
		// 查询属性分组与属性的关联关系，以及属性分组关联的属性
		for(PropertyGroupDO propertyGroup : propertyGroups) {
			PropertyGroupDTO resultPropertyGroup = propertyGroup.clone(PropertyGroupDTO.class);
			
			List<PropertyGroupRelationshipDO> relations = propertyGroupRelationDAO
					.listByPropertyGroupId(propertyGroup.getId());
			resultPropertyGroup.setRelations(ObjectUtils.convertList(relations, 
					PropertyGroupRelationshipDTO.class));  
			
			List<PropertyDTO> properties = new ArrayList<PropertyDTO>();
			for(PropertyGroupRelationshipDO relation : relations) {
				properties.add(getPropertyById(relation.getPropertyId()));
			}
			resultPropertyGroup.setProperties(properties); 
			
			resultPropertyGroups.add(resultPropertyGroup);
		}
		
		return resultPropertyGroups;
	}
	
	/**
	 * 根据id查询属性
	 * @param propertyId 属性id
	 * @return 属性
	 */
	private PropertyDTO getPropertyById(Long propertyId) throws Exception {
		PropertyDO property = propertyDAO.getPropertyById(propertyId);
		return property.clone(PropertyDTO.class);
	}
	
	/**
	 * 删除类目
	 * @param id 类目id
	 * @throws Exception
	 */
	public Boolean remove(Long id) throws Exception {
		Category category = new Category(id); 
		
		CategoryOperation<Boolean> relatedCheckOperation = context.getBean(
				CategoryRelatedCheckOperation.class);
		Boolean result = category.execute(relatedCheckOperation); 
	
		if(result) {
			return false;
		}
		
		CategoryOperation<Boolean> removeOperation = 
				context.getBean(CategoryRemoveOperation.class);
		return category.execute(removeOperation);
	}
	
}
