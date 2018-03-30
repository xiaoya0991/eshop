package com.zhss.eshop.auth.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.domain.AccountDO;
import com.zhss.eshop.auth.domain.AccountQuery;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 账号管理DAO组件的单元测试
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional (rollbackFor = Exception.class)
@Rollback(true)
public class AccountDaoTest {

	/**
	 * 账号管理DAO组件
	 */
	@Autowired
	private AccountDAO accountDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增账号
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		AccountDO account = createAccount();
		assertNotNull(account.getId()); 
		assertThat(account.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试分页查询账号
	 */
	@Test
	public void testListByPage() throws Exception {
		int count = 30;
		Map<Long, AccountDO> accountMap = createAccounts(count);
	
		
		Integer offset = 20;
		Integer size = 10;
		
		AccountQuery query = new AccountQuery();
		query.setOffset(offset); 
		query.setSize(size);  
		query.setUsername("zhang");
		query.setName("张");  
		
		List<AccountDO> resultAccounts = accountDAO.listByPage(query);
		
		assertEquals((int)size, resultAccounts.size()); 
		compareAccounts(accountMap, resultAccounts);  
	}
	
	/**
	 * 测试根据id查询账号
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		AccountDO account = createAccount();
		AccountDO resultAccount = accountDAO.getById(account.getId());
		assertEquals(account, resultAccount); 
	}
	
	/**
	 * 测试更新账号
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		AccountDO account = createAccount();
		
		account.setRemark("修改后的测试账号备注");  
		account.setGmtModified(dateProvider.getCurrentTime()); 
		accountDAO.update(account); 
		
		AccountDO resultAccount = accountDAO.getById(account.getId());
		
		assertEquals(account, resultAccount); 
	}
	
	/**
	 * 测试更新密码
	 * @throws Exception
	 */
	@Test
	public void testUpdatePassword() throws Exception {
		AccountDO account = createAccount();
		
		account.setPassword("87654321");   
		account.setGmtModified(dateProvider.getCurrentTime()); 
		accountDAO.updatePassword(account); 
		
		AccountDO resultAccount = accountDAO.getById(account.getId());
		
		assertEquals(account, resultAccount); 
	}
	
	/**
	 * 测试删除账号
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		AccountDO account = createAccount();
		accountDAO.remove(account.getId());
		AccountDO resultAccount = accountDAO.getById(account.getId());
		assertNull(resultAccount); 
	}
	
	/**
	 * 比较两个账号集合
	 * @param accountMap
	 * @param accounts
	 * @throws Exception
	 */
	private void compareAccounts(Map<Long, AccountDO> targetAccountMap, 
			List<AccountDO> resultAccounts) throws Exception {
		for(AccountDO account : resultAccounts) {
			AccountDO targetAccount = targetAccountMap.get(account.getId());
			assertEquals(targetAccount, account);  
		}
	}
	
	/**
	 * 创建账号集合
	 * @param count
	 * @return
	 * @throws Exception
	 */ 
	private Map<Long, AccountDO> createAccounts(int count) throws Exception {
		Map<Long, AccountDO> accountMap = new HashMap<Long, AccountDO>(CollectionSize.DEFAULT);
	
		AccountDO account = null;
		for(int i = 0; i < count; i++) {
			account = createAccount();
			accountMap.put(account.getId(), account);
		}
		
		return accountMap;
	}
		
	/**
	 * 创建账号
	 * @return 账号
	 * @throws Exception
	 */
	private AccountDO createAccount() throws Exception {
		AccountDO account = new AccountDO();
		account.setUsername("zhangsan"); 
		account.setPassword("12345678");
		account.setName("张三");
		account.setRemark("测试账号");  
		account.setGmtCreate(dateProvider.getCurrentTime()); 
		account.setGmtModified(dateProvider.getCurrentTime()); 
		
		accountDAO.save(account);
		
		return account;
	}
	
}
