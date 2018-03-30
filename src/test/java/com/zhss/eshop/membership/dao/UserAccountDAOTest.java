package com.zhss.eshop.membership.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.dao.UserAccountDAO;
import com.zhss.eshop.membership.domain.UserAccountDO;

/**
 * 用户账号管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class UserAccountDAOTest {
	
	/**
	 * 用户账号管理DAO组件
	 */
	@Autowired
	private UserAccountDAO userAccountDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 测试新增用户账号
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		UserAccountDO userAccount = createUserAccount();
		assertNotNull(userAccount.getId()); 
		assertThat(userAccount.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试为登录来统计是否有对应的账号在
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_user_account.sql"})  
	public void testGetForLogin() throws Exception {
		UserAccountDO userAccount = createUserAccount();
		
		UserAccountDO queryUserAccount = new UserAccountDO();
		queryUserAccount.setUsername("zhangsan");  
		queryUserAccount.setPassword("12345678");  
		
		UserAccountDO resultUserAccount = userAccountDAO
				.getForLogin(queryUserAccount);
		
		assertEquals(userAccount, resultUserAccount); 
	}
	
	/**
	 * 测试根据id查询用户账号 
	 * @throws Exception
	 */
	@Test
	public void testGetById() throws Exception {
		UserAccountDO expectedUserAccount = createUserAccount();  
		expectedUserAccount.setPassword(null); 
		UserAccountDO actualUserAccount = userAccountDAO.getById(expectedUserAccount.getId());
		assertEquals(expectedUserAccount, actualUserAccount); 
	}
	
	/**
	 * 测试更新密码
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_user_account.sql"})  
	public void testUpdatePassword() throws Exception {  
		UserAccountDO expectedUserAccount = createUserAccount();
		
		expectedUserAccount.setPassword("修改后的" + expectedUserAccount.getPassword()); 
		userAccountDAO.updatePassword(expectedUserAccount); 
		
		UserAccountDO query = new UserAccountDO();
		query.setUsername("zhangsan");  
		query.setPassword("修改后的12345678");  
		
		UserAccountDO actualUserAccount = userAccountDAO.getForLogin(query);
		
		assertEquals(expectedUserAccount, actualUserAccount); 
	}
	
	/**
	 * 创建用户账号
	 * @return 用户账号
	 * @throws Exception
	 */
	private UserAccountDO createUserAccount() throws Exception {
		UserAccountDO userAccount = new UserAccountDO();
		userAccount.setUsername("zhangsan"); 
		userAccount.setPassword("12345678");  
		userAccount.setEmail("zhangsan@sian.com");  
		userAccount.setCellPhoneNumber("18967543209");  
		userAccount.setGmtCreate(dateProvider.getCurrentTime()); 
		userAccount.setGmtModified(dateProvider.getCurrentTime()); 
		
		userAccountDAO.save(userAccount);
		
		return userAccount;
	}
	
}
