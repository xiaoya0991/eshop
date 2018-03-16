package com.zhss.eshop.membership.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.dao.MemberPointDetailDAO;
import com.zhss.eshop.membership.domain.MemberPointDetailDO;
import com.zhss.eshop.membership.domain.MemberPointDetailQuery;
import com.zhss.eshop.membership.mapper.MemberPointDetailMapper;

/**
 * 会员积分变更明细管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class MemberPointDetailDAOImpl implements MemberPointDetailDAO {

	/**
	 * 会员积分明细管理mapper组件
	 */
	@Autowired
	private MemberPointDetailMapper memberPointDetailMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 分页查询会员积分变更明细 
	 * @param query 查询调价你
	 * @return 会员积分变更明细
	 */
	public List<MemberPointDetailDO> listByPage(MemberPointDetailQuery query) throws Exception {
		return memberPointDetailMapper.listByPage(query);
	}
	
	/**
	 * 新增会员积分明细
	 * @param memberPointDetail 会员积分明细
	 */
	public void save(MemberPointDetailDO memberPointDetail) throws Exception {
		memberPointDetail.setGmtCreate(dateProvider.getCurrentTime());  
		memberPointDetail.setGmtModified(dateProvider.getCurrentTime()); 
		memberPointDetailMapper.save(memberPointDetail); 
	}
	
}
