package com.zhss.eshop.schedule.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.domain.ScheduleGoodsStockDO;

/**
 * 调度中心的商品库存管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class ScheduleGoodsStockDaoTest {

	/**
	 * 商品库存管理DAO组件
	 */
	@Autowired
	private ScheduleGoodsStockDAO goodsStockDAO;
	/**
	 * mock后的日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		when(dateProvider.getCurrentTime()).thenReturn(formatter.parse(formatter.format(new Date()))); 
	}
	
	/**
	 * 测试新增商品库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_stock.sql"})  
	public void testSave() throws Exception { 
		ScheduleGoodsStockDO expectedGoodsStock = createGoodsStock();
		assertNotNull(expectedGoodsStock.getId()); 
		assertThat(expectedGoodsStock.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据商品sku id查询商品库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_stock.sql"})  
	public void testGetBySkuId() throws Exception {
		Long goodsSkuId = 1L;
		ScheduleGoodsStockDO expectedGoodsStock = createGoodsStock(goodsSkuId);
		ScheduleGoodsStockDO actualGoodsStock = goodsStockDAO.getBySkuId(goodsSkuId);
		assertEquals(expectedGoodsStock, actualGoodsStock); 
	}
	
	/**
	 * 测试更新商品库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_stock.sql"})  
	public void testUpdate() throws Exception {
		Long goodsSkuId = 1L;
		ScheduleGoodsStockDO expectedGoodsStock = createGoodsStock(goodsSkuId);
		
		expectedGoodsStock.setAvailableStockQuantity(100L); 
		goodsStockDAO.update(expectedGoodsStock);
		
		ScheduleGoodsStockDO actualGoodsStock = goodsStockDAO.getBySkuId(goodsSkuId);
		
		assertEquals(expectedGoodsStock, actualGoodsStock); 
	}
	
	/**
	 * 创建商品库存
	 * @return 商品库存
	 * @throws Exception
	 */
	private ScheduleGoodsStockDO createGoodsStock() throws Exception {
		Long goodsSkuId = 1L;
		return createGoodsStock(goodsSkuId);
	}
	
	/**
	 * 创建商品库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存
	 * @throws Exception
	 */
	private ScheduleGoodsStockDO createGoodsStock(Long goodsSkuId) throws Exception {
		ScheduleGoodsStockDO goodsStock = new ScheduleGoodsStockDO();
		goodsStock.setGoodsSkuId(goodsSkuId); 
		goodsStock.setAvailableStockQuantity(0L); 
		goodsStock.setLockedStockQuantity(0L); 
		goodsStock.setOutputStockQuantity(0L);  
		
		goodsStockDAO.save(goodsStock); 
		
		return goodsStock;
	}
	
}
