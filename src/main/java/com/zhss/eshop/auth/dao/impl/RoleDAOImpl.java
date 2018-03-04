package com.zhss.eshop.auth.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.RoleDAO;
import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleQuery;
import com.zhss.eshop.auth.mapper.RoleMapper;

/**
 * 角色管理模块DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);
	
	/**
	 * 角色管理模块mapper组件
	 */
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 */
	public List<RoleDO> listByPage(RoleQuery query) {
		try {
			return roleMapper.listByPage(query);
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
	public RoleDO getById(Long id) {
		try {
			return roleMapper.getById(id);
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 */
	public Long save(RoleDO role) {
		try {
			roleMapper.save(role);
			return role.getId();
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 */
	public Boolean update(RoleDO role) {
		try {
			roleMapper.update(role); 
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
			roleMapper.remove(id);
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}

}
