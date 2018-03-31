package com.zhss.eshop.membership.dao;

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

import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.domain.DeliveryAddressDO;

/**
 * 收货地址管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class DeliveryAddressDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 收货地址管理DAO组件
	 */
	@Autowired
	private DeliveryAddressDAO deliveryAddressDAO;
	
	/**
	 * 测试查询用户账号的所有收货地址
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_delivery_address.sql"})  
	public void testlistAllByUserAccountId() throws Exception {
		Long userAccountId = 1L;
		Integer count = 5;
		Map<Long, DeliveryAddressDO> expectedDeliveryAddresses = 
				createDeliveryAddressMap(userAccountId, count);
	
		List<DeliveryAddressDO> actualDeliveryAddresses = 
				deliveryAddressDAO.listAllByUserAccountId(userAccountId);
		
		compareDeliveryAddresses(count, expectedDeliveryAddresses, 
				actualDeliveryAddresses); 
	}
	
	/**
	 * 测试新增收货地址
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long userAccountId = 1L;
		DeliveryAddressDO expectedDeliveryAddress = createDeliveryAddress(userAccountId);
		assertNotNull(expectedDeliveryAddress.getId()); 
		assertThat(expectedDeliveryAddress.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试更新收货地址
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Long userAccountId = 1L;
		DeliveryAddressDO expectedDeliveryAddress = createDeliveryAddress(userAccountId);
		
		expectedDeliveryAddress.setAddress("修改后的" + expectedDeliveryAddress.getAddress());  
		deliveryAddressDAO.update(expectedDeliveryAddress); 
		
		List<DeliveryAddressDO> actualDeliveryAddresses =  
				deliveryAddressDAO.listAllByUserAccountId(userAccountId);
		
		Boolean equals = false;
		for(DeliveryAddressDO actualDeliveryAddress : actualDeliveryAddresses) {
			if(expectedDeliveryAddress.equals(actualDeliveryAddress)) {
				equals = true;
				break;
			}
		}
		
		assertTrue(equals); 
	}
	
	/**
	 * 测试删除收货地址
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long userAccountId = 1L;
		DeliveryAddressDO expectedDeliveryAddress = createDeliveryAddress(userAccountId);
		
		deliveryAddressDAO.remove(expectedDeliveryAddress.getId()); 
	
		List<DeliveryAddressDO> actualDeliveryAddresses =  
				deliveryAddressDAO.listAllByUserAccountId(userAccountId);
		
		Boolean existed = false;
		
		for(DeliveryAddressDO actualDeliveryAddress : actualDeliveryAddresses) {
			if(actualDeliveryAddress.getId().equals(expectedDeliveryAddress.getId())) {
				existed = true;
				break;
			}
		}
		
		assertFalse(existed); 
	}
	
	/**
	 * 比较两个收货地址集合
	 * @param expectedSize 期望的集合大小
	 * @param expectedDeliveryAddresses 期望的收货地址
	 * @param actualDeliveryAddresses 实际的收货地址
	 * @throws Exception
	 */
	private void compareDeliveryAddresses(
			Integer expectedSize,
			Map<Long, DeliveryAddressDO> expectedDeliveryAddresses,
			List<DeliveryAddressDO> actualDeliveryAddresses) throws Exception {
		assertEquals((int)expectedSize, actualDeliveryAddresses.size()); 
		
		for(DeliveryAddressDO actualDeliveryAddress : actualDeliveryAddresses) {
			DeliveryAddressDO expectedDeliveryAddress = expectedDeliveryAddresses.get(
					actualDeliveryAddress.getId());
			assertEquals(expectedDeliveryAddress, actualDeliveryAddress);
		}
	}
	
	/**
	 * 创建收货地址集合
	 * @param userAccountId 用户账号id
	 * @param count 收货地址数量
	 * @return 收货地址集合
	 * @throws Exception
	 */
	private Map<Long, DeliveryAddressDO> createDeliveryAddressMap(
			Long userAccountId, Integer count) throws Exception {
		Map<Long, DeliveryAddressDO> deliveryAddressMap = 
				new HashMap<Long, DeliveryAddressDO>(CollectionSize.DEFAULT);
	
		List<DeliveryAddressDO> deliveryAddresses = createDeliveryAddresses(
				userAccountId, count);
		for(DeliveryAddressDO deliveryAddress : deliveryAddresses) {
			deliveryAddressMap.put(deliveryAddress.getId(), deliveryAddress);
		}
		
		return deliveryAddressMap;
	}
	
	/**
	 * 创建收货地址集合
	 * @param userAccountId 用户账号id
	 * @return 收货地址集合
	 * @throws Exception
	 */
	private List<DeliveryAddressDO> createDeliveryAddresses(
			Long userAccountId, Integer count) throws Exception {
		List<DeliveryAddressDO> deliveryAddresses = new ArrayList<DeliveryAddressDO>();
		for(int i = 0; i < count; i++) {
			deliveryAddresses.add(createDeliveryAddress(userAccountId));
		}
		return deliveryAddresses;
	}
	
	/**
	 * 创建收货地址
	 * @param userAccountId 用户账号id
	 * @return 收货地址
	 * @throws Exception
	 */
	private DeliveryAddressDO createDeliveryAddress(
			Long userAccountId) throws Exception {
		DeliveryAddressDO deliveryAddress = new DeliveryAddressDO();
		deliveryAddress.setUserAccountId(userAccountId); 
		deliveryAddress.setProvince("测试省份");
		deliveryAddress.setCity("测试市");  
		deliveryAddress.setDistrict("测试区"); 
		deliveryAddress.setConsignee("张三"); 
		deliveryAddress.setAddress("测试地址");  
		deliveryAddress.setPhoneNumber("测试电话");  
		deliveryAddress.setGmtCreate(dateProvider.getCurrentTime()); 
		deliveryAddress.setGmtModified(dateProvider.getCurrentTime()); 
		
		deliveryAddressDAO.save(deliveryAddress); 
		
		return deliveryAddress;
 	}
	
}
