package com.zhss.eshop.membership.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.membership.dao.UserAccountDAO;
import com.zhss.eshop.membership.domain.UserAccountDO;
import com.zhss.eshop.membership.mapper.UserAccountMapper;

/**
 * 用户账号管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class UserAccountDAOImpl implements UserAccountDAO {

	/**
	 * 用户账号管理mapper组件
	 */
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	public UserAccountDO save(UserAccountDO userAccount) {
		userAccountMapper.save(userAccount);  
		return userAccount;
	}
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	public UserAccountDO getForLogin(UserAccountDO userAccount) {
		return userAccountMapper.getForLogin(userAccount);
	}
	
}
