package com.zhss.eshop.schedule.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.service.WmsService;

/**
 * 调度中心对外接口service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class ScheduleServiceTest {

	/**
	 * 调度中心service组件
	 */
	@Autowired
	private ScheduleService scheduleService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * wms中心service组件
	 */
	@MockBean
	private WmsService wmsService;
	
	/**
	 * 测试调度采购入库
	 * @throws Exception
	 */
	@Test
	public void testSchedulePurchaseInput() throws Exception {
		PurchaseOrderDTO purchaseOrder = createPurchaseOrder();
		PurchaseInputOrderDTO purchaseInputOrder = createPurchaseInputOrder();
		
		scheduleService.schedulePurchaseInput(purchaseOrder);
		
		verify(wmsService, times(1)).createPurchaseInputOrder(purchaseInputOrder);
	}
	
	/**
	 * 创建采购单
	 * @return 采购单
	 * @throws Exception
	 */
	private PurchaseOrderDTO createPurchaseOrder() throws Exception {
		Long purchaseOrderId = 1L;
		
		PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO();
		purchaseOrder.setId(purchaseOrderId); 
		purchaseOrder.setSupplierId(1L); 
		purchaseOrder.setExpectArrivalTime(dateProvider.parseDatetime("2018-01-10 10:00:00")); 
		purchaseOrder.setContactor("张三"); 
		purchaseOrder.setContactorPhoneNumber("测试电话");  
		purchaseOrder.setContactorEmail("测试邮箱"); 
		purchaseOrder.setRemark("测试采购单");  
		purchaseOrder.setPurchaser("李四");  
		purchaseOrder.setStatus(3); 
		purchaseOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		purchaseOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		List<PurchaseOrderItemDTO> items = new ArrayList<PurchaseOrderItemDTO>();
		for(int i = 0; i < 5; i++) {
			items.add(createPurchaseOrderItem(purchaseOrderId, (long)i, (long)i)); 
		}
		purchaseOrder.setItems(items);
		
		return purchaseOrder;
	}
	
	/**
	 * 创建采购单条目
	 * @return 采购单条目
	 * @throws Exception
	 */
	private PurchaseOrderItemDTO createPurchaseOrderItem(
			Long purchaseOrderId, Long itemId, Long goodsSkuId) throws Exception {
		PurchaseOrderItemDTO item = new PurchaseOrderItemDTO();
		item.setId(itemId);
		item.setPurchaseOrderId(purchaseOrderId);
		item.setGoodsSkuId(goodsSkuId); 
		item.setPurchaseCount(1000L); 
		item.setPurchasePrice(599.45); 
		item.setGmtCreate(dateProvider.getCurrentTime()); 
		item.setGmtModified(dateProvider.getCurrentTime()); 
		return item;
	}
	
	/**
	 * 创建采购入库单
	 * @return
	 * @throws Exception
	 */
	private PurchaseInputOrderDTO createPurchaseInputOrder() throws Exception {
		PurchaseInputOrderDTO purchaseInputOrder = new PurchaseInputOrderDTO(); 
		purchaseInputOrder.setSupplierId(1L); 
		purchaseInputOrder.setExpectArrivalTime(dateProvider.parseDatetime("2018-01-10 10:00:00")); 
		purchaseInputOrder.setPurchaseContactor("张三"); 
		purchaseInputOrder.setPurchaseContactPhoneNumber("测试电话");  
		purchaseInputOrder.setPurchaseContactEmail("测试邮箱"); 
		purchaseInputOrder.setPurchaseOrderComment("测试采购单");  
		purchaseInputOrder.setPurchaser("李四");  
		
		List<PurchaseInputOrderItemDTO> items = new ArrayList<PurchaseInputOrderItemDTO>();
		for(int i = 0; i < 5; i++) {
			items.add(createPurchaseInputOrderItem((long)i));  
		}
		purchaseInputOrder.setPurchaseInputOrderItemDTOs(items); 
		
		return purchaseInputOrder;
	}
	
	/**
	 * 创建采购入库单条目
	 * @return 采购单条目
	 * @throws Exception
	 */
	private PurchaseInputOrderItemDTO createPurchaseInputOrderItem(Long goodsSkuId) throws Exception {
		PurchaseInputOrderItemDTO item = new PurchaseInputOrderItemDTO();
		item.setGoodsSkuId(goodsSkuId); 
		item.setPurchaseCount(1000L); 
		item.setPurchasePrice(599.45); 
		return item;
	}
	
}
