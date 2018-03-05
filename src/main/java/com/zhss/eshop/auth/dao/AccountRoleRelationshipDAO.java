package com.zhss.eshop.auth.dao;

import java.util.List;

import com.zhss.eshop.auth.domain.AccountRoleRelationshipDO;

/**
 * 账号角色关系管理模块DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface AccountRoleRelationshipDAO {

	/**
	 * 根据角色id来查询记录数
	 * @param roleId 角色id
	 * @return 记录数
	 */
	Long countByRoleId(Long roleId);
	
	/**
	 * 根据账号id查询账号和角色关联关系
	 * @param accountId 账号id
	 * @return 账号和角色关联关系
	 */
	List<AccountRoleRelationshipDO> listByAccountId(Long accountId); 
	
	/**
	 * 新增账号和角色的关联关系
	 * @param relation 账号和角色的关联关系
	 */
	void save(AccountRoleRelationshipDO relation);
	
	/**
	 * 根据账号id删除账号和角色的关联关系
	 * @param accountId 账号id
	 */
	void removeByAccountId(Long accountId);
	
}
