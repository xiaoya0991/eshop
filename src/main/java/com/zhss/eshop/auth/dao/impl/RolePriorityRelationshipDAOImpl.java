package com.zhss.eshop.auth.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;
import com.zhss.eshop.auth.mapper.RolePriorityRelationshipMapper;

/**
 * 角色和权限关系管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RolePriorityRelationshipDAOImpl.class);

	/**
	 * 角色和权限关系管理模块的mapper组件
	 */
	@Autowired
	private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;
	
	/**
	 * 新增账号和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	@Override
	public Boolean save(RolePriorityRelationshipDO rolePriorityRelationshipDO) {
		try {
			rolePriorityRelationshipMapper.save(rolePriorityRelationshipDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Override
	public Long countByPriorityId(Long priorityId) {
		try {
			return rolePriorityRelationshipMapper.countByPriorityId(priorityId); 
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return 0L;
	}
	
	/**
	 * 根据角色id查询角色和权限的关系
	 * @param roleId 角色id
	 * @return 角色权限关系DO对象集合
	 */
	@Override
	public List<RolePriorityRelationshipDO> listByRoleId(Long roleId) {
		try {
			return rolePriorityRelationshipMapper.listByRoleId(roleId);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据角色id删除角色权限关联关系
	 * @param roleId 角色id
	 */
	@Override
	public Boolean removeByRoleId(Long roleId) {
		try {
			rolePriorityRelationshipMapper.removeByRoleId(roleId);
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}

}
