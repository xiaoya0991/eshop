package com.zhss.eshop.auth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.dao.AccountRoleRelationshipDAO;
import com.zhss.eshop.auth.dao.RoleDAO;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleDTO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipDO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipDTO;
import com.zhss.eshop.auth.domain.RoleQuery;
import com.zhss.eshop.auth.service.RoleService;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 角色管理模块service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	/**
	 * 角色管理模块DAO组件
	 */
	@Autowired
	private RoleDAO roleDAO;
	/**
	 * 角色权限关系管理模块DAO组件
	 */
	@Autowired
	private RolePriorityRelationshipDAO rolePriorityRelationDAO;
	/**
	 * 账号角色关系管理模块DAO组件
	 */
	@Autowired
	private AccountRoleRelationshipDAO accountRoleRelationDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 */
	public List<RoleDTO> listByPage(RoleQuery query) {
		try {
			List<RoleDO> roles = roleDAO.listByPage(query);
			return ObjectUtils.convertList(roles, RoleDTO.class);  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询角色DO对象
	 * @param id 角色 id 
	 * @return 角色DO对象
	 */
	public RoleDTO getById(Long id) {
		try {
			RoleDO role = roleDAO.getById(id); 
			if(role == null) {
				return null;
			}
			
			RoleDTO resultRole = role.clone(RoleDTO.class);
			
			List<RolePriorityRelationshipDO> relations = 
					rolePriorityRelationDAO.listByRoleId(id);
			resultRole.setRolePriorityRelations(ObjectUtils.convertList(
					relations, RolePriorityRelationshipDTO.class));  
			
			return resultRole;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 */
	public Boolean save(RoleDTO role) {
		try {
			role.setGmtCreate(dateProvider.getCurrentTime()); 
			role.setGmtModified(dateProvider.getCurrentTime());  
			Long roleId = roleDAO.save(role.clone(RoleDO.class));  
			
			for(RolePriorityRelationshipDTO relation : role.getRolePriorityRelations()) {
				relation.setRoleId(roleId);
				relation.setGmtCreate(dateProvider.getCurrentTime()); 
				relation.setGmtModified(dateProvider.getCurrentTime()); 
				rolePriorityRelationDAO.save(relation.clone(RolePriorityRelationshipDO.class));
			}
			
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 */
	public Boolean update(RoleDTO role) {
		try {
			role.setGmtModified(dateProvider.getCurrentTime()); 
			roleDAO.update(role.clone(RoleDO.class));
			
			rolePriorityRelationDAO.removeByRoleId(role.getId());
			
			for(RolePriorityRelationshipDTO relation : role.getRolePriorityRelations()) {
				relation.setRoleId(role.getId());
				relation.setGmtCreate(dateProvider.getCurrentTime()); 
				relation.setGmtModified(dateProvider.getCurrentTime()); 
				rolePriorityRelationDAO.save(relation.clone(RolePriorityRelationshipDO.class));
			}
			
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 删除角色
	 * @param id 角色id
	 */
	public Boolean remove(Long id) {
		try {
			Long count = accountRoleRelationDAO.countByRoleId(id);
			if(count > 0L) {
				return false;
			}
			
			roleDAO.remove(id);
			rolePriorityRelationDAO.removeByRoleId(id);
			
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
