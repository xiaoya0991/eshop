package com.zhss.eshop.membership.dao;

import com.zhss.eshop.membership.domain.MemberPointDO;

/**
 * 会员积分管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface MemberPointDAO {

	/**
	 * 根据用户账号id查询会员积分
	 * @param userAccountId 用户账号id
	 * @return 会员积分
	 * @throws Exception
	 */
	MemberPointDO getByUserAccountId(Long userAccountId) throws Exception;
	
	/**
	 * 新增会员积分
	 * @param memberPoint 会员积分
	 * @throws Exception
	 */
	void save(MemberPointDO memberPoint) throws Exception;
	
	/**
	 * 更新会员积分
	 * @param memberPoint 会员积分
	 * @throws Exception
	 */
	void update(MemberPointDO memberPoint) throws Exception;
	
}
