package com.zhss.eshop.wms.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;

/**
 * 退货入库单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class ReturnGoodsInputOrderDaoTest {

	/**
	 * 退货入库单管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderDAO returnGoodsInputOrderDAO;
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
		when(dateProvider.getCurrentTime()).thenReturn(formatter.parse(formatter.format(new Date()))); 
	}
	
	/**
	 * 测试新增退货入库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order.sql"})    
	public void testSave() throws Exception {
		Long returnGoodsWorksheetId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		ReturnGoodsInputOrderDO returnGoodsInputOrder = createReturnGoodsInputOrder(
				returnGoodsWorksheetId, orderId, userAccountId);  
		assertNotNull(returnGoodsInputOrder.getId()); 
		assertThat(returnGoodsInputOrder.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询退货入库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order.sql"})    
	public void testListByPage() throws Exception {
		Long returnGoodsWorksheetId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		
		Integer count = 30;
		Map<Long, ReturnGoodsInputOrderDO> expectedReturnGoodsInputOrders = 
				createReturnGoodsInputOrderMap(count, returnGoodsWorksheetId, orderId, userAccountId);
		processExpectedOrderForListByPage(expectedReturnGoodsInputOrders); 
		
		Integer offset = 10;
		Integer size = 10;
		ReturnGoodsInputOrderQuery query = createReturnGoodsInputOrderQuery(offset, size, userAccountId);
		List<ReturnGoodsInputOrderDO> actualReturnGoodsInputOrders = returnGoodsInputOrderDAO.listByPage(query);
		
		compareReturnGoodsInputOrders(size, expectedReturnGoodsInputOrders, actualReturnGoodsInputOrders); 
	}
	
	/**
	 * 测试根据id查询退货入库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order.sql"})    
	public void testGetById() throws Exception {
		Long returnGoodsWorksheetId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		ReturnGoodsInputOrderDO expectedReturnGoodsInputOrder = createReturnGoodsInputOrder(
				returnGoodsWorksheetId, orderId, userAccountId);  
		ReturnGoodsInputOrderDO actualReturnGoodsInputOrder = returnGoodsInputOrderDAO.getById(
				expectedReturnGoodsInputOrder.getId());
		assertEquals(expectedReturnGoodsInputOrder, actualReturnGoodsInputOrder);  
	}
	
	/**
	 * 测试更新退货入库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order.sql"})    
	public void testUpdate() throws Exception {
		Long returnGoodsWorksheetId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		ReturnGoodsInputOrderDO expectedReturnGoodsInputOrder = createReturnGoodsInputOrder(
				returnGoodsWorksheetId, orderId, userAccountId);  
		
		expectedReturnGoodsInputOrder.setArrivalTime(dateProvider.getCurrentTime()); 
		returnGoodsInputOrderDAO.update(expectedReturnGoodsInputOrder); 
		
		ReturnGoodsInputOrderDO actualReturnGoodsInputOrder = returnGoodsInputOrderDAO.getById(
				expectedReturnGoodsInputOrder.getId());
		
		assertEquals(expectedReturnGoodsInputOrder, actualReturnGoodsInputOrder);  
	}
	
	/**
	 * 测试更新退货入库单状态
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_input_order.sql"})    
	public void testUpdateUpdate() throws Exception {
		Long returnGoodsWorksheetId = 1L;
		Long orderId = 1L;
		Long userAccountId = 1L;
		ReturnGoodsInputOrderDO expectedReturnGoodsInputOrder = createReturnGoodsInputOrder(
				returnGoodsWorksheetId, orderId, userAccountId);  
		expectedReturnGoodsInputOrder.setStatus(2); 
		
		returnGoodsInputOrderDAO.updateStatus(expectedReturnGoodsInputOrder.getId(), 2); 
		
		ReturnGoodsInputOrderDO actualReturnGoodsInputOrder = returnGoodsInputOrderDAO.getById(
				expectedReturnGoodsInputOrder.getId());
		assertEquals(expectedReturnGoodsInputOrder, actualReturnGoodsInputOrder);  
	}
	
	/**
	 * 为分页查询处理一下期望的退货入库单集合
	 * @param expectedReturnGoodsInputOrders 期望的退货入库单集合
	 * @throws Exception
	 */
	private void processExpectedOrderForListByPage(
			Map<Long, ReturnGoodsInputOrderDO> expectedReturnGoodsInputOrders) throws Exception {
		for(ReturnGoodsInputOrderDO expectedReturnGoodsInputOrder : expectedReturnGoodsInputOrders.values()) {
			expectedReturnGoodsInputOrder.setDeliveryAddress(null);
			expectedReturnGoodsInputOrder.setConsigneeCellPhoneNumber(null); 
			expectedReturnGoodsInputOrder.setInvoiceTitle(null); 
			expectedReturnGoodsInputOrder.setTaxpayerId(null); 
			expectedReturnGoodsInputOrder.setOrderComment(null); 
		}
	}
	
	/**
	 * 比较退货入库单集合
	 * @param expectedReturnGoodsInputOrders 期望的退货入库单集合
	 * @param actualReturnGoodsInputOrders 实际的退货入库单集合
	 * @throws Exception
	 */
	private void compareReturnGoodsInputOrders(Integer expectedSize, 
			Map<Long, ReturnGoodsInputOrderDO> expectedReturnGoodsInputOrders,
			List<ReturnGoodsInputOrderDO> actualReturnGoodsInputOrders) throws Exception {
		assertEquals((int)expectedSize, actualReturnGoodsInputOrders.size()); 
		for(ReturnGoodsInputOrderDO actualReturnGoodsInputOrder : actualReturnGoodsInputOrders) {
			ReturnGoodsInputOrderDO expectedReturnGoodsInputOrder = expectedReturnGoodsInputOrders.get(actualReturnGoodsInputOrder.getId());
			assertEquals(expectedReturnGoodsInputOrder, actualReturnGoodsInputOrder);
		}
	}
	
	/**
	 * 创建退货入库单查询条件
	 * @param offset 分页查询起始位置
	 * @param size 每页的数据量
	 * @return 退货入库单查询条件
	 * @throws Exception
	 */
	private ReturnGoodsInputOrderQuery createReturnGoodsInputOrderQuery(Integer offset, 
			Integer size, Long userAccountId) throws Exception {
		ReturnGoodsInputOrderQuery query = new ReturnGoodsInputOrderQuery();
		query.setOffset(offset);
		query.setSize(size); 
		return query;
	}
	
	/**
	 * 创建退货入库单map
	 * @param count 退货入库单数量 
	 * @return 退货入库单map
	 * @throws Exception
	 */
	private Map<Long, ReturnGoodsInputOrderDO> createReturnGoodsInputOrderMap(Integer count,
			Long returnGoodsWorksheetId, Long orderId, Long userAccountId) throws Exception {
		Map<Long, ReturnGoodsInputOrderDO> returnGoodsInputOrderMap = 
				new HashMap<Long, ReturnGoodsInputOrderDO>(CollectionSize.DEFAULT);
	
		List<ReturnGoodsInputOrderDO> returnGoodsInputOrders = createReturnGoodsInputOrders(
				count, returnGoodsWorksheetId, orderId, userAccountId);
		for(ReturnGoodsInputOrderDO returnGoodsInputOrder : returnGoodsInputOrders) {
			returnGoodsInputOrderMap.put(returnGoodsInputOrder.getId(), returnGoodsInputOrder);
		}
		
		return returnGoodsInputOrderMap;
	}
	
	/**
	 * 创建退货入库单集合
	 * @param count 退货入库单数量
	 * @return 退货入库单集合
	 * @throws Exception
	 */
	private List<ReturnGoodsInputOrderDO> createReturnGoodsInputOrders(Integer count, 
			Long returnGoodsWorksheetId, Long orderId, Long userAccountId) throws Exception {
		List<ReturnGoodsInputOrderDO> returnGoodsInputOrders = new ArrayList<ReturnGoodsInputOrderDO>();
		for(int i = 0; i < count; i++) {
			returnGoodsInputOrders.add(createReturnGoodsInputOrder(returnGoodsWorksheetId, orderId, userAccountId));
		}
		return returnGoodsInputOrders;
	}
	
	private ReturnGoodsInputOrderDO createReturnGoodsInputOrder(
			Long returnGoodsWorksheetId, Long orderId, Long userAccountId) throws Exception {
		ReturnGoodsInputOrderDO returnGoodsInputOrder = new ReturnGoodsInputOrderDO();
		
		returnGoodsInputOrder.setReturnGoodsWorksheetId(returnGoodsWorksheetId); 
		returnGoodsInputOrder.setOrderId(orderId); 
		returnGoodsInputOrder.setOrderNo(UUID.randomUUID().toString().replace("-", ""));   
		returnGoodsInputOrder.setUserAccountId(userAccountId); 
		returnGoodsInputOrder.setConsignee("张三");  
		returnGoodsInputOrder.setDeliveryAddress("上海市");  
		returnGoodsInputOrder.setConsigneeCellPhoneNumber("13900567849");  
		returnGoodsInputOrder.setFreight(10.8); 
		returnGoodsInputOrder.setPayType(1); 
		returnGoodsInputOrder.setTotalAmount(100.00); 
		returnGoodsInputOrder.setDiscountAmount(1.8);
		returnGoodsInputOrder.setCouponAmount(10.00); 
		returnGoodsInputOrder.setPayableAmount(99.0); 
		returnGoodsInputOrder.setInvoiceTitle("上海市某公司");  
		returnGoodsInputOrder.setTaxpayerId(UUID.randomUUID().toString().replace("-", ""));  
		returnGoodsInputOrder.setOrderComment("测试退货入库单");  
		returnGoodsInputOrder.setStatus(1); 
		returnGoodsInputOrder.setReturnGoodsReason(1); 
		returnGoodsInputOrder.setReturnGoodsRemark("测试退货入库单");
		returnGoodsInputOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		returnGoodsInputOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		returnGoodsInputOrderDAO.save(returnGoodsInputOrder);
		
		return returnGoodsInputOrder;
 	}
	
}
