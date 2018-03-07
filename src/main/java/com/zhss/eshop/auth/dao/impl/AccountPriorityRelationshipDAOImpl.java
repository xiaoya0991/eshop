package com.zhss.eshop.auth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.AccountPriorityRelationshipDO;
import com.zhss.eshop.auth.mapper.AccountPriorityRelationshipMapper;

/**
 * 账号和权限关系管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {
	
	/**
	 * 账号和权限关系管理模块的mapper组件
	 */
	@Autowired
	private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	public Long countByPriorityId(Long priorityId) {
		return accountPriorityRelationshipMapper.countByPriorityId(priorityId); 
	}
	
	/**
	 * 根据账号id查询账号和权限的关联关系
	 * @param accountId 账号id
	 * @return 账号和权限的关联关系
	 */
	public List<AccountPriorityRelationshipDO> listByAccountId(Long accountId) {
		return accountPriorityRelationshipMapper.listByAccountId(accountId);
	}
	
	/**
	 * 新增账号和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	public void save(AccountPriorityRelationshipDO accountPriorityRelationshipDO) {
		accountPriorityRelationshipMapper.save(accountPriorityRelationshipDO); 
	}
	
	/**
	 * 根据账号id删除账号和权限的关联关系
	 * @param accountId 账号id
	 */
	public void removeByAccountId(Long accountId) {
		accountPriorityRelationshipMapper.removeByAccountId(accountId);
	}

}
