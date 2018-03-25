package com.zhss.eshop.purchase.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDO;

/**
 * 采购单条目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class PurchaseOrderItemDAOTest {

	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	/**
	 * 采购单条目管理DAO组件
	 */
	@Autowired
	private PurchaseOrderItemDAO purchaseOrderItemDAO;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		when(dateProvider.getCurrentTime()).thenReturn(formatter.parse(formatter.format(new Date())));   
	}
	
	/**
	 * 测试新建采购单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_order_item.sql"})   
	public void testBatchSave() throws Exception {
		Long purchaseOrderId = 1L;
		Integer count = 10;
		createPurchaseOrderItems(count, purchaseOrderId);
		
		List<PurchaseOrderItemDO> actualPurchaseOrderItems = 
				purchaseOrderItemDAO.listByPurchaseOrderId(purchaseOrderId);
		
		assertEquals((int)count, actualPurchaseOrderItems.size());
 	}
	
	/**
	 * 测试根据id查询采购单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_order_item.sql"})   
	public void testListByPurchaseOrderId() throws Exception {
		Long purchaseOrderId = 1L;
		Integer count = 10;
		Map<Long, PurchaseOrderItemDO> expectedPurchaseOrderItems = 
				createPurchaseOrderItemMap(count, purchaseOrderId);
		
		List<PurchaseOrderItemDO> actualPurchaseOrderItems = 
				purchaseOrderItemDAO.listByPurchaseOrderId(purchaseOrderId);
		
		comparePurchaseOrderItem(count, expectedPurchaseOrderItems, 
				actualPurchaseOrderItems); 
	}
	
	/**
	 * 测试根据采购单id删除采购单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_order_item.sql"})   
	public void testRemoveByPurchaseOrderId() throws Exception {
		Long purchaseOrderId = 1L;
		Integer count = 10;
		createPurchaseOrderItemMap(count, purchaseOrderId);
		
		purchaseOrderItemDAO.removeByPurchaseOrderId(purchaseOrderId); 
		
		List<PurchaseOrderItemDO> actualPurchaseOrderItems = 
				purchaseOrderItemDAO.listByPurchaseOrderId(purchaseOrderId);
		
		assertEquals(0, actualPurchaseOrderItems.size()); 
	}
	
	/**
	 * 比较两个采购单条目集合
	 * @param expectedPurchaseOrderItemMap 期望的采购单条目集合
	 * @param actualPurchaseOrderItemList 实际的采购单条目集合
	 * @throws Exception
	 */
	private void comparePurchaseOrderItem(
			Integer expectedSize ,
			Map<Long, PurchaseOrderItemDO> expectedPurchaseOrderItems,
			List<PurchaseOrderItemDO> actualPurchaseOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualPurchaseOrderItems.size()); 
		for(PurchaseOrderItemDO actualPurchaseOrderItem : actualPurchaseOrderItems) {
			PurchaseOrderItemDO expectedPurchaseOrderItem = expectedPurchaseOrderItems
					.get(actualPurchaseOrderItem.getId());
			assertEquals(expectedPurchaseOrderItem, actualPurchaseOrderItem); 
		}
	}
	
	/**
	 * 创建采购单条目集合
	 * @param categoryId 类目id
	 * @return 采购单条目集合
	 * @throws Exception
	 */
	private Map<Long, PurchaseOrderItemDO> createPurchaseOrderItemMap(
			Integer count, Long purchaseOrderId) throws Exception {
		Map<Long, PurchaseOrderItemDO> purchaseOrderItemMap = new HashMap<Long, PurchaseOrderItemDO>();
		
		List<PurchaseOrderItemDO> purchaseOrderItemList = createPurchaseOrderItems(
				count, purchaseOrderId);
		 
		for(PurchaseOrderItemDO purchaseOrderItem : purchaseOrderItemList) {
			purchaseOrderItemMap.put(purchaseOrderItem.getId(), purchaseOrderItem);
		}
		
		return purchaseOrderItemMap;
	}
	
	/**
	 * 创建采购单条目集合
	 * @param categoryId 类目id 
	 * @param count 采购单条目数量
	 * @return 采购单条目集合
	 * @throws Exception
	 */
	private List<PurchaseOrderItemDO> createPurchaseOrderItems(
			Integer count, Long purchaseOrderId) throws Exception {
		List<PurchaseOrderItemDO> purchaseOrderItemList = 
				new ArrayList<PurchaseOrderItemDO>();
		
		for(int i = 0; i < count; i++) {
			purchaseOrderItemList.add(createPurchaseOrderItem(purchaseOrderId, (long)i));    
		}
		
		purchaseOrderItemDAO.batchSave(purchaseOrderId, purchaseOrderItemList); 
		
		return purchaseOrderItemList;
	}
	
	/**
	 * 创建采购单条目
	 * @return 采购单条目
	 * @throws Exception
	 */
	private PurchaseOrderItemDO createPurchaseOrderItem(
			Long purchaseOrderId, Long goodsSkuId) throws Exception {
		PurchaseOrderItemDO purchaseOrderItem = new PurchaseOrderItemDO();
		purchaseOrderItem.setPurchaseOrderId(purchaseOrderId); 
		purchaseOrderItem.setGoodsSkuId(goodsSkuId); 
		purchaseOrderItem.setPurchaseCount(1000L); 
		purchaseOrderItem.setPurchasePrice(5999.0); 
		purchaseOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		purchaseOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
		
		return purchaseOrderItem;
	}
	
}
