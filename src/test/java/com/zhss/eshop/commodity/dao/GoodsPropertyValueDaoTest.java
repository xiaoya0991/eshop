package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品属性值管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class GoodsPropertyValueDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品属性值管理DAO组件
	 */
	@Autowired
	private GoodsPropertyValueDAO goodsPropertyValueDAO;
	
	/**
	 * 测试根据商品id查询商品属性值
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_property_value.sql"})  
	public void testListByGoodsId() throws Exception {
		Long goodsId = 1L;
		Integer count = 10;
		Map<Long, GoodsPropertyValueDO> expectedGoodsPropertyValueMap = 
				createGoodsPropertyValueMap(goodsId, count);
		
		List<GoodsPropertyValueDO> actualGoodsPropertyValues = 
				goodsPropertyValueDAO.listByGoodsId(goodsId);
		
		compareGoodsPropertyValues(count, expectedGoodsPropertyValueMap, 
				actualGoodsPropertyValues); 
	}
	
	/**
	 * 测试新建商品属性值
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long goodsId = 1L;
		GoodsPropertyValueDO goodsPropertyValue = createGoodsPropertyValue(goodsId);  
		assertNotNull(goodsPropertyValue.getId()); 
		assertThat(goodsPropertyValue.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试删除商品属性值
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_property_value.sql"})  
	public void testRemove() throws Exception {
		Long goodsId = 1L;
		GoodsPropertyValueDO expectedGoodsPropertyValue = createGoodsPropertyValue(goodsId);
		
		goodsPropertyValueDAO.removeByGoodsId(expectedGoodsPropertyValue.getGoodsId()); 
		
		List<GoodsPropertyValueDO> actualGoodsPropertyValues = 
				goodsPropertyValueDAO.listByGoodsId(goodsId);
		
		assertEquals(0, actualGoodsPropertyValues.size()); 
	}
	
	/**
	 * 比较两个商品属性值集合
	 * @param expectedGoodsPropertyValueMap 期望的商品属性值集合
	 * @param actualGoodsPropertyValues 实际的商品属性值集合
	 * @throws Exception
	 */
	private void compareGoodsPropertyValues(Integer expectedSize ,
			Map<Long, GoodsPropertyValueDO> expectedGoodsPropertyValueMap,
			List<GoodsPropertyValueDO> actualGoodsPropertyValues) throws Exception {
		assertEquals((int)expectedSize, actualGoodsPropertyValues.size()); 
		
		for(GoodsPropertyValueDO actualGoodsPropertyValue : actualGoodsPropertyValues) {
			GoodsPropertyValueDO expectedGoodsPropertyValue = expectedGoodsPropertyValueMap.get(
					actualGoodsPropertyValue.getId());
			assertEquals(expectedGoodsPropertyValue, actualGoodsPropertyValue); 
		}
	}
	
	/**
	 * 创建商品属性值集合
	 * @param categoryId 类目id
	 * @return 商品属性值集合
	 * @throws Exception
	 */
	private Map<Long, GoodsPropertyValueDO> createGoodsPropertyValueMap(
			Long goodsId, Integer count) throws Exception {
		Map<Long, GoodsPropertyValueDO> goodsPropertyValueMap = 
				new HashMap<Long, GoodsPropertyValueDO>(CollectionSize.DEFAULT);
		
		List<GoodsPropertyValueDO> goodsPropertyValues = createGoodsPropertyValues(
				goodsId, count);
		for(GoodsPropertyValueDO goodsPropertyValue : goodsPropertyValues) {
			goodsPropertyValueMap.put(goodsPropertyValue.getId(), goodsPropertyValue);
		}
		
		return goodsPropertyValueMap;
	}
	
	/**
	 * 创建商品属性值集合
	 * @param categoryId 类目id 
	 * @param count 商品数量
	 * @return 商品属性值集合
	 * @throws Exception
	 */
	private List<GoodsPropertyValueDO> createGoodsPropertyValues(
			Long goodsId, Integer count) throws Exception {
		List<GoodsPropertyValueDO> goodsPropertyValues = new ArrayList<GoodsPropertyValueDO>();
		for(int i = 0; i < count; i++) {
			goodsPropertyValues.add(createGoodsPropertyValue(goodsId));  
		}
		return goodsPropertyValues;
	}
	
	/**
	 * 创建商品属性值
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsPropertyValueDO createGoodsPropertyValue(Long goodsId) throws Exception {
		GoodsPropertyValueDO goodsPropertyValue = new GoodsPropertyValueDO();
		
		goodsPropertyValue.setGoodsId(goodsId); 
		goodsPropertyValue.setRelationId(1L); 
		goodsPropertyValue.setPropertyValue("测试值");
		goodsPropertyValue.setType(1);  
		goodsPropertyValue.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsPropertyValue.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsPropertyValueDAO.save(goodsPropertyValue);
		
		return goodsPropertyValue;
	}
	
}
