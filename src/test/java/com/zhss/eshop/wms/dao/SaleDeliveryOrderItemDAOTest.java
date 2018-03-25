package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDO;

/**
 * 销售出库单条目管理DAO单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class SaleDeliveryOrderItemDAOTest {

	/**
	 * 销售出库单管理DAO组件
	 */
	@Autowired
	private SaleDeliveryOrderItemDAO saleDeliveryOrderItemDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增商品条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order_item.sql"}) 
	public void testSave() throws Exception {
		Long saleDeliveryOrderId = 1L;
		SaleDeliveryOrderItemDO saleDeliveryOrderItem = createSaleDeliveryOrderItem(saleDeliveryOrderId);
		assertNotNull(saleDeliveryOrderItem.getId()); 
		assertThat(saleDeliveryOrderItem.getId(), greaterThan(0L)); 
	} 
	
	/**
	 * 测试查询销售出库单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order_item.sql"}) 
	public void testListBySaleDeliveryOrderId() throws Exception {
		Integer count = 10;
		Long saleDeliveryOrderId = 1L;
		Map<Long, SaleDeliveryOrderItemDO> expectedSaleDeliveryOrderItemMap = 
				createSaleDeliveryOrderItemMap(count, saleDeliveryOrderId);
		
		List<SaleDeliveryOrderItemDO> actualSaleDeliveryOrderItems = saleDeliveryOrderItemDAO.listBySaleDeliveryOrderId(saleDeliveryOrderId);
		
		compareSaleDeliveryOrderItems(count, expectedSaleDeliveryOrderItemMap, actualSaleDeliveryOrderItems);
	}
	
	/**
	 * 比较销售出库单集合
	 * @param expectedSaleDeliveryOrderMap 期望的销售出库单集合
	 * @param actualSaleDeliveryOrders 实际的销售出库单集合
	 * @throws Exception
	 */
	private void compareSaleDeliveryOrderItems(Integer expectedSize, 
			Map<Long, SaleDeliveryOrderItemDO> expectedSaleDeliveryOrderItemMap,
			List<SaleDeliveryOrderItemDO> actualSaleDeliveryOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualSaleDeliveryOrderItems.size()); 
	
		for(SaleDeliveryOrderItemDO actualSaleDeliveryOrderItem : actualSaleDeliveryOrderItems) {
			SaleDeliveryOrderItemDO expectedSaleDeliveryOrderItem = expectedSaleDeliveryOrderItemMap.get(actualSaleDeliveryOrderItem.getId());
			assertEquals(expectedSaleDeliveryOrderItem, actualSaleDeliveryOrderItem);
		}
	}
	
	/**
	 * 创建销售出库单map
	 * @param count 销售出库单数量 
	 * @return 销售出库单map
	 * @throws Exception
	 */
	private Map<Long, SaleDeliveryOrderItemDO> createSaleDeliveryOrderItemMap(Integer count, 
			Long saleDeliveryOrderId) throws Exception {
		Map<Long, SaleDeliveryOrderItemDO> saleDeliveryOrderItemMap = new HashMap<Long, SaleDeliveryOrderItemDO>();
		
		List<SaleDeliveryOrderItemDO> saleDeliveryOrderItems = createSaleDeliveryOrderItems(count, saleDeliveryOrderId);
		for(SaleDeliveryOrderItemDO saleDeliveryOrderItem : saleDeliveryOrderItems) {
			saleDeliveryOrderItemMap.put(saleDeliveryOrderItem.getId(), saleDeliveryOrderItem);
		}
		
		return saleDeliveryOrderItemMap;
	}
	
	/**
	 * 创建销售出库单条目集合
	 * @param count 销售出库单条目数量
	 * @return 销售出库单条目集合
	 * @throws Exception
	 */
	private List<SaleDeliveryOrderItemDO> createSaleDeliveryOrderItems(Integer count, Long saleDeliveryOrderId) throws Exception {
		List<SaleDeliveryOrderItemDO> saleDeliveryOrderItems = new ArrayList<SaleDeliveryOrderItemDO>();
		for(int i = 0; i < count; i++) {
			saleDeliveryOrderItems.add(createSaleDeliveryOrderItem(saleDeliveryOrderId));
		}
		return saleDeliveryOrderItems;
	}
	
	/**
	 * 创建一个销售出库单条目
	 * @param saleDeliveryOrderId
	 * @return
	 * @throws Exception
	 */
	private SaleDeliveryOrderItemDO createSaleDeliveryOrderItem(Long saleDeliveryOrderId) throws Exception {
		SaleDeliveryOrderItemDO saleDeliveryOrderItem = new SaleDeliveryOrderItemDO();
		saleDeliveryOrderItem.setSaleDeliveryOrderId(saleDeliveryOrderId); 
		saleDeliveryOrderItem.setGoodsSkuId(1L); 
		saleDeliveryOrderItem.setGoodsSkuCode(UUID.randomUUID().toString().replace("-", ""));  
		saleDeliveryOrderItem.setGoodsName("测试商品");
		saleDeliveryOrderItem.setSaleProperties("测试销售属性");  
		saleDeliveryOrderItem.setGoodsGrossWeight(56.0); 
		saleDeliveryOrderItem.setPurchaseQuantity(3L); 
		saleDeliveryOrderItem.setPurchasePrice(45.5); 
		saleDeliveryOrderItem.setPromotionActivityId(null); 
		saleDeliveryOrderItem.setGoodsLength(23.5); 
		saleDeliveryOrderItem.setGoodsWidth(56.7);
		saleDeliveryOrderItem.setGoodsHeight(29.6); 
		saleDeliveryOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		saleDeliveryOrderItem.setGmtModified(dateProvider.getCurrentTime());
		
		saleDeliveryOrderItemDAO.save(saleDeliveryOrderItem);
		
		return saleDeliveryOrderItem;
	}
	
}
