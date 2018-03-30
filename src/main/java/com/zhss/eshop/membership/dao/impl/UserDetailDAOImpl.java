package com.zhss.eshop.membership.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.membership.dao.UserDetailDAO;
import com.zhss.eshop.membership.domain.UserDetailDO;
import com.zhss.eshop.membership.mapper.UserDetailMapper;

/**
 * 用户详细信息管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class UserDetailDAOImpl implements UserDetailDAO {
	
	/**
	 * 用户详细信息管理mapper组件
	 */
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	/**
	 * 新增用户详细信息
	 * @param userDetail 用户详细信息
	 */
	@Override
	public void save(UserDetailDO userDetail) {
		userDetailMapper.save(userDetail); 
	}
	
	/**
	 * 根据用户账号id查询用户详细信息
	 * @param userAccountId 用户账号id
	 * @return 用户详细信息
	 */
	@Override
	public UserDetailDO getByUserAccountId(Long userAccountId) {
		return userDetailMapper.getByUserAccountId(userAccountId);
	}
	
	/**
	 * 更新用户详细信息
	 * @param userDetail 用户详细信息
	 */
	@Override
	public void updateByUserAccountId(UserDetailDO userDetail) {
		userDetailMapper.updateByUserAccountId(userDetail); 
	}

}
