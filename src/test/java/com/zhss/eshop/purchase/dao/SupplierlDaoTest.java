package com.zhss.eshop.purchase.dao;

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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.domain.SupplierDO;
import com.zhss.eshop.purchase.domain.SupplierQuery;

/**
 * 供应商管理的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class SupplierlDaoTest {

	/**
	 * 供应商管理DAO组件
	 */
	@Autowired
	private SupplierDAO supplierDAO;
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
	 * 测试新增供应商
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_supplier.sql"})  
	public void testSave() throws Exception { 
		SupplierDO expectedSupplier = createSupplier();
		assertNotNull(expectedSupplier.getId()); 
		assertThat(expectedSupplier.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询供应商
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_supplier.sql"})  
	public void testListByPage() throws Exception {
		Integer count = 30;
		Map<Long, SupplierDO> expectedSuppliers = createSupplierMap(count);
		
		for(SupplierDO expectedSupplier : expectedSuppliers.values()) {
			expectedSupplier.setCompanyAddress(null); 
			expectedSupplier.setContactorPhoneNumber(null);
			expectedSupplier.setBankAccount(null);
			expectedSupplier.setBankAccountHolder(null); 
			expectedSupplier.setInvoiceTitle(null); 
			expectedSupplier.setTaxpayerId(null); 
			expectedSupplier.setBusinessScope(null); 
			expectedSupplier.setRemark(null); 
		}
		
		SupplierQuery query = new SupplierQuery();
		query.setOffset(0); 
		query.setSize(10);  
		List<SupplierDO> actualSuppliers = supplierDAO.listByPage(query);
		
		compareSuppliers(10, expectedSuppliers, actualSuppliers); 
	}
	
	/**
	 * 测试根据id查询供应商
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_supplier.sql"})  
	public void testGetById() throws Exception {
		SupplierDO expectedSupplier = createSupplier();
		SupplierDO actualSupplier = supplierDAO.getById(expectedSupplier.getId());  
		assertEquals(expectedSupplier, actualSupplier); 
	}
	
	/**
	 * 比较两个供应商
	 * @param expectedSuppliers 期望的供应商
	 * @param actualSuppliers 实际的供应商
	 */
	private void compareSuppliers(
			Integer expectedSize,
			Map<Long, SupplierDO> expectedSuppliers,
			List<SupplierDO> actualSuppliers) {
		assertEquals((int)expectedSize, actualSuppliers.size()); 
		for(SupplierDO actualSupplier : actualSuppliers) {
			SupplierDO expectedSupplier = expectedSuppliers.get(actualSupplier.getId());
			assertEquals(expectedSupplier, actualSupplier); 
		}
	}
	
	/**
	 * 创建供应商
	 * @param count 供应商的数量
	 * @return 供应商
	 * @throws Exception
	 */
	private Map<Long, SupplierDO> createSupplierMap(Integer count) throws Exception {
		List<SupplierDO> suppliers = createSuppliers(count);
		Map<Long, SupplierDO> supplierMap = new HashMap<Long, SupplierDO>(CollectionSize.DEFAULT);
		for(SupplierDO supplier : suppliers) {
			supplierMap.put(supplier.getId(), supplier);
		}
		return supplierMap;
	}
	
	/**
	 * 创建供应商
	 * @param count 供应商的数量
	 * @return 供应商
	 * @throws Exception
	 */
	private List<SupplierDO> createSuppliers(Integer count) throws Exception {
		List<SupplierDO> suppliers = new ArrayList<SupplierDO>();
		for(int i = 0; i < count; i++) {
			suppliers.add(createSupplier()); 
		}
		return suppliers;
	}
	
	/**
	 * 创建供应商
	 * @param goodsAllocationId 货位id
	 * @param goodsSkuId 商品sku id
	 * @return 供应商
	 * @throws Exception
	 */
	private SupplierDO createSupplier() throws Exception {
		SupplierDO supplier = new SupplierDO();
		supplier.setName("测试供应商");
		supplier.setCompanyName("测试公司"); 
		supplier.setCompanyAddress("测试公司地址");  
		supplier.setContactor("张三");  
		supplier.setContactorPhoneNumber("测试电话号码");  
		supplier.setSettlementPeriod(1); 
		supplier.setBankName("测试银行名称");  
		supplier.setBankAccount("测试银行账号");
		supplier.setBankAccountHolder("测试银行账号持有人");  
		supplier.setInvoiceTitle("测试发票抬头");  
		supplier.setTaxpayerId("测试纳税人识别号");  
		supplier.setBusinessScope("测试经营范围");  
		supplier.setRemark("测试备注");  
		
		supplierDAO.save(supplier); 
		
		return supplier;
	}
	
}
