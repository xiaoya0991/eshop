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
import com.zhss.eshop.membership.domain.MemberLevelDO;

/**
 * 会员等级管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class MemberLevelDaoTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 会员等级管理DAO组件
	 */
	@Autowired
	private MemberLevelDAO memberLevelDAO;
	
	/**
	 * 测试查询用户账号的会员等级
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_member_level.sql"})  
	public void testGetByUserAccountId() throws Exception {
		Long userAccountId = 1L;
		MemberLevelDO expectedMemberLevel = createMemberLevel(userAccountId);
		MemberLevelDO actualMemberLevel = memberLevelDAO.getByUserAccountId(userAccountId);
		assertEquals(expectedMemberLevel, actualMemberLevel);  
	}
	
	/**
	 * 测试新增会员等级
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long userAccountId = 1L;
		MemberLevelDO expectedMemberLevel = createMemberLevel(userAccountId);
		assertNotNull(expectedMemberLevel.getId()); 
		assertThat(expectedMemberLevel.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试更新会员等级
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Long userAccountId = 1L;
		MemberLevelDO expectedMemberLevel = createMemberLevel(userAccountId);
		
		expectedMemberLevel.setGrowthValue(100L);  
		memberLevelDAO.update(expectedMemberLevel); 
		
		MemberLevelDO actualMemberLevel = memberLevelDAO.getByUserAccountId(userAccountId);
		
		assertEquals(expectedMemberLevel, actualMemberLevel); 
	}
	
	/**
	 * 创建会员等级
	 * @param userAccountId 用户账号id
	 * @return 会员等级
	 * @throws Exception
	 */
	private MemberLevelDO createMemberLevel(
			Long userAccountId) throws Exception {
		MemberLevelDO memberLevel = new MemberLevelDO();
		memberLevel.setUserAccountId(userAccountId); 
		memberLevel.setGrowthValue(0L); 
		memberLevel.setLevel(1); 
		memberLevel.setGmtCreate(dateProvider.getCurrentTime()); 
		memberLevel.setGmtModified(dateProvider.getCurrentTime()); 
		
		memberLevelDAO.save(memberLevel); 
		
		return memberLevel;
 	}
	
}
