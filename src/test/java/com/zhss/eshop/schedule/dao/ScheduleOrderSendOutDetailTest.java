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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDO;

/**
 * 调度中心的发货明细管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class ScheduleOrderSendOutDetailTest {

	/**
	 * 发货明细管理DAO组件
	 */
	@Autowired
	private ScheduleOrderSendOutDetailDAO sendOutDetailDAO;
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
	 * 测试新增发货明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_send_out_detail.sql"})  
	public void testBatchSave() throws Exception { 
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsAllocationStockDetailId = 1L;
		Integer count = 3;
		
		List<ScheduleOrderSendOutDetailDO> sendOutDetails = createSendOutDetails(
				orderInfoId, orderItemId, goodsAllocationStockDetailId, count);
		
		for(ScheduleOrderSendOutDetailDO sendOutDetail : sendOutDetails) {
			assertNotNull(sendOutDetail.getId()); 
			assertThat(sendOutDetail.getId(), greaterThan(0L));  
		}
	}
	
	/**
	 * 测试根据订单id和订单条目id查询发货明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_send_out_detail.sql"})  
	public void testListByOrderItemId() throws Exception {
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsAllocationStockDetailId = 1L;
		Integer count = 3;
		
		Map<Long, ScheduleOrderSendOutDetailDO> expectedSendOutDetails = 
				createSendOutDetailMap(orderInfoId, orderItemId, goodsAllocationStockDetailId, count);
		
		List<ScheduleOrderSendOutDetailDO> actualSendOutDetails = 
				sendOutDetailDAO.listByOrderItemId(orderInfoId, orderItemId);
		
		compareSendOutDetails(count, expectedSendOutDetails, actualSendOutDetails); 
	}
	
	/**
	 * 测试根据订单条目id删除发货明细
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_send_out_detail.sql"})  
	public void testRemoveByOrderItemId() throws Exception {
		Long orderInfoId = 1L;
		Long orderItemId = 1L;
		Long goodsAllocationStockDetailId = 1L;
		Integer count = 3;
		
		createSendOutDetailMap(orderInfoId, orderItemId, goodsAllocationStockDetailId, count);
		sendOutDetailDAO.removeByOrderItemId(orderInfoId, orderItemId);
		
		List<ScheduleOrderSendOutDetailDO> actualSendOutDetails = 
				sendOutDetailDAO.listByOrderItemId(orderInfoId, orderItemId);
		
		assertEquals(0, actualSendOutDetails.size());  
	}
	
	/**
	 * 比较两个货位库存明细
	 * @param expectedSendOutDetails 期望的货位库存明细
	 * @param actualSendOutDetails 实际的货位库存明细
	 */
	private void compareSendOutDetails(
			Integer expectedSize,
			Map<Long, ScheduleOrderSendOutDetailDO> expectedSendOutDetails,
			List<ScheduleOrderSendOutDetailDO> actualSendOutDetails) {
		assertEquals((int)expectedSize, actualSendOutDetails.size()); 
		for(ScheduleOrderSendOutDetailDO actualSendOutDetail : actualSendOutDetails) {
			ScheduleOrderSendOutDetailDO expectedSendOutDetail = expectedSendOutDetails.get(
					actualSendOutDetail.getId());
			assertEquals(expectedSendOutDetail, actualSendOutDetail); 
		}
	}
	
	/**
	 * 创建货位库存明细
	 * @param goodsAllocationStockDetailId 商品sku id
	 * @param count 货位库存明细的数量
	 * @return 货位库存明细
	 * @throws Exception
	 */
	private Map<Long, ScheduleOrderSendOutDetailDO> createSendOutDetailMap(
			Long orderInfoId, Long orderItemId, Long goodsAllocationStockDetailId, Integer count) throws Exception {
		List<ScheduleOrderSendOutDetailDO> sendOutDetails = createSendOutDetails(
				orderInfoId, orderItemId, goodsAllocationStockDetailId, count);
		
		Map<Long, ScheduleOrderSendOutDetailDO> sendOutDetailMap = 
				new HashMap<Long, ScheduleOrderSendOutDetailDO>(CollectionSize.DEFAULT);
		
		for(ScheduleOrderSendOutDetailDO sendOutDetail : sendOutDetails) {
			sendOutDetailMap.put(sendOutDetail.getId(), sendOutDetail);
		}
		
		return sendOutDetailMap;
	}
	
	/**
	 * 创建发货明细
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 * @param goodsAllocationId 货位id
	 * @param goodsAllocationStockDetailId 商品sku id
	 * @param count 发货明细数量
	 * @return 发货明细
	 * @throws Exception
	 */
	private List<ScheduleOrderSendOutDetailDO> createSendOutDetails(Long orderInfoId, 
			Long orderItemId, Long goodsAllocationStockDetailId, Integer count) throws Exception {
		List<ScheduleOrderSendOutDetailDO> sendOutDetails = new ArrayList<ScheduleOrderSendOutDetailDO>();
		
		for(int i = 0; i < count; i++) {
			sendOutDetails.add(createSendOutDetail(orderInfoId, orderItemId, 
					goodsAllocationStockDetailId)); 
		}
		
		sendOutDetailDAO.batchSave(orderInfoId, orderItemId, sendOutDetails); 
		
		return sendOutDetails;
	}
	
	/**
	 * 创建发货明细
	 * @param goodsAllocationId 货位id
	 * @param goodsAllocationStockDetailId 商品sku id
	 * @return 发货明细
	 * @throws Exception
	 */
	private ScheduleOrderSendOutDetailDO createSendOutDetail(Long orderInfoId, Long orderItemId, 
			Long goodsAllocationStockDetailId) throws Exception {
		ScheduleOrderSendOutDetailDO sendOutDetail = new ScheduleOrderSendOutDetailDO();
		sendOutDetail.setOrderInfoId(orderInfoId);
		sendOutDetail.setOrderItemId(orderItemId); 
		sendOutDetail.setGoodsAllocationStockDetailId(goodsAllocationStockDetailId);
		sendOutDetail.setSendOutCount(100L);  
		return sendOutDetail;
	}
	
}
