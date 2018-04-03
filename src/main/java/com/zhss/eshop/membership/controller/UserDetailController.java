package com.zhss.eshop.membership.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.membership.domain.UserAccountVO;
import com.zhss.eshop.membership.domain.UserDetailDTO;
import com.zhss.eshop.membership.domain.UserDetailShowVO;
import com.zhss.eshop.membership.domain.UserDetailVO;
import com.zhss.eshop.membership.service.UserAccountService;
import com.zhss.eshop.membership.service.UserDetailService;

/**
 * 用户详细信息管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/membership/user/detail")  
public class UserDetailController {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailController.class);
	
	/**
	 * 用户账号管理service组件
	 */
	@Autowired
	private UserAccountService userAccountService;
	/**
	 * 用户详细信息管理service组件
	 */
	@Autowired
	private UserDetailService userDetailService;
	
	/**
	 * 显示用户的详细信息
	 * @param userAccountId 用户账号id
	 * @return 用户的详细信息
	 */
	@GetMapping("/{userAccountId}")    
	public UserDetailShowVO showDetail(
			@PathVariable("userAccountId") Long userAccountId) {
		try {
			UserAccountVO userAccount = userAccountService.getById(userAccountId)
					.clone(UserAccountVO.class);
			UserDetailVO userDetail = userDetailService.getByUserAccountId(userAccountId)
					.clone(UserDetailVO.class);
			
			UserDetailShowVO userDetailShow = new UserDetailShowVO();
			userDetailShow.setUserAccount(userAccount); 
			userDetailShow.setUserDetail(userDetail); 
			
			return userDetailShow;
		} catch (Exception e) {
			logger.error("error", e); 
			return new UserDetailShowVO();
		}
	}
	
	/**
	 * 更新用户详细信息
	 * @param userDetail 用户详细信息
	 * @return 处理结果
	 */
	@PutMapping("/{userAccountId}")  
	public Boolean update(@RequestBody UserDetailVO userDetail) {
		try {
			userDetailService.updateByUserAccountId(userDetail.clone(UserDetailDTO.class));  
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
