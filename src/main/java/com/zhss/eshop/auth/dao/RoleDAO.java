package com.zhss.eshop.auth.dao;

import java.util.List;

import com.zhss.eshop.auth.domain.RoleDO;
import com.zhss.eshop.auth.domain.RoleQuery;

/**
 * 角色管理模块DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface RoleDAO {

	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 * @throws Exception
	 */
	List<RoleDO> listByPage(RoleQuery query) throws Exception;
	
	/**
	 * 根据id查询角色DO对象
	 * @param id 角色 id 
	 * @return 角色DO对象
	 * @throws Exception
	 */
	RoleDO getById(Long id) throws Exception;
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 * @return 角色id
	 * @throws Exception
	 */
	Long save(RoleDO role) throws Exception; 
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 * @throws Exception
	 */
	void update(RoleDO role) throws Exception;
	
	/**
	 * 删除角色
	 * @param id 角色id
	 * @throws Exception
	 */
	void remove(Long id) throws Exception;
	
}
