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

import com.zhss.eshop.commodity.domain.GoodsPictureDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品图片管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class GoodsPictureDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品图片管理DAO组件
	 */
	@Autowired
	private GoodsPictureDAO goodsPictureDAO;
	
	/**
	 * 测试根据商品id查询商品图片id
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_picture.sql"})  
	public void testListIdsByGoodsId() throws Exception {
		Long goodsId = 1L;
		Integer count = 10;
		Map<Long, GoodsPictureDO> expectedGoodsPictureMap = 
				createGoodsPictureMap(goodsId, count);
		
		List<Long> actualGoodsPictureIds = 
				goodsPictureDAO.listIdsByGoodsId(goodsId);
		
		assertEquals((int)count, actualGoodsPictureIds.size()); 
		
		for(Long actualGoodsPictureId : actualGoodsPictureIds) {
			GoodsPictureDO expectedGoodsPictureDO = 
					expectedGoodsPictureMap.get(actualGoodsPictureId);
			assertNotNull(expectedGoodsPictureDO); 
		}
	}
	
	/**
	 * 测试根据id查询商品图片
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		Long goodsId = 1L;
		GoodsPictureDO expectedGoodsPicture = createGoodsPicture(goodsId);  
		
		GoodsPictureDO actualGoodsPicture = goodsPictureDAO.getById(
				expectedGoodsPicture.getId());
		
		assertEquals(expectedGoodsPicture, actualGoodsPicture); 
	}
	
	/**
	 * 测试根据商品id查询商品图片
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_picture.sql"})  
	public void testListByGoodsId() throws Exception {
		Long goodsId = 1L;
		Integer count = 10;
		Map<Long, GoodsPictureDO> expectedGoodsPictureMap = 
				createGoodsPictureMap(goodsId, count);
		
		List<GoodsPictureDO> actualGoodsPictures = 
				goodsPictureDAO.listByGoodsId(goodsId);
		
		compareGoodsPictures(count, expectedGoodsPictureMap, 
				actualGoodsPictures); 
	}
	
	/**
	 * 测试新建商品图片
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long goodsId = 1L;
		GoodsPictureDO goodsPicture = createGoodsPicture(goodsId);  
		assertNotNull(goodsPicture.getId()); 
		assertThat(goodsPicture.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试删除商品图片
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long goodsId = 1L;
		GoodsPictureDO expectedGoodsPicture = createGoodsPicture(goodsId);
		
		goodsPictureDAO.removeByGoodsId(expectedGoodsPicture.getGoodsId()); 
		
		GoodsPictureDO actualGoodsPicture = goodsPictureDAO.getById(
				expectedGoodsPicture.getId()); 
		
		assertNull(actualGoodsPicture); 
	}
	
	/**
	 * 比较两个商品图片集合
	 * @param expectedGoodsPictureMap 期望的商品图片集合
	 * @param actualGoodsPictures 实际的商品图片集合
	 * @throws Exception
	 */
	private void compareGoodsPictures(Integer expectedSize ,
			Map<Long, GoodsPictureDO> expectedGoodsPictureMap,
			List<GoodsPictureDO> actualGoodsPictures) throws Exception {
		assertEquals((int)expectedSize, actualGoodsPictures.size()); 
		
		for(GoodsPictureDO actualGoodsPicture : actualGoodsPictures) {
			GoodsPictureDO expectedGoodsPicture = expectedGoodsPictureMap.get(
					actualGoodsPicture.getId());
			assertEquals(expectedGoodsPicture, actualGoodsPicture); 
		}
	}
	
	/**
	 * 创建商品图片集合
	 * @param categoryId 类目id
	 * @return 商品图片集合
	 * @throws Exception
	 */
	private Map<Long, GoodsPictureDO> createGoodsPictureMap(
			Long goodsId, Integer count) throws Exception {
		Map<Long, GoodsPictureDO> goodsPictureMap = 
				new HashMap<Long, GoodsPictureDO>(CollectionSize.DEFAULT);
		
		List<GoodsPictureDO> goodsPictures = createGoodsPictures(
				goodsId, count);
		for(GoodsPictureDO goodsPicture : goodsPictures) {
			goodsPictureMap.put(goodsPicture.getId(), goodsPicture);
		}
		
		return goodsPictureMap;
	}
	
	/**
	 * 创建商品图片集合
	 * @param categoryId 类目id 
	 * @param count 商品数量
	 * @return 商品图片集合
	 * @throws Exception
	 */
	private List<GoodsPictureDO> createGoodsPictures(
			Long goodsId, Integer count) throws Exception {
		List<GoodsPictureDO> goodsPictures = new ArrayList<GoodsPictureDO>();
		for(int i = 0; i < count; i++) {
			goodsPictures.add(createGoodsPicture(goodsId));  
		}
		return goodsPictures;
	}
	
	/**
	 * 创建商品图片
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsPictureDO createGoodsPicture(Long goodsId) throws Exception {
		GoodsPictureDO goodsPicture = new GoodsPictureDO();
		
		goodsPicture.setGoodsId(goodsId); 
		goodsPicture.setPicturePath("测试图片路径");   
		goodsPicture.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsPicture.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsPictureDAO.save(goodsPicture);
		
		return goodsPicture;
	}
	
}
