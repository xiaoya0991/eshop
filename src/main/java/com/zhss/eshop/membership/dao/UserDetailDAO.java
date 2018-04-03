package com.zhss.eshop.membership.dao;

import com.zhss.eshop.membership.domain.UserDetailDO;

/**
 * 用户详细信息管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface UserDetailDAO {

	/**
	 * 新增用户详细信息
	 * @param userDetail 用户详细信息
	 */
	void save(UserDetailDO userDetail);
	
	/**
	 * 根据用户账号id查询用户详细信息
	 * @param userAccountId 用户账号id
	 * @return 用户详细信息
	 */
	UserDetailDO getByUserAccountId(Long userAccountId);
	
	/**
	 * 更新用户详细信息
	 * @param userDetail 用户详细信息
	 */
	void updateByUserAccountId(UserDetailDO userDetail);
	
}
