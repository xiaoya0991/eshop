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
import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDO;

/**
 * 调度中心的拣货条目管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class ScheduleOrderPickingItemDAOTest {

	/**
	 * 拣货条目管理DAO组件
	 */
	@Autowired
	private ScheduleOrderPickingItemDAO pickingItemDAO;
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
	 * 测试新增拣货条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_picking_item.sql"})  
	public void testBatchSave() throws Exception { 
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsSkuId = 1L;
		Integer count = 3;
		
		List<ScheduleOrderPickingItemDO> pickingItems = createPickingItems(
				orderInfoId, orderItemId, goodsSkuId, count);
		
		for(ScheduleOrderPickingItemDO pickingItem : pickingItems) {
			assertNotNull(pickingItem.getId()); 
			assertThat(pickingItem.getId(), greaterThan(0L));  
		}
	}
	
	/**
	 * 测试根据订单id和订单条目id查询拣货条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_picking_item.sql"})  
	public void testListByOrderItemId() throws Exception {
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsSkuId = 1L;
		Integer count = 3;
		
		Map<Long, ScheduleOrderPickingItemDO> expectedPickingItems = 
				createPickingItemMap(orderInfoId, orderItemId, goodsSkuId, count);
		
		List<ScheduleOrderPickingItemDO> actualPickingItems = 
				pickingItemDAO.listByOrderItemId(orderInfoId, orderItemId);
		
		comparePickingItems(count, expectedPickingItems, actualPickingItems); 
	}
	
	/**
	 * 测试根据订单条目id删除拣货条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_picking_item.sql"})  
	public void testRemoveByOrderItemId() throws Exception {
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsSkuId = 1L;
		Integer count = 3;
		
		createPickingItemMap(orderInfoId, orderItemId, goodsSkuId, count);
		pickingItemDAO.removeByOrderItemId(orderInfoId, orderItemId);
		
		List<ScheduleOrderPickingItemDO> actualPickingItems = 
				pickingItemDAO.listByOrderItemId(orderInfoId, orderItemId);
		
		assertEquals(0, actualPickingItems.size());  
	}
	
	/**
	 * 比较两个货位库存明细
	 * @param expectedPickingItems 期望的货位库存明细
	 * @param actualPickingItems 实际的货位库存明细
	 */
	private void comparePickingItems(
			Integer expectedSize,
			Map<Long, ScheduleOrderPickingItemDO> expectedPickingItems,
			List<ScheduleOrderPickingItemDO> actualPickingItems) {
		assertEquals((int)expectedSize, actualPickingItems.size()); 
		for(ScheduleOrderPickingItemDO actualPickingItem : actualPickingItems) {
			ScheduleOrderPickingItemDO expectedPickingItem = expectedPickingItems.get(
					actualPickingItem.getId());
			assertEquals(expectedPickingItem, actualPickingItem); 
		}
	}
	
	/**
	 * 创建货位库存明细
	 * @param goodsSkuId 商品sku id
	 * @param count 货位库存明细的数量
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private Map<Long, ScheduleOrderPickingItemDO> createPickingItemMap(
			Long orderInfoId, Long orderItemId, Long goodsSkuId, Integer count) throws Exception {
		List<ScheduleOrderPickingItemDO> pickingItems = createPickingItems(
				orderInfoId, orderItemId, goodsSkuId, count);
		
		Map<Long, ScheduleOrderPickingItemDO> pickingItemMap = 
				new HashMap<Long, ScheduleOrderPickingItemDO>();
		
		for(ScheduleOrderPickingItemDO pickingItem : pickingItems) {
			pickingItemMap.put(pickingItem.getId(), pickingItem);
		}
		
		return pickingItemMap;
	}
	
	/**
	 * 创建拣货条目
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @param count 拣货条目数量
	 * @return 拣货条目
	 * @throws Exception
	 */
	private List<ScheduleOrderPickingItemDO> createPickingItems(Long orderInfoId, 
			Long orderItemId, Long goodsSkuId, Integer count) throws Exception {
		List<ScheduleOrderPickingItemDO> pickingItems = new ArrayList<ScheduleOrderPickingItemDO>();
		for(int i = 0; i < count; i++) {
			pickingItems.add(createPickingItem(orderInfoId, orderItemId, (long)i, goodsSkuId)); 
		}
		
		pickingItemDAO.batchSave(orderInfoId, orderItemId, pickingItems); 
		
		return pickingItems;
	}
	
	/**
	 * 创建拣货条目
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @return 拣货条目
	 * @throws Exception
	 */
	private ScheduleOrderPickingItemDO createPickingItem(Long orderInfoId, Long orderItemId, 
			Long goodsAllocationId, Long goodsSkuId) throws Exception {
		ScheduleOrderPickingItemDO pickingItem = new ScheduleOrderPickingItemDO();
		pickingItem.setOrderInfoId(orderInfoId);
		pickingItem.setOrderItemId(orderItemId); 
		pickingItem.setGoodsAllocationId(goodsAllocationId); 
		pickingItem.setGoodsSkuId(goodsSkuId); 
		pickingItem.setPickingCount(100L); 
		return pickingItem;
	}
	
}
