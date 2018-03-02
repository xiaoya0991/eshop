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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.constant.PropertyInputType;
import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.domain.PropertyQuery;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 属性管理模块DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class PropertyDAOTest {

	/**
	 * 属性管理模块DAO组件
	 */
	@Autowired
	private PropertyDAO propertyDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增商品属性
	 * @throws Exception
	 */
	@Test
	public void testSaveProperty() throws Exception {
		String inputValues = "红色,蓝色,白色";
		String propertyDesc = "手机机身的颜色";
		String propertyName = "机身颜色";
		PropertyDO propertyDO = createPropertyDO(inputValues, propertyDesc, propertyName);
		assertNotNull(propertyDO.getId()); 
		assertThat(propertyDO.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询商品属性
	 * @throws Exception
	 */
	@Test
	public void testListPropertiesByPage() throws Exception {
		// 模拟一个分页查询的场景
		// 假设每页的数据是2条，我们来构造3页的数据，一共是6条，其中5条都符合一个PropertyName的查询条件
		// 我们来分页查询第2页
		
		PropertyDO propertyDO1 = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色1");  
		PropertyDO propertyDO2 = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色2");
		PropertyDO propertyDO3 = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色3");
		PropertyDO propertyDO4 = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色4");
		PropertyDO propertyDO5 = createPropertyDO(null, "手机前后摄像头的像素", "摄像头像素");
		PropertyDO propertyDO6 = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色5");
		
		Map<Long, PropertyDO> propertyDOMap = new HashMap<Long, PropertyDO>();
		propertyDOMap.put(propertyDO1.getId(), propertyDO1);
		propertyDOMap.put(propertyDO2.getId(), propertyDO2);
		propertyDOMap.put(propertyDO3.getId(), propertyDO3);
		propertyDOMap.put(propertyDO4.getId(), propertyDO4);
		propertyDOMap.put(propertyDO5.getId(), propertyDO5);
		propertyDOMap.put(propertyDO6.getId(), propertyDO6);
		
		Long propertyDO3Id = propertyDO3.getId();
		Long propertyDO4Id = propertyDO4.getId();
		
		// 我们可以来执行分页查询
		PropertyQuery propertyQuery = new PropertyQuery();
		propertyQuery.setOffset(2); 
		propertyQuery.setSize(2); 
		propertyQuery.setPropertyName("机身颜色"); 
		 
		List<PropertyDO> propertyDOs = propertyDAO.listPropertiesByPage(propertyQuery);
		assertThat(propertyDOs.size(), greaterThan(0));  
		
		for(PropertyDO propertyDO : propertyDOs) {
			PropertyDO targetPropertyDO = propertyDOMap.get(propertyDO.getId());
			assertEquals(targetPropertyDO, propertyDO);  
			assertTrue(propertyDO.getId().equals(propertyDO3Id) || 
					propertyDO.getId().equals(propertyDO4Id)); 
		}
	}
	
	/**
	 * 测试根据id查询商品属性 
	 * @throws Exception
	 */
	@Test
	public void testGetPropertyById() throws Exception {
		PropertyDO propertyDO = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色1");
		PropertyDO resultPropertyDO = propertyDAO.getPropertyById(propertyDO.getId());
		assertEquals(propertyDO, resultPropertyDO); 
	}
	
	/**
	 * 测试更新商品属性
	 * @throws Exception
	 */
	@Test
	public void testUpdateProperty() throws Exception {
		PropertyDO propertyDO = createPropertyDO("红色,蓝色,白色", "手机机身的颜色", "机身颜色1");
		
		propertyDO.setGmtModified(dateProvider.getCurrentTime());
		propertyDO.setPropertyDesc("机身颜色");  
		propertyDAO.updateProperty(propertyDO);
		
		PropertyDO resultPropertyDO = propertyDAO.getPropertyById(propertyDO.getId());
		
		assertEquals(propertyDO, resultPropertyDO);  
	}
	
	/**
	 * 创建一个属性DO对象
	 * @return 属性DO对象
	 * @throws Exception
	 */
	private PropertyDO createPropertyDO(String inputValues,
			String propertyDesc, String propertyName) throws Exception {  
		PropertyDO propertyDO = new PropertyDO();
		propertyDO.setGmtCreate(dateProvider.getCurrentTime()); 
		propertyDO.setGmtModified(dateProvider.getCurrentTime()); 
		propertyDO.setInputType(PropertyInputType.MULTIPUT_CHOICE);
		propertyDO.setInputValues(inputValues); 
		propertyDO.setPropertyDesc(propertyDesc); 
		propertyDO.setPropertyName(propertyName); 
		
		propertyDAO.saveProperty(propertyDO);
		
		return propertyDO;
	}
	
}
