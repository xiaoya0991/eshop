package com.zhss.eshop.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.dao.MemberLevelDetailDAO;
import com.zhss.eshop.membership.domain.MemberLevelDetailDO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;
import com.zhss.eshop.membership.mapper.MemberLevelDetailMapper;

/**
 * 会员等级变更明细管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class MemberLevelDetailDAOImpl implements MemberLevelDetailDAO {

	/**
	 * 会员等级明细管理mapper组件
	 */
	@Autowired
	private MemberLevelDetailMapper memberLevelDetailMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 */
	public List<MemberLevelDetailDO> listByPage(MemberLevelDetailQuery query) throws Exception {
		return memberLevelDetailMapper.listByPage(query);
	}
	
	/**
	 * 新增会员等级明细
	 * @param memberLevelDetail 会员等级明细
	 */
	public void save(MemberLevelDetailDO memberLevelDetail) throws Exception {
		memberLevelDetail.setGmtCreate(dateProvider.getCurrentTime()); 
		memberLevelDetail.setGmtModified(dateProvider.getCurrentTime()); 
		memberLevelDetailMapper.save(memberLevelDetail); 
	}
	
}
