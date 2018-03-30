package com.zhss.eshop.membership.dao;

import java.util.List;

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
	 * @return 用户账号
	 */
	UserAccountDO save(UserAccountDO userAccount);
	
	/**
	 * 为登录来统计是否有对应的账号在
	 * @param userAccount 用户账号
	 * @return
	 */
	UserAccountDO getForLogin(UserAccountDO userAccount);
	
	/**
	 * 根据id查询用户账号 
	 * @param id 用户账号id
	 * @return 用户账号
	 */
	UserAccountDO getById(Long id);
	
	/**
	 * 更新密码
	 * @param userAccount 用户账号
	 */
	void updatePassword(UserAccountDO userAccount);
	
	/**
	 * 查询所有用户账号
	 * @return
	 */
	List<UserAccountDO> listAll();
	
}
