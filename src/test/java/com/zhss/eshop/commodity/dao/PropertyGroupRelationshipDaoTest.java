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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.constant.PropertyRequired;
import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 属性分组与属性关系管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class PropertyGroupRelationshipDaoTest {
	
	/**
	 * 属性分组与属性关系管理DAO组件
	 */
	@Autowired
	private PropertyGroupRelationshipDAO relationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 测试新增属性分组与属性关系
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long propertyGroupId = 1L;
		PropertyGroupRelationshipDO relation = createRelation(propertyGroupId);
		assertNotNull(relation.getId()); 
		assertThat(relation.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试根据属性分组id查询属性分组与属性的关联关系
	 * @throws Exception
	 */
	@Test
	public void testListByPropertyGroupId() throws Exception {
		Long propertyGroupId = 1L;
		Integer relationCount = 5;
		Map<Long, PropertyGroupRelationshipDO> relationMap = 
				createRelations(relationCount, propertyGroupId);
		
		List<PropertyGroupRelationshipDO> resultRelations = 
				relationDAO.listByPropertyGroupId(propertyGroupId);
		
		compareRelations(relationMap, resultRelations);
	}
	
	/**
	 * 测试根据属性分组id删除属性分组与属性的关联关系
	 * @throws Exception
	 */
	@Test
	public void testRemoveByPropertyGroupId() throws Exception {
		Integer relationCount = 5;
		Long propertyGroupId = 1L;
		createRelations(relationCount, propertyGroupId);
		
		relationDAO.removeByPropertyGroupId(propertyGroupId); 
		
		List<PropertyGroupRelationshipDO> resultRelations = 
				relationDAO.listByPropertyGroupId(propertyGroupId);
		
		assertEquals(0, resultRelations.size());  
	}
	
	/**
	 * 比较两个属性分组与属性关联关系集合
	 * @throws Exception
	 */
	private void compareRelations(Map<Long, PropertyGroupRelationshipDO> targetRelationMap, 
			List<PropertyGroupRelationshipDO> resultRelations) throws Exception {
		assertThat(resultRelations.size(), greaterThanOrEqualTo(targetRelationMap.size()));
		
		for(PropertyGroupRelationshipDO resultRelation : resultRelations) {
			PropertyGroupRelationshipDO targetRelation = targetRelationMap.get(resultRelation.getId());
			assertEquals(targetRelation, resultRelation);
		}
	}
	
	/**
	 * 创建属性分组与属性关联关系集合
	 * @param relationCount
	 * @param propertyGroupId
	 * @return
	 * @throws Exception
	 */
	private Map<Long, PropertyGroupRelationshipDO> createRelations(
			Integer relationCount, Long propertyGroupId) throws Exception {
		Map<Long, PropertyGroupRelationshipDO> relationMap = 
				new HashMap<Long, PropertyGroupRelationshipDO>(CollectionSize.DEFAULT);
		for(int i = 0; i < relationCount; i++) {
			PropertyGroupRelationshipDO relation = createRelation(propertyGroupId);
			relationMap.put(relation.getId(), relation);
		}
		return relationMap;
	}
	
	/**
	 * 创建属性分组与属性的关联关系
	 * @param propertyGroupId 属性分组id 
	 * @return
	 * @throws Exception
	 */
	private PropertyGroupRelationshipDO createRelation(
			Long propertyGroupId) throws Exception {
		Random random = new Random();
		
		PropertyGroupRelationshipDO relation = new PropertyGroupRelationshipDO();
		relation.setPropertyGroupId(propertyGroupId); 
		relation.setGmtCreate(dateProvider.getCurrentTime()); 
		relation.setGmtModified(dateProvider.getCurrentTime()); 
		relation.setPropertyId(random.nextLong());
		relation.setPropertyTypes("测试类型"); 
		relation.setRequired(PropertyRequired.YES);
		
		relationDAO.save(relation);
		
		return relation;
	}
	
}
