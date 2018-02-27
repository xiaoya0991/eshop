package com.zhss.eshop.auth.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(AccountPriorityRelationshipDAOImpl.class);

	/**
	 * 账号和权限关系管理模块的mapper组件
	 */
	@Autowired
	private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;
	
	/**
	 * 新增账号和权限的关联关系
	 * @param accountPriorityRelationshipDO
	 */
	public Boolean save(AccountPriorityRelationshipDO accountPriorityRelationshipDO) {
		try {
			accountPriorityRelationshipMapper.save(accountPriorityRelationshipDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 根据权限id查询记录数
	 * @param priorityId 权限id
	 * @return 记录数
	 */
	@Override
	public Long countByPriorityId(Long priorityId) {
		try {
			return accountPriorityRelationshipMapper.countByPriorityId(priorityId); 
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return 0L;
	}

}
