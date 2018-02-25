package com.zhss.eshop.auth.dao;

/**
 * 账号和权限关系管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface AccountPriorityRelationshipDAO {

	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	Long getCountByPriorityId(Long priorityId);
	
}
