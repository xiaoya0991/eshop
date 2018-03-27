package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

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
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDO;

/**
 * 退货入库单上架条目管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class ReturnGoodsInputOrderPutOnItemDAOTest {

	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	/**
	 * 退货入库单上架条目管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderPutOnItemDAO returnGoodsInputOrderPutOnItemDAO;
	
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
	 * 测试新建退货入库单上架条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order_put_on_item.sql"})   
	public void testSave() throws Exception {
		Long returnGoodsInputOrderItemId = 1L;
		ReturnGoodsInputOrderPutOnItemDO expectedPutOnItem = 
				createReturnGoodsInputOrderPutOnItem(returnGoodsInputOrderItemId, 1L, 1L);
		assertNotNull(expectedPutOnItem.getId()); 
		assertThat(expectedPutOnItem.getId(), greaterThan(0L));  
 	}
	
	/**
	 * 测试根据id查询退货入库单上架条目
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order_put_on_item.sql"})   
	public void testListByReturnGoodsInputOrderId() throws Exception {
		Long returnGoodsInputOrderItemId = 1L;
		Integer count = 10;
		Map<Long, ReturnGoodsInputOrderPutOnItemDO> expectedReturnGoodsInputOrderPutOnItems = 
				createReturnGoodsInputOrderPutOnItemMap(count, returnGoodsInputOrderItemId);
		
		List<ReturnGoodsInputOrderPutOnItemDO> actualReturnGoodsInputOrderPutOnItems = 
				returnGoodsInputOrderPutOnItemDAO.listByReturnGoodsInputOrderItemId(returnGoodsInputOrderItemId);
		
		compareReturnGoodsInputOrderPutOnItem(count, expectedReturnGoodsInputOrderPutOnItems, 
				actualReturnGoodsInputOrderPutOnItems); 
	}
	
	/**
	 * 比较两个退货入库单上架条目集合
	 * @param expectedReturnGoodsInputOrderPutOnItemMap 期望的退货入库单上架条目集合
	 * @param actualReturnGoodsInputOrderPutOnItemList 实际的退货入库单上架条目集合
	 * @throws Exception
	 */
	private void compareReturnGoodsInputOrderPutOnItem(
			Integer expectedSize ,
			Map<Long, ReturnGoodsInputOrderPutOnItemDO> expectedReturnGoodsInputOrderPutOnItems,
			List<ReturnGoodsInputOrderPutOnItemDO> actualReturnGoodsInputOrderPutOnItems) throws Exception {
		assertEquals((int)expectedSize, actualReturnGoodsInputOrderPutOnItems.size()); 
		for(ReturnGoodsInputOrderPutOnItemDO actualReturnGoodsInputOrderPutOnItem : actualReturnGoodsInputOrderPutOnItems) {
			ReturnGoodsInputOrderPutOnItemDO expectedReturnGoodsInputOrderPutOnItem = expectedReturnGoodsInputOrderPutOnItems
					.get(actualReturnGoodsInputOrderPutOnItem.getId());
			assertEquals(expectedReturnGoodsInputOrderPutOnItem, actualReturnGoodsInputOrderPutOnItem); 
		}
	}
	
	/**
	 * 创建退货入库单上架条目集合
	 * @param categoryId 类目id
	 * @return 退货入库单上架条目集合
	 * @throws Exception
	 */
	private Map<Long, ReturnGoodsInputOrderPutOnItemDO> createReturnGoodsInputOrderPutOnItemMap(
			Integer count, Long returnGoodsInputOrderItemId) throws Exception {
		Map<Long, ReturnGoodsInputOrderPutOnItemDO> returnGoodsInputOrderPutOnItemMap = new HashMap<Long, ReturnGoodsInputOrderPutOnItemDO>();
		
		List<ReturnGoodsInputOrderPutOnItemDO> returnGoodsInputOrderPutOnItemList = createReturnGoodsInputOrderPutOnItems(
				count, returnGoodsInputOrderItemId);
		 
		for(ReturnGoodsInputOrderPutOnItemDO returnGoodsInputOrderPutOnItem : returnGoodsInputOrderPutOnItemList) {
			returnGoodsInputOrderPutOnItemMap.put(returnGoodsInputOrderPutOnItem.getId(), returnGoodsInputOrderPutOnItem);
		}
		
		return returnGoodsInputOrderPutOnItemMap;
	}
	
	/**
	 * 创建退货入库单上架条目集合
	 * @param categoryId 类目id 
	 * @param count 退货入库单上架条目数量
	 * @return 退货入库单上架条目集合
	 * @throws Exception
	 */
	private List<ReturnGoodsInputOrderPutOnItemDO> createReturnGoodsInputOrderPutOnItems(
			Integer count, Long returnGoodsInputOrderItemId) throws Exception {
		List<ReturnGoodsInputOrderPutOnItemDO> returnGoodsInputOrderPutOnItemList = 
				new ArrayList<ReturnGoodsInputOrderPutOnItemDO>();
		
		for(int i = 0; i < count; i++) {
			ReturnGoodsInputOrderPutOnItemDO putOnItem = createReturnGoodsInputOrderPutOnItem(
					returnGoodsInputOrderItemId, (long)i, (long)i);
			returnGoodsInputOrderPutOnItemList.add(putOnItem);       
		}
		
		return returnGoodsInputOrderPutOnItemList;
	}
	
	/**
	 * 创建退货入库单上架条目
	 * @return 退货入库单上架条目
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderPutOnItemDO createReturnGoodsInputOrderPutOnItem(
			Long returnGoodsInputOrderItemId, Long goodsAllocationId, Long goodsSkuId) throws Exception {
		ReturnGoodsInputOrderPutOnItemDO returnGoodsInputOrderPutOnItem = new ReturnGoodsInputOrderPutOnItemDO();
		returnGoodsInputOrderPutOnItem.setReturnGoodsInputOrderItemId(returnGoodsInputOrderItemId); 
		returnGoodsInputOrderPutOnItem.setGoodsAllocationId(goodsAllocationId); 
		returnGoodsInputOrderPutOnItem.setGoodsSkuId(goodsSkuId); 
		returnGoodsInputOrderPutOnItem.setPutOnShelvesCount(100L);  
		
		returnGoodsInputOrderPutOnItemDAO.save(returnGoodsInputOrderPutOnItem); 
		
		return returnGoodsInputOrderPutOnItem;
	}
	
}
