package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.constant.PropertyRequired;
import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 类目与属性关系管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class CategoryPropertyRelationshipDaoTest {
	
	/**
	 * 类目与属性关系管理DAO组件
	 */
	@Autowired
	private CategoryPropertyRelationshipDAO relationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 测试新增类目与属性关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_commodity_category_property_relationship.sql"}) 
	public void testSave() throws Exception {
		Long categoryId = 1L;
		CategoryPropertyRelationshipDO relation = createRelation(categoryId);
		assertNotNull(relation.getId()); 
		assertThat(relation.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试根据类目id查询类目与属性的关联关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_commodity_category_property_relationship.sql"}) 
	public void testListByCategoryId() throws Exception {
		Long categoryId = 1L;
		Integer relationCount = 5;
		Map<Long, CategoryPropertyRelationshipDO> relationMap = 
				createRelations(relationCount, categoryId);
		
		List<CategoryPropertyRelationshipDO> resultRelations = 
				relationDAO.listByCategoryId(categoryId);
		
		compareRelations(relationMap, resultRelations);
	}
	
	/**
	 * 测试根据类目id删除类目与属性的关联关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_commodity_category_property_relationship.sql"}) 
	public void testRemoveByCategoryId() throws Exception {
		Integer relationCount = 5;
		Long categoryId = 1L;
		createRelations(relationCount, categoryId);
		
		relationDAO.removeByCategoryId(categoryId); 
		
		List<CategoryPropertyRelationshipDO> resultRelations = 
				relationDAO.listByCategoryId(categoryId);
		
		assertEquals(0, resultRelations.size());  
	}
	
	/**
	 * 比较两个类目与属性关联关系集合
	 * @throws Exception
	 */
	private void compareRelations(Map<Long, CategoryPropertyRelationshipDO> targetRelationMap, 
			List<CategoryPropertyRelationshipDO> resultRelations) throws Exception {
		assertThat(resultRelations.size(), greaterThanOrEqualTo(targetRelationMap.size()));
		
		for(CategoryPropertyRelationshipDO resultRelation : resultRelations) {
			CategoryPropertyRelationshipDO targetRelation = targetRelationMap.get(resultRelation.getId());
			assertEquals(targetRelation, resultRelation);
		}
	}
	
	/**
	 * 创建类目与属性关联关系集合
	 * @param relationCount
	 * @param categoryId
	 * @return
	 * @throws Exception
	 */
	private Map<Long, CategoryPropertyRelationshipDO> createRelations(
			Integer relationCount, Long categoryId) throws Exception {
		Map<Long, CategoryPropertyRelationshipDO> relationMap = 
				new HashMap<Long, CategoryPropertyRelationshipDO>(CollectionSize.DEFAULT);
		for(int i = 0; i < relationCount; i++) {
			CategoryPropertyRelationshipDO relation = createRelation(categoryId);
			relationMap.put(relation.getId(), relation);
		}
		return relationMap;
	}
	
	/**
	 * 创建类目与属性的关联关系
	 * @param categoryId 类目id 
	 * @return
	 * @throws Exception
	 */
	private CategoryPropertyRelationshipDO createRelation(
			Long categoryId) throws Exception {
		Random random = new Random();
		
		CategoryPropertyRelationshipDO relation = new CategoryPropertyRelationshipDO();
		relation.setCategoryId(categoryId); 
		relation.setGmtCreate(dateProvider.getCurrentTime()); 
		relation.setGmtModified(dateProvider.getCurrentTime()); 
		relation.setPropertyId(random.nextLong());
		relation.setPropertyTypes("测试类型"); 
		relation.setRequired(PropertyRequired.YES);
		
		relationDAO.save(relation);
		
		return relation;
	}
	
}
