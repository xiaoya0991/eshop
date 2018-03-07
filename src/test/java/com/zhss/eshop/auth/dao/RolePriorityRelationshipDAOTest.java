package com.zhss.eshop.auth.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 角色和权限关系管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true)
public class RolePriorityRelationshipDAOTest {

	/**
	 * 角色和权限关系管理模块的DAO组件
	 */
	@Autowired
	private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
	
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
		Long roleId = 1L;
		Long priorityId = 1L;
		RolePriorityRelationshipDO rolePriorityRelationshipDO = 
				createRolePriorityRelationshipDO(roleId, priorityId);
		assertNotNull(rolePriorityRelationshipDO.getId()); 
		assertThat(rolePriorityRelationshipDO.getId(), greaterThan(0L));  
	}
	
	/**
	 * 测试根据权限id查询记录数
	 * @throws Exception
	 */
	@Test
	public void testCountByPriorityId() throws Exception {
		Long priorityId = 1L;
		
		Long roleId1 = 1L;
		createRolePriorityRelationshipDO(roleId1, priorityId);
	
		Long roleId2 = 2L;
		createRolePriorityRelationshipDO(roleId2, priorityId);
		
		Long resultCount = rolePriorityRelationshipDAO.countByPriorityId(priorityId);
		
		assertEquals(2L, resultCount.longValue());  
	}
	
	/**
	 * 创建账号和权限关系DO对象
	 * @return 账号和权限关系DO对象
	 * @throws Exception
	 */
	private RolePriorityRelationshipDO createRolePriorityRelationshipDO(
			Long roleId, Long priorityId) throws Exception {
		RolePriorityRelationshipDO rolePriorityRelationshipDO = 
				new RolePriorityRelationshipDO();
		rolePriorityRelationshipDO.setRoleId(roleId);
		rolePriorityRelationshipDO.setPriorityId(priorityId); 
		rolePriorityRelationshipDO.setGmtCreate(dateProvider.getCurrentTime()); 
		rolePriorityRelationshipDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		rolePriorityRelationshipDAO.save(rolePriorityRelationshipDO);
		
		return rolePriorityRelationshipDO;
	}
	
}
