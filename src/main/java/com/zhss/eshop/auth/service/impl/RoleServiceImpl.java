package com.zhss.eshop.auth.service.impl;

import java.util.List;

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
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

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
	 * 权限缓存管理组件
	 */
	@Autowired
	private PriorityCacheManager priorityCacheManager;
	
	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 */
	@Override
	public List<RoleDTO> listByPage(RoleQuery query) throws Exception {
		List<RoleDO> roles = roleDAO.listByPage(query);
		return ObjectUtils.convertList(roles, RoleDTO.class);  
	}
	
	/**
	 * 根据id查询角色DO对象
	 * @param id 角色 id 
	 * @return 角色DO对象
	 */
	@Override
	public RoleDTO getById(Long id) throws Exception {
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
	}
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 */
	@Override
	public void save(RoleDTO role) throws Exception {
		role.setGmtCreate(dateProvider.getCurrentTime()); 
		role.setGmtModified(dateProvider.getCurrentTime());  
		Long roleId = roleDAO.save(role.clone(RoleDO.class));  
		
		for(RolePriorityRelationshipDTO relation : role.getRolePriorityRelations()) {
			relation.setRoleId(roleId);
			relation.setGmtCreate(dateProvider.getCurrentTime()); 
			relation.setGmtModified(dateProvider.getCurrentTime()); 
			rolePriorityRelationDAO.save(relation.clone(RolePriorityRelationshipDO.class));
		}
	}
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 */
	@Override
	public void update(RoleDTO role) throws Exception {
		role.setGmtModified(dateProvider.getCurrentTime()); 
		roleDAO.update(role.clone(RoleDO.class));
		
		rolePriorityRelationDAO.removeByRoleId(role.getId());
		
		for(RolePriorityRelationshipDTO relation : role.getRolePriorityRelations()) {
			relation.setRoleId(role.getId());
			relation.setGmtCreate(dateProvider.getCurrentTime()); 
			relation.setGmtModified(dateProvider.getCurrentTime()); 
			rolePriorityRelationDAO.save(relation.clone(RolePriorityRelationshipDO.class));
		}
		
		List<Long> accountIds = accountRoleRelationDAO
				.listAccountIdsByRoleId(role.getId());
		for(Long accountId : accountIds) {
			priorityCacheManager.remove(accountId);
		}
	}
	
	/**
	 * 删除角色
	 * @param id 角色id
	 * @return 处理结果
	 */
	@Override
	public Boolean remove(Long id) throws Exception {
		Long count = accountRoleRelationDAO.countByRoleId(id);
		if(count > 0L) {
			return false;
		}
		
		roleDAO.remove(id);
		rolePriorityRelationDAO.removeByRoleId(id);
		
		return true;
	}
	
}
