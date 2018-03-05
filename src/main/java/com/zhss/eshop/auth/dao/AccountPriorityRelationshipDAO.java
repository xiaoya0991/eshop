package com.zhss.eshop.auth.dao;

import java.util.List;

import com.zhss.eshop.auth.domain.AccountPriorityRelationshipDO;

/**
 * 账号和权限关系管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface AccountPriorityRelationshipDAO {
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	Long countByPriorityId(Long priorityId);
	
	/**
	 * 根据账号id查询账号和权限的关联关系
	 * @param accountId 账号id
	 * @return 账号和权限的关联关系
	 */
	List<AccountPriorityRelationshipDO> listByAccountId(Long accountId);
	
	/**
	 * 新增账号和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	void save(AccountPriorityRelationshipDO accountPriorityRelationshipDO);
	
	/**
	 * 根据账号id删除账号和权限的关联关系
	 * @param accountId 账号id
	 */
	void removeByAccountId(Long accountId);
	
}
