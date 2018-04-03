package com.zhss.eshop.auth.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.constant.PriorityType;
import com.zhss.eshop.auth.domain.AccountDO;
import com.zhss.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.zhss.eshop.auth.domain.AccountRoleRelationshipDO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 权限管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class PriorityDaoTest {
	
	/**
	 * 权限管理模块的DAO组件
	 */
	@Autowired
	private PriorityDAO priorityDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 角色管理DAO组件
	 */
	@Autowired
	private RoleDAO roleDAO;
	/**
	 * 角色和权限关系管理DAO组件
	 */
	@Autowired
	private RolePriorityRelationshipDAO rolePriorityRelationDAO;
	/**
	 * 账号管理DAO组件
	 */
	@Autowired
	private AccountDAO accountDAO;
	/**
	 * 账号和角色关系管理组件
	 */
	@Autowired
	private AccountRoleRelationshipDAO accountRoleRelationDAO;
	/**
	 * 账号和权限关系管理组件
	 */
	@Autowired
	private AccountPriorityRelationshipDAO accountPriorityRelationDAO;
	
	/**
	 * 测试查询根权限
	 */
	@Test
	public void testListRootPriorities() throws Exception {
		Long parentId = null;
		Integer count = 2;
		Map<Long, PriorityDO> priorityDOMap = createPriorityMap(parentId, count);
		List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities(); 
		comparePriorityDOs(priorityDOMap, priorityDOs);
	}
	
	/**
	 * 测试根据父权限id查询子权限
	 * @throws Exception
	 */
	@Test
	public void testListChildPriorities() throws Exception {
		Long parentId = 1L;
		Integer count = 2;
		Map<Long, PriorityDO> priorityDOMap = createPriorityMap(parentId, count);
		List<PriorityDO> priorityDOs = priorityDAO.listChildPriorities(parentId);
		comparePriorityDOs(priorityDOMap, priorityDOs);
	}
	
	/**
	 * 测试根据id查询权限
	 * @throws Exception
	 */
	@Test
	public void testGetPriorityById() throws Exception {
		Long parentId = 1L;
		PriorityDO priorityDO = createPriorityDO(parentId);
		PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());
		assertEquals(priorityDO, resultPriorityDO); 
	}
	
	/**
	 * 测试新增权限
	 * @throws Exception
	 */
	@Test
	public void testSavePriority() throws Exception {
		Long prarentId = 1L;
		PriorityDO priorityDO = createPriorityDO(prarentId);
		assertNotNull(priorityDO.getId()); 
		assertThat(priorityDO.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试更新权限
	 * @throws Exception
	 */
	@Test
	public void testUpdatePriority() throws Exception {
		Long parentId = 1L;
		PriorityDO priorityDO = createPriorityDO(parentId);
		
		priorityDO.setCode(priorityDO.getCode() + "_modified"); 
		priorityDO.setGmtModified(dateProvider.getCurrentTime()); 
		priorityDO.setPriorityComment(priorityDO.getPriorityComment() + "_modified"); 
		priorityDO.setUrl(priorityDO.getUrl() + "_modified");  
		
		priorityDAO.updatePriority(priorityDO);
		
		PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());
		
		assertEquals(priorityDO, resultPriorityDO);  
	}
	
	/**
	 * 测试删除权限
	 * @throws Exception
	 */
	@Test
	public void testRemovePriority() throws Exception {
		Long parentId = 1L;
		PriorityDO priorityDO = createPriorityDO(parentId);
		
		priorityDAO.removePriority(priorityDO.getId());
		PriorityDO resultPriorityDO = priorityDAO.getPriorityById(priorityDO.getId());
		
		assertNull(resultPriorityDO);
	}
	
	/**
	 * 测试查询账号被授权的菜单
	 * @throws Exception
	 */
	@Test
	public void testListAuthroziedByAccountId() throws Exception {
		// 模拟复杂的权限场景
		Long parentId = null;
		Integer count = 2;
		
		MockResult mockResult = mockComplexPrioritySituation(parentId, count);
		AccountDO account = mockResult.getAccount();
		List<PriorityDO> roleRelatedPriorities = mockResult.getRoleRelatedPriorities();
		List<PriorityDO> accountRelatedPriorities = mockResult.getAccountRelatedPriorities();
		
		// 执行核心的业务逻辑
		Map<String, Object> parameters = new HashMap<String, Object>(CollectionSize.DEFAULT);
		parameters.put("accountId", account.getId());
		parameters.put("parentId", parentId);
		
		List<PriorityDO> resultPriorities = priorityDAO.listAuthroziedByAccountId(parameters);
		
		// 执行断言
		assertEquals(roleRelatedPriorities.size() + accountRelatedPriorities.size(), 
				resultPriorities.size());  
		
		for(PriorityDO resultPriority : resultPriorities) {
			Boolean equals = false;
			
			for(PriorityDO priority : roleRelatedPriorities) {
				if(priority.equals(resultPriority)) {
					equals = true;
					break;
				}
			}
			for(PriorityDO priority : accountRelatedPriorities) {
				if(priority.equals(resultPriority)) {
					equals = true;
					break;
				}
			}
			
			assertTrue(equals);  
		}
	}
	
	/**
	 * 测试统计账号对指定编号的权限是否有授权记录
	 * @throws Exception
	 */
	@Test
	public void testCountAuthorizedByCode() throws Exception {
		Long parentId = null;
		Integer count = 2;
		
		MockResult mockResult = mockComplexPrioritySituation(parentId, count);
		AccountDO account = mockResult.getAccount();
		List<PriorityDO> roleRelatedPriorities = mockResult.getRoleRelatedPriorities();
		
		// 执行对应的方法逻辑
		Long resultCount = priorityDAO.countAuthorizedByCode(account.getId(), 
				roleRelatedPriorities.get(0).getCode());
		
		// 执行断言
		assertEquals(1L, (long)resultCount);  
	}
	
	/**
	 * 测试统计账号对指定url的权限是否有授权记录
	 * @throws Exception
	 */ 
	@Test
	public void testCountAuthorizedByUrl() throws Exception {
		Long parentId = null;
		Integer count = 2;
		
		MockResult mockResult = mockComplexPrioritySituation(parentId, count);
		AccountDO account = mockResult.getAccount();
		List<PriorityDO> accountRelatedPriorities = mockResult.getAccountRelatedPriorities();
		
		// 执行对应的方法逻辑
		Long resultCount = priorityDAO.countAuthorizedByUrl(account.getId(), 
				accountRelatedPriorities.get(0).getUrl()); 
		
		// 执行断言
		assertEquals(1L, (long)resultCount);  
	}
	
	/**
	 * 测试根据权限id查询账号id
	 * @throws Exception
	 */
	@Test
	public void testListAccountIdsByPriorityId() throws Exception {
		Long parentId = null;
		Integer count = 2;
		
		MockResult mockResult = mockComplexPrioritySituation(parentId, count);
		AccountDO account = mockResult.getAccount();
		List<PriorityDO> roleRelatedPriorities = mockResult.getRoleRelatedPriorities();
		
		// 执行方法逻辑
		List<Long> resultAccountIds = priorityDAO.listAccountIdsByPriorityId(
				roleRelatedPriorities.get(0).getId());
		
		// 执行断言
		assertNotNull(resultAccountIds); 
		assertEquals(1L, resultAccountIds.size()); 
		assertEquals(account.getId(), resultAccountIds.get(0));
	}
	
	/**
	 * 模拟复杂的权限场景
	 * @throws Exception
	 */
	private MockResult mockComplexPrioritySituation(Long parentId, Integer count) throws Exception {
		// 创建角色要关联的权限
		List<PriorityDO> roleRelatedPriorities = 
				createPriorities(parentId, count);
		// 创建角色
		List<RoleDO> roles = createRoles(count);
		// 创建角色和权限的关联关系
		for(int i = 0; i < count; i++) {
			createRolePriorityRelation(roles.get(i).getId(), 
					roleRelatedPriorities.get(i).getId());
		}
		
		// 创建账号
		AccountDO account = createAccount();
		
		// 创建账号和角色的关联关系
		for(int i = 0; i < count; i++) {
			createAccountRoleRelation(account.getId(), roles.get(i).getId());
		}
		
		// 创建账号要关联的权限
		List<PriorityDO> accountRelatedPriorities = 
				createPriorities(parentId, count);
		
		// 创建账号和权限的关联关系
		for(int i = 0; i < count; i++) {
			createAccountPriorityRelation(account.getId(), 
					accountRelatedPriorities.get(i).getId());
		}
		
		return new MockResult(roleRelatedPriorities, accountRelatedPriorities, account);
	}
	
	private class MockResult {
		
		private List<PriorityDO> roleRelatedPriorities;
		private List<PriorityDO> accountRelatedPriorities;
		private AccountDO account;
		
		public MockResult(List<PriorityDO> roleRelatedPriorities, List<PriorityDO> accountRelatedPriorities,
				AccountDO account) {
			this.roleRelatedPriorities = roleRelatedPriorities;
			this.accountRelatedPriorities = accountRelatedPriorities;
			this.account = account;
		}

		public List<PriorityDO> getRoleRelatedPriorities() {
			return roleRelatedPriorities;
		}

		public List<PriorityDO> getAccountRelatedPriorities() {
			return accountRelatedPriorities;
		}

		public AccountDO getAccount() {
			return account;
		}
		
	}
	
	/**
	 * 创建账号和权限关系DO对象
	 * @return 账号和权限关系DO对象
	 * @throws Exception
	 */
	private AccountPriorityRelationshipDO createAccountPriorityRelation(
			Long accountId, Long priorityId) throws Exception {
		AccountPriorityRelationshipDO accountPriorityRelationshipDO = 
				new AccountPriorityRelationshipDO();
		accountPriorityRelationshipDO.setAccountId(accountId);
		accountPriorityRelationshipDO.setPriorityId(priorityId); 
		accountPriorityRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		accountPriorityRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		accountPriorityRelationDAO.save(accountPriorityRelationshipDO);
		
		return accountPriorityRelationshipDO;
	}
	
	/**
	 * 创建账号和角色关系DO对象
	 * @return 账号和角色关系DO对象
	 * @throws Exception
	 */
	private AccountRoleRelationshipDO createAccountRoleRelation(
			Long accountId, Long roleId) throws Exception {
		AccountRoleRelationshipDO accountRoleRelationshipDO = 
				new AccountRoleRelationshipDO();
		accountRoleRelationshipDO.setAccountId(accountId);
		accountRoleRelationshipDO.setRoleId(roleId); 
		accountRoleRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		accountRoleRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		accountRoleRelationDAO.save(accountRoleRelationshipDO);
		
		return accountRoleRelationshipDO;
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
	
	/**
	 * 创建账号和权限关系DO对象
	 * @return 账号和权限关系DO对象
	 * @throws Exception
	 */
	private RolePriorityRelationshipDO createRolePriorityRelation(
			Long roleId, Long priorityId) throws Exception {
		RolePriorityRelationshipDO rolePriorityRelationshipDO = 
				new RolePriorityRelationshipDO();
		rolePriorityRelationshipDO.setRoleId(roleId);
		rolePriorityRelationshipDO.setPriorityId(priorityId); 
		rolePriorityRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		rolePriorityRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		rolePriorityRelationDAO.save(rolePriorityRelationshipDO);
		
		return rolePriorityRelationshipDO;
	}
	
	/**
	 * 创建角色集合
	 * @param count
	 * @return
	 * @throws Exeption
	 */
	private List<RoleDO> createRoles(Integer count) throws Exception {
		List<RoleDO> roles = new ArrayList<RoleDO>();
		for(int i = 0; i < count; i++) {
			RoleDO role = createRole("测试角色_" + i, "TEST_ROLE_" + i);
			roles.add(role);
		}
		return roles;
	}
	
	/**
	 * 创建角色
	 * @throws Exception
	 */
	private RoleDO createRole(String name, String code) throws Exception {
		RoleDO role = new RoleDO();
		role.setName(name);
		role.setCode(code);
		role.setRemark(name); 
		role.setGmtCreate(dateProvider.getCurrentTime());
		role.setGmtModified(dateProvider.getCurrentTime()); 
		
		roleDAO.save(role);
		
		return role;
	}
	
	/**
	 * 构造一个权限DO对象集合 
	 * @param parentId 父权限id
	 * @return 权限DO对象集合
	 * @throws Exception
	 */
	private List<PriorityDO> createPriorities(Long parentId, Integer count) throws Exception {
		List<PriorityDO> priorities = new ArrayList<PriorityDO>();
		for(int i = 0; i < count; i++) {
			PriorityDO priority = createPriorityDO(parentId);
			priorities.add(priority);
		}
		return priorities;
	}
	
	/**
	 * 创建一个权限map集合
	 * @param parentId
	 * @param count
	 * @return
	 * @throws Exception
	 */
	private Map<Long, PriorityDO> createPriorityMap(
			Long parentId, Integer count) throws Exception {
		List<PriorityDO> priorities = createPriorities(parentId, count);
		Map<Long, PriorityDO> priorityMap = new HashMap<Long, PriorityDO>(CollectionSize.DEFAULT);
		for(PriorityDO priority : priorities) {
			priorityMap.put(priority.getId(), priority);
		}
		return priorityMap;
	}
	
	/**
	 * 构造一个权限DO对象
	 * @return 权限DO对象
	 * @throws Exception
	 */
	private PriorityDO createPriorityDO(Long parentId) throws Exception {
		Random random = new Random();
		int randomInt = random.nextInt() * 100;
		
		PriorityDO priorityDO = new PriorityDO();
		priorityDO.setCode("TEST_" + randomInt);  
		priorityDO.setGmtCreate(dateProvider.getCurrentTime()); 
		priorityDO.setGmtModified(dateProvider.getCurrentTime()); 
		priorityDO.setParentId(parentId); 
		priorityDO.setPriorityComment("TEST_" + randomInt);
		priorityDO.setPriorityType(PriorityType.MENU);
		priorityDO.setUrl("http://127.0.0.1/" + randomInt);  
		
		priorityDAO.savePriority(priorityDO);
		
		return priorityDO;
	}
	
	/**
	 * 比较两个权限DO集合
	 * @param priorityDOMap 权限DO集合1
	 * @param priorityDOs 权限DO集合2
	 */
	private void comparePriorityDOs(Map<Long, PriorityDO> priorityDOMap, 
			List<PriorityDO> priorityDOs) {
		assertThat(priorityDOs.size(), greaterThanOrEqualTo(priorityDOMap.size())); 
		 
		for(PriorityDO priorityDO : priorityDOs) {
			PriorityDO targetPriorityDO = priorityDOMap.get(priorityDO.getId());
			if(targetPriorityDO != null) {
				assertEquals(targetPriorityDO, priorityDO);  
			}
		}
	}
	
	
}
