package com.zhss.eshop.auth.visitor;

import java.util.List;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 权限树节点的关联检查访问者
 * @author zhonghuashishan
 *
 */
public class PriorityNodeRelateCheckVisitor implements PriorityNodeVisitor {

	/**
	 * 关联检查结果
	 */
	private Boolean relateCheckResult = false;
	/**
	 * 权限管理模块的DAO组件
	 */
	private PriorityDAO priorityDAO;
	/**
	 * 角色和权限关系管理模块的DAO组件
	 */
	private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
	/**
	 * 账号和权限关系管理模块的DAO组件
	 */
	private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;
	
	/**
	 * 构造函数
	 * @param priorityDAO 权限管理模块的DAO组件
	 * @param rolePriorityRelationshipDAO 角色和权限关系管理模块的DAO组件
	 * @param accountPriorityRelationshipDAO 账号和权限关系管理模块的DAO组件
	 */
	public PriorityNodeRelateCheckVisitor(
			PriorityDAO priorityDAO,
			RolePriorityRelationshipDAO rolePriorityRelationshipDAO,
			AccountPriorityRelationshipDAO accountPriorityRelationshipDAO) {
		this.priorityDAO = priorityDAO;
		this.rolePriorityRelationshipDAO = rolePriorityRelationshipDAO;
		this.accountPriorityRelationshipDAO = accountPriorityRelationshipDAO;
	}
	
	/**
	 * 访问权限树节点
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
		
		if(relateCheck(node)) {
			this.relateCheckResult = true;
		}
	}
	
	/**
	 * 检查权限是否被任何一个角色或者是账号关联了 
	 * @param node 权限树节点
	 * @return 是否被任何一个角色或者是账号关联了，如果有关联则为true；如果没有关联则为false
	 */
	private Boolean relateCheck(PriorityNode node) {
		Long roleRelatedCount = rolePriorityRelationshipDAO
				.getCountByPriorityId(node.getId());
		if(roleRelatedCount != null && roleRelatedCount > 0) {
			return true;
		}
		
		Long accountRelatedCount = accountPriorityRelationshipDAO
				.getCountByPriorityId(node.getId());
		if(accountRelatedCount != null && accountRelatedCount > 0) {
			return true;
		}
		
		return false;
	}

	public Boolean getRelateCheckResult() {
		return relateCheckResult;
	}
	
}
