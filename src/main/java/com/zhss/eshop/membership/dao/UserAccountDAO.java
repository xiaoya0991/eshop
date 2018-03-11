package com.zhss.eshop.membership.dao;

import com.zhss.eshop.membership.domain.UserAccountDO;

/**
 * 用户账号管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface UserAccountDAO {

	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	UserAccountDO save(UserAccountDO userAccount);
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	UserAccountDO getForLogin(UserAccountDO userAccount);
	
}
