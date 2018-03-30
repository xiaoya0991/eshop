package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.domain.GoodsDO;
import com.zhss.eshop.commodity.domain.GoodsQuery;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class GoodsDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品管理DAO组件
	 */
	@Autowired
	private GoodsDAO goodsDAO;
	
	/**
	 * 测试根据类目id查询商品数量
	 * @throws Exception
	 */
	@Test
	public void testCountByCategoryId() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		Integer expectedCount = 10;
		createGoodsList(categoryId, brandId, expectedCount);
		
		Long actualCount = goodsDAO.countByCategoryId(categoryId);
		
		assertEquals((long)expectedCount, (long)actualCount);   
	}
	
	/**
	 * 测试根据品牌id查询商品数量
	 * @throws Exception
	 */
	@Test
	public void testCountByBrandId() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		Integer expectedCount = 10;
		createGoodsList(categoryId, brandId, expectedCount);
		
		Long actualCount = goodsDAO.countByBrandId(brandId);
		
		assertEquals((long)expectedCount, (long)actualCount);   
	}
	
	/**
	 * 测试分页查询商品
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods.sql"})
	public void testListByPage() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		Integer count = 30;
		Map<Long, GoodsDO> expectedGoodsMap = createGoodsMap(
				categoryId, brandId, count);
		processGoodsForListByPage(expectedGoodsMap); 
	
		Integer offset = 10;
		Integer size = 10;
		GoodsQuery query = createGoodsQuery(offset, size, categoryId, brandId);
		List<GoodsDO> actualGoodsList = goodsDAO.listByPage(query);
		
		compareGoods(size, expectedGoodsMap, actualGoodsList);
	}
	
	/**
	 * 测试根据id查询商品
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		GoodsDO expectedGoods = createGoods(categoryId, brandId);
		
		GoodsDO actualGoods = goodsDAO.getById(expectedGoods.getId());
		
		assertEquals(expectedGoods, actualGoods); 
	}
	
	/**
	 * 测试新建商品
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		GoodsDO goods = createGoods(categoryId, brandId);  
		assertNotNull(goods.getId()); 
		assertThat(goods.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试更新商品
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		GoodsDO expectedGoods = createGoods(categoryId, brandId);
		
		expectedGoods.setName("修改后的" + expectedGoods.getName()); 
		goodsDAO.update(expectedGoods);
		
		GoodsDO actualGoods = goodsDAO.getById(expectedGoods.getId());
		
		assertEquals(expectedGoods, actualGoods); 
	}
	
	/**
	 * 测试更新商品状态
	 * @throws Exception
	 */
	@Test
	public void testUpdateStatus() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		GoodsDO expectedGoods = createGoods(categoryId, brandId);
		
		expectedGoods.setStatus(2); 
		goodsDAO.updateStatus(expectedGoods);
		
		GoodsDO actualGoods = goodsDAO.getById(expectedGoods.getId());
		
		assertEquals(expectedGoods, actualGoods); 
	}
	
	/**
	 * 测试删除商品
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long categoryId = 1L;
		Long brandId = 1L;
		GoodsDO expectedGoods = createGoods(categoryId, brandId);
		
		goodsDAO.remove(expectedGoods.getId()); 
		
		GoodsDO actualGoods = goodsDAO.getById(expectedGoods.getId());
		
		assertNull(actualGoods); 
	}
	
	/**
	 * 为分页查询处理一下商品
	 * @throws Exception
	 */
	private void processGoodsForListByPage(
			Map<Long, GoodsDO> expectedGoodsMap) throws Exception {
		for(GoodsDO expectedGoods : expectedGoodsMap.values()) {
			expectedGoods.setServiceGuarantees(null); 
			expectedGoods.setPackageList(null); 
			expectedGoods.setFreightTemplateId(null); 
		}
	}
	
	/**
	 * 比较两个商品集合
	 * @param expectedGoodsMap 期望的商品集合
	 * @param actualGoodsList 实际的商品集合
	 * @throws Exception
	 */
	private void compareGoods(Integer expectedSize ,
			Map<Long, GoodsDO> expectedGoodsMap,
			List<GoodsDO> actualGoodsList) throws Exception {
		assertEquals((int)expectedSize, actualGoodsList.size()); 
		
		for(GoodsDO actualGoods : actualGoodsList) {
			GoodsDO expectedGoods = expectedGoodsMap.get(actualGoods.getId());
			assertEquals(expectedGoods, actualGoods); 
		}
	}
	
	/**
	 * 创建商品查询条件
	 * @return
	 * @throws Exception
	 */
	private GoodsQuery createGoodsQuery(Integer offset, Integer size,
			Long categoryId, Long brandId) throws Exception {
		GoodsQuery query = new GoodsQuery();
		query.setOffset(offset);
		query.setSize(size); 
		query.setCategoryId(categoryId);
		query.setBrandId(brandId); 
		query.setName("测试"); 
		query.setStatus(1);
		query.setSubName("测试");
		return query;
	}
	
	/**
	 * 创建商品集合
	 * @param categoryId 类目id
	 * @return 商品集合
	 * @throws Exception
	 */
	private Map<Long, GoodsDO> createGoodsMap(Long categoryId, Long brandId,
			Integer count) throws Exception {
		Map<Long, GoodsDO> goodsMap = new HashMap<Long, GoodsDO>(CollectionSize.DEFAULT);
		
		List<GoodsDO> goodsList = createGoodsList(categoryId, brandId, count);
		for(GoodsDO goods : goodsList) {
			goodsMap.put(goods.getId(), goods);
		}
		
		return goodsMap;
	}
	
	/**
	 * 创建商品集合
	 * @param categoryId 类目id 
	 * @param count 商品数量
	 * @return 商品集合
	 * @throws Exception
	 */
	private List<GoodsDO> createGoodsList(Long categoryId, Long brandId,
			Integer count) throws Exception {
		List<GoodsDO> goodsList = new ArrayList<GoodsDO>();
		for(int i = 0; i < count; i++) {
			goodsList.add(createGoods(categoryId, brandId));  
		}
		return goodsList;
	}
	
	/**
	 * 创建商品
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsDO createGoods(Long categoryId, Long brandId) throws Exception {
		GoodsDO goods = new GoodsDO();
		
		goods.setCategoryId(categoryId);  
		goods.setBrandId(brandId); 
		goods.setCode(UUID.randomUUID().toString().replace("-", ""));  
		goods.setName("测试商品"); 
		goods.setSubName("测试商品副名称");  
		goods.setGrossWeight(45.0); 
		goods.setLength(24.0); 
		goods.setWidth(34.5); 
		goods.setHeight(3.5); 
		goods.setStatus(1); 
		goods.setServiceGuarantees("测试服务保障"); 
		goods.setPackageList("测试包装清单");  
		goods.setFreightTemplateId(1L); 
		goods.setGmtCreate(dateProvider.getCurrentTime()); 
		goods.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsDAO.save(goods);
		
		return goods;
	}
	
}
