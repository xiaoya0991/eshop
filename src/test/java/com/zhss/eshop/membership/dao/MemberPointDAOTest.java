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
import com.zhss.eshop.membership.domain.MemberPointDO;

/**
 * 会员积分管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class MemberPointDAOTest {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 会员积分管理DAO组件
	 */
	@Autowired
	private MemberPointDAO memberPointDAO;
	
	/**
	 * 测试查询用户账号的会员积分
	 * @throws Exception
	 */
	@Test
	@Sql({"clean_member_point.sql"})  
	public void testGetByUserAccountId() throws Exception {
		Long userAccountId = 1L;
		MemberPointDO expectedMemberPoint = createMemberPoint(userAccountId);
		MemberPointDO actualMemberPoint = memberPointDAO.getByUserAccountId(userAccountId);
		assertEquals(expectedMemberPoint, actualMemberPoint);  
	}
	
	/**
	 * 测试新增会员积分
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long userAccountId = 1L;
		MemberPointDO expectedMemberPoint = createMemberPoint(userAccountId);
		assertNotNull(expectedMemberPoint.getId()); 
		assertThat(expectedMemberPoint.getId(), greaterThan(0L)); 
	}
	
	/**
	 * 测试更新会员积分
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		Long userAccountId = 1L;
		MemberPointDO expectedMemberPoint = createMemberPoint(userAccountId);
		
		expectedMemberPoint.setPoint(1200L); 
		memberPointDAO.update(expectedMemberPoint); 
		
		MemberPointDO actualMemberPoint = memberPointDAO.getByUserAccountId(userAccountId);
		
		assertEquals(expectedMemberPoint, actualMemberPoint); 
	}
	
	/**
	 * 创建会员积分
	 * @param userAccountId 用户账号id
	 * @return 会员积分
	 * @throws Exception
	 */
	private MemberPointDO createMemberPoint(
			Long userAccountId) throws Exception {
		MemberPointDO memberPoint = new MemberPointDO();
		memberPoint.setUserAccountId(userAccountId); 
		memberPoint.setPoint(1000L); 
		memberPoint.setGmtCreate(dateProvider.getCurrentTime()); 
		memberPoint.setGmtModified(dateProvider.getCurrentTime()); 
		
		memberPointDAO.save(memberPoint); 
		
		return memberPoint;
 	}
	
}
