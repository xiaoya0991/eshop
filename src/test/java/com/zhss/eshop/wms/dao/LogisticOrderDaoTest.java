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
import com.zhss.eshop.wms.domain.LogisticOrderDO;

/**
 * 物流单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class LogisticOrderDaoTest {

	/**
	 * 物流单管理DAO组件
	 */
	@Autowired
	private LogisticOrderDAO logisticOrderDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增物流单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_logistic_order.sql"})
	public void testSave() throws Exception {
		Long saleDeliveryOrderId = 1L;
		LogisticOrderDO logisticOrder = createLogisticOrder(saleDeliveryOrderId);  
		assertNotNull(logisticOrder.getId()); 
		assertThat(logisticOrder.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据id查询物流单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_logistic_order.sql"})
	public void testGetById() throws Exception {
		Long saleDeliveryOrderId = 1L;
		LogisticOrderDO expectedOrder = createLogisticOrder(saleDeliveryOrderId);  
		LogisticOrderDO actualOrder = logisticOrderDAO.getBySaleDeliveryOrderId(saleDeliveryOrderId);
		assertEquals(expectedOrder, actualOrder);  
	}
	
	private LogisticOrderDO createLogisticOrder(Long saleDeliveryOrderId) throws Exception {
		LogisticOrderDO logisticOrder = new LogisticOrderDO();
		
		logisticOrder.setSaleDeliveryOrderId(saleDeliveryOrderId); 
		logisticOrder.setLogisticCode(UUID.randomUUID().toString().replace("-", ""));   
		logisticOrder.setContent("测试物流单"); 
		logisticOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		logisticOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		logisticOrderDAO.save(logisticOrder);
		
		return logisticOrder;
 	}
	
}
