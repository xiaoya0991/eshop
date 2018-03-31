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

import com.zhss.eshop.commodity.domain.GoodsSkuDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品sku管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class GoodsSkuDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品sku管理DAO组件
	 */
	@Autowired
	private GoodsSkuDAO goodsSkuDAO;
	
	/**
	 * 测试根据商品id查询商品sku
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_sku.sql"})  
	public void testListByGoodsId() throws Exception {
		Long goodsId = 1L;
		Integer count = 10;
		Map<Long, GoodsSkuDO> expectedGoodsSkuMap = 
				createGoodsSkuMap(goodsId, count);
		
		List<GoodsSkuDO> actualGoodsSkus = 
				goodsSkuDAO.listByGoodsId(goodsId);
		
		compareGoodsSkus(count, expectedGoodsSkuMap, 
				actualGoodsSkus); 
	}
	
	/**
	 * 测试新建商品sku
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long goodsId = 1L;
		GoodsSkuDO goodsSku = createGoodsSku(goodsId);  
		assertNotNull(goodsSku.getId()); 
		assertThat(goodsSku.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试删除商品sku
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_sku.sql"})  
	public void testRemove() throws Exception {
		Long goodsId = 1L;
		GoodsSkuDO expectedGoodsSku = createGoodsSku(goodsId);
		
		goodsSkuDAO.removeByGoodsId(expectedGoodsSku.getGoodsId()); 
		
		List<GoodsSkuDO> actualGoodsSkus = 
				goodsSkuDAO.listByGoodsId(goodsId);
		
		assertEquals(0, actualGoodsSkus.size()); 
	}
	
	/**
	 * 比较两个商品sku集合
	 * @param expectedGoodsSkuMap 期望的商品sku集合
	 * @param actualGoodsSkus 实际的商品sku集合
	 * @throws Exception
	 */
	private void compareGoodsSkus(Integer expectedSize ,
			Map<Long, GoodsSkuDO> expectedGoodsSkuMap,
			List<GoodsSkuDO> actualGoodsSkus) throws Exception {
		assertEquals((int)expectedSize, actualGoodsSkus.size()); 
		
		for(GoodsSkuDO actualGoodsSku : actualGoodsSkus) {
			GoodsSkuDO expectedGoodsSku = expectedGoodsSkuMap.get(
					actualGoodsSku.getId());
			assertEquals(expectedGoodsSku, actualGoodsSku); 
		}
	}
	
	/**
	 * 创建商品sku集合
	 * @param goodsId 商品id
	 * @return 商品sku集合
	 * @throws Exception
	 */
	private Map<Long, GoodsSkuDO> createGoodsSkuMap(
			Long goodsId, Integer count) throws Exception {
		Map<Long, GoodsSkuDO> goodsSkuMap = 
				new HashMap<Long, GoodsSkuDO>(CollectionSize.DEFAULT);
		
		List<GoodsSkuDO> goodsSkus = createGoodsSkus(
				goodsId, count);
		for(GoodsSkuDO goodsSku : goodsSkus) {
			goodsSkuMap.put(goodsSku.getId(), goodsSku);
		}
		
		return goodsSkuMap;
	}
	
	/**
	 * 创建商品sku集合
	 * @param goodsId 商品id
	 * @param count 商品数量
	 * @return 商品sku集合
	 * @throws Exception
	 */
	private List<GoodsSkuDO> createGoodsSkus(
			Long goodsId, Integer count) throws Exception {
		List<GoodsSkuDO> goodsSkus = new ArrayList<GoodsSkuDO>();
		for(int i = 0; i < count; i++) {
			goodsSkus.add(createGoodsSku(goodsId));  
		}
		return goodsSkus;
	}
	
	/**
	 * 创建商品sku
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsSkuDO createGoodsSku(Long goodsId) throws Exception {
		GoodsSkuDO goodsSku = new GoodsSkuDO();
		
		goodsSku.setGoodsId(goodsId); 
		goodsSku.setSkuCode("测试编号"); 
		goodsSku.setPurchasePrice(45.0); 
		goodsSku.setSalePrice(23.4); 
		goodsSku.setDiscountPrice(45.7);
		goodsSku.setSaleProperties("测试销售属性");  
		goodsSku.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsSku.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsSkuDAO.save(goodsSku);
		
		return goodsSku;
	}
	
}
