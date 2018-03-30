package com.zhss.eshop.auth.service.impl;

import java.util.List;

/**
 * 权限缓存管理器
 * @author zhonghuashishan
 *
 */
 interface PriorityCacheManager {

	/**
	 * 获取账号的授权菜单树
	 * @param accountId 账号id
	 * @return
	 */
	List<Priority> getAuthorizedPriorityTree(Long accountId);
	
	/**
	 * 缓存授权菜单树
	 * @param accountId 账号id
	 * @param authorizedPriorityTree 授权菜单树
	 * @throws Exception
	 */
	void cacheAuthorizedPriorityTree(Long accountId, 
			List<Priority> authorizedPriorityTree) throws Exception;
		
	/**
	 * 删除授权菜单树的缓存
	 * @param accountId 账号id
	 */
	void removeAuthorizedPriorityTree(Long accountId);
	
	/**
	 * 获取账号对指定编号的权限是否被授权
	 * @param accountId 账号id 
	 * @param code 权限编号
	 * @return 是否授权
	 */
	Boolean getAuthorizedByCode(Long accountId, String code);
	
	/**
	 * 缓存账号对指定编号的权限是否被授权
	 * @param accountId 账号
	 * @param code 权限编号
	 * @param authorized 是否被授权
	 * @throws Exception
	 */
	void cacheAuthorizedByCode(Long accountId, 
			String code, Boolean authorized) throws Exception;
	
	/**
	 * 删除账号对指定编号的权限是否被授权的缓存
	 * @param accountId 账号id
	 * @param code 权限编号
	 */
	void removeAuthorizedByCode(Long accountId);
	
	/**
	 * 获取账号对指定url的权限是否被授权
	 * @param accountId 账号id 
	 * @param url 权限url
	 * @return 是否授权
	 */
	Boolean getAuthorizedByUrl(Long accountId, String url);
	
	/**
	 * 缓存账号对指定URL的权限是否被授权
	 * @param accountId 账号
	 * @param url 权限url
	 * @param authorized 是否被授权
	 * @throws Exception
	 */
	void cacheAuthorizedByUrl(Long accountId, 
			String url, Boolean authorized) throws Exception;
	
	/**
	 * 删除账号对指定url的权限是否被授权的缓存
	 * @param accountId 账号id
	 * @param url 权限url
	 */
	void removeAuthorizedByUrl(Long accountId);
	
	/**
	 * 删除账号对应的所有权限缓存数据
	 * @param accountId
	 */
	void remove(Long accountId);
	
}
