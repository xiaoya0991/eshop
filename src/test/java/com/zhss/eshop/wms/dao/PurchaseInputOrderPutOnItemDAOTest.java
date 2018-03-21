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

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;

/**
 * 采购入库单上架条目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class PurchaseInputOrderPutOnItemDAOTest {

	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	/**
	 * 采购入库单上架条目管理DAO组件
	 */
	@Autowired
	private PurchaseInputOrderPutOnItemDAO purchaseInputOrderPutOnItemDAO;
	
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
	 * 测试新建采购入库单上架条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_input_order_put_on_item.sql"})   
	public void testBatchSave() throws Exception {
		Long purchaseInputOrderItemId = 1L;
		Integer count = 10;
		createPurchaseInputOrderPutOnItems(count, purchaseInputOrderItemId);
		
		List<PurchaseInputOrderPutOnItemDO> actualPurchaseInputOrderPutOnItems = 
				purchaseInputOrderPutOnItemDAO.listByPurchaseInputOrderItemId(purchaseInputOrderItemId);
		
		assertEquals((int)count, actualPurchaseInputOrderPutOnItems.size());
 	}
	
	/**
	 * 测试根据id查询采购入库单上架条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_purchase_input_order_put_on_item.sql"})   
	public void testListByPurchaseInputOrderId() throws Exception {
		Long purchaseInputOrderItemId = 1L;
		Integer count = 10;
		Map<Long, PurchaseInputOrderPutOnItemDO> expectedPurchaseInputOrderPutOnItems = 
				createPurchaseInputOrderPutOnItemMap(count, purchaseInputOrderItemId);
		
		List<PurchaseInputOrderPutOnItemDO> actualPurchaseInputOrderPutOnItems = 
				purchaseInputOrderPutOnItemDAO.listByPurchaseInputOrderItemId(purchaseInputOrderItemId);
		
		comparePurchaseInputOrderPutOnItem(count, expectedPurchaseInputOrderPutOnItems, 
				actualPurchaseInputOrderPutOnItems); 
	}
	
	/**
	 * 比较两个采购入库单上架条目集合
	 * @param expectedPurchaseInputOrderPutOnItemMap 期望的采购入库单上架条目集合
	 * @param actualPurchaseInputOrderPutOnItemList 实际的采购入库单上架条目集合
	 * @throws Exception
	 */
	private void comparePurchaseInputOrderPutOnItem(
			Integer expectedSize ,
			Map<Long, PurchaseInputOrderPutOnItemDO> expectedPurchaseInputOrderPutOnItems,
			List<PurchaseInputOrderPutOnItemDO> actualPurchaseInputOrderPutOnItems) throws Exception {
		assertEquals((int)expectedSize, actualPurchaseInputOrderPutOnItems.size()); 
		for(PurchaseInputOrderPutOnItemDO actualPurchaseInputOrderPutOnItem : actualPurchaseInputOrderPutOnItems) {
			PurchaseInputOrderPutOnItemDO expectedPurchaseInputOrderPutOnItem = expectedPurchaseInputOrderPutOnItems
					.get(actualPurchaseInputOrderPutOnItem.getId());
			assertEquals(expectedPurchaseInputOrderPutOnItem, actualPurchaseInputOrderPutOnItem); 
		}
	}
	
	/**
	 * 创建采购入库单上架条目集合
	 * @param categoryId 类目id
	 * @return 采购入库单上架条目集合
	 * @throws Exception
	 */
	private Map<Long, PurchaseInputOrderPutOnItemDO> createPurchaseInputOrderPutOnItemMap(
			Integer count, Long purchaseInputOrderItemId) throws Exception {
		Map<Long, PurchaseInputOrderPutOnItemDO> purchaseInputOrderPutOnItemMap = new HashMap<Long, PurchaseInputOrderPutOnItemDO>();
		
		List<PurchaseInputOrderPutOnItemDO> purchaseInputOrderPutOnItemList = createPurchaseInputOrderPutOnItems(
				count, purchaseInputOrderItemId);
		 
		for(PurchaseInputOrderPutOnItemDO purchaseInputOrderPutOnItem : purchaseInputOrderPutOnItemList) {
			purchaseInputOrderPutOnItemMap.put(purchaseInputOrderPutOnItem.getId(), purchaseInputOrderPutOnItem);
		}
		
		return purchaseInputOrderPutOnItemMap;
	}
	
	/**
	 * 创建采购入库单上架条目集合
	 * @param categoryId 类目id 
	 * @param count 采购入库单上架条目数量
	 * @return 采购入库单上架条目集合
	 * @throws Exception
	 */
	private List<PurchaseInputOrderPutOnItemDO> createPurchaseInputOrderPutOnItems(
			Integer count, Long purchaseInputOrderItemId) throws Exception {
		List<PurchaseInputOrderPutOnItemDO> purchaseInputOrderPutOnItemList = 
				new ArrayList<PurchaseInputOrderPutOnItemDO>();
		for(int i = 0; i < count; i++) {
			purchaseInputOrderPutOnItemList.add(createPurchaseInputOrderPutOnItem(
					purchaseInputOrderItemId, (long)i, (long)i));       
		}
		
		purchaseInputOrderPutOnItemDAO.batchSave(purchaseInputOrderPutOnItemList);  
		
		return purchaseInputOrderPutOnItemList;
	}
	
	/**
	 * 创建采购入库单上架条目
	 * @return 采购入库单上架条目
	 * @throws Exception
	 */
	private PurchaseInputOrderPutOnItemDO createPurchaseInputOrderPutOnItem(
			Long purchaseInputOrderItemId, Long goodsAllocationId, Long goodsSkuId) throws Exception {
		PurchaseInputOrderPutOnItemDO purchaseInputOrderPutOnItem = new PurchaseInputOrderPutOnItemDO();
		purchaseInputOrderPutOnItem.setPurchaseInputOrderItemId(purchaseInputOrderItemId); 
		purchaseInputOrderPutOnItem.setGoodsAllocationId(goodsAllocationId); 
		purchaseInputOrderPutOnItem.setGoodsSkuId(goodsSkuId); 
		purchaseInputOrderPutOnItem.setPutOnShelvesCount(100L);  
		
		return purchaseInputOrderPutOnItem;
	}
	
}
