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

import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleQuery;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 角色管理模块DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true)
public class RoleDaoTest {

	/**
	 * 角色管理模块DAO组件
	 */
	@Autowired
	private RoleDAO roleDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增角色
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_role.sql"})
	public void testSave() throws Exception {
		RoleDO role = createRole("测试角色", "TEST_CODE"); 
		assertNotNull(role.getId()); 
		assertThat(role.getId(), greaterThan(0L));
	}
	
	/**
	 * 测试分页查询角色
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_role.sql"})
	public void testListByPage() throws Exception {
		// 准备参数
		Integer count = 5;
		String namePrefix = "测试角色";
		String codePrefix = "TEST_ROLE";
		String otherName = "别的角色";
		String otherCode = "OTHER_ROLE";
		Integer offset = 2;
		Integer size = 2;
		
		// 构造6个角色出来
		// 其中5个角色都是以“测试角色”打头
		Map<Long, RoleDO> roleMap = new HashMap<Long, RoleDO>(CollectionSize.DEFAULT);
		
		RoleDO role = null;
		
		for(int i = 0; i < count; i++) {
			role = createRole(namePrefix + i, codePrefix + i);
			roleMap.put(role.getId(), role);
		}
		
		role = createRole(otherName, otherCode); 
		
		// 执行分页查询的方法逻辑
		RoleQuery query = new RoleQuery();
		query.setOffset(offset); 
		query.setSize(size);  
		query.setName(namePrefix);
		query.setCode(codePrefix); 
		
		List<RoleDO> resultRoles = roleDAO.listByPage(query);
		
		// 执行断言
		assertEquals((int)size, resultRoles.size()); 
		
		for(RoleDO resultRole : resultRoles) {
			assertEquals(roleMap.get(resultRole.getId()), resultRole);
		}
	}
	
	/**
	 * 测试根据id查询角色DO对象
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_role.sql"})
	public void testGetById() throws Exception {
		RoleDO role = createRole("测试角色", "TEST_CODE"); 
		RoleDO resultRole = roleDAO.getById(role.getId());
		assertEquals(role, resultRole);
	}
	
	/**
	 * 测试更新角色
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_role.sql"})
	public void testUpdate() throws Exception {
		RoleDO role = createRole("测试角色", "TEST_CODE"); 
		
		role.setName(role.getName() + "_修改"); 
		role.setCode(role.getCode() + "_modified");  
		roleDAO.update(role);
	
		RoleDO resultRole = roleDAO.getById(role.getId());
		
		assertEquals(role, resultRole); 
	}
	
	/**
	 * 测试删除角色
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_role.sql"})
	public void testRemove() throws Exception {
		RoleDO role = createRole("测试角色", "TEST_CODE"); 
		roleDAO.remove(role.getId());
		RoleDO resultRole = roleDAO.getById(role.getId());
		assertNull(resultRole); 
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
	
}
