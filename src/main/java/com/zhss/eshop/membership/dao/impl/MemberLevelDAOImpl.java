package com.zhss.eshop.membership.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.membership.constant.MemberLevel;
import com.zhss.eshop.membership.dao.MemberLevelDAO;
import com.zhss.eshop.membership.domain.MemberLevelDO;
import com.zhss.eshop.membership.mapper.MemberLevelMapper;

/**
 * 会员等级管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class MemberLevelDAOImpl implements MemberLevelDAO {
	
	/**
	 * 会员等级管理mapper组件
	 */
	@Autowired
	private MemberLevelMapper memberLevelMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 根据用户账号id查询会员等级
	 * @param userAccountId 用户账号id
	 * @return 会员等级
	 */
	@Override
	public MemberLevelDO getByUserAccountId(Long userAccountId) throws Exception {
		MemberLevelDO memberLevel = memberLevelMapper.getByUserAccountId(userAccountId);
		
		if(memberLevel == null) {
			memberLevel = new MemberLevelDO();
			memberLevel.setUserAccountId(userAccountId); 
			memberLevel.setGrowthValue(0L); 
			memberLevel.setLevel(MemberLevel.BRONZE); 
			save(memberLevel);
		}
		
		return memberLevel;
	}
	
	/**
	 * 新增会员等级
	 * @param memberLevel 会员等级
	 */
	@Override
	public void save(MemberLevelDO memberLevel) throws Exception {
		memberLevel.setGmtCreate(dateProvider.getCurrentTime()); 
		memberLevel.setGmtModified(dateProvider.getCurrentTime()); 
		memberLevelMapper.save(memberLevel); 
	}
	
	/**
	 * 更新会员等级
	 * @param memberLevel 会员等级
	 */
	@Override
	public void update(MemberLevelDO memberLevel) throws Exception {
		memberLevel.setGmtModified(dateProvider.getCurrentTime()); 
		memberLevelMapper.update(memberLevel); 
	}
	
}
