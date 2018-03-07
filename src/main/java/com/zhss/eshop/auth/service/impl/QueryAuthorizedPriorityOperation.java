package com.zhss.eshop.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 查询授权权限的操作
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype") 
public class QueryAuthorizedPriorityOperation implements PriorityOperation<Boolean> {

	/**
	 * 账号id
	 */
	private Long accountId;
	
	/**
	 * 权限管理DAO组件
	 */
	@Autowired
	private PriorityDAO priorityDAO;
	
	/**
	 * 构造函数
	 * @param accountId
	 */
	public QueryAuthorizedPriorityOperation(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * 执行这个操作
	 */
	public Boolean doExecute(Priority priority) throws Exception { 
		List<Priority> targetChildren = new ArrayList<Priority>();
		
		List<PriorityDO> children = priorityDAO.listAuthroziedByAccountId(
				accountId, priority.getId());
		for(PriorityDO child : children) {
			Priority targetChild = child.clone(Priority.class);
			targetChild.execute(this);
			targetChildren.add(targetChild);
		}
		
		priority.setChildren(targetChildren); 
		
		return true;
	}  
	
}
