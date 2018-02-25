package com.zhss.eshop.auth.service;

import java.util.List;

import com.zhss.eshop.auth.domain.PriorityDTO;

/**
 * 权限管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface PriorityService {

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	List<PriorityDTO> listRootPriorities();
	
	/**
	 * 根据父权限id查询子权限
	 * @param parentId 父权限id
	 * @return 子权限
	 */
	List<PriorityDTO> listChildPriorities(Long parentId);
	
	/**
	 * 根据id查询权限
	 * @param id 权限id
	 * @return 权限
	 */
	PriorityDTO getPriorityById(Long id);
	
	/**
	 * 新增权限
	 * @param priorityDO 权限DO对象
	 */
	Boolean savePriority(PriorityDTO priorityDTO); 
	
	/**
	 * 更新权限
	 * @param priorityDO 权限DO对象
	 */
	Boolean updatePriority(PriorityDTO priorityDTO);
	
	/**
	 * 删除权限
	 * @param id 权限id
	 * @return 处理结果
	 */
	Boolean removePriority(Long id);
	
}
