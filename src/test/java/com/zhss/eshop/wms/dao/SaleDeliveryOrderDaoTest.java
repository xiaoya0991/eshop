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
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;

/**
 * 销售出库单管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class SaleDeliveryOrderDaoTest {

	/**
	 * 销售出库单管理DAO组件
	 */
	@Autowired
	private SaleDeliveryOrderDAO saleDeliveryOrderDAO;
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
	 * 测试新增销售出库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order.sql"})    
	public void testSave() throws Exception {
		Long orderId = 1L;
		Long userAccountId = 1L;
		SaleDeliveryOrderDO saleDeliveryOrder = createSaleDeliveryOrder(orderId, userAccountId);  
		assertNotNull(saleDeliveryOrder.getId()); 
		assertThat(saleDeliveryOrder.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询销售出库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order.sql"})    
	public void testListByPage() throws Exception {
		Long orderId = 1L;
		Long userAccountId = 1L;
		
		Integer count = 30;
		Map<Long, SaleDeliveryOrderDO> expectedSaleDeliveryOrders = createSaleDeliveryOrderMap(
				count, orderId, userAccountId);
		processExpectedOrderForListByPage(expectedSaleDeliveryOrders); 
		
		Integer offset = 10;
		Integer size = 10;
		SaleDeliveryOrderQuery query = createSaleDeliveryOrderQuery(offset, size, userAccountId);
		List<SaleDeliveryOrderDO> actualSaleDeliveryOrders = saleDeliveryOrderDAO.listByPage(query);
		
		compareSaleDeliveryOrders(size, expectedSaleDeliveryOrders, actualSaleDeliveryOrders); 
	}
	
	/**
	 * 测试根据id查询销售出库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order.sql"})    
	public void testGetById() throws Exception {
		Long orderId = 1L;
		Long userAccountId = 1L;
		SaleDeliveryOrderDO expectedSaleDeliveryOrder = createSaleDeliveryOrder(orderId, userAccountId);  
		SaleDeliveryOrderDO actualSaleDeliveryOrder = saleDeliveryOrderDAO.getById(expectedSaleDeliveryOrder.getId());
		assertEquals(expectedSaleDeliveryOrder, actualSaleDeliveryOrder);  
	}
	
	/**
	 * 测试更新销售出库单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_sale_delivery_order.sql"})    
	public void testUpdate() throws Exception {
		Long orderId = 1L;
		Long userAccountId = 1L;
		SaleDeliveryOrderDO expectedSaleDeliveryOrder = createSaleDeliveryOrder(orderId, userAccountId);  
		
		expectedSaleDeliveryOrder.setDeliveryTime(dateProvider.getCurrentTime()); 
		saleDeliveryOrderDAO.update(expectedSaleDeliveryOrder); 
		
		SaleDeliveryOrderDO actualSaleDeliveryOrder = saleDeliveryOrderDAO.getById(expectedSaleDeliveryOrder.getId());
		assertEquals(expectedSaleDeliveryOrder, actualSaleDeliveryOrder);  
	}
	
	/**
	 * 为分页查询处理一下期望的销售出库单集合
	 * @param expectedSaleDeliveryOrders 期望的销售出库单集合
	 * @throws Exception
	 */
	private void processExpectedOrderForListByPage(
			Map<Long, SaleDeliveryOrderDO> expectedSaleDeliveryOrders) throws Exception {
		for(SaleDeliveryOrderDO expectedSaleDeliveryOrder : expectedSaleDeliveryOrders.values()) {
			expectedSaleDeliveryOrder.setDeliveryAddress(null);
			expectedSaleDeliveryOrder.setConsigneeCellPhoneNumber(null); 
			expectedSaleDeliveryOrder.setInvoiceTitle(null); 
			expectedSaleDeliveryOrder.setTaxpayerId(null); 
			expectedSaleDeliveryOrder.setOrderComment(null); 
		}
	}
	
	/**
	 * 比较销售出库单集合
	 * @param expectedSaleDeliveryOrders 期望的销售出库单集合
	 * @param actualSaleDeliveryOrders 实际的销售出库单集合
	 * @throws Exception
	 */
	private void compareSaleDeliveryOrders(Integer expectedSize, 
			Map<Long, SaleDeliveryOrderDO> expectedSaleDeliveryOrders,
			List<SaleDeliveryOrderDO> actualSaleDeliveryOrders) throws Exception {
		assertEquals((int)expectedSize, actualSaleDeliveryOrders.size()); 
	
		for(SaleDeliveryOrderDO actualSaleDeliveryOrder : actualSaleDeliveryOrders) {
			SaleDeliveryOrderDO expectedSaleDeliveryOrder = expectedSaleDeliveryOrders.get(actualSaleDeliveryOrder.getId());
			assertEquals(expectedSaleDeliveryOrder, actualSaleDeliveryOrder);
		}
	}
	
	/**
	 * 创建销售出库单查询条件
	 * @param offset 分页查询起始位置
	 * @param size 每页的数据量
	 * @return 销售出库单查询条件
	 * @throws Exception
	 */
	private SaleDeliveryOrderQuery createSaleDeliveryOrderQuery(Integer offset, 
			Integer size, Long userAccountId) throws Exception {
		SaleDeliveryOrderQuery query = new SaleDeliveryOrderQuery();
		query.setOffset(offset);
		query.setSize(size); 
		return query;
	}
	
	/**
	 * 创建销售出库单map
	 * @param count 销售出库单数量 
	 * @return 销售出库单map
	 * @throws Exception
	 */
	private Map<Long, SaleDeliveryOrderDO> createSaleDeliveryOrderMap(Integer count,
			Long orderId, Long userAccountId) throws Exception {
		Map<Long, SaleDeliveryOrderDO> saleDeliveryOrderMap = 
				new HashMap<Long, SaleDeliveryOrderDO>(CollectionSize.DEFAULT);
	
		List<SaleDeliveryOrderDO> saleDeliveryOrders = createSaleDeliveryOrders(
				count, orderId, userAccountId);
		for(SaleDeliveryOrderDO saleDeliveryOrder : saleDeliveryOrders) {
			saleDeliveryOrderMap.put(saleDeliveryOrder.getId(), saleDeliveryOrder);
		}
		
		return saleDeliveryOrderMap;
	}
	
	/**
	 * 创建销售出库单集合
	 * @param count 销售出库单数量
	 * @return 销售出库单集合
	 * @throws Exception
	 */
	private List<SaleDeliveryOrderDO> createSaleDeliveryOrders(Integer count, 
			Long orderId, Long userAccountId) throws Exception {
		List<SaleDeliveryOrderDO> saleDeliveryOrders = new ArrayList<SaleDeliveryOrderDO>();
		for(int i = 0; i < count; i++) {
			saleDeliveryOrders.add(createSaleDeliveryOrder(orderId, userAccountId));
		}
		return saleDeliveryOrders;
	}
	
	private SaleDeliveryOrderDO createSaleDeliveryOrder(Long orderId, 
			Long userAccountId) throws Exception {
		SaleDeliveryOrderDO saleDeliveryOrder = new SaleDeliveryOrderDO();
		
		saleDeliveryOrder.setOrderId(orderId); 
		saleDeliveryOrder.setOrderNo(UUID.randomUUID().toString().replace("-", ""));   
		saleDeliveryOrder.setUserAccountId(userAccountId); 
		saleDeliveryOrder.setConsignee("张三");  
		saleDeliveryOrder.setDeliveryAddress("上海市");  
		saleDeliveryOrder.setConsigneeCellPhoneNumber("13900567849");  
		saleDeliveryOrder.setFreight(10.8); 
		saleDeliveryOrder.setPayType(1); 
		saleDeliveryOrder.setTotalAmount(100.00); 
		saleDeliveryOrder.setDiscountAmount(1.8);
		saleDeliveryOrder.setCouponAmount(10.00); 
		saleDeliveryOrder.setPayableAmount(99.0); 
		saleDeliveryOrder.setInvoiceTitle("上海市某公司");  
		saleDeliveryOrder.setTaxpayerId(UUID.randomUUID().toString().replace("-", ""));  
		saleDeliveryOrder.setOrderComment("测试销售出库单");  
		saleDeliveryOrder.setStatus(1); 
		saleDeliveryOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		saleDeliveryOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		saleDeliveryOrderDAO.save(saleDeliveryOrder);
		
		return saleDeliveryOrder;
 	}
	
}
