package com.zhss.eshop.Inventory.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.Inventory.dao.GoodsStockDAO;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.Inventory.async.StockUpdateMessage;
import com.zhss.eshop.Inventory.async.StockUpdateObservable;
import com.zhss.eshop.Inventory.async.StockUpdateObserver;
import com.zhss.eshop.Inventory.async.StockUpdateQueue;
import com.zhss.eshop.Inventory.async.StockUpdateResult;
import com.zhss.eshop.Inventory.async.StockUpdateResultManager;
import com.zhss.eshop.Inventory.domain.GoodsStockDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDTO;

/**
 * 库存中心service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class InventoryServiceTest {
	
	/**
	 * 库存中心service组件
	 */
	@Autowired
	private InventoryService InventoryService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 商品库存管理DAO组件
	 */
	@Autowired
	private GoodsStockDAO goodsStockDAO;
	/**
	 * 库存更新消息队列
	 */
	@Autowired
	private StockUpdateQueue stockUpdateQueue;
	/**
	 * 库存更新结果管理组件
	 */
	@Autowired
	private StockUpdateResultManager stockUpdateResultManager;
	/**
	 * 库存更新结果监听组件
	 */
	@MockBean
	private StockUpdateObserver stockUpdateObserver;
	
	/**
	 * 测试通知库存中心，“采购入库完成”事件发生了
	 * @throws Exception
	 */
	@Test
	public void testInformPurchaseInputFinished() throws Exception {
		// 准备商品sku id集合
		Long[] goodsSkuIds = new Long[]{1L, 2L};
		// 准备商品sku对应的销售库存map，将每个商品sku id对应的销售库存放在map中
		Map<Long, Long> oldSaleStockQuantityMap = new HashMap<Long, Long>();
		for(Long goodsSkuId : goodsSkuIds) {
			oldSaleStockQuantityMap.put(goodsSkuId, getSaleStockQuantity(goodsSkuId));
		}
		// 准备采购数量
		Long purchaseQuantity = 1000L;
		
		// 构造一个采购入库单，有两个条目，其goodsSkuId分别为1和2，同时采购数量为1000
		PurchaseInputOrderDTO purchaseInputOrder = createPurchaseInputOrder(
				purchaseQuantity, goodsSkuIds);    
		InventoryService.informPurchaseInputFinished(purchaseInputOrder);
		
		// 然后来执行断言
		for(Long goodsSkuId : goodsSkuIds) { 
			assertEquals((long)oldSaleStockQuantityMap.get(goodsSkuId) + purchaseQuantity, 
					(long)getSaleStockQuantity(goodsSkuId));  
		}
	}
	
	/**
	 * 测试通知库存中心，“完成退货入库”事件发生了
	 * @throws Exception
	 */
	@Test
	public void testInformReturnGoodsInputFinished() throws Exception {
		// 准备两个库存数据，分别是goodsSkuId为3和4
		// 这两份数据的销售库存为50，已销售库存为100
		Long[] goodsSkuIds = new Long[] {3L, 4L};
		Long oldSaleStockQuantity = 50L;
		Long oldSaledStockQuantity = 100L;
		Long purchaseQuantity = 3L;
		
		for(Long goodsSkuId : goodsSkuIds) {
			createGoodsStock(goodsSkuId, oldSaleStockQuantity, 0L, oldSaledStockQuantity); 
		}
		
		// 构造一个退货入库单，有两个商品条目，goodsSkuId分别为3和4，其购买数量都是3
		ReturnGoodsInputOrderDTO returnGoodsInputOrder = createReturnGoodsInputOrder(
				purchaseQuantity, goodsSkuIds);
		InventoryService.informReturnGoodsInputFinished(returnGoodsInputOrder);
		
		// 执行断言
		for(Long goodsSkuId : goodsSkuIds) {
			assertEquals((long)oldSaleStockQuantity + purchaseQuantity, 
					(long)getSaleStockQuantity(goodsSkuId));   
			assertEquals((long)oldSaledStockQuantity - purchaseQuantity, 
					(long)getSaledStockQuantity(goodsSkuId));  
		}
	}
	
	/**
	 * 测试通知库存中心，“提交订单”事件发生了
	 * @throws Exception
	 */
	@Test
	public void testInformSubmitOrderEvent() throws Exception {
		// 构造数据
		Long[] goodsSkuIds = new Long[]{5L, 6L};
		Long oldSaleStockQuantity = 100L;
		Long oldLockedStockQuantity = 50L;
		Long oldSaledStockQuantity = 200L;
		Long purchaseQuantity = 5L;
		
		for(Long goodsSkuId : goodsSkuIds) { 
			createGoodsStock(goodsSkuId, oldSaleStockQuantity, 
					oldLockedStockQuantity, oldSaledStockQuantity);
		}
		
		OrderInfoDTO order = createOrder(goodsSkuIds, purchaseQuantity);
		
		// 执行方法逻辑
		InventoryService.informSubmitOrderEvent(order);
		
		// 执行库存变更逻辑的断言
		for(Long goodsSkuId : goodsSkuIds) {
			assertEquals((long)oldSaleStockQuantity - purchaseQuantity, 
					(long)getSaleStockQuantity(goodsSkuId)); 
			assertEquals((long)oldLockedStockQuantity + purchaseQuantity, 
					(long)getLockedStockQuantity(goodsSkuId)); 
		}
		
		assertAsyncOperation();
	}
	
	/**
	 * 测试通知库存中心，“支付订单”事件发生了
	 * @throws Exception
	 */
	@Test
	public void testInformPayOrderEvent() throws Exception {
		// 构造数据
		Long[] goodsSkuIds = new Long[]{7L, 8L}; 
		Long oldSaleStockQuantity = 100L;
		Long oldLockedStockQuantity = 50L;
		Long oldSaledStockQuantity = 200L;
		Long purchaseQuantity = 5L;
		
		for(Long goodsSkuId : goodsSkuIds) { 
			createGoodsStock(goodsSkuId, oldSaleStockQuantity, 
					oldLockedStockQuantity, oldSaledStockQuantity);
		}
		
		OrderInfoDTO order = createOrder(goodsSkuIds, purchaseQuantity);
		
		// 执行方法逻辑
		InventoryService.informPayOrderEvent(order);
		
		// 执行库存变更逻辑的断言
		for(Long goodsSkuId : goodsSkuIds) {
			assertEquals((long)oldLockedStockQuantity - purchaseQuantity, 
					(long)getLockedStockQuantity(goodsSkuId)); 
			assertEquals((long)oldSaledStockQuantity + purchaseQuantity, 
					(long)getSaledStockQuantity(goodsSkuId));
		}
		
		assertAsyncOperation();
	}
	
	/**
	 * 测试通知库存中心，“取消订单”事件发生了
	 * @throws Exception
	 */
	@Test
	public void testInformCancelOrderEvent() throws Exception {
		// 构造数据
		Long[] goodsSkuIds = new Long[]{9L, 10L}; 
		Long oldSaleStockQuantity = 100L;
		Long oldLockedStockQuantity = 50L;
		Long oldSaledStockQuantity = 200L;
		Long purchaseQuantity = 5L;
		
		for(Long goodsSkuId : goodsSkuIds) { 
			createGoodsStock(goodsSkuId, oldSaleStockQuantity, 
					oldLockedStockQuantity, oldSaledStockQuantity);
		}
		
		OrderInfoDTO order = createOrder(goodsSkuIds, purchaseQuantity);
		
		// 执行方法逻辑
		InventoryService.informCancelOrderEvent(order);
		
		// 执行库存变更逻辑的断言
		for(Long goodsSkuId : goodsSkuIds) {
			assertEquals((long)oldSaleStockQuantity + purchaseQuantity, 
					(long)getSaleStockQuantity(goodsSkuId));
			assertEquals((long)oldLockedStockQuantity - purchaseQuantity, 
					(long)getLockedStockQuantity(goodsSkuId)); 
		}
		
		assertAsyncOperation();
	}
	
	/**
	 * 测试查询商品sku的库存
	 * @throws Exception
	 */
	@Test
	public void testGetSaleStockQuantity() throws Exception {
		Long goodsSkuId = 1L;
		Long saleStockQuantity = 100L;
		Long lockedStockQuantity = 100L;
		Long saledStockQuantity = 100L;
		
		createGoodsStock(goodsSkuId, saleStockQuantity, 
				lockedStockQuantity, saledStockQuantity);
		
		Long resultSaleStockQuantity = InventoryService.getSaleStockQuantity(goodsSkuId);
		
		assertEquals(saleStockQuantity, resultSaleStockQuantity); 
	}
	
	/**
	 * 对异步操作进行断言
	 * @throws Exception
	 */
	private void assertAsyncOperation() throws Exception {
		// 执行内存队列的断言
		assertEquals(1, (int)stockUpdateQueue.size());  
		
		// 自己模拟调度中心来消费queue里面的数据，然后通知一下结果
		StockUpdateMessage message = stockUpdateQueue.take();
		
		StockUpdateObservable observable = stockUpdateResultManager.getObservable(message.getId());
		
		StockUpdateResult result = new StockUpdateResult();
		result.setMessageId(message.getId()); 
		result.setResult(true); 
		
		stockUpdateResultManager.inform(message.getId(), true); 
		
		verify(stockUpdateObserver, times(1)).update(observable, result);
	}
	
	/**
	 * 查询商品sku的销售库存
	 * @throws Exception
	 */
	private Long getSaleStockQuantity(Long goodsSkuId) throws Exception {
		GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId); 
		if(stock == null) {
			return 0L;
		} else {
			return stock.getSaleStockQuantity();
		}
	}
	
	/**
	 * 查询商品sku的锁定库存
	 * @throws Exception
	 */
	private Long getLockedStockQuantity(Long goodsSkuId) throws Exception {
		GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId); 
		if(stock == null) {
			return 0L;
		} else {
			return stock.getLockedStockQuantity();
		}
	}
	
	/**
	 * 查询商品sku的已销售库存
	 * @param goodsSkuId 商品sku id
	 * @return
	 * @throws Exception
	 */
	private Long getSaledStockQuantity(Long goodsSkuId) throws Exception {
		GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId); 
		if(stock == null) {
			return 0L;
		} else {
			return stock.getSaledStockQuantity();
		}
	}
	
	/**
	 * 
	 * 构造库存数据
	 * @throws Exception
	 */
	private void createGoodsStock(Long goodsSkuId, Long saleStockQuantity, 
			Long lockedStockQuantity, Long saledStockQuantity) throws Exception {
		GoodsStockDO stock = goodsStockDAO.getGoodsStockBySkuId(goodsSkuId);
		
		if(stock == null) {
			stock = new GoodsStockDO();
			stock.setGoodsSkuId(goodsSkuId); 
			stock.setSaleStockQuantity(saleStockQuantity); 
			stock.setLockedStockQuantity(lockedStockQuantity); 
			stock.setSaledStockQuantity(saledStockQuantity); 
			stock.setStockStatus(saleStockQuantity > 0L ? 1 : 0); 
			stock.setGmtCreate(dateProvider.getCurrentTime()); 
			stock.setGmtModified(dateProvider.getCurrentTime()); 
			
			goodsStockDAO.saveGoodsStock(stock);
		} else {
			stock.setSaleStockQuantity(saleStockQuantity); 
			stock.setLockedStockQuantity(lockedStockQuantity); 
			stock.setSaledStockQuantity(saledStockQuantity); 
			stock.setStockStatus(saleStockQuantity > 0L ? 1 : 0);  
			stock.setGmtModified(dateProvider.getCurrentTime()); 
			
			goodsStockDAO.updateGoodsStock(stock);
		}
	}
	
	/**
	 * 创建采购入库单
	 * @return 采购入库单
	 * @throws Exception
	 */
	private PurchaseInputOrderDTO createPurchaseInputOrder(Long count, Long...goodsSkuIds) throws Exception {
		PurchaseInputOrderDTO order = new PurchaseInputOrderDTO();
		
		order.setId(1L); 
		order.setSupplierId(1L); 
		order.setExpectArrivalTime(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		order.setArrivalTime(dateProvider.parseDatetime("2018-01-10 10:05:00"));
		order.setPurchaseContactor("张三");  
		order.setPurchaseContactPhoneNumber("18910106578");  
		order.setPurchaseContactEmail("zhangsan@sina.com");  
		order.setPurchaseOrderComment("测试采购入库单");
		order.setPurchaser("李四");  
		order.setPurcahseInputOrderStatus(5); 
		order.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		order.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		
		List<PurchaseInputOrderItemDTO> items = new ArrayList<PurchaseInputOrderItemDTO>();
		for(int i = 0; i < goodsSkuIds.length; i++) {   
			items.add(createPurchaseInputItem((long)i, goodsSkuIds[i], 1L, count)); 
		}
		order.setPurchaseInputOrderItemDTOs(items);

		List<PurchaseInputOrderPutOnItemDTO> putOnItems = 
				new ArrayList<PurchaseInputOrderPutOnItemDTO>();
		for(int i = 0; i < goodsSkuIds.length; i++) {
			putOnItems.add(createPurchaseInputOrderPutOnItem((long)i, (long)i));   
		}
		order.setPurchaseInputOrderPutOnItemDTOs(putOnItems); 
		
		return order;
	}
	
	/**
	 * 创建采购入库单条目
	 * @return 采购入库单条目
	 * @throws Exception
	 */
	private PurchaseInputOrderItemDTO createPurchaseInputItem(
			Long itemId, Long goodsSkuId, Long orderId, Long count) throws Exception {
		PurchaseInputOrderItemDTO item = new PurchaseInputOrderItemDTO();
		item.setId(itemId);  
		item.setPurchaseInputOrderId(orderId); 
		item.setGoodsSkuId(goodsSkuId); 
		item.setPurchaseCount(count); 
		item.setQualifiedCount(count); 
		item.setArrivalCount(count);  
		item.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		item.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		return item;
	}
	
	/**
	 * 创建采购入库单上架条目
	 * @return 采购入库单上架条目
	 * @throws Exception
	 */
	private PurchaseInputOrderPutOnItemDTO createPurchaseInputOrderPutOnItem(
			Long putOnItemId, Long itemId) throws Exception {
		PurchaseInputOrderPutOnItemDTO item = new PurchaseInputOrderPutOnItemDTO();
		item.setId(putOnItemId);
		item.setPurchaseInputOrderItemId(itemId); 
		item.setGoodsAllocationId(1L); 
		item.setPutOnShelvesCount(1000L); 
		item.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		item.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		return item;
	}
	
	/**
	 * 创建退货入库单
	 * @return 退货入库单
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderDTO createReturnGoodsInputOrder(
			Long purchaseQuantity, Long...goodsSkuIds) throws Exception {
		ReturnGoodsInputOrderDTO returnGoodsInputOrder = new ReturnGoodsInputOrderDTO();
		
		returnGoodsInputOrder.setId(1L); 
		returnGoodsInputOrder.setUserAccountId(1L); 
		returnGoodsInputOrder.setOrderId(1L); 
		returnGoodsInputOrder.setOrderNo("test"); 
		returnGoodsInputOrder.setReturnGoodsInputOrderStatus(3); 
		returnGoodsInputOrder.setConsignee("张三");
		returnGoodsInputOrder.setDeliveryAddress("测试地址"); 
		returnGoodsInputOrder.setConsigneeCellPhoneNumber("18910106578");
		returnGoodsInputOrder.setFreight(45.90);
		returnGoodsInputOrder.setPayType(1); 
		returnGoodsInputOrder.setTotalAmount(999.00); 
		returnGoodsInputOrder.setDiscountAmount(50.40);
		returnGoodsInputOrder.setCouponAmount(35.00); 
		returnGoodsInputOrder.setPayableAmount(899.30); 
		returnGoodsInputOrder.setInvoiceTitle("测试发票抬头"); 
		returnGoodsInputOrder.setTaxpayerId("测试纳税人识别号");
		returnGoodsInputOrder.setOrderComment("测试订单");
		returnGoodsInputOrder.setReturnGoodsReason("测试退货原因");
		returnGoodsInputOrder.setReturnGoodsComment("测试退货备注"); 
		returnGoodsInputOrder.setArrivalTime(dateProvider.parseDatetime("2018-01-10 10:00:00")); 
		returnGoodsInputOrder.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		returnGoodsInputOrder.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		
		List<ReturnGoodsInputOrderItemDTO> items = new ArrayList<ReturnGoodsInputOrderItemDTO>();
		for(Long goodsSkuId : goodsSkuIds) {
			items.add(createReturnGoodsInputOrderItem(1L, goodsSkuId, purchaseQuantity)); 
		}
		returnGoodsInputOrder.setReturnGoodsInputOrderItemDTOs(items); 
		
		List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems = 
				new ArrayList<ReturnGoodsInputOrderPutOnItemDTO>();
		for(int i = 0; i < goodsSkuIds.length; i++) {
			putOnItems.add(createReturnGoodsInputOrderPutOnItem((long)i, (long)i)); 
		}
		returnGoodsInputOrder.setReturnGoodsInputOrderPutOnItemDTO(putOnItems); 
		
		return returnGoodsInputOrder;
	}
	
	/**
	 * 创建退货入库单条目
	 * @param returnGoodsInputOrderId 退货入库单id
	 * @return 退货入库单条目
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderItemDTO createReturnGoodsInputOrderItem(
			Long returnGoodsInputOrderId, 
			Long goodsSkuId,
			Long purchaseQuantity) throws Exception {
		ReturnGoodsInputOrderItemDTO item = new ReturnGoodsInputOrderItemDTO();
		
		item.setReturnGoodsInputOrderId(returnGoodsInputOrderId); 
		item.setGoodsSkuId(goodsSkuId); 
		item.setGoodsSkuCode("测试编号"); 
		item.setGoodsName("测试商品"); 
		item.setSaleProperties("测试销售属性"); 
		item.setGoodsGrossWeight(59.30);
		item.setPurchaseQuantity(purchaseQuantity); 
		item.setPurchasePrice(39.30); 
		item.setPromotionActivityId(1L); 
		item.setGoodsLength(49.00); 
		item.setGoodsWidth(29.50); 
		item.setGoodsHeight(68.90); 
		item.setQualifiedCount(purchaseQuantity); 
		item.setArrivalCount(purchaseQuantity); 
		item.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		item.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		
		return item;
	}
	
	/**
	 * 创建退货入库单上架条目
	 * @return 采购入库单上架条目
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderPutOnItemDTO createReturnGoodsInputOrderPutOnItem(
			Long putOnItemId, Long itemId) throws Exception {
		ReturnGoodsInputOrderPutOnItemDTO item = new ReturnGoodsInputOrderPutOnItemDTO();
		item.setId(putOnItemId);
		item.setReturnGoodsInputOrderItemId(itemId); 
		item.setGoodsAllocationId(1L); 
		item.setPutOnShelvesCount(1000L); 
		item.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		item.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		return item;
	}
	
	/**
	 * 构造订单
	 * @return
	 * @throws Exception
	 */
	private OrderInfoDTO createOrder(Long[] goodsSkuIds, Long purchaseQuantity) throws Exception {
		OrderInfoDTO order = new OrderInfoDTO();
		
		order.setId(1L); 
		order.setUserAccountId(1L); 
		order.setUsername("test");  
		order.setOrderNo("test"); 
		order.setOrderStatus(1);
		order.setConsignee("张三");
		order.setDeliveryAddress("测试地址"); 
		order.setConsigneeCellPhoneNumber("18910106578");
		order.setFreight(45.90);
		order.setPayType(1); 
		order.setTotalAmount(999.00); 
		order.setDiscountAmount(50.40);
		order.setCouponAmount(35.00); 
		order.setPayableAmount(899.30); 
		order.setInvoiceTitle("测试发票抬头"); 
		order.setTaxpayerId("测试纳税人识别号");
		order.setOrderComment("测试订单");
		order.setPublishedComment(1); 
		order.setConfirmReceiptTime(dateProvider.parseDatetime("2018-01-10 10:00:00"));   
		order.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		order.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		
		List<OrderItemDTO> items = new ArrayList<OrderItemDTO>();  
		for(int i = 0; i < goodsSkuIds.length; i++) {
			items.add(createOrderItem(1L, (long)i, goodsSkuIds[i], purchaseQuantity)); 
		} 
		order.setOrderItems(items);
		
		return order;
	}
	
	/**
	 * 创建订单条目
	 * @throws Exception
	 */
	private OrderItemDTO createOrderItem(
			Long orderId, Long itemId, Long goodsSkuId,
			Long purchaseQuantity) throws Exception {
		OrderItemDTO item = new OrderItemDTO();
		
		item.setId(itemId); 
		item.setOrderInfoId(orderId); 
		item.setGoodsId(1L); 
		item.setGoodsSkuId(goodsSkuId); 
		item.setGoodsSkuCode("测试编号"); 
		item.setGoodsName("测试商品"); 
		item.setSaleProperties("测试销售属性"); 
		item.setGoodsGrossWeight(59.30);
		item.setPurchaseQuantity(purchaseQuantity); 
		item.setPurchasePrice(39.30); 
		item.setPromotionActivityId(1L); 
		item.setGoodsLength(49.00); 
		item.setGoodsWidth(29.50); 
		item.setGoodsHeight(68.90); 
		item.setGmtCreate(dateProvider.parseDatetime("2018-01-01 10:00:00"));  
		item.setGmtModified(dateProvider.parseDatetime("2018-01-10 10:00:00"));  
		
		return item;
	}
	
}
