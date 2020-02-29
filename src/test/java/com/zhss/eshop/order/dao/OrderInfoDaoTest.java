package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoQuery;

/**
 * 订单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class OrderInfoDaoTest {

	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDao orderInfoDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testSave() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		OrderInfoDO order = createOrder(userAccountId, orderStatus);  
		assertNotNull(order.getId()); 
		assertThat(order.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testListByPage() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		
		Integer count = 30;
		Map<Long, OrderInfoDO> expectedOrderMap = createOrderMap(count, userAccountId, orderStatus);
		processExpectedOrderForListByPage(expectedOrderMap); 
		
		Integer offset = 10;
		Integer size = 10;
		OrderInfoQuery query = createOrderInfoQuery(offset, size, userAccountId);
		List<OrderInfoDO> actualOrders = orderInfoDAO.listByPage(query);
		
		compareOrders(size, expectedOrderMap, actualOrders); 
	}
	
	/**
	 * 测试根据id查询订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testGetById() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		OrderInfoDO expectedOrder = createOrder(userAccountId, orderStatus);  
		OrderInfoDO actualOrder = orderInfoDAO.getById(expectedOrder.getId());
		assertEquals(expectedOrder, actualOrder);  
	}
	
	/**
	 * 测试查询所有未付款的订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testListAllUnpayed() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		
		Integer count = 10;
		Map<Long, OrderInfoDO> expectedOrders = createOrderMap(count, userAccountId, orderStatus);
		
		List<OrderInfoDO> actualOrders = orderInfoDAO.listAllUnpayed();
		
		compareOrders(count, expectedOrders, actualOrders); 
	}
	
	/**
	 * 测试查询所有待收货的订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testListAllUnreceived() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_RECEIVE;
		
		Integer count = 10;
		Map<Long, OrderInfoDO> expectedOrders = createOrderMap(count, userAccountId, orderStatus);
		
		List<OrderInfoDO> actualOrders = orderInfoDAO.listUnreceived();
		
		compareOrders(count, expectedOrders, actualOrders); 
	}
	
	/**
	 * 测试查询确认收货时间超过了7天而且还没有发表评论的订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testListNotPublishedCommentOrders() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		
		Integer count = 10;
		Map<Long, OrderInfoDO> expectedOrders = createOrderMap(count, userAccountId, orderStatus);
		
		List<OrderInfoDO> actualOrders = orderInfoDAO.listNotPublishedCommentOrders();
		
		compareOrders(count, expectedOrders, actualOrders); 
	}
	
	/**
	 * 测试更新订单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testUpdate() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		
		OrderInfoDO expectedOrder = createOrder(userAccountId, orderStatus);  
		
		expectedOrder.setOrderStatus(OrderStatus.WAIT_FOR_DELIVERY);  
		orderInfoDAO.update(expectedOrder); 
		
		OrderInfoDO actualOrder = orderInfoDAO.getById(expectedOrder.getId());
		
		assertEquals(expectedOrder, actualOrder);  
	}
	
	/**
	 * 测试更新订单状态
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order.sql"})    
	public void testUpdateStatus() throws Exception {
		Long userAccountId = 1L;
		Integer orderStatus = OrderStatus.WAIT_FOR_PAY;
		
		OrderInfoDO expectedOrder = createOrder(userAccountId, orderStatus);  
		expectedOrder.setOrderStatus(OrderStatus.WAIT_FOR_DELIVERY);  

		orderInfoDAO.updateStatus(expectedOrder.getId(), OrderStatus.WAIT_FOR_DELIVERY); 
		
		OrderInfoDO actualOrder = orderInfoDAO.getById(expectedOrder.getId());
		
		assertEquals(expectedOrder, actualOrder);  
	}
	
	/**
	 * 为分页查询处理一下期望的订单集合
	 * @param expectedOrderMap 期望的订单集合
	 * @throws Exception
	 */
	private void processExpectedOrderForListByPage(
			Map<Long, OrderInfoDO> expectedOrderMap) throws Exception {
		for(OrderInfoDO expectedOrder : expectedOrderMap.values()) {
			expectedOrder.setDeliveryAddress(null);
			expectedOrder.setConsigneeCellPhoneNumber(null); 
			expectedOrder.setInvoiceTitle(null); 
			expectedOrder.setTaxpayerId(null); 
			expectedOrder.setOrderComment(null); 
			expectedOrder.setPublishedComment(null); 
			expectedOrder.setGmtModified(null); 
		}
	}
	
	/**
	 * 比较订单集合
	 * @param expectedOrderMap 期望的订单集合
	 * @param actualOrders 实际的订单集合
	 * @throws Exception
	 */
	private void compareOrders(Integer expectedSize, 
			Map<Long, OrderInfoDO> expectedOrderMap,
			List<OrderInfoDO> actualOrders) throws Exception {
		assertEquals((int)expectedSize, actualOrders.size()); 
	
		for(OrderInfoDO actualOrder : actualOrders) {
			OrderInfoDO expectedOrder = expectedOrderMap.get(actualOrder.getId());
			assertEquals(expectedOrder, actualOrder);
		}
	}
	
	/**
	 * 创建订单查询条件
	 * @param offset 分页查询起始位置
	 * @param size 每页的数据量
	 * @return 订单查询条件
	 * @throws Exception
	 */
	private OrderInfoQuery createOrderInfoQuery(Integer offset, 
			Integer size, Long userAccountId) throws Exception {
		OrderInfoQuery query = new OrderInfoQuery();
		query.setOffset(offset);
		query.setSize(size); 
		query.setUserAccountId(userAccountId);
		return query;
	}
	
	/**
	 * 创建订单map
	 * @param count 订单数量 
	 * @return 订单map
	 * @throws Exception
	 */
	private Map<Long, OrderInfoDO> createOrderMap(Integer count, 
			Long userAccountId, Integer orderStatus) throws Exception {
		Map<Long, OrderInfoDO> orderMap = new HashMap<Long, OrderInfoDO>(CollectionSize.DEFAULT);
	
		List<OrderInfoDO> orders = createOrders(count, userAccountId, orderStatus);
		for(OrderInfoDO order : orders) {
			orderMap.put(order.getId(), order);
		}
		
		return orderMap;
	}
	
	/**
	 * 创建订单集合
	 * @param count 订单数量
	 * @return 订单集合
	 * @throws Exception
	 */
	private List<OrderInfoDO> createOrders(Integer count, 
			Long userAccountId, Integer orderStatus) throws Exception {
		List<OrderInfoDO> orders = new ArrayList<OrderInfoDO>();
		for(int i = 0; i < count; i++) {
			orders.add(createOrder(userAccountId, orderStatus));
		}
		return orders;
	}
	
	private OrderInfoDO createOrder(Long userAccountId, Integer orderStatus) throws Exception {
		OrderInfoDO order = new OrderInfoDO();
		
		order.setUserAccountId(userAccountId); 
		order.setUsername("zhangsan"); 
		order.setOrderNo(UUID.randomUUID().toString().replace("-", ""));   
		order.setOrderStatus(orderStatus); 
		order.setConsignee("张三");  
		order.setDeliveryAddress("上海市");  
		order.setConsigneeCellPhoneNumber("13900567849");  
		order.setFreight(10.8); 
		order.setPayType(1); 
		order.setTotalAmount(100.00); 
		order.setDiscountAmount(1.8);
		order.setCouponAmount(10.00); 
		order.setPayableAmount(99.0); 
		order.setInvoiceTitle("上海市某公司");  
		order.setTaxpayerId(UUID.randomUUID().toString().replace("-", ""));  
		order.setOrderComment("测试订单");  
		order.setPublishedComment(0); 
		order.setConfirmReceiptTime(dateProvider.parseDatetime("2018-01-01 10:00:00"));   
		order.setGmtCreate(dateProvider.getCurrentTime()); 
		order.setGmtModified(dateProvider.getCurrentTime()); 
		
		orderInfoDAO.save(order);
		
		return order;
 	}
	
}
