package com.zhss.eshop.auth.service;

import java.util.List;

import com.zhss.eshop.auth.domain.RoleDTO;
import com.zhss.eshop.auth.domain.RoleQuery;

/**
 * 角色管理模块service组件接口
 * @author zhonghuashishan
 *
 */
public interface RoleService {

	/**
	 * 分页查询角色
	 * @param query 查询条件
	 * @return 角色DO对象集合
	 * @throws Exception
	 */
	List<RoleDTO> listByPage(RoleQuery query) throws Exception;
	
	/**
	 * 根据id查询角色DO对象
	 * @param id 角色 id 
	 * @return 角色DO对象
	 * @throws Exception
	 */
	RoleDTO getById(Long id) throws Exception;
	
	/**
	 * 新增角色
	 * @param role 角色DO对象
	 * @throws Exception
	 */
	void save(RoleDTO role) throws Exception; 
	
	/**
	 * 更新角色
	 * @param role 角色DO对象
	 * @throws Exception
	 */
	void update(RoleDTO role) throws Exception;
	
	/**
	 * 删除角色
	 * @param id 角色id
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean remove(Long id) throws Exception;
	
}
