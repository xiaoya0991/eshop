package com.zhss.eshop.auth.visitor;

import java.util.List;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 权限树节点的删除访问者
 * @author zhonghuashishan
 *
 */
public class PriorityNodeRemoveVisitor implements PriorityNodeVisitor {

	/**
	 * 权限管理模块的DAO组件
	 */
	private PriorityDAO priorityDAO;
	
	/**
	 * 构造函数
	 * @param priorityDAO 权限管理模块的DAO组件
	 */
	public PriorityNodeRemoveVisitor(PriorityDAO priorityDAO) {
		this.priorityDAO = priorityDAO;
	}
	
	/**
	 * 访问权限树节点
	 * @param node 权限树节点
	 */
	@Override
	public void visit(PriorityNode node) {
		List<PriorityDO> priorityDOs = priorityDAO
				.listChildPriorities(node.getId());
		
		if(priorityDOs != null && priorityDOs.size() > 0) {
			for(PriorityDO priorityDO : priorityDOs) {
				PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
				priorityNode.accept(this); 
			}
		}
		
		removePriority(node); 
	}
	
	/**
	 * 删除权限
	 * @param node 权限树节点
	 */
	private void removePriority(PriorityNode node) {
		priorityDAO.removePriority(node.getId());
	}

}
