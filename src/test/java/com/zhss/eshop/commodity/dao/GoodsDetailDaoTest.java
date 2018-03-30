package com.zhss.eshop.commodity.dao;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.domain.GoodsDetailDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 商品详情管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class GoodsDetailDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品详情管理DAO组件
	 */
	@Autowired
	private GoodsDetailDAO goodsDetailDAO;
	
	/**
	 * 测试根据id查询商品
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_detail.sql"})  
	public void testGetByGoodsId() throws Exception {
		Long goodsId = 1L;
		GoodsDetailDO expectedGoodsDetail = createGoodsDetail(goodsId);
		expectedGoodsDetail.setDetailContent(null); 
		GoodsDetailDO actualGoodsDetail = goodsDetailDAO.getByGoodsId(goodsId);
		assertEquals(expectedGoodsDetail, actualGoodsDetail); 
	}
	
	/**
	 * 测试新建商品
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long goodsId = 1L;
		GoodsDetailDO goodsDetail = createGoodsDetail(goodsId);  
		assertNotNull(goodsDetail.getId()); 
		assertThat(goodsDetail.getId(), greaterThan(0L));
 	}
	
	/**
	 * 测试更新商品
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Long goodsId = 1L;
		GoodsDetailDO expectedGoodsDetail = createGoodsDetail(goodsId);
		
		expectedGoodsDetail.setDetailContent("修改后的" + expectedGoodsDetail.getDetailContent()); 
		goodsDetailDAO.update(expectedGoodsDetail);
		
		GoodsDetailDO actualGoodsDetail = goodsDetailDAO.getByGoodsId(
				expectedGoodsDetail.getGoodsId()); 
		
		assertEquals(expectedGoodsDetail, actualGoodsDetail); 
	}
	
	/**
	 * 测试删除商品
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long goodsId = 1L;
		GoodsDetailDO expectedGoodsDetail = createGoodsDetail(goodsId);
		
		goodsDetailDAO.remove(expectedGoodsDetail.getId()); 
		
		GoodsDetailDO actualGoodsDetail = goodsDetailDAO.getByGoodsId(
				expectedGoodsDetail.getGoodsId()); 
		
		assertNull(actualGoodsDetail); 
	}
	
	/**
	 * 创建商品
	 * @return 商品
	 * @throws Exception
	 */
	private GoodsDetailDO createGoodsDetail(Long goodsId) throws Exception {
		GoodsDetailDO goodsDetail = new GoodsDetailDO();
		
		goodsDetail.setGoodsId(goodsId); 
		goodsDetail.setDetailContent("测试商品详情内容");   
		goodsDetail.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsDetail.setGmtModified(dateProvider.getCurrentTime()); 
		
		goodsDetailDAO.save(goodsDetail);
		
		return goodsDetail;
	}
	
}
