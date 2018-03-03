package com.zhss.eshop.auth.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.AccountRoleRelationshipDAO;
import com.zhss.eshop.auth.mapper.AccountRoleRelationshipMapper;

/**
 * 账号角色关系管理模块DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class AccountRoleRelationshipDAOImpl implements AccountRoleRelationshipDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRoleRelationshipDAOImpl.class);

	/**
	 * 账号角色关系管理模块mapper组件
	 */
	@Autowired
	private AccountRoleRelationshipMapper accountRoleRelationMapper;
	
	/**
	 * 根据角色id来查询记录数
	 * @param roleId 角色id
	 * @return 记录数
	 */
	public Long countByRoleId(Long roleId) {
		try {
			return accountRoleRelationMapper.countByRoleId(roleId);
		} catch (Exception e) {
			logger.error("error", e); 
			return 0L;
		}
	}
	
}
