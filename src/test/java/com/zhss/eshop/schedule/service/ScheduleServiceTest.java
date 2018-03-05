package com.zhss.eshop.schedule.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;

/**
 * 调度中心对外接口service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class ScheduleServiceTest {

	/**
	 * 调度中心对外接口service组件
	 */
	@Autowired
	private ScheduleService scheduleService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试调度采购入库
	 * @throws Exception
	 */
	@Test
	public void testSchedulePurchaseInput() throws Exception {
		
	}
	
	/**
	 * 创建采购单
	 * @return 采购单
	 * @throws Exception
	 */
	private PurchaseOrderDTO createPurchaseOrder() throws Exception {
		PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO();
		purchaseOrder.setId(1L); 
		purchaseOrder.setSupplierId(1L); 
		purchaseOrder.setExpectArrivalTime(dateProvider.parseDatetime("2018-01-10 10:00:00")); 
		purchaseOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		purchaseOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		purchaseOrder.setPurcahseOrderStatus(3); 
		
		return null;
	}
	
}
