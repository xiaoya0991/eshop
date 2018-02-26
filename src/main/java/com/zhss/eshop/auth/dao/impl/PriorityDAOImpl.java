package com.zhss.eshop.auth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.mapper.PriorityMapper;

/**
 * 权限管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PriorityDAOImpl implements PriorityDAO {
	
	/**
	 * 权限管理模块的mapper组件
	 */
	@Autowired
	private PriorityMapper priorityMapper;

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	public List<PriorityDO> listRootPriorities() {
		return priorityMapper.listRootPriorities(); 
	}

}
