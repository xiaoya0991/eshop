package com.zhss.eshop.wms.dao;

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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDO;

/**
 * 采购入库单条目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class PurchaseInputOrderItemDaoTest {

	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	/**
	 * 采购入库单条目管理DAO组件
	 */
	@Autowired
	private PurchaseInputOrderItemDAO purchaseInputOrderItemDAO;
	
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
	 * 测试新建采购入库单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_input_order_item.sql"})   
	public void testBatchSave() throws Exception {
		Long purchaseInputOrderId = 1L;
		Integer count = 10;
		List<PurchaseInputOrderItemDO> expectedPurchaseInputOrderItems = 
				createPurchaseInputOrderItems(count, purchaseInputOrderId);
		
		purchaseInputOrderItemDAO.batchSave(purchaseInputOrderId, expectedPurchaseInputOrderItems); 
		
		List<PurchaseInputOrderItemDO> actualPurchaseInputOrderItems = 
				purchaseInputOrderItemDAO.listByPurchaseInputOrderId(purchaseInputOrderId);
		
		assertEquals((int)count, actualPurchaseInputOrderItems.size());
 	}
	
	/**
	 * 测试根据id查询采购入库单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_input_order_item.sql"})   
	public void testListByPurchaseInputOrderId() throws Exception {
		Long purchaseInputOrderId = 1L;
		Integer count = 10;
		Map<Long, PurchaseInputOrderItemDO> expectedPurchaseInputOrderItems = 
				createPurchaseInputOrderItemMap(count, purchaseInputOrderId);
		
		List<PurchaseInputOrderItemDO> actualPurchaseInputOrderItems = 
				purchaseInputOrderItemDAO.listByPurchaseInputOrderId(purchaseInputOrderId);
		
		comparePurchaseInputOrderItem(count, expectedPurchaseInputOrderItems, 
				actualPurchaseInputOrderItems); 
	}
	
	/**
	 * 测试更新采购入库单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_input_order_item.sql"})   
	public void testUpdate() throws Exception {
		Long purchaseInputOrderId = 1L;
		Long goodsSkuId = 1L;
		PurchaseInputOrderItemDO expectedPurchaseInputOrderItem = 
				createPurchaseInputOrderItem(purchaseInputOrderId, goodsSkuId);
		
		List<PurchaseInputOrderItemDO> expectedPurchaseInputOrderItems = 
				new ArrayList<PurchaseInputOrderItemDO>();
		expectedPurchaseInputOrderItems.add(expectedPurchaseInputOrderItem);
		purchaseInputOrderItemDAO.batchSave(purchaseInputOrderId, expectedPurchaseInputOrderItems); 
		
		expectedPurchaseInputOrderItem.setQualifiedCount(1000L); 
		expectedPurchaseInputOrderItem.setArrivalCount(1000L); 
		purchaseInputOrderItemDAO.update(expectedPurchaseInputOrderItem);
		
		List<PurchaseInputOrderItemDO> actualPurchaseInputOrderItems = 
				purchaseInputOrderItemDAO.listByPurchaseInputOrderId(purchaseInputOrderId);
		
		assertEquals(1, actualPurchaseInputOrderItems.size()); 
		assertEquals(expectedPurchaseInputOrderItem, actualPurchaseInputOrderItems.get(0));  
	}
	
	/**
	 * 比较两个采购入库单条目集合
	 * @param expectedPurchaseInputOrderItemMap 期望的采购入库单条目集合
	 * @param actualPurchaseInputOrderItemList 实际的采购入库单条目集合
	 * @throws Exception
	 */
	private void comparePurchaseInputOrderItem(
			Integer expectedSize ,
			Map<Long, PurchaseInputOrderItemDO> expectedPurchaseInputOrderItems,
			List<PurchaseInputOrderItemDO> actualPurchaseInputOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualPurchaseInputOrderItems.size()); 
		for(PurchaseInputOrderItemDO actualPurchaseInputOrderItem : actualPurchaseInputOrderItems) {
			PurchaseInputOrderItemDO expectedPurchaseInputOrderItem = expectedPurchaseInputOrderItems
					.get(actualPurchaseInputOrderItem.getId());
			assertEquals(expectedPurchaseInputOrderItem, actualPurchaseInputOrderItem); 
		}
	}
	
	/**
	 * 创建采购入库单条目集合
	 * @param categoryId 类目id
	 * @return 采购入库单条目集合
	 * @throws Exception
	 */
	private Map<Long, PurchaseInputOrderItemDO> createPurchaseInputOrderItemMap(
			Integer count, Long purchaseInputOrderId) throws Exception {
		Map<Long, PurchaseInputOrderItemDO> purchaseInputOrderItemMap = 
				new HashMap<Long, PurchaseInputOrderItemDO>(CollectionSize.DEFAULT);
		
		List<PurchaseInputOrderItemDO> purchaseInputOrderItemList = createPurchaseInputOrderItems(
				count, purchaseInputOrderId);
		 
		purchaseInputOrderItemDAO.batchSave(purchaseInputOrderId, purchaseInputOrderItemList);
		
		for(PurchaseInputOrderItemDO purchaseInputOrderItem : purchaseInputOrderItemList) {
			purchaseInputOrderItemMap.put(purchaseInputOrderItem.getId(), purchaseInputOrderItem);
		}
		
		return purchaseInputOrderItemMap;
	}
	
	/**
	 * 创建采购入库单条目集合
	 * @param categoryId 类目id 
	 * @param count 采购入库单条目数量
	 * @return 采购入库单条目集合
	 * @throws Exception
	 */
	private List<PurchaseInputOrderItemDO> createPurchaseInputOrderItems(
			Integer count, Long purchaseInputOrderId) throws Exception {
		List<PurchaseInputOrderItemDO> purchaseInputOrderItemList = 
				new ArrayList<PurchaseInputOrderItemDO>();
		for(int i = 0; i < count; i++) {
			purchaseInputOrderItemList.add(createPurchaseInputOrderItem(purchaseInputOrderId, (long)i));    
		}
		return purchaseInputOrderItemList;
	}
	
	/**
	 * 创建采购入库单条目
	 * @return 采购入库单条目
	 * @throws Exception
	 */
	private PurchaseInputOrderItemDO createPurchaseInputOrderItem(
			Long purchaseInputOrderId, Long goodsSkuId) throws Exception {
		PurchaseInputOrderItemDO purchaseInputOrderItem = new PurchaseInputOrderItemDO();
		purchaseInputOrderItem.setPurchaseInputOrderId(purchaseInputOrderId); 
		purchaseInputOrderItem.setGoodsSkuId(goodsSkuId); 
		purchaseInputOrderItem.setPurchaseCount(1000L); 
		purchaseInputOrderItem.setPurchasePrice(5999.0); 
		purchaseInputOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		purchaseInputOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
		
		return purchaseInputOrderItem;
	}
	
}
