package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderInfoDO;

/**
 * 订单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class OrderInfoDAOTest {

	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDAO orderInfoDAO;
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
	public void testSave() throws Exception {
		OrderInfoDO order = createOrder();
		assertNotNull(order.getId()); 
		assertThat(order.getId(), greaterThan(0L));  
	}
	
	private OrderInfoDO createOrder() throws Exception {
		OrderInfoDO order = new OrderInfoDO();
		order.setUserAccountId(1L); 
		order.setUsername("zhangsan"); 
		order.setOrderNo(UUID.randomUUID().toString().replace("-", ""));   
		order.setOrderStatus(1); 
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
		order.setGmtCreate(dateProvider.getCurrentTime()); 
		order.setGmtModified(dateProvider.getCurrentTime()); 
		
		orderInfoDAO.save(order);
		
		return order;
 	}
	
}
