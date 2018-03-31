package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.SendOutOrderDO;

/**
 * 发货单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class SendOutOrderDaoTest {

	/**
	 * 发货单管理DAO组件
	 */
	@Autowired
	private SendOutOrderDAO sendOutOrderInfoDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增发货单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_send_out_order.sql"})
	public void testSave() throws Exception {
		Long saleDeliveryOrderId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		SendOutOrderDO sendOutOrder = createSendOutOrder(saleDeliveryOrderId, orderId, userAccountId);  
		assertNotNull(sendOutOrder.getId()); 
		assertThat(sendOutOrder.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据id查询发货单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_send_out_order.sql"})
	public void testGetById() throws Exception {
		Long saleDeliveryOrderId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		SendOutOrderDO expectedOrder = createSendOutOrder(saleDeliveryOrderId, orderId, userAccountId);  
		SendOutOrderDO actualOrder = sendOutOrderInfoDAO.getBySaleDeliveryOrderId(saleDeliveryOrderId);
		assertEquals(expectedOrder, actualOrder);  
	}
	
	private SendOutOrderDO createSendOutOrder(Long saleDeliveryOrderId, Long orderId, Long userAccountId) throws Exception {
		SendOutOrderDO sendOutOrder = new SendOutOrderDO();
		
		sendOutOrder.setSaleDeliveryOrderId(saleDeliveryOrderId); 
		sendOutOrder.setUserAccountId(userAccountId); 
		sendOutOrder.setUsername("zhangsan"); 
		sendOutOrder.setOrderId(orderId); 
		sendOutOrder.setOrderNo(UUID.randomUUID().toString().replace("-", ""));   
		sendOutOrder.setConsignee("张三");  
		sendOutOrder.setDeliveryAddress("上海市");  
		sendOutOrder.setConsigneeCellPhoneNumber("13900567849");  
		sendOutOrder.setFreight(10.8); 
		sendOutOrder.setPayType(1); 
		sendOutOrder.setTotalAmount(100.00); 
		sendOutOrder.setDiscountAmount(1.8);
		sendOutOrder.setCouponAmount(10.00); 
		sendOutOrder.setPayableAmount(99.0); 
		sendOutOrder.setInvoiceTitle("上海市某公司");  
		sendOutOrder.setTaxpayerId(UUID.randomUUID().toString().replace("-", ""));  
		sendOutOrder.setOrderComment("测试发货单");  
		sendOutOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		sendOutOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		sendOutOrderInfoDAO.save(sendOutOrder);
		
		return sendOutOrder;
 	}
	
}
