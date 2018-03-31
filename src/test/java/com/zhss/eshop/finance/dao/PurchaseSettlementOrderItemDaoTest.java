package com.zhss.eshop.finance.dao;

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
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderItemDO;

/**
 * 采购结算单条目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class PurchaseSettlementOrderItemDaoTest {

	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	/**
	 * 采购结算单条目管理DAO组件
	 */
	@Autowired
	private PurchaseSettlementOrderItemDAO purchaseSettlementOrderItemDAO;
	
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
	 * 测试新建采购结算单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_settlement_order_item.sql"})   
	public void testBatchSave() throws Exception {
		Long purchaseSettlementOrderId = 1L;
		Integer count = 10;
		createPurchaseSettlementOrderItems(count, purchaseSettlementOrderId);
		
		List<PurchaseSettlementOrderItemDO> actualPurchaseSettlementOrderItems = 
				purchaseSettlementOrderItemDAO.listByPurchaseSettlementOrderId(purchaseSettlementOrderId);
		
		assertEquals((int)count, actualPurchaseSettlementOrderItems.size());
 	}
	
	/**
	 * 测试根据id查询采购结算单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_settlement_order_item.sql"})   
	public void testListByPurchaseSettlementOrderId() throws Exception {
		Long purchaseSettlementOrderId = 1L;
		Integer count = 10;
		Map<Long, PurchaseSettlementOrderItemDO> expectedPurchaseSettlementOrderItems = 
				createPurchaseSettlementOrderItemMap(count, purchaseSettlementOrderId);
		
		List<PurchaseSettlementOrderItemDO> actualPurchaseSettlementOrderItems = 
				purchaseSettlementOrderItemDAO.listByPurchaseSettlementOrderId(purchaseSettlementOrderId);
		
		comparePurchaseSettlementOrderItem(count, expectedPurchaseSettlementOrderItems, 
				actualPurchaseSettlementOrderItems); 
	}
	
	/**
	 * 比较两个采购结算单条目集合
	 * @param expectedPurchaseSettlementOrderItemMap 期望的采购结算单条目集合
	 * @param actualPurchaseSettlementOrderItemList 实际的采购结算单条目集合
	 * @throws Exception
	 */
	private void comparePurchaseSettlementOrderItem(
			Integer expectedSize ,
			Map<Long, PurchaseSettlementOrderItemDO> expectedPurchaseSettlementOrderItems,
			List<PurchaseSettlementOrderItemDO> actualPurchaseSettlementOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualPurchaseSettlementOrderItems.size()); 
		for(PurchaseSettlementOrderItemDO actualPurchaseSettlementOrderItem : actualPurchaseSettlementOrderItems) {
			PurchaseSettlementOrderItemDO expectedPurchaseSettlementOrderItem = expectedPurchaseSettlementOrderItems
					.get(actualPurchaseSettlementOrderItem.getId());
			assertEquals(expectedPurchaseSettlementOrderItem, actualPurchaseSettlementOrderItem); 
		}
	}
	
	/**
	 * 创建采购结算单条目集合
	 * @param categoryId 类目id
	 * @return 采购结算单条目集合
	 * @throws Exception
	 */
	private Map<Long, PurchaseSettlementOrderItemDO> createPurchaseSettlementOrderItemMap(
			Integer count, Long purchaseSettlementOrderId) throws Exception {
		Map<Long, PurchaseSettlementOrderItemDO> purchaseSettlementOrderItemMap = 
				new HashMap<Long, PurchaseSettlementOrderItemDO>(CollectionSize.DEFAULT);
		
		List<PurchaseSettlementOrderItemDO> purchaseSettlementOrderItemList = 
				createPurchaseSettlementOrderItems(count, purchaseSettlementOrderId);
		 
		for(PurchaseSettlementOrderItemDO purchaseSettlementOrderItem : purchaseSettlementOrderItemList) {
			purchaseSettlementOrderItemMap.put(purchaseSettlementOrderItem.getId(), 
					purchaseSettlementOrderItem);
		}
		
		return purchaseSettlementOrderItemMap;
	}
	
	/**
	 * 创建采购结算单条目集合
	 * @param categoryId 类目id 
	 * @param count 采购结算单条目数量
	 * @return 采购结算单条目集合
	 * @throws Exception
	 */
	private List<PurchaseSettlementOrderItemDO> createPurchaseSettlementOrderItems(
			Integer count, Long purchaseSettlementOrderId) throws Exception {
		List<PurchaseSettlementOrderItemDO> purchaseSettlementOrderItemList = 
				new ArrayList<PurchaseSettlementOrderItemDO>();
		for(int i = 0; i < count; i++) {
			purchaseSettlementOrderItemList.add(createPurchaseSettlementOrderItem(purchaseSettlementOrderId, (long)i));    
		}
		
		purchaseSettlementOrderItemDAO.batchSave(purchaseSettlementOrderId, purchaseSettlementOrderItemList);
		
		return purchaseSettlementOrderItemList;
	}
	
	/**
	 * 创建采购结算单条目
	 * @return 采购结算单条目
	 * @throws Exception
	 */
	private PurchaseSettlementOrderItemDO createPurchaseSettlementOrderItem(
			Long purchaseSettlementOrderId, Long goodsSkuId) throws Exception {
		PurchaseSettlementOrderItemDO purchaseSettlementOrderItem = new PurchaseSettlementOrderItemDO();
		purchaseSettlementOrderItem.setPurchaseSettlementOrderId(purchaseSettlementOrderId); 
		purchaseSettlementOrderItem.setGoodsSkuId(goodsSkuId); 
		purchaseSettlementOrderItem.setPurchaseCount(1000L); 
		purchaseSettlementOrderItem.setPurchasePrice(5999.0);
		purchaseSettlementOrderItem.setQualifiedCount(1000L);
		purchaseSettlementOrderItem.setArrivalCount(1000L); 
		
		return purchaseSettlementOrderItem;
	}
	
}
