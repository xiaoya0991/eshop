package com.zhss.eshop.auth.visitor;

import com.zhss.eshop.auth.composite.PriorityNode;

/**
 * 权限树节点的访问者接口
 * @author zhonghuashishan
 *
 */
public interface PriorityNodeVisitor {

	/**
	 * 访问权限树节点
	 * @param node 权限树节点
	 */
	void visit(PriorityNode node);
	
}
