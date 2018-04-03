package com.zhss.eshop.auth.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.mapper.PriorityMapper;

/**
 * 权限管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PriorityDAOImpl implements PriorityDAO {
	
	/**
	 * 权限管理模块的mapper组件
	 */
	@Autowired
	private PriorityMapper priorityMapper;

	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	@Override
	public List<PriorityDO> listRootPriorities() throws Exception {
		return priorityMapper.listRootPriorities(); 
	}
	
	/**
	 * 根据父权限id查询子权限
	 * @param parentId 父权限id
	 * @return 子权限
	 */
	@Override
	public List<PriorityDO> listChildPriorities(Long parentId) throws Exception {
		return priorityMapper.listChildPriorities(parentId);
	}
	
	/**
	 * 根据id查询权限
	 * @param id 权限id
	 * @return 权限
	 */
	@Override
	public PriorityDO getPriorityById(Long id) throws Exception {
		return priorityMapper.getPriorityById(id);
	}
	
	/**
	 * 查询账号被授权的菜单
	 * @param accountId 账号id
	 * @return
	 */
	@Override
	public List<PriorityDO> listAuthroziedByAccountId(
			Map<String, Object> parameters) throws Exception {
		return priorityMapper.listAuthroziedByAccountId(parameters);
	}
	
	/**
	 * 统计账号对指定编号的权限是否有授权记录
	 * @param accountId 账号id
	 * @param code 权限编号
	 * @return 是否有授权记录
	 */
	@Override
	public Long countAuthorizedByCode(Long accountId, String code) throws Exception {
		return priorityMapper.countAuthorizedByCode(accountId, code);
	}
	
	/**
	 * 统计账号对指定url的权限是否有授权记录
	 * @param accountId 账号id
	 * @param url 权限url
	 * @return 是否有授权记录
	 */
	@Override
	public Long countAuthorizedByUrl(Long accountId, String url) throws Exception {
		return priorityMapper.countAuthorizedByUrl(accountId, url);
	}
	
	/**
	 * 根据权限id查询账号id
	 * @param priorityId 权限id
	 * @return 
	 */
	@Override
	public List<Long> listAccountIdsByPriorityId(Long priorityId) throws Exception {
		return priorityMapper.listAccountIdsByPriorityId(priorityId);
	}
	
	/**
	 * 新增权限
	 * @param priorityDO 权限DO对象
	 */
	@Override
	public Long savePriority(PriorityDO priorityDO) throws Exception {
		priorityMapper.savePriority(priorityDO); 
		return priorityDO.getId();
	}
	
	/**
	 * 更新权限
	 * @param priorityDO 权限DO对象
	 */
	@Override
	public void updatePriority(PriorityDO priorityDO) throws Exception {
		priorityMapper.updatePriority(priorityDO); 
	}
	
	/**
	 * 删除权限
	 * @param id 权限id
	 */
	@Override
	public void removePriority(Long id) throws Exception {
		priorityMapper.removePriority(id);
	}

}
