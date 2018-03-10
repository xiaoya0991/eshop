package com.zhss.eshop.auth.dao;

import java.util.List;
import java.util.Map;

import com.zhss.eshop.auth.domain.PriorityDO;

/**
 * 权限管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface PriorityDAO {

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	List<PriorityDO> listRootPriorities();
	
	/**
	 * 根据父权限id查询子权限
	 * @param parentId 父权限id
	 * @return 子权限
	 */
	List<PriorityDO> listChildPriorities(Long parentId);
	
	/**
	 * 根据id查询权限
	 * @param id 权限id
	 * @return 权限
	 */
	PriorityDO getPriorityById(Long id);
	
	/**
	 * 查询账号被授权的菜单
	 * @param accountId 账号id
	 * @return
	 */
	List<PriorityDO> listAuthroziedByAccountId(
			Map<String, Object> parameters);
	
	/**
	 * 根据权限id查询账号id
	 * @param priorityId 权限id
	 * @return 
	 */
	List<Long> listAccountIdsByPriorityId(Long priorityId);
	
	/**
	 * 统计账号对指定编号的权限是否有授权记录
	 * @param accountId 账号id
	 * @param code 权限编号
	 * @return 是否有授权记录
	 */
	Long countAuthorizedByCode(Long accountId, String code);
	
	/**
	 * 统计账号对指定URL的权限是否有授权记录
	 * @param accountId 账号id
	 * @param url 权限url
	 * @return 是否有授权记录
	 */
	Long countAuthorizedByUrl(Long accountId, String url);
	
	/**
	 * 新增权限
	 * @param priorityDO 权限DO对象
	 */
	Long savePriority(PriorityDO priorityDO); 
	
	/**
	 * 更新权限
	 * @param priorityDO 权限DO对象
	 */
	Boolean updatePriority(PriorityDO priorityDO);
	
	/**
	 * 删除权限
	 * @param id 权限id
	 */
	Boolean removePriority(Long id);
	
}
