package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderItemDO;

/**
 * 订单条目管理DAO单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class OrderItemDAOTest {

	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderItemDAO orderItemDAO;
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
	@Sql({"clean_order_item.sql"})
	public void testSave() throws Exception {
		Long orderInfoId = 1L;
		OrderItemDO orderItem = createOrderItem(orderInfoId);
		assertNotNull(orderItem.getId()); 
		assertThat(orderItem.getId(), greaterThan(0L)); 
	} 
	
	/**
	 * 测试查询订单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_order_item.sql"})
	public void testListByOrderInfoId() throws Exception {
		Integer count = 10;
		Long orderInfoId = 1L;
		Map<Long, OrderItemDO> expectedOrderItemMap = 
				createOrderItemMap(count, orderInfoId);
		
		List<OrderItemDO> actualOrderItems = orderItemDAO.listByOrderInfoId(orderInfoId);
		
		compareOrderItems(count, expectedOrderItemMap, actualOrderItems);
	}
	
	/**
	 * 比较订单集合
	 * @param expectedOrderMap 期望的订单集合
	 * @param actualOrders 实际的订单集合
	 * @throws Exception
	 */
	private void compareOrderItems(Integer expectedSize, 
			Map<Long, OrderItemDO> expectedOrderItemMap,
			List<OrderItemDO> actualOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualOrderItems.size()); 
	
		for(OrderItemDO actualOrderItem : actualOrderItems) {
			OrderItemDO expectedOrderItem = expectedOrderItemMap.get(actualOrderItem.getId());
			assertEquals(expectedOrderItem, actualOrderItem);
		}
	}
	
	/**
	 * 创建订单map
	 * @param count 订单数量 
	 * @return 订单map
	 * @throws Exception
	 */
	private Map<Long, OrderItemDO> createOrderItemMap(Integer count, 
			Long orderInfoId) throws Exception {
		Map<Long, OrderItemDO> orderItemMap = new HashMap<Long, OrderItemDO>();
		
		List<OrderItemDO> orderItems = createOrderItems(count, orderInfoId);
		for(OrderItemDO orderItem : orderItems) {
			orderItemMap.put(orderItem.getId(), orderItem);
		}
		
		return orderItemMap;
	}
	
	/**
	 * 创建订单条目集合
	 * @param count 订单条目数量
	 * @return 订单条目集合
	 * @throws Exception
	 */
	private List<OrderItemDO> createOrderItems(Integer count, Long orderInfoId) throws Exception {
		List<OrderItemDO> orderItems = new ArrayList<OrderItemDO>();
		for(int i = 0; i < count; i++) {
			orderItems.add(createOrderItem(orderInfoId));
		}
		return orderItems;
	}
	
	/**
	 * 创建一个订单条目
	 * @param orderInfoId
	 * @return
	 * @throws Exception
	 */
	private OrderItemDO createOrderItem(Long orderInfoId) throws Exception {
		OrderItemDO orderItem = new OrderItemDO();
		orderItem.setOrderInfoId(orderInfoId); 
		orderItem.setGoodsId(1L); 
		orderItem.setGoodsSkuId(1L); 
		orderItem.setGoodsSkuCode(UUID.randomUUID().toString().replace("-", ""));  
		orderItem.setGoodsName("测试商品");
		orderItem.setSaleProperties("测试销售属性");  
		orderItem.setGoodsGrossWeight(56.0); 
		orderItem.setPurchaseQuantity(3L); 
		orderItem.setPurchasePrice(45.5); 
		orderItem.setPromotionActivityId(null); 
		orderItem.setGoodsLength(23.5); 
		orderItem.setGoodsWidth(56.7);
		orderItem.setGoodsHeight(29.6); 
		orderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		orderItem.setGmtModified(dateProvider.getCurrentTime());
		
		orderItemDAO.save(orderItem);
		
		return orderItem;
	}
	
}
