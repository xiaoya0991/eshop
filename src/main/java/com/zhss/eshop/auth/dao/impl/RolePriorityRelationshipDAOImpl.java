package com.zhss.eshop.auth.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.mapper.RolePriorityRelationshipMapper;

/**
 * 角色和权限关系管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {

	/**
	 * 角色和权限关系管理模块的mapper组件
	 */
	@Autowired
	private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Override
	public Long getCountByPriorityId(Long priorityId) {
		return rolePriorityRelationshipMapper.getCountByPriorityId(priorityId); 
	}

}
