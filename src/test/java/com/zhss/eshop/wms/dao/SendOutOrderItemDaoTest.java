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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.SendOutOrderItemDO;

/**
 * 发货单条目管理DAO单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class SendOutOrderItemDaoTest {

	/**
	 * 发货单管理DAO组件
	 */
	@Autowired
	private SendOutOrderItemDAO sendOutOrderItemDAO;
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
	@Sql({"clean_send_out_order_item.sql"}) 
	public void testSave() throws Exception {
		Long sendOutOrderId = 1L;
		SendOutOrderItemDO sendOutOrderItem = createSendOutOrderItem(sendOutOrderId);
		assertNotNull(sendOutOrderItem.getId()); 
		assertThat(sendOutOrderItem.getId(), greaterThan(0L)); 
	} 
	
	/**
	 * 测试查询发货单条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_send_out_order_item.sql"}) 
	public void testListBySendOutOrderId() throws Exception {
		Integer count = 10;
		Long sendOutOrderId = 1L;
		Map<Long, SendOutOrderItemDO> expectedSendOutOrderItemMap = 
				createSendOutOrderItemMap(count, sendOutOrderId);
		
		List<SendOutOrderItemDO> actualSendOutOrderItems = sendOutOrderItemDAO.listByOrderInfoId(sendOutOrderId);
		
		compareSendOutOrderItems(count, expectedSendOutOrderItemMap, actualSendOutOrderItems);
	}
	
	/**
	 * 比较发货单集合
	 * @param expectedSendOutOrderMap 期望的发货单集合
	 * @param actualSendOutOrders 实际的发货单集合
	 * @throws Exception
	 */
	private void compareSendOutOrderItems(Integer expectedSize, 
			Map<Long, SendOutOrderItemDO> expectedSendOutOrderItemMap,
			List<SendOutOrderItemDO> actualSendOutOrderItems) throws Exception {
		assertEquals((int)expectedSize, actualSendOutOrderItems.size()); 
	
		for(SendOutOrderItemDO actualSendOutOrderItem : actualSendOutOrderItems) {
			SendOutOrderItemDO expectedSendOutOrderItem = expectedSendOutOrderItemMap.get(actualSendOutOrderItem.getId());
			assertEquals(expectedSendOutOrderItem, actualSendOutOrderItem);
		}
	}
	
	/**
	 * 创建发货单map
	 * @param count 发货单数量 
	 * @return 发货单map
	 * @throws Exception
	 */
	private Map<Long, SendOutOrderItemDO> createSendOutOrderItemMap(Integer count, 
			Long sendOutOrderId) throws Exception {
		Map<Long, SendOutOrderItemDO> sendOutOrderItemMap = 
				new HashMap<Long, SendOutOrderItemDO>(CollectionSize.DEFAULT);
		
		List<SendOutOrderItemDO> sendOutOrderItems = createSendOutOrderItems(count, sendOutOrderId);
		for(SendOutOrderItemDO sendOutOrderItem : sendOutOrderItems) {
			sendOutOrderItemMap.put(sendOutOrderItem.getId(), sendOutOrderItem);
		}
		
		return sendOutOrderItemMap;
	}
	
	/**
	 * 创建发货单条目集合
	 * @param count 发货单条目数量
	 * @return 发货单条目集合
	 * @throws Exception
	 */
	private List<SendOutOrderItemDO> createSendOutOrderItems(Integer count, Long sendOutOrderId) throws Exception {
		List<SendOutOrderItemDO> sendOutOrderItems = new ArrayList<SendOutOrderItemDO>();
		for(int i = 0; i < count; i++) {
			sendOutOrderItems.add(createSendOutOrderItem(sendOutOrderId));
		}
		return sendOutOrderItems;
	}
	
	/**
	 * 创建一个发货单条目
	 * @param sendOutOrderId
	 * @return
	 * @throws Exception
	 */
	private SendOutOrderItemDO createSendOutOrderItem(Long sendOutOrderId) throws Exception {
		SendOutOrderItemDO sendOutOrderItem = new SendOutOrderItemDO();
		sendOutOrderItem.setSendOutOrderId(sendOutOrderId); 
		sendOutOrderItem.setGoodsId(1L); 
		sendOutOrderItem.setGoodsSkuId(1L); 
		sendOutOrderItem.setGoodsSkuCode(UUID.randomUUID().toString().replace("-", ""));  
		sendOutOrderItem.setGoodsName("测试商品");
		sendOutOrderItem.setSaleProperties("测试销售属性");  
		sendOutOrderItem.setGoodsGrossWeight(56.0); 
		sendOutOrderItem.setPurchaseQuantity(3L); 
		sendOutOrderItem.setPurchasePrice(45.5); 
		sendOutOrderItem.setGoodsLength(23.5); 
		sendOutOrderItem.setGoodsWidth(56.7);
		sendOutOrderItem.setGoodsHeight(29.6); 
		sendOutOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
		sendOutOrderItem.setGmtModified(dateProvider.getCurrentTime());
		
		sendOutOrderItemDAO.save(sendOutOrderItem);
		
		return sendOutOrderItem;
	}
	
}
