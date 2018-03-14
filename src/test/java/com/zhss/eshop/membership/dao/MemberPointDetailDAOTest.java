package com.zhss.eshop.membership.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.membership.domain.MemberPointDetailDO;
import com.zhss.eshop.membership.domain.MemberPointDetailQuery;

/**
 * 会员积分明细管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class MemberPointDetailDAOTest {
	
	/**
	 * 会员积分明细管理DAO组件
	 */
	@Autowired
	private MemberPointDetailDAO memberPointDetailDAO;
	
	/**
	 * 测试分页查询会员积分明细
	 * @throws Exception
	 */
	@Test
	@Sql({"init_member_point_detail.sql"})  
	public void testListByPage() throws Exception {
		MemberPointDetailQuery query = new MemberPointDetailQuery();
		query.setOffset(0); 
		query.setSize(10);
		query.setUserAccountId(1L); 
		
		List<MemberPointDetailDO> memberPointDetails = 
				memberPointDetailDAO.listByPage(query);
	
		assertEquals(2, memberPointDetails.size()); 
	}
	
}
