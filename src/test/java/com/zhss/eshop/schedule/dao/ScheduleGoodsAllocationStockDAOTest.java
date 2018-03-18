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
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;

/**
 * 调度中心的货位库存管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class ScheduleGoodsAllocationStockDAOTest {

	/**
	 * 货位库存管理DAO组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockDAO goodsAllocationStockDAO;
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
	 * 测试新增货位库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock.sql"})  
	public void testSave() throws Exception { 
		ScheduleGoodsAllocationStockDO expectedGoodsAllocationStock = createGoodsAllocationStock();
		assertNotNull(expectedGoodsAllocationStock.getId()); 
		assertThat(expectedGoodsAllocationStock.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据商品sku id查询货位库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock.sql"})  
	public void testGetBySkuId() throws Exception {
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		ScheduleGoodsAllocationStockDO expectedGoodsAllocationStock = 
				createGoodsAllocationStock(goodsAllocationId, goodsSkuId);
		
		ScheduleGoodsAllocationStockDO actualGoodsAllocationStock = 
				goodsAllocationStockDAO.getBySkuId(goodsAllocationId, goodsSkuId);
		
		assertEquals(expectedGoodsAllocationStock, actualGoodsAllocationStock); 
	}
	
	/**
	 * 测试更新货位库存
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock.sql"})  
	public void testUpdate() throws Exception {
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		ScheduleGoodsAllocationStockDO expectedGoodsAllocationStock = 
				createGoodsAllocationStock(goodsAllocationId, goodsSkuId);
		
		expectedGoodsAllocationStock.setAvailableStockQuantity(100L); 
		goodsAllocationStockDAO.update(expectedGoodsAllocationStock);
		
		ScheduleGoodsAllocationStockDO actualGoodsAllocationStock = 
				goodsAllocationStockDAO.getBySkuId(goodsAllocationId, goodsSkuId);
		
		assertEquals(expectedGoodsAllocationStock, actualGoodsAllocationStock); 
	}
	
	/**
	 * 创建货位库存
	 * @return 货位库存
	 * @throws Exception
	 */
	private ScheduleGoodsAllocationStockDO createGoodsAllocationStock() throws Exception {
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		return createGoodsAllocationStock(goodsAllocationId, goodsSkuId);
	}
	
	/**
	 * 创建货位库存
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 * @throws Exception
	 */
	private ScheduleGoodsAllocationStockDO createGoodsAllocationStock(
			Long goodsAllocationId, Long goodsSkuId) throws Exception {
		ScheduleGoodsAllocationStockDO goodsAllocationStock = new ScheduleGoodsAllocationStockDO();
		goodsAllocationStock.setGoodsAllocationId(goodsAllocationId); 
		goodsAllocationStock.setGoodsSkuId(goodsSkuId); 
		goodsAllocationStock.setAvailableStockQuantity(0L); 
		goodsAllocationStock.setLockedStockQuantity(0L); 
		goodsAllocationStock.setOutputStockQuantity(0L);  
		
		goodsAllocationStockDAO.save(goodsAllocationStock); 
		
		return goodsAllocationStock;
	}
	
}
