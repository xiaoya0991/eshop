package com.zhss.eshop.schedule.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDetailDO;

/**
 * 调度中心的货位库存明细管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class ScheduleGoodsAllocationStockDetailDAOTest {

	/**
	 * 货位库存明细管理DAO组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockDetailDAO stockDetailDAO;
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
	 * 测试根据商品sku id查询货位库存明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock_detail.sql"})  
	public void testListByGoodsSkuId() throws Exception {
		Long goodsSkuId = 1L;
		Integer count = 10;
		Map<Long, ScheduleGoodsAllocationStockDetailDO> expectedStockDetails = 
				createStockDetailMap(goodsSkuId, count);
		
		List<ScheduleGoodsAllocationStockDetailDO> actualStockDetails = 
				stockDetailDAO.listByGoodsSkuId(goodsSkuId);
		
		compareStockDetails(count, expectedStockDetails, actualStockDetails); 
	}
	
	/**
	 * 测试新增货位库存明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock_detail.sql"})  
	public void testSave() throws Exception { 
		ScheduleGoodsAllocationStockDetailDO expectedStockDetail = createStockDetail();
		assertNotNull(expectedStockDetail.getId()); 
		assertThat(expectedStockDetail.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据id查询货位库存明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock_detail.sql"})  
	public void testGetById() throws Exception {
		Long id = 1L;
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		ScheduleGoodsAllocationStockDetailDO expectedStockDetail = createStockDetail(
				id, goodsAllocationId, goodsSkuId);
		
		ScheduleGoodsAllocationStockDetailDO actualStockDetail = stockDetailDAO.getById(id);
		
		assertEquals(expectedStockDetail, actualStockDetail); 
	}
	
	/**
	 * 测试更新货位库存明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_goods_allocation_stock_detail.sql"})  
	public void testUpdate() throws Exception {
		Long id = 1L;
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		ScheduleGoodsAllocationStockDetailDO expectedStockDetail = createStockDetail(
				id, goodsAllocationId, goodsSkuId);
		
		expectedStockDetail.setCurrentStockQuantity(50L); 
		stockDetailDAO.update(expectedStockDetail);
		
		ScheduleGoodsAllocationStockDetailDO actualStockDetail = stockDetailDAO.getById(id);
		
		assertEquals(expectedStockDetail, actualStockDetail); 
	}
	
	/**
	 * 创建货位库存明细
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private ScheduleGoodsAllocationStockDetailDO createStockDetail() throws Exception {
		Long id = 1L;
		Long goodsAllocationId = 1L;
		Long goodsSkuId = 1L;
		return createStockDetail(id, goodsAllocationId, goodsSkuId);
	}
	
	/**
	 * 比较两个货位库存明细
	 * @param expectedStockDetails 期望的货位库存明细
	 * @param actualStockDetails 实际的货位库存明细
	 */
	private void compareStockDetails(
			Integer expectedSize,
			Map<Long, ScheduleGoodsAllocationStockDetailDO> expectedStockDetails,
			List<ScheduleGoodsAllocationStockDetailDO> actualStockDetails) {
		assertEquals((int)expectedSize, actualStockDetails.size()); 
		for(ScheduleGoodsAllocationStockDetailDO actualStockDetail : actualStockDetails) {
			ScheduleGoodsAllocationStockDetailDO expectedStockDetail = expectedStockDetails.get(
					actualStockDetail.getId());
			assertEquals(expectedStockDetail, actualStockDetail); 
		}
	}
	
	/**
	 * 创建货位库存明细
	 * @param goodsSkuId 商品sku id
	 * @param count 货位库存明细的数量
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private Map<Long, ScheduleGoodsAllocationStockDetailDO> createStockDetailMap(
			Long goodsSkuId, Integer count) throws Exception {
		List<ScheduleGoodsAllocationStockDetailDO> stockDetails = 
				createStockDetails(goodsSkuId, count);
		
		Map<Long, ScheduleGoodsAllocationStockDetailDO> stockDetailMap = 
				new HashMap<Long, ScheduleGoodsAllocationStockDetailDO>();
		
		for(ScheduleGoodsAllocationStockDetailDO stockDetail : stockDetails) {
			stockDetailMap.put(stockDetail.getId(), stockDetail);
		}
		
		return stockDetailMap;
	}
	
	/**
	 * 创建货位库存明细
	 * @param goodsSkuId 商品sku id
	 * @param count 货位库存明细的数量
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private List<ScheduleGoodsAllocationStockDetailDO> createStockDetails(
			Long goodsSkuId, Integer count) throws Exception {
		List<ScheduleGoodsAllocationStockDetailDO> stockDetails = 
				new ArrayList<ScheduleGoodsAllocationStockDetailDO>();
		for(int i = 0; i < count; i++) {
			stockDetails.add(createStockDetail((long)i, (long)i, goodsSkuId)); 
		}
		return stockDetails;
	}
	
	/**
	 * 创建货位库存明细
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private ScheduleGoodsAllocationStockDetailDO createStockDetail(
			Long id, Long goodsAllocationId, Long goodsSkuId) throws Exception {
		ScheduleGoodsAllocationStockDetailDO stockDetail = new ScheduleGoodsAllocationStockDetailDO();
		stockDetail.setId(id); 
		stockDetail.setGoodsAllocationId(goodsAllocationId); 
		stockDetail.setGoodsSkuId(goodsSkuId); 
		stockDetail.setPutOnQuantity(100L); 
		stockDetail.setPutOnTime(dateProvider.getCurrentTime());  
		stockDetail.setCurrentStockQuantity(100L); 
		stockDetail.setLockedStockQuantity(0L); 
		
		stockDetailDAO.save(stockDetail); 
		
		return stockDetail;
	}
	
}
