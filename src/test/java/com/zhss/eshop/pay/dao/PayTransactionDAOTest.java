package com.zhss.eshop.pay.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.pay.domain.PayTransactionDO;
import com.zhss.eshop.pay.domain.PayTransactionQuery;

/**
 * 支付交易流水管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class PayTransactionDAOTest {

	/**
	 * 支付交易流水管理DAO组件
	 */
	@Autowired
	private PayTransactionDAO payTransactionDAO;
	/**
	 * mock后的日期辅助组件
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
	 * 测试新增支付交易流水
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_pay_transaction.sql"})  
	public void testSave() throws Exception { 
		PayTransactionDO expectedPayTransaction = createPayTransaction();
		assertNotNull(expectedPayTransaction.getId()); 
		assertThat(expectedPayTransaction.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据条件查询支付交易流水
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_pay_transaction.sql"})  
	public void testListByCondition() throws Exception {
		Integer count = 30;
		Map<Long, PayTransactionDO> expectedPayTransactions = createPayTransactionMap(count);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("transactionChannel", 1);
		parameters.put("status", 1);
		parameters.put("orderNo", "测试订单编号"); 
		List<PayTransactionDO> actualPayTransactions = 
				payTransactionDAO.listByCondition(parameters);
		
		comparePayTransactions(count, expectedPayTransactions, actualPayTransactions); 
	}
	
	/**
	 * 测试分页查询支付交易流水
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_pay_transaction.sql"})  
	public void testListByPage() throws Exception {
		Integer count = 30;
		Map<Long, PayTransactionDO> expectedPayTransactions = createPayTransactionMap(count);
		
		PayTransactionQuery query = new PayTransactionQuery();
		query.setOffset(0); 
		query.setSize(10);  
		List<PayTransactionDO> actualPayTransactions = payTransactionDAO.listByPage(query);
		
		comparePayTransactions(10, expectedPayTransactions, actualPayTransactions); 
	}
	
	/**
	 * 测试根据id查询支付交易流水
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_pay_transaction.sql"})  
	public void testUpdate() throws Exception {
		PayTransactionDO expectedPayTransaction = createPayTransaction();
		
		expectedPayTransaction.setFinishPayTime(dateProvider.getCurrentTime()); 
		expectedPayTransaction.setResponseCode("SUCCESS");  
		expectedPayTransaction.setTransactionNumber("测试交易流水号");  
		expectedPayTransaction.setUserPayAccount("测试用户账号");  
		payTransactionDAO.update(expectedPayTransaction); 
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("orderNo", "测试订单编号"); 
		List<PayTransactionDO> actualPayTransactions = 
				payTransactionDAO.listByCondition(parameters);
		PayTransactionDO actualPayTransaction = actualPayTransactions.get(0);
		
		assertEquals(expectedPayTransaction, actualPayTransaction); 
	}
	
	/**
	 * 比较两个支付交易流水
	 * @param expectedPayTransactions 期望的支付交易流水
	 * @param actualPayTransactions 实际的支付交易流水
	 */
	private void comparePayTransactions(
			Integer expectedSize,
			Map<Long, PayTransactionDO> expectedPayTransactions,
			List<PayTransactionDO> actualPayTransactions) {
		assertEquals((int)expectedSize, actualPayTransactions.size()); 
		for(PayTransactionDO actualPayTransaction : actualPayTransactions) {
			PayTransactionDO expectedPayTransaction = expectedPayTransactions.get(actualPayTransaction.getId());
			assertEquals(expectedPayTransaction, actualPayTransaction); 
		}
	}
	
	/**
	 * 创建支付交易流水
	 * @param count 支付交易流水的数量
	 * @return 支付交易流水
	 * @throws Exception
	 */
	private Map<Long, PayTransactionDO> createPayTransactionMap(Integer count) throws Exception {
		List<PayTransactionDO> payTransactions = createPayTransactions(count);
		Map<Long, PayTransactionDO> payTransactionMap = new HashMap<Long, PayTransactionDO>();
		for(PayTransactionDO payTransaction : payTransactions) {
			payTransactionMap.put(payTransaction.getId(), payTransaction);
		}
		return payTransactionMap;
	}
	
	/**
	 * 创建支付交易流水
	 * @param count 支付交易流水的数量
	 * @return 支付交易流水
	 * @throws Exception
	 */
	private List<PayTransactionDO> createPayTransactions(Integer count) throws Exception {
		List<PayTransactionDO> payTransactions = new ArrayList<PayTransactionDO>();
		for(int i = 0; i < count; i++) {
			payTransactions.add(createPayTransaction()); 
		}
		return payTransactions;
	}
	
	/**
	 * 创建支付交易流水
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @return 支付交易流水
	 * @throws Exception
	 */
	private PayTransactionDO createPayTransaction() throws Exception {
		PayTransactionDO payTransaction = new PayTransactionDO();
		payTransaction.setOrderInfoId(1L); 
		payTransaction.setOrderNo("测试订单编号");  
		payTransaction.setPayableAmount(1000.0); 
		payTransaction.setUserAccountId(1L);
		payTransaction.setTransactionChannel(1); 
		payTransaction.setStatus(1); 
		payTransactionDAO.save(payTransaction); 
		
		return payTransaction;
	}
	
}
