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
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.domain.AccountRoleRelationshipDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 账号和角色关系管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class AccountRoleRelationshipDaoTest {

	/**
	 * 账号和角色关系管理模块的DAO组件
	 */
	@Autowired
	private AccountRoleRelationshipDAO accountRoleRelationshipDAO;
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增账号和角色的关联关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_account_role_relationship.sql"})  
	public void testSave() throws Exception {
		Long accountId = 1L;
		Long roleId = 1L;
		AccountRoleRelationshipDO accountRoleRelationshipDO = 
				createAccountRoleRelationshipDO(accountId, roleId);
		assertNotNull(accountRoleRelationshipDO.getId()); 
		assertThat(accountRoleRelationshipDO.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据角色id查询记录数
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_account_role_relationship.sql"})  
	public void testCountByRoleId() throws Exception {
		Long roleId = 1L;
		
		Long accountId1 = 1L;
		createAccountRoleRelationshipDO(accountId1, roleId);
		
		Long accountId2 = 2L;
		createAccountRoleRelationshipDO(accountId2, roleId);
		
		Long resultCount = accountRoleRelationshipDAO.countByRoleId(roleId);
		
		assertEquals(2L, resultCount.longValue());  
	}
	
	/**
	 * 测试根据账号id查询账号和角色的关联关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_account_role_relationship.sql"})  
	public void testListByAccountId() throws Exception {
		Long accountId = 1L;
		int count = 20;
		Map<Long, AccountRoleRelationshipDO> relationMap = 
				createRelations(accountId, count);
		
		List<AccountRoleRelationshipDO> resultRelations = 
				accountRoleRelationshipDAO.listByAccountId(accountId);
		
		compareRelations(relationMap, resultRelations); 
	}
	
	/**
	 * 测试根据账号id删除账号和角色的关联关系
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_account_role_relationship.sql"})  
	public void testRemoveByAccountId() throws Exception {
		Long accountId = 1L;
		int count = 20;
		createRelations(accountId, count);
		
		accountRoleRelationshipDAO.removeByAccountId(accountId); 
		
		List<AccountRoleRelationshipDO> resultRelations = 
				accountRoleRelationshipDAO.listByAccountId(accountId);
		
		assertEquals(0, resultRelations.size()); 
	}
	
	/**
	 * 比较两个关联关系集合
	 * @param relationMap
	 * @param resultRelations
	 * @throws Exception
	 */
	private void compareRelations(Map<Long, AccountRoleRelationshipDO> relationMap,
			List<AccountRoleRelationshipDO> resultRelations) throws Exception {
		assertThat(resultRelations.size(), greaterThanOrEqualTo(relationMap.size())); 
		
		for(AccountRoleRelationshipDO relation : resultRelations) {
			AccountRoleRelationshipDO targetRelation = relationMap.get(relation.getId());
			if(targetRelation == null) {
				continue;
			}
			assertEquals(targetRelation, relation);
		}
	}
	
	/**
	 * 创建账号和角色关联关系的集合
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	private Map<Long, AccountRoleRelationshipDO> createRelations(
			Long accountId, int count) throws Exception {
		Map<Long, AccountRoleRelationshipDO> relationMap = 
				new HashMap<Long, AccountRoleRelationshipDO>(CollectionSize.DEFAULT);
	
		for(int i = 0; i < count; i++) {
			AccountRoleRelationshipDO relation = 
					createAccountRoleRelationshipDO(accountId, (long)i);
			relationMap.put(relation.getId(), relation);
		}
		
		return relationMap;
	}
	
	/**
	 * 创建账号和角色关系DO对象
	 * @return 账号和角色关系DO对象
	 * @throws Exception
	 */
	private AccountRoleRelationshipDO createAccountRoleRelationshipDO(
			Long accountId, Long roleId) throws Exception {
		AccountRoleRelationshipDO accountRoleRelationshipDO = 
				new AccountRoleRelationshipDO();
		accountRoleRelationshipDO.setAccountId(accountId);
		accountRoleRelationshipDO.setRoleId(roleId); 
		accountRoleRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		accountRoleRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		accountRoleRelationshipDAO.save(accountRoleRelationshipDO);
		
		return accountRoleRelationshipDO;
	}
	
}
