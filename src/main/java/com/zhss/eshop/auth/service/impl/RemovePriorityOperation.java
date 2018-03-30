package com.zhss.eshop.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 删除权限操作
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype") 
public class RemovePriorityOperation implements PriorityOperation<Boolean> { 

	/**
	 * 权限管理模块的DAO组件
	 */
	@Autowired
	private PriorityDAO priorityDAO;
	
	/**
	 * 访问权限树节点
	 * @param node 权限树节点
	 */
	@Override
	public Boolean doExecute(Priority node) throws Exception {
		List<PriorityDO> priorityDOs = priorityDAO
				.listChildPriorities(node.getId());
		
		if(priorityDOs != null && priorityDOs.size() > 0) {
			for(PriorityDO priorityDO : priorityDOs) {
				Priority priorityNode = priorityDO.clone(Priority.class);
				priorityNode.execute(this);  
			}
		}
		
		removePriority(node); 
		
		return true;
	}
	
	/**
	 * 删除权限
	 * @param node 权限树节点
	 */
	private void removePriority(Priority node) throws Exception {
		priorityDAO.removePriority(node.getId());
	}

}
