package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;

import java.util.UUID;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
	public void testSave() throws Exception {
		Long orderInfoId = 1L;
		OrderItemDO orderItem = createOrderItem(orderInfoId);
		assertNotNull(orderItem.getId()); 
		assertThat(orderItem.getId(), greaterThan(0L)); 
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
