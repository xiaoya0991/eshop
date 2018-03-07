package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.constant.CategoryLeaf;
import com.zhss.eshop.commodity.domain.CategoryDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 类目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class CategoryDAOTest {  
	
	/**
	 * 类目管理DAO组件
	 */
	@Autowired
	private CategoryDAO categoryDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 测试新增类目
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		CategoryDO category = createCategory(); 
		assertNotNull(category.getId());  
		assertThat(category.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试查询根类目
	 * @throws Exception
	 */
	@Test
	public void testListRoos() throws Exception {
		Integer categoryCount = 5;
		Map<Long, CategoryDO> categoryMap = createCategories(categoryCount); 
		
		List<CategoryDO> resultCategories = categoryDAO.listRoots();
		
		compareCategories(categoryMap, resultCategories); 
	}
	
	/**
	 * 测试查询子类目
	 * @throws Exception
	 */
	@Test
	public void testListChildren() throws Exception {
		Integer categoryCount = 5;
		Long parentId = 1L;
		Map<Long, CategoryDO> categoryMap = createCategories(categoryCount, parentId);
		
		List<CategoryDO> resultCategories = categoryDAO.listChildren(parentId);
		
		compareCategories(categoryMap, resultCategories); 
	}
	
	/**
	 * 测试根据id查询类目
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		CategoryDO category = createCategory(); 
		CategoryDO resultCategory = categoryDAO.getById(category.getId());
		assertEquals(category, resultCategory); 
	}
	
	/**
	 * 测试更新类目
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		CategoryDO category = createCategory();
		
		category.setDescription("修改后的测试类目");
		category.setGmtModified(dateProvider.getCurrentTime()); 
		categoryDAO.update(category); 
		
		CategoryDO resultCategory = categoryDAO.getById(category.getId());
		
		assertEquals(category, resultCategory); 
	}
	
	/**
	 * 测试删除类目
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		CategoryDO category = createCategory();
		categoryDAO.remove(category.getId()); 
		CategoryDO resultCategory = categoryDAO.getById(category.getId());
		assertNull(resultCategory); 
	}
	
	/**
	 * 创建类目集合
	 * @return 类目集合
	 * @throws Exception
	 */
	private Map<Long, CategoryDO> createCategories(Integer categoryCount) throws Exception {
		Long parentId = null;
		return createCategories(categoryCount, parentId);
	}
	
	/**
	 * 创建类目集合
	 * @return 类目集合
	 * @throws Exception
	 */
	private Map<Long, CategoryDO> createCategories(
			Integer categoryCount, Long parentId) throws Exception {
		Map<Long, CategoryDO> categoryMap = new HashMap<Long, CategoryDO>();
		for(int i = 0; i < categoryCount; i++) {
			CategoryDO category = createCategory(parentId);
			categoryMap.put(category.getId(), category);
		}
		return categoryMap;
	}
	
	/**
	 * 创建根类目
	 * @return 根类目
	 * @throws Exception
	 */
	private CategoryDO createCategory() throws Exception {
		Long parentId = null;
		return createCategory(parentId);
	}
	
	/**
	 * 创建类目
	 * @return 类目
	 * @throws Exception
	 */
	private CategoryDO createCategory(Long parentId) throws Exception {
		CategoryDO category = new CategoryDO();
		category.setLeaf(CategoryLeaf.NO); 
		category.setDescription("测试类目"); 
		category.setGmtCreate(dateProvider.getCurrentTime()); 
		category.setGmtModified(dateProvider.getCurrentTime()); 
		category.setName("测试类目");
		category.setParentId(parentId);
		
		categoryDAO.save(category);
		
		return category;
	}
	
	/**
	 * 比较两个类目集合
	 * @param targetCategoryMap 目标类目集合
	 * @param resultCategories 结果类目集合
	 * @throws Exception
	 */
	private void compareCategories(Map<Long, CategoryDO> targetCategoryMap, 
			List<CategoryDO> resultCategories) throws Exception {
		assertThat(resultCategories.size(), greaterThanOrEqualTo(targetCategoryMap.size()));   
		
		for(CategoryDO resultCategory : resultCategories) {
			CategoryDO targetCategory = targetCategoryMap.get(resultCategory.getId());
			if(targetCategory == null) {
				continue;
			}
			assertEquals(targetCategory, resultCategory);
		}
	}
	
}
