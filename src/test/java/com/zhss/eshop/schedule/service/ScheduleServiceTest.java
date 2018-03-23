package com.zhss.eshop.schedule.service;

import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDTO;
import com.zhss.eshop.wms.constant.SaleDeliveryOrderStatus;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDTO;
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
	@MockBean
	private DateProvider dateProvider;
	/**
	 * wms中心service组件
	 */
	@MockBean
	private WmsService wmsService;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		when(dateProvider.getCurrentTime()).thenReturn(dateFormatter.parse(dateFormatter.format(new Date())));    
	}
	
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
	 * 测试调度销售出库
	 * @throws Exception
	 */
	@Test
	public void testScheduleSaleDelivery() throws Exception {
		OrderInfoDTO order = createOrder();
		
		for(OrderItemDTO orderItem : order.getOrderItems()) {
			mockStockDetails(orderItem.getGoodsSkuId());  
		}
		
		SaleDeliveryOrderDTO expectedSaleDeliveryOrder = 
				createExpectedSaleDeliveryOrder(order);
		
		scheduleService.scheduleSaleDelivery(order);
		
		verify(wmsService, times(1)).createSaleDeliveryOrder(expectedSaleDeliveryOrder);
	}
	
	/**
	 * 自行创建一个期望的销售出库单
	 * @param order
	 * @return
	 * @throws Exception
	 */
	private SaleDeliveryOrderDTO createExpectedSaleDeliveryOrder(
			OrderInfoDTO order) throws Exception {
		SaleDeliveryOrderDTO saleDeliveryOrder = new SaleDeliveryOrderDTO();
		saleDeliveryOrder.setOrderId(order.getId()); 
		order.clone(saleDeliveryOrder);
		
		List<SaleDeliveryOrderItemDTO> saleDeliveryOrderItems = 
				new ArrayList<SaleDeliveryOrderItemDTO>();
		saleDeliveryOrder.setSaleDeliveryOrderItems(saleDeliveryOrderItems);
		
		for(OrderItemDTO orderItem : order.getOrderItems()) {
			SaleDeliveryOrderItemDTO saleDeliveryOrderItem = new SaleDeliveryOrderItemDTO();
			
			List<SaleDeliveryOrderPickingItemDTO> pickingItems = 
					new ArrayList<SaleDeliveryOrderPickingItemDTO>();
			
			SaleDeliveryOrderPickingItemDTO pickingItem1 = new SaleDeliveryOrderPickingItemDTO();
			pickingItem1.setGoodsAllocationId(1L);
			pickingItem1.setPickingCount(100L); 
			pickingItem1.setGmtCreate(dateProvider.getCurrentTime()); 
			pickingItem1.setGmtModified(dateProvider.getCurrentTime()); 
			pickingItems.add(pickingItem1);
			
			SaleDeliveryOrderPickingItemDTO pickingItem2 = new SaleDeliveryOrderPickingItemDTO();
			pickingItem2.setGoodsAllocationId(2L);
			pickingItem2.setPickingCount(20L); 
			pickingItem2.setGmtCreate(dateProvider.getCurrentTime()); 
			pickingItem2.setGmtModified(dateProvider.getCurrentTime()); 
			pickingItems.add(pickingItem2);
			
			saleDeliveryOrderItem.setPickingItems(pickingItems); 
			
			List<SaleDeliveryOrderSendOutDetailDTO> sendOutDetails = 
					new ArrayList<SaleDeliveryOrderSendOutDetailDTO>();
			
			SaleDeliveryOrderSendOutDetailDTO sendOutDetail1 = new SaleDeliveryOrderSendOutDetailDTO();
			sendOutDetail1.setGoodsAllocationStockDetailId(1L);
			sendOutDetail1.setSendOutCount(40L); 
			sendOutDetail1.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutDetail1.setGmtModified(dateProvider.getCurrentTime()); 
			sendOutDetails.add(sendOutDetail1);
			
			SaleDeliveryOrderSendOutDetailDTO sendOutDetail2 = new SaleDeliveryOrderSendOutDetailDTO();
			sendOutDetail2.setGoodsAllocationStockDetailId(2L);
			sendOutDetail2.setSendOutCount(60L); 
			sendOutDetail2.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutDetail2.setGmtModified(dateProvider.getCurrentTime()); 
			sendOutDetails.add(sendOutDetail2);
			
			SaleDeliveryOrderSendOutDetailDTO sendOutDetail3 = new SaleDeliveryOrderSendOutDetailDTO();
			sendOutDetail3.setGoodsAllocationStockDetailId(3L);
			sendOutDetail3.setSendOutCount(20L); 
			sendOutDetail3.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutDetail3.setGmtModified(dateProvider.getCurrentTime()); 
			sendOutDetails.add(sendOutDetail3);
			
			saleDeliveryOrderItem.setSendOutItems(sendOutDetails);
			
			orderItem.clone(saleDeliveryOrderItem);
			saleDeliveryOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
			saleDeliveryOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
			
			saleDeliveryOrderItems.add(saleDeliveryOrderItem);
		}
		
		saleDeliveryOrder.setStatus(SaleDeliveryOrderStatus.EDITING);
		saleDeliveryOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		saleDeliveryOrder.setGmtModified(dateProvider.getCurrentTime());
		
		return saleDeliveryOrder;
	}
	
	private void mockStockDetails(Long goodsSkuId) throws Exception {
		List<GoodsAllocationStockDetailDTO> stockDetails = 
				new ArrayList<GoodsAllocationStockDetailDTO>();
		
		GoodsAllocationStockDetailDTO stockDetail1 = new GoodsAllocationStockDetailDTO();
		stockDetail1.setId(1L); 
		stockDetail1.setGoodsSkuId(goodsSkuId); 
		stockDetail1.setGoodsAllocationId(1L); 
		stockDetail1.setPutOnTime(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		stockDetail1.setPutOnQuantity(40L);
		stockDetail1.setCurrentStockQuantity(40L); 
		stockDetail1.setGmtCreate(dateProvider.getCurrentTime()); 
		stockDetail1.setGmtModified(dateProvider.getCurrentTime()); 
		stockDetails.add(stockDetail1);
		
		GoodsAllocationStockDetailDTO stockDetail2 = new GoodsAllocationStockDetailDTO();
		stockDetail2.setId(2L); 
		stockDetail2.setGoodsSkuId(goodsSkuId); 
		stockDetail2.setGoodsAllocationId(1L); 
		stockDetail2.setPutOnTime(dateProvider.parseDatetime("2018-01-01 11:00:00"));  
		stockDetail2.setPutOnQuantity(60L);
		stockDetail2.setCurrentStockQuantity(60L); 
		stockDetail2.setGmtCreate(dateProvider.getCurrentTime()); 
		stockDetail2.setGmtModified(dateProvider.getCurrentTime()); 
		stockDetails.add(stockDetail2);
		
		GoodsAllocationStockDetailDTO stockDetail3 = new GoodsAllocationStockDetailDTO();
		stockDetail3.setId(3L); 
		stockDetail3.setGoodsSkuId(goodsSkuId); 
		stockDetail3.setGoodsAllocationId(2L); 
		stockDetail3.setPutOnTime(dateProvider.parseDatetime("2018-01-01 12:00:00"));  
		stockDetail3.setPutOnQuantity(150L);
		stockDetail3.setCurrentStockQuantity(150L); 
		stockDetail3.setGmtCreate(dateProvider.getCurrentTime()); 
		stockDetail3.setGmtModified(dateProvider.getCurrentTime()); 
		stockDetails.add(stockDetail3);
		
		when(wmsService.listStockDetailsByGoodsSkuId(goodsSkuId)).thenReturn(stockDetails);
	}
	
	/**
	 * 创建订单
	 * @return 订单
	 * @throws Exception
	 */
	private OrderInfoDTO createOrder() throws Exception {
		OrderInfoDTO order = new OrderInfoDTO();
		order.setId(1L); 
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
		order.setOrderItems(new ArrayList<OrderItemDTO>());  
		
		for(int i = 0; i < 2; i++) {
			order.getOrderItems().add(createOrderItem(1L, (long)i, (long)i)); 
		}
		
		return order;
	}
	
	/**
	 * 创建订单条目
	 * @param orderId 订单id
	 * @return
	 * @throws Exception
	 */
	private OrderItemDTO createOrderItem(Long orderInfoId, 
			Long orderItemId, Long goodsSkuId) throws Exception {
		OrderItemDTO orderItem = new OrderItemDTO();
		orderItem.setId(orderItemId); 
		orderItem.setOrderInfoId(orderInfoId); 
		orderItem.setGoodsId(1L); 
		orderItem.setGoodsSkuId(goodsSkuId);  
		orderItem.setGoodsSkuCode(UUID.randomUUID().toString().replace("-", ""));  
		orderItem.setGoodsName("测试商品");
		orderItem.setSaleProperties("测试销售属性");  
		orderItem.setGoodsGrossWeight(56.0); 
		orderItem.setPurchaseQuantity(120L); 
		orderItem.setPurchasePrice(45.5); 
		orderItem.setPromotionActivityId(null); 
		orderItem.setGoodsLength(23.5); 
		orderItem.setGoodsWidth(56.7);
		orderItem.setGoodsHeight(29.6); 
		orderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		orderItem.setGmtModified(dateProvider.getCurrentTime());
		return orderItem;
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
		purchaseInputOrder.setPurchaseContactorPhoneNumber("测试电话");  
		purchaseInputOrder.setPurchaseContactorEmail("测试邮箱"); 
		purchaseInputOrder.setPurchaseOrderRemark("测试采购单");  
		purchaseInputOrder.setPurchaser("李四");  
		
		List<PurchaseInputOrderItemDTO> items = new ArrayList<PurchaseInputOrderItemDTO>();
		for(int i = 0; i < 5; i++) {
			items.add(createPurchaseInputOrderItem((long)i));  
		}
		purchaseInputOrder.setItems(items); 
		
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
