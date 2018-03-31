package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.domain.PropertyGroupDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 属性分组管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class PropertyGroupDaoTest {

	/**
	 * 属性分组管理DAO组件
	 */
	@Autowired
	private PropertyGroupDAO propertyGroupDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增属性分组
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_property_group.sql"})
	public void testSave() throws Exception {
		Long categoryId = 1L;
		PropertyGroupDO propertyGroup = createPropertyGroup(categoryId);
		assertNotNull(propertyGroup.getId()); 
		assertThat(propertyGroup.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据类目id查询属性分组
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_property_group.sql"})
	public void testListByCategoryId() throws Exception {
		Long categoryId = 1L;
		Integer count = 5;
		Map<Long, PropertyGroupDO> propertyGroupMap = 
				createPropertyGroups(count, categoryId);
		
		List<PropertyGroupDO> resultPropertyGroups = 
				propertyGroupDAO.listByCategoryId(categoryId);
		
		assertThat(resultPropertyGroups.size(), greaterThanOrEqualTo(propertyGroupMap.size()));  
		for(PropertyGroupDO resultPropertyGroup : resultPropertyGroups) {
			PropertyGroupDO targetPropertyGroup = propertyGroupMap.get(resultPropertyGroup.getId());
			assertEquals(targetPropertyGroup, resultPropertyGroup);
		}
	}
	
	/**
	 * 测试根据类目id删除属性分组
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_property_group.sql"})
	public void testRemoveByCategoryId() throws Exception {
		Long categoryId = 1L;
		Integer count = 5;
		createPropertyGroups(count, categoryId);
		
		propertyGroupDAO.removeByCategoryId(categoryId); 
		
		List<PropertyGroupDO> resultPropertyGroups = 
				propertyGroupDAO.listByCategoryId(categoryId);
		
		assertEquals(0, resultPropertyGroups.size()); 
	}
	
	/**
	 * 创建属性分组集合
	 * @param count 
	 * @param categoryId
	 * @return
	 * @throws Exception
	 */
	private Map<Long, PropertyGroupDO> createPropertyGroups(
			Integer count, Long categoryId) throws Exception {
		Map<Long, PropertyGroupDO> propertyGroupMap = new HashMap<Long, PropertyGroupDO>(CollectionSize.DEFAULT);
		for(int i = 0; i < count; i++) {
			PropertyGroupDO propertyGroup = createPropertyGroup(categoryId);
			propertyGroupMap.put(propertyGroup.getId(), propertyGroup);
		}
		return propertyGroupMap;
	}
	
	/**
	 * 创建属性分组
	 * @param categoryId 类目id
	 * @return 属性分组
	 * @throws Exception
	 */
	private PropertyGroupDO createPropertyGroup(Long categoryId) throws Exception {
		PropertyGroupDO propertyGroup = new PropertyGroupDO();
		propertyGroup.setCategoryId(categoryId); 
		propertyGroup.setGmtCreate(dateProvider.getCurrentTime()); 
		propertyGroup.setGmtModified(dateProvider.getCurrentTime()); 
		propertyGroup.setName("测试属性分组");  
		
		propertyGroupDAO.save(propertyGroup);
		
		return propertyGroup;
	}
	
}
