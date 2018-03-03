package com.zhss.eshop.auth.dao;

/**
 * 账号角色关系管理模块DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface AccountRoleRelationshipDAO {

	/**
	 * 根据角色id来查询记录数
	 * @param roleId 角色id
	 * @return 记录数
	 */
	Long countByRoleId(Long roleId);
	
}
