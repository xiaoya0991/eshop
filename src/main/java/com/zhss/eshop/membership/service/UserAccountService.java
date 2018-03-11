package com.zhss.eshop.membership.service;

import com.zhss.eshop.membership.domain.UserAccountDTO;

/**
 * 用户账号管理service接口
 * @author zhonghuashishan
 *
 */
public interface UserAccountService {

	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	UserAccountDTO save(UserAccountDTO userAccount) throws Exception;
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	UserAccountDTO getForLogin(UserAccountDTO userAccount) throws Exception;
	
}
