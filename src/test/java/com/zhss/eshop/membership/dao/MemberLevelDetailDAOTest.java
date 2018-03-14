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

import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

/**
 * 会员等级明细管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class MemberLevelDetailDAOTest {
	
	/**
	 * 会员等级明细管理DAO组件
	 */
	@Autowired
	private MemberLevelDetailDAO memberLevelDetailDAO;
	
	/**
	 * 测试分页查询会员等级明细
	 * @throws Exception
	 */
	@Test
	@Sql({"init_member_level_detail.sql"})  
	public void testListByPage() throws Exception {
		MemberLevelDetailQuery query = new MemberLevelDetailQuery();
		query.setOffset(0); 
		query.setSize(10);
		query.setUserAccountId(1L); 
		
		List<MemberLevelDetailDO> memberLevelDetails = 
				memberLevelDetailDAO.listByPage(query);
	
		assertEquals(2, memberLevelDetails.size()); 
	}
	
}
