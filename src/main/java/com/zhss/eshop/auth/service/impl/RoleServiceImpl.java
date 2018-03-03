package com.zhss.eshop.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.auth.dao.RoleDAO;
import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleDTO;
import com.zhss.eshop.auth.domain.RoleQuery;
import com.zhss.eshop.auth.service.RoleService;

/**
 * 角色管理模块service组件
 * @author zhonghuashishan
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	/**
	 * 角色管理模块DAO组件
	 */
	@Autowired
	private RoleDAO roleDAO;
	
	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 */
	public List<RoleDTO> listByPage(RoleQuery query) {
		try {
			List<RoleDTO> resultRoles = new ArrayList<RoleDTO>();
			
			List<RoleDO> roles = roleDAO.listByPage(query);
			for(RoleDO role : roles) {
//				resultRoles.add(role)
			}
			return null;
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
		return null;
	}
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 */
	public Boolean save(RoleDTO role) {
		return true;
	}
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 */
	public Boolean update(RoleDTO role) {
		return true;
	}
	
	/**
	 * 删除角色
	 * @param id 角色id
	 */
	public Boolean remove(Long id) {
		return true;
	}
	
}
