package com.zhss.eshop.auth.dao;

import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;

/**
 * 角色和权限关系管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface RolePriorityRelationshipDAO {

	/**
	 * 新增角色和权限的关联关系
	 * @param rolePriorityRelationshipDO
	 */
	Boolean save(RolePriorityRelationshipDO rolePriorityRelationshipDO);
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	Long countByPriorityId(Long priorityId);
	
}
