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
	
}
