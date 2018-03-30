package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderOperateLogDO;

/**
 * 订单操作日志DAO的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class OrderOperateLogDaoTest {

	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderOperateLogDAO orderOperateLogDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增商品条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_operate_log.sql"})  
	public void testSave() throws Exception {
		Long orderInfoId = 1L;
		OrderOperateLogDO orderOperateLog = createOrderOperateLog(orderInfoId);
		assertNotNull(orderOperateLog.getId()); 
		assertThat(orderOperateLog.getId(), greaterThan(0L)); 
	} 
	
	/**
	 * 测试查询订单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_operate_log.sql"})  
	public void testListByOrderInfoId() throws Exception {
		Integer count = 10;
		Long orderInfoId = 1L;
		Map<Long, OrderOperateLogDO> expectedOrderOperateLogMap = 
				createOrderOperateLogMap(count, orderInfoId);
		
		List<OrderOperateLogDO> actualOrderOperateLogs = orderOperateLogDAO
				.listByOrderInfoId(orderInfoId);
		
		compareOrderOperateLogs(count, expectedOrderOperateLogMap, actualOrderOperateLogs);
	}
	
	/**
	 * 比较订单集合
	 * @param expectedOrderMap 期望的订单集合
	 * @param actualOrders 实际的订单集合
	 * @throws Exception
	 */
	private void compareOrderOperateLogs(Integer expectedSize, 
			Map<Long, OrderOperateLogDO> expectedOrderOperateLogMap,
			List<OrderOperateLogDO> actualOrderOperateLogs) throws Exception {
		assertEquals((int)expectedSize, actualOrderOperateLogs.size()); 
	
		for(OrderOperateLogDO actualOrderOperateLog : actualOrderOperateLogs) {
			OrderOperateLogDO expectedOrderOperateLog = expectedOrderOperateLogMap.get(actualOrderOperateLog.getId());
			assertEquals(expectedOrderOperateLog, actualOrderOperateLog);
		}
	}
	
	/**
	 * 创建订单map
	 * @param count 订单数量 
	 * @return 订单map
	 * @throws Exception
	 */
	private Map<Long, OrderOperateLogDO> createOrderOperateLogMap(Integer count, 
			Long orderInfoId) throws Exception {
		Map<Long, OrderOperateLogDO> orderOperateLogMap = new HashMap<Long, OrderOperateLogDO>(CollectionSize.DEFAULT);
		
		List<OrderOperateLogDO> orderOperateLogs = createOrderOperateLogs(count, orderInfoId);
		for(OrderOperateLogDO orderOperateLog : orderOperateLogs) {
			orderOperateLogMap.put(orderOperateLog.getId(), orderOperateLog);
		}
		
		return orderOperateLogMap;
	}
	
	/**
	 * 创建订单条目集合
	 * @param count 订单条目数量
	 * @return 订单条目集合
	 * @throws Exception
	 */
	private List<OrderOperateLogDO> createOrderOperateLogs(Integer count, Long orderInfoId) throws Exception {
		List<OrderOperateLogDO> orderOperateLogs = new ArrayList<OrderOperateLogDO>();
		for(int i = 0; i < count; i++) {
			orderOperateLogs.add(createOrderOperateLog(orderInfoId));
		}
		return orderOperateLogs;
	}
	
	/**
	 * 创建一个订单条目
	 * @param orderInfoId
	 * @return
	 * @throws Exception
	 */
	private OrderOperateLogDO createOrderOperateLog(Long orderInfoId) throws Exception {
		OrderOperateLogDO orderOperateLog = new OrderOperateLogDO();
		orderOperateLog.setOrderInfoId(orderInfoId); 
		orderOperateLog.setOperateType(1); 
		orderOperateLog.setOperateContent("测试内容");  
		orderOperateLog.setGmtCreate(dateProvider.getCurrentTime()); 
		orderOperateLog.setGmtModified(dateProvider.getCurrentTime());
		
		orderOperateLogDAO.save(orderOperateLog);
		
		return orderOperateLog;
	}
	
}
