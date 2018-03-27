package com.zhss.eshop.order.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.domain.ReturnGoodsApplyDO;

/**
 * 退货申请管理DAO组件单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class ReturnGoodsApplyDAOTest {

	/**
	 * 退货申请管理DAO组件
	 */
	@Autowired
	private ReturnGoodsApplyDAO returnGoodsApplyDAO;
	
	/**
	 * 测试新增退货申请
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_apply.sql"})    
	public void testSave() throws Exception {
		Long orderInfoId = 1L;
		ReturnGoodsApplyDO returnGoodsApply = createReturnGoodsApply(orderInfoId);  
		assertNotNull(returnGoodsApply.getId()); 
		assertThat(returnGoodsApply.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据id查询退货申请
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_apply.sql"})    
	public void testGetByOrderInfoId() throws Exception {
		Long orderInfoId = 1L;
		ReturnGoodsApplyDO expectedReturnGoodsApply = createReturnGoodsApply(orderInfoId);  
		ReturnGoodsApplyDO actualReturnGoodsApply = returnGoodsApplyDAO.getByOrderInfoId(orderInfoId);
		assertEquals(expectedReturnGoodsApply, actualReturnGoodsApply);  
	}
	
	/**
	 * 测试更新退货申请
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_apply.sql"})    
	public void testUpdate() throws Exception {
		Long orderInfoId = 1L;
		ReturnGoodsApplyDO expectedReturnGoodsApply = createReturnGoodsApply(orderInfoId);  
		
		expectedReturnGoodsApply.setReturnGoodsLogisticCode(UUID.randomUUID().toString().replace("-", ""));   
		returnGoodsApplyDAO.update(expectedReturnGoodsApply); 
		
		ReturnGoodsApplyDO actualReturnGoodsApply = returnGoodsApplyDAO.getByOrderInfoId(orderInfoId);
		
		assertEquals(expectedReturnGoodsApply, actualReturnGoodsApply);  
	}
	
	/**
	 * 测试更新退货申请状态
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_return_goods_apply.sql"})    
	public void testUpdateStatus() throws Exception {
		Long orderInfoId = 1L;
		ReturnGoodsApplyDO expectedReturnGoodsApply = createReturnGoodsApply(orderInfoId);  
		expectedReturnGoodsApply.setReturnGoodsApplyStatus(2);
		
		returnGoodsApplyDAO.updateStatus(orderInfoId, 2); 
		 
		ReturnGoodsApplyDO actualReturnGoodsApply = returnGoodsApplyDAO.getByOrderInfoId(orderInfoId);
		
		assertEquals(expectedReturnGoodsApply, actualReturnGoodsApply);  
	}
	
	private ReturnGoodsApplyDO createReturnGoodsApply(Long orderInfoId) throws Exception {
		ReturnGoodsApplyDO returnGoodsApply = new ReturnGoodsApplyDO();
		returnGoodsApply.setOrderInfoId(orderInfoId);
		returnGoodsApply.setReturnGoodsComment("测试退货原因");  
		returnGoodsApply.setReturnGoodsReason(1); 
		
		returnGoodsApplyDAO.save(returnGoodsApply);
		
		return returnGoodsApply;
 	}
	
}
