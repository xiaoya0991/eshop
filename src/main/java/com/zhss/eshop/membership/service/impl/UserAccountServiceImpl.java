package com.zhss.eshop.membership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.membership.dao.UserAccountDAO;
import com.zhss.eshop.membership.domain.UserAccountDO;
import com.zhss.eshop.membership.domain.UserAccountDTO;
import com.zhss.eshop.membership.service.UserAccountService;

/**
 * 用户账号管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

	/**
	 * 用户账号管理DAO组件
	 */
	@Autowired
	private UserAccountDAO userAccountDAO;
	
	/**
	 * 新增用户账号
	 * @param userAccount 用户账号
	 */
	public UserAccountDTO save(UserAccountDTO userAccount) throws Exception {
		UserAccountDO resultUserAccount = userAccountDAO.save(
				userAccount.clone(UserAccountDO.class));  
		return resultUserAccount.clone(UserAccountDTO.class);  
	}
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	public UserAccountDTO getForLogin(UserAccountDTO userAccount) throws Exception {
		UserAccountDO resultUserAccount = userAccountDAO.getForLogin(
				userAccount.clone(UserAccountDO.class));  
		return resultUserAccount.clone(UserAccountDTO.class);
	}
	
}
