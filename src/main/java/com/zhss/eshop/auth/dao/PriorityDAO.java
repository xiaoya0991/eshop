package com.zhss.eshop.auth.dao;

import java.util.List;

import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 权限管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PriorityDAO {

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	List<PriorityDO> listRootPriorities();
	
}
