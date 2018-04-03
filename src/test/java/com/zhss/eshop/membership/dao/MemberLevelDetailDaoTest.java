package com.zhss.eshop.membership.dao;

import static org.junit.Assert.*;

import java.util.List;

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
import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

/**
 * 会员等级明细管理DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class MemberLevelDetailDaoTest {
	
	/**
	 * 会员等级明细管理DAO组件
	 */
	@Autowired
	private MemberLevelDetailDAO memberLevelDetailDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
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
	
	/**
	 * 测试新增会员等级明细
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		Long userAccountId = 1L;
		MemberLevelDetailDO expectedMemberLevelDetail = 
				createMemberLevelDetail(userAccountId);
		assertNotNull(expectedMemberLevelDetail.getId()); 
		assertThat(expectedMemberLevelDetail.getId(), greaterThan(0L));  
	}
	
	/**
	 * 创建会员等级明细
	 * @param userAccountId 用户账号id
	 * @return 会员等级明细
	 * @throws Exception
	 */
	private MemberLevelDetailDO createMemberLevelDetail(
			Long userAccountId) throws Exception {
		MemberLevelDetailDO memberLevelDetail = new MemberLevelDetailDO();
		memberLevelDetail.setUserAccountId(userAccountId); 
		memberLevelDetail.setOldGrowthValue(1000L); 
		memberLevelDetail.setUpdatedGrowthValue(100L); 
		memberLevelDetail.setNewGrowthValue(1100L); 
		memberLevelDetail.setOldMemberLevel(1); 
		memberLevelDetail.setNewMemberLevel(2); 
		memberLevelDetail.setUpdateReason("测试原因"); 
		memberLevelDetail.setGmtCreate(dateProvider.getCurrentTime()); 
		memberLevelDetail.setGmtModified(dateProvider.getCurrentTime()); 
		
		memberLevelDetailDAO.save(memberLevelDetail); 
		
		return memberLevelDetail;
 	}
	
}
