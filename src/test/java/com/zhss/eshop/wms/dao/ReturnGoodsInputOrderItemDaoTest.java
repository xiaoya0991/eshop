package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

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
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDO;

/**
 * 退货入库单条目管理DAO单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class ReturnGoodsInputOrderItemDaoTest {

	/**
	 * 退货入库单管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderItemDAO returnGoodsInputOrderItemDAO;
	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 初始化
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = formatter.parse(formatter.format(new Date()));  
		when(dateProvider.getCurrentTime()).thenReturn(date);
	}
	
	/**
	 * 测试新增商品条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order_item.sql"}) 
	public void testSave() throws Exception {
		Long returnGoodsInputOrderId = 1L;
		ReturnGoodsInputOrderItemDO returnGoodsInputOrderItem = 
				createReturnGoodsInputOrderItem(returnGoodsInputOrderId);
		assertNotNull(returnGoodsInputOrderItem.getId()); 
		assertThat(returnGoodsInputOrderItem.getId(), greaterThan(0L)); 
	} 
	
	/**
	 * 测试查询退货入库单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order_item.sql"}) 
	public void testListByReturnGoodsInputOrderId() throws Exception {
		Integer count = 10;
		Long returnGoodsInputOrderId = 1L;
		Map<Long, ReturnGoodsInputOrderItemDO> expectedReturnGoodsInputOrderItemMap = 
				createReturnGoodsInputOrderItemMap(count, returnGoodsInputOrderId);
		
		List<ReturnGoodsInputOrderItemDO> actualReturnGoodsInputOrderItems = 
				returnGoodsInputOrderItemDAO.listByReturnGoodsInputOrderId(returnGoodsInputOrderId);
		
		compareReturnGoodsInputOrderItems(count, expectedReturnGoodsInputOrderItemMap, 
				actualReturnGoodsInputOrderItems);
	}
	
	/**
	 * 测试更新商品条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order_item.sql"}) 
	public void testUpdate() throws Exception {
		Long returnGoodsInputOrderId = 1L;
		ReturnGoodsInputOrderItemDO expectedReturnGoodsInputOrderItem = 
				createReturnGoodsInputOrderItem(returnGoodsInputOrderId);
		
		expectedReturnGoodsInputOrderItem.setQualifiedCount(3L);
		expectedReturnGoodsInputOrderItem.setArrivalCount(3L);
		returnGoodsInputOrderItemDAO.update(expectedReturnGoodsInputOrderItem); 
		
		List<ReturnGoodsInputOrderItemDO> actualReturnGoodsInputOrderItems = 
				returnGoodsInputOrderItemDAO.listByReturnGoodsInputOrderId(returnGoodsInputOrderId);
		ReturnGoodsInputOrderItemDO actualReturnGoodsInputOrderItem = 
				actualReturnGoodsInputOrderItems.get(0);
		
		assertEquals(expectedReturnGoodsInputOrderItem, actualReturnGoodsInputOrderItem); 
	} 
	
	/**
	 * 比较退货入库单集合
	 * @param expectedSaleDeliveryOrderMap 期望的退货入库单集合
	 * @param actualSaleDeliveryOrders 实际的退货入库单集合
	 * @throws Exception
	 */
	private void compareReturnGoodsInputOrderItems(Integer expectedSize, 
			Map<Long, ReturnGoodsInputOrderItemDO> expectedReturnGoodsInputOrderItemMap,
			List<ReturnGoodsInputOrderItemDO> actualReturnGoodsInputOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualReturnGoodsInputOrderItems.size()); 
	
		for(ReturnGoodsInputOrderItemDO actualReturnGoodsInputOrderItem : actualReturnGoodsInputOrderItems) {
			ReturnGoodsInputOrderItemDO expectedReturnGoodsInputOrderItem = expectedReturnGoodsInputOrderItemMap.get(actualReturnGoodsInputOrderItem.getId());
			assertEquals(expectedReturnGoodsInputOrderItem, actualReturnGoodsInputOrderItem);
		}
	}
	
	/**
	 * 创建退货入库单map
	 * @param count 退货入库单数量 
	 * @return 退货入库单map
	 * @throws Exception
	 */
	private Map<Long, ReturnGoodsInputOrderItemDO> createReturnGoodsInputOrderItemMap(Integer count, 
			Long returnGoodsInputOrderId) throws Exception {
		Map<Long, ReturnGoodsInputOrderItemDO> returnGoodsInputOrderItemMap = 
				new HashMap<Long, ReturnGoodsInputOrderItemDO>(CollectionSize.DEFAULT);
		
		List<ReturnGoodsInputOrderItemDO> returnGoodsInputOrderItems = createReturnGoodsInputOrderItems(count, returnGoodsInputOrderId);
		for(ReturnGoodsInputOrderItemDO returnGoodsInputOrderItem : returnGoodsInputOrderItems) {
			returnGoodsInputOrderItemMap.put(returnGoodsInputOrderItem.getId(), returnGoodsInputOrderItem);
		}
		
		return returnGoodsInputOrderItemMap;
	}
	
	/**
	 * 创建退货入库单条目集合
	 * @param count 退货入库单条目数量
	 * @return 退货入库单条目集合
	 * @throws Exception
	 */
	private List<ReturnGoodsInputOrderItemDO> createReturnGoodsInputOrderItems(Integer count, Long returnGoodsInputOrderId) throws Exception {
		List<ReturnGoodsInputOrderItemDO> returnGoodsInputOrderItems = new ArrayList<ReturnGoodsInputOrderItemDO>();
		for(int i = 0; i < count; i++) {
			returnGoodsInputOrderItems.add(createReturnGoodsInputOrderItem(returnGoodsInputOrderId));
		}
		return returnGoodsInputOrderItems;
	}
	
	/**
	 * 创建一个退货入库单条目
	 * @param returnGoodsInputOrderId
	 * @return
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderItemDO createReturnGoodsInputOrderItem(Long returnGoodsInputOrderId) throws Exception {
		ReturnGoodsInputOrderItemDO returnGoodsInputOrderItem = new ReturnGoodsInputOrderItemDO();
		returnGoodsInputOrderItem.setReturnGoodsInputOrderId(returnGoodsInputOrderId); 
		returnGoodsInputOrderItem.setGoodsSkuId(1L); 
		returnGoodsInputOrderItem.setGoodsSkuCode(UUID.randomUUID().toString().replace("-", ""));  
		returnGoodsInputOrderItem.setGoodsName("测试商品");
		returnGoodsInputOrderItem.setSaleProperties("测试销售属性");  
		returnGoodsInputOrderItem.setGoodsGrossWeight(56.0); 
		returnGoodsInputOrderItem.setPurchaseQuantity(3L); 
		returnGoodsInputOrderItem.setPurchasePrice(45.5); 
		returnGoodsInputOrderItem.setPromotionActivityId(null); 
		returnGoodsInputOrderItem.setGoodsLength(23.5); 
		returnGoodsInputOrderItem.setGoodsWidth(56.7);
		returnGoodsInputOrderItem.setGoodsHeight(29.6); 
		returnGoodsInputOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		returnGoodsInputOrderItem.setGmtModified(dateProvider.getCurrentTime());
		
		returnGoodsInputOrderItemDAO.save(returnGoodsInputOrderItem);
		
		return returnGoodsInputOrderItem;
	}
	
}
