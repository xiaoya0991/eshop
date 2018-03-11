package com.zhss.eshop.membership.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.membership.domain.UserAccountDTO;
import com.zhss.eshop.membership.domain.UserAccountVO;
import com.zhss.eshop.membership.service.UserAccountService;

/**
 * 用户账号管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/membership/user")  
public class UserAccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);

	/**
	 * 用户账号管理service组件
	 */
	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * 用户注册
	 * @param userAccount 用户账号
	 */
	@PostMapping("/register")  
	public UserAccountVO register(@RequestBody UserAccountVO userAccount) {
		try {
			UserAccountDTO resultUserAccount = userAccountService.save(
					userAccount.clone(UserAccountDTO.class));
			return resultUserAccount.clone(UserAccountVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return userAccount;
		}
	}
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	@PutMapping("/login")  
	public UserAccountVO login(@RequestBody UserAccountVO userAccount) {
		try {
			UserAccountDTO resultUserAccount = userAccountService.getForLogin(
					userAccount.clone(UserAccountDTO.class));
			return resultUserAccount.clone(UserAccountVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return userAccount;
		}
	}
	
}
