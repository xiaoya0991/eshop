package com.zhss.eshop.membership.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.dao.MemberPointDAO;
import com.zhss.eshop.membership.domain.MemberPointDO;
import com.zhss.eshop.membership.mapper.MemberPointMapper;

/**
 * 会员积分管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class MemberPointDAOImpl implements MemberPointDAO {
	
	/**
	 * 会员积分管理mapper组件
	 */
	@Autowired
	private MemberPointMapper memberPointMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 根据用户账号id查询会员积分
	 * @param userAccountId 用户账号id
	 * @return 会员积分
	 */
	public MemberPointDO getByUserAccountId(Long userAccountId) throws Exception {
		MemberPointDO memberPoint = memberPointMapper.getByUserAccountId(userAccountId);
		
		if(memberPoint == null) {
			memberPoint = new MemberPointDO();
			memberPoint.setUserAccountId(userAccountId); 
			memberPoint.setPoint(0L); 
			save(memberPoint);
		}
		
		return memberPoint;
	}
	
	/**
	 * 新增会员积分
	 * @param memberPoint 会员积分
	 */
	public void save(MemberPointDO memberPoint) throws Exception {
		memberPoint.setGmtCreate(dateProvider.getCurrentTime()); 
		memberPoint.setGmtModified(dateProvider.getCurrentTime()); 
		memberPointMapper.save(memberPoint); 
	}
	
	/**
	 * 更新会员积分
	 * @param memberPoint 会员积分
	 */
	public void update(MemberPointDO memberPoint) throws Exception {
		memberPoint.setGmtModified(dateProvider.getCurrentTime()); 
		memberPointMapper.update(memberPoint); 
	}
	
}
