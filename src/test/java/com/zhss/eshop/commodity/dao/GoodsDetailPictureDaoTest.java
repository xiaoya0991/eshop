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

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品详情图片管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class GoodsDetailPictureDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品详情图片管理DAO组件
	 */
	@Autowired
	private GoodsDetailPictureDAO goodsDetailPictureDAO;
	
	/**
	 * 测试根据id查询商品详情图片
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		Long goodsDetailId = 1L;
		GoodsDetailPictureDO expectedGoodsDetailPicture = 
				createGoodsDetailPicture(goodsDetailId);  
		
		GoodsDetailPictureDO actualGoodsDetailPicture = goodsDetailPictureDAO.getById(
				expectedGoodsDetailPicture.getId());
		
		assertEquals(expectedGoodsDetailPicture, actualGoodsDetailPicture); 
	}
	
	/**
	 * 测试根据商品详情id查询商品详情图片
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_detail_picture.sql"})  
	public void testListByGoodsDetailId() throws Exception {
		Long goodsDetailId = 1L;
		Integer count = 10;
		Map<Long, GoodsDetailPictureDO> expectedGoodsDetailPictureMap = 
				createGoodsDetailPictureMap(goodsDetailId, count);
		
		List<GoodsDetailPictureDO> actualGoodsDetailPictures = 
				goodsDetailPictureDAO.listByGoodsDetailId(goodsDetailId);
		
		compareGoodsDetailPictures(count, expectedGoodsDetailPictureMap, 
				actualGoodsDetailPictures); 
	}
	
	/**
	 * 测试新建商品详情图片
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long goodsDetailId = 1L;
		GoodsDetailPictureDO goodsDetailPicture = createGoodsDetailPicture(goodsDetailId);  
		assertNotNull(goodsDetailPicture.getId()); 
		assertThat(goodsDetailPicture.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试删除商品详情图片
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long goodsDetailId = 1L;
		GoodsDetailPictureDO expectedGoodsDetailPicture = createGoodsDetailPicture(goodsDetailId);
		
		goodsDetailPictureDAO.removeByGoodsDetailId(expectedGoodsDetailPicture.getGoodsDetailId()); 
		
		GoodsDetailPictureDO actualGoodsDetailPicture = goodsDetailPictureDAO.getById(
				expectedGoodsDetailPicture.getId()); 
		
		assertNull(actualGoodsDetailPicture); 
	}
	
	/**
	 * 比较两个商品详情图片集合
	 * @param expectedGoodsDetailPictureMap 期望的商品详情图片集合
	 * @param actualGoodsDetailPictures 实际的商品详情图片集合
	 * @throws Exception
	 */
	private void compareGoodsDetailPictures(Integer expectedSize ,
			Map<Long, GoodsDetailPictureDO> expectedGoodsDetailPictureMap,
			List<GoodsDetailPictureDO> actualGoodsDetailPictures) throws Exception {
		assertEquals((int)expectedSize, actualGoodsDetailPictures.size()); 
		
		for(GoodsDetailPictureDO actualGoodsDetailPicture : actualGoodsDetailPictures) {
			GoodsDetailPictureDO expectedGoodsDetailPicture = expectedGoodsDetailPictureMap.get(
					actualGoodsDetailPicture.getId());
			assertEquals(expectedGoodsDetailPicture, actualGoodsDetailPicture); 
		}
	}
	
	/**
	 * 创建商品详情图片集合
	 * @param categoryId 类目id
	 * @return 商品详情图片集合
	 * @throws Exception
	 */
	private Map<Long, GoodsDetailPictureDO> createGoodsDetailPictureMap(
			Long goodsDetailId, Integer count) throws Exception {
		Map<Long, GoodsDetailPictureDO> goodsDetailPictureMap = 
				new HashMap<Long, GoodsDetailPictureDO>(CollectionSize.DEFAULT);
		
		List<GoodsDetailPictureDO> goodsDetailPictures = createGoodsDetailPictures(
				goodsDetailId, count);
		for(GoodsDetailPictureDO goodsDetailPicture : goodsDetailPictures) {
			goodsDetailPictureMap.put(goodsDetailPicture.getId(), goodsDetailPicture);
		}
		
		return goodsDetailPictureMap;
	}
	
	/**
	 * 创建商品详情图片集合
	 * @param categoryId 类目id 
	 * @param count 商品数量
	 * @return 商品详情图片集合
	 * @throws Exception
	 */
	private List<GoodsDetailPictureDO> createGoodsDetailPictures(
			Long goodsDetailId, Integer count) throws Exception {
		List<GoodsDetailPictureDO> goodsDetailPictures = new ArrayList<GoodsDetailPictureDO>();
		for(int i = 0; i < count; i++) {
			goodsDetailPictures.add(createGoodsDetailPicture(goodsDetailId));  
		}
		return goodsDetailPictures;
	}
	
	/**
	 * 创建商品详情图片
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsDetailPictureDO createGoodsDetailPicture(Long goodsDetailId) throws Exception {
		GoodsDetailPictureDO goodsDetailPicture = new GoodsDetailPictureDO();
		
		goodsDetailPicture.setGoodsDetailId(goodsDetailId); 
		goodsDetailPicture.setPicturePath("测试图片路径");   
		goodsDetailPicture.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsDetailPicture.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsDetailPictureDAO.save(goodsDetailPicture);
		
		return goodsDetailPicture;
	}
	
}
