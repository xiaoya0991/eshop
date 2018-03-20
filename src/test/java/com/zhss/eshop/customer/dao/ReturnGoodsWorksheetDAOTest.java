package com.zhss.eshop.customer.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.customer.constant.ReturnGoodsWorksheetStatus;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;

/**
 * 退货工单管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class ReturnGoodsWorksheetDAOTest {

	/**
	 * 退货工单管理DAO组件
	 */
	@Autowired
	private ReturnGoodsWorksheetDAO worksheetDAO;

	/**
	 * 测试新增退货工单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_worksheet.sql"})  
	public void testSave() throws Exception {
		Long orderInfoId = 1L;
		String orderNo = "测试订单";
		ReturnGoodsWorksheetDO worksheet = createReturnGoodsWorksheet(orderInfoId, orderNo);   
		assertNotNull(worksheet.getId()); 
		assertThat(worksheet.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询退货工单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_worksheet.sql"})    
	public void testListByPage() throws Exception {
		Integer count = 30;
		Map<Long, ReturnGoodsWorksheetDO> expectedReturnGoodsWorksheets = 
				createReturnGoodsWorksheetMap(count, false);
		
		Integer expectedSize = 10;
		ReturnGoodsWorksheetQuery query = createReturnGoodsWorksheetQuery(expectedSize);
		List<ReturnGoodsWorksheetDO> actualReturnGoodsWorksheets = worksheetDAO.listByPage(query);
		
		compareReturnGoodsWorksheets(expectedSize, 
				expectedReturnGoodsWorksheets, actualReturnGoodsWorksheets); 
	}
	
	/**
	 * 测试根据id查询退货工单
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_worksheet.sql"})  
	public void testGetById() throws Exception {
		Long orderInfoId = 1L;
		String orderNo = "测试订单";
		ReturnGoodsWorksheetDO expectedReturnGoodsWorksheet = createReturnGoodsWorksheet(
				orderInfoId, orderNo);
		ReturnGoodsWorksheetDO actualReturnGoodsWorksheet = worksheetDAO.getById(
				expectedReturnGoodsWorksheet.getId());
		assertEquals(expectedReturnGoodsWorksheet, actualReturnGoodsWorksheet); 
	}
	
	/**
	 * 测试更新退货工单状态
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_worksheet.sql"})  
	public void testUpdateStatus() throws Exception {
		Long orderInfoId = 1L;
		String orderNo = "测试订单";
		ReturnGoodsWorksheetDO expectedReturnGoodsWorksheet = createReturnGoodsWorksheet(
				orderInfoId, orderNo);
		
		expectedReturnGoodsWorksheet.setStatus(2);
		worksheetDAO.updateStatus(expectedReturnGoodsWorksheet); 
		
		ReturnGoodsWorksheetDO actualReturnGoodsWorksheet = worksheetDAO.getById(
				expectedReturnGoodsWorksheet.getId());
		
		assertEquals(expectedReturnGoodsWorksheet, actualReturnGoodsWorksheet);  
	}
	
	/**
	 * 测试更新退货工单物流单号
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_worksheet.sql"})  
	public void testUpdateReturnGoodsLogisticsCode() throws Exception {
		Long orderInfoId = 1L;
		String orderNo = "测试订单";
		ReturnGoodsWorksheetDO expectedReturnGoodsWorksheet = createReturnGoodsWorksheet(
				orderInfoId, orderNo);
		
		expectedReturnGoodsWorksheet.setReturnGoodsLogisticsCode("测试物流单号");   
		worksheetDAO.updateReturnGoodsLogisticsCode(expectedReturnGoodsWorksheet); 
		
		ReturnGoodsWorksheetDO actualReturnGoodsWorksheet = worksheetDAO.getById(
				expectedReturnGoodsWorksheet.getId());
		
		assertEquals(expectedReturnGoodsWorksheet, actualReturnGoodsWorksheet);  
	}
	
	/**
	 * 创建退货工单查询条件
	 * @return 退货工单查询条件
	 * @throws Exception
	 */
	private ReturnGoodsWorksheetQuery createReturnGoodsWorksheetQuery(
			Integer expectedSize) throws Exception {
		ReturnGoodsWorksheetQuery query = new ReturnGoodsWorksheetQuery();
		query.setOffset(0);
		query.setSize(expectedSize);  
		return query;
	}
	
	/**
	 * 比较退货工单集合
	 * @param expectedSize 期望的促销集合大小
	 * @param expectedReturnGoodsWorksheetMap 期望的退货工单集合
	 * @param actualReturnGoodsWorksheets 实际的退货工单集合
	 * @throws Exception
	 */
	private void compareReturnGoodsWorksheets(
			Integer expectedSize, 
			Map<Long, ReturnGoodsWorksheetDO> expectedReturnGoodsWorksheets,
			List<ReturnGoodsWorksheetDO> actualReturnGoodsWorksheets) throws Exception {
		assertEquals((int)expectedSize, actualReturnGoodsWorksheets.size()); 
		for(ReturnGoodsWorksheetDO actualReturnGoodsWorksheet : actualReturnGoodsWorksheets) {
			ReturnGoodsWorksheetDO expectedReturnGoodsWorksheet = expectedReturnGoodsWorksheets.get(
					actualReturnGoodsWorksheet.getId());
			assertEquals(expectedReturnGoodsWorksheet, actualReturnGoodsWorksheet);  
		}
	}
	
	/**
	 * 创建退货工单map
	 * @param count 退货工单数量
	 * @return
	 * @throws Exception
	 */
	private Map<Long, ReturnGoodsWorksheetDO> createReturnGoodsWorksheetMap(
			Integer count, Boolean includeRemark) throws Exception {
		Map<Long, ReturnGoodsWorksheetDO> worksheetMap = 
				new HashMap<Long, ReturnGoodsWorksheetDO>();
		
		List<ReturnGoodsWorksheetDO> worksheets = createReturnGoodsWorksheets(
				count, includeRemark);  
		for(ReturnGoodsWorksheetDO worksheet : worksheets) {
			worksheetMap.put(worksheet.getId(), worksheet);
		}
		
		return worksheetMap;
	}
	
	/**
	 * 创建一个退货工单集合
	 * @return
	 * @throws Exception
	 */
	private List<ReturnGoodsWorksheetDO> createReturnGoodsWorksheets(
			Integer count, Boolean includeRemark) throws Exception {
		List<ReturnGoodsWorksheetDO> worksheets = new ArrayList<ReturnGoodsWorksheetDO>();
		for(int i = 0; i < count; i++) {
			ReturnGoodsWorksheetDO worksheet = createReturnGoodsWorksheet((long)i, "测试编号_" + i);
			if(!includeRemark) {
				worksheet.setReturnGoodsRemark(null);  
			}
			worksheets.add(worksheet);    
		}
		return worksheets;
	}
	
	/**
	 * 创建退货工单
	 * @return 退货工单
	 * @throws Exception
	 */
	private ReturnGoodsWorksheetDO createReturnGoodsWorksheet(
			Long orderInfoId, String orderNo) throws Exception {
		ReturnGoodsWorksheetDO worksheet = new ReturnGoodsWorksheetDO();
		worksheet.setOrderInfoId(orderInfoId);
		worksheet.setOrderNo(orderNo); 
		worksheet.setStatus(ReturnGoodsWorksheetStatus.WAIT_FOR_APPROVE);
		worksheet.setReturnGoodsReason(1); 
		worksheet.setReturnGoodsRemark("测试退货工单"); 
		
		worksheetDAO.save(worksheet);
		
		return worksheet;
	}
	
}
