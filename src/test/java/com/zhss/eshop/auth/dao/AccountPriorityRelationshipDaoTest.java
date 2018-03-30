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

import com.zhss.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 账号和权限关系管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class AccountPriorityRelationshipDaoTest {

	/**
	 * 账号和权限关系管理模块的DAO组件
	 */
	@Autowired
	private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增账号和权限的关联关系
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long accountId = 1L;
		Long priorityId = 1L;
		AccountPriorityRelationshipDO accountPriorityRelationshipDO = 
				createAccountPriorityRelationshipDO(accountId, priorityId);
		assertNotNull(accountPriorityRelationshipDO.getId()); 
		assertThat(accountPriorityRelationshipDO.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据权限id查询记录数
	 * @throws Exception
	 */
	@Test
	public void testCountByPriorityId() throws Exception {
		Long priorityId = 1L;
		
		Long accountId1 = 1L;
		createAccountPriorityRelationshipDO(accountId1, priorityId);
		
		Long accountId2 = 2L;
		createAccountPriorityRelationshipDO(accountId2, priorityId);
		
		Long resultCount = accountPriorityRelationshipDAO.countByPriorityId(priorityId);
		
		assertEquals(2L, resultCount.longValue());  
	}
	
	/**
	 * 测试根据账号id查询账号和权限的关联关系
	 * @throws Exception
	 */
	@Test
	public void testListByAccountId() throws Exception {
		Long accountId = 1L;
		int count = 20;
		Map<Long, AccountPriorityRelationshipDO> relationMap = 
				createRelations(accountId, count);
		
		List<AccountPriorityRelationshipDO> resultRelations = 
				accountPriorityRelationshipDAO.listByAccountId(accountId);
		
		compareRelations(relationMap, resultRelations); 
	}
	
	/**
	 * 测试根据账号id删除账号和权限的关联关系
	 * @throws Exception
	 */
	@Test
	public void testRemoveByAccountId() throws Exception {
		Long accountId = 1L;
		int count = 20;
		createRelations(accountId, count);
		
		accountPriorityRelationshipDAO.removeByAccountId(accountId); 
		
		List<AccountPriorityRelationshipDO> resultRelations = 
				accountPriorityRelationshipDAO.listByAccountId(accountId);
		
		assertEquals(0, resultRelations.size()); 
	}
	
	/**
	 * 比较两个关联关系集合
	 * @param relationMap
	 * @param resultRelations
	 * @throws Exception
	 */
	private void compareRelations(Map<Long, AccountPriorityRelationshipDO> relationMap,
			List<AccountPriorityRelationshipDO> resultRelations) throws Exception {
		assertThat(resultRelations.size(), greaterThanOrEqualTo(relationMap.size())); 
		
		for(AccountPriorityRelationshipDO relation : resultRelations) {
			AccountPriorityRelationshipDO targetRelation = relationMap.get(relation.getId());
			if(targetRelation == null) {
				continue;
			}
			assertEquals(targetRelation, relation);
		}
	}
	
	/**
	 * 创建账号和权限关联关系的集合
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	private Map<Long, AccountPriorityRelationshipDO> createRelations(
			Long accountId, int count) throws Exception {
		Map<Long, AccountPriorityRelationshipDO> relationMap = 
				new HashMap<Long, AccountPriorityRelationshipDO>(CollectionSize.DEFAULT);
	
		for(int i = 0; i < count; i++) {
			AccountPriorityRelationshipDO relation = 
					createAccountPriorityRelationshipDO(accountId, (long)i);
			relationMap.put(relation.getId(), relation);
		}
		
		return relationMap;
	}
	
	/**
	 * 创建账号和权限关系DO对象
	 * @return 账号和权限关系DO对象
	 * @throws Exception
	 */
	private AccountPriorityRelationshipDO createAccountPriorityRelationshipDO(
			Long accountId, Long priorityId) throws Exception {
		AccountPriorityRelationshipDO accountPriorityRelationshipDO = 
				new AccountPriorityRelationshipDO();
		accountPriorityRelationshipDO.setAccountId(accountId);
		accountPriorityRelationshipDO.setPriorityId(priorityId); 
		accountPriorityRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		accountPriorityRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		accountPriorityRelationshipDAO.save(accountPriorityRelationshipDO);
		
		return accountPriorityRelationshipDO;
	}
	
}
