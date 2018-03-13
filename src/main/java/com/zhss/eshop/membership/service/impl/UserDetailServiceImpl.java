package com.zhss.eshop.membership.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.membership.dao.UserDetailDAO;
import com.zhss.eshop.membership.domain.UserDetailDO;
import com.zhss.eshop.membership.domain.UserDetailDTO;
import com.zhss.eshop.membership.service.UserDetailService;

/**
 * 用户详细信息管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

	/**
	 * 用户详细信息管理DAO组件
	 */
	@Autowired
	private UserDetailDAO userDetailDAO;
	
	/**
	 * 根据用户账号id查询用户详细信息
	 * @param userAccountId 用户账号id
	 * @return 用户详细信息
	 */
	public UserDetailDTO getByUserAccountId(Long userAccountId) throws Exception {
		return userDetailDAO.getByUserAccountId(userAccountId).clone(UserDetailDTO.class); 
	}
	
	/**
	 * 更新用户详细信息
	 * @param userDetail 用户详细信息
	 */
	public void updateByUserAccountId(UserDetailDTO userDetail) throws Exception {
		userDetailDAO.updateByUserAccountId(userDetail.clone(UserDetailDO.class));   
	}
	
}
