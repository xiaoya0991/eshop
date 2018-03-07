package com.zhss.eshop.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;
import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 权限管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {
	
	/**
	 * 权限管理模块的DAO组件
	 */
	@Autowired
	private PriorityDAO priorityDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * spring容器组件
	 */
	@Autowired
	private SpringApplicationContext context;
	/**
	 * 权限缓存管理组件
	 */
	@Autowired
	private PriorityCacheManager priorityCacheManager;
	
	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	public List<PriorityDTO> listRootPriorities() throws Exception {
		List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities(); 
		if(priorityDOs == null) {
			return null;
		}
		
		List<PriorityDTO> priorityDTOs = new ArrayList<PriorityDTO>(priorityDOs.size()); 
		for(PriorityDO priorityDO : priorityDOs) {
			priorityDTOs.add(priorityDO.clone(PriorityDTO.class)); 
		}	
		
		return priorityDTOs;
	}
	
	/**
	 * 根据父权限id查询子权限
	 * @param parentId 父权限id
	 * @return 子权限
	 */
	public List<PriorityDTO> listChildPriorities(Long parentId) throws Exception {
		List<PriorityDO> priorityDOs = priorityDAO.listChildPriorities(parentId);
		if(priorityDOs == null) {
			return null;
		}
		
		List<PriorityDTO> priorityDTOs = new ArrayList<PriorityDTO>(priorityDOs.size()); 
		for(PriorityDO priorityDO : priorityDOs) {
			priorityDTOs.add(priorityDO.clone(PriorityDTO.class)); 
		}	
		
		return priorityDTOs;
	}
	
	/**
	 * 根据id查询权限
	 * @param id 权限id
	 * @return 权限
	 */
	public PriorityDTO getPriorityById(Long id) throws Exception {
		PriorityDO priorityDO = priorityDAO.getPriorityById(id);
		if(priorityDO == null) {
			return null;
		}
		
		return priorityDO.clone(PriorityDTO.class);
	}
	
	/**
	 * 查询账号被授权的权限树
	 * @param accountId 账号id
	 * @return 权限树
	 * @throws Exception
	 */
	public List<Priority> listAuthorizedByAccountId(
			Long accountId) throws Exception {
		List<Priority> authorizedTree = priorityCacheManager
				.getAuthorizedPriorityTree(accountId);
		if(authorizedTree != null) {
			return authorizedTree;
		}
		
		QueryAuthorizedPriorityOperation operation = context.getBean(
				QueryAuthorizedPriorityOperation.class);
		
		authorizedTree = new ArrayList<Priority>();
		
		List<PriorityDO> authorizedRoots = priorityDAO
				.listAuthroziedByAccountId(accountId, null);
		
		for(PriorityDO root : authorizedRoots) {
			Priority targetRoot = root.clone(Priority.class);
			targetRoot.execute(operation);
			authorizedTree.add(targetRoot);
		}
		
		priorityCacheManager.cacheAuthorizedPriorityTree(accountId, authorizedTree); 
		
		return authorizedTree;
	}
	
	/**
	 * 判断账号是否存在对指定编号的权限的授权记录
	 * @param AccountId 账号id 
	 * @param code 权限编号
	 * @return 是否存在授权记录
	 * @throws Exception
	 */
	public Boolean existAuthorizedByCode(Long accountId, 
			String code) throws Exception {
		Boolean authorized = priorityCacheManager.getAuthorizedByCode(accountId, code);
		if(authorized != null) {
			return authorized;
		}
		
		Long count = priorityDAO.countAuthorizedByCode(accountId, code);
		authorized = count > 0 ? true : false;
		priorityCacheManager.cacheAuthorizedByCode(accountId, code, authorized); 
		
		return authorized;
	}
	
	/**
	 * 判断账号是否存在对指定url的权限的授权记录
	 * @param AccountId 账号id 
	 * @param url 权限url
	 * @return 是否存在授权记录
	 * @throws Exception
	 */
	public Boolean existAuthorizedByUrl(Long accountId, 
			String url) throws Exception {
		Boolean authorized = priorityCacheManager.getAuthorizedByUrl(accountId, url);
		if(authorized != null) {
			return authorized;
		}
		
		Long count = priorityDAO.countAuthorizedByUrl(accountId, url);
		authorized = count > 0 ? true : false;
		priorityCacheManager.cacheAuthorizedByUrl(accountId, url, authorized); 
		
		return authorized;
	}
	
	/**
	 * 新增权限
	 * @param priorityDO 权限DO对象
	 */
	public Boolean savePriority(PriorityDTO priorityDTO) throws Exception {
		priorityDTO.setGmtCreate(dateProvider.getCurrentTime()); 
		priorityDTO.setGmtModified(dateProvider.getCurrentTime());  
		priorityDAO.savePriority(priorityDTO.clone(PriorityDO.class));  
		return true;
	}
	
	/**
	 * 更新权限
	 * @param priorityDO 权限DO对象
	 */
	public Boolean updatePriority(PriorityDTO priorityDTO) throws Exception {
		priorityDTO.setGmtModified(dateProvider.getCurrentTime());  
		priorityDAO.updatePriority(priorityDTO.clone(PriorityDO.class));
		
		List<Long> accountIds = priorityDAO.listAccountIdsByPriorityId(priorityDTO.getId());
		for(Long accountId : accountIds) {
			priorityCacheManager.remove(accountId); 
		}
		
		return true;
	}
	
	/**
	 * 删除权限
	 * @param id 权限id
	 * @return 处理结果
	 */
	public Boolean removePriority(Long id) throws Exception {
		// 根据id查询权限
		Priority priority = priorityDAO.getPriorityById(id)
				.clone(Priority.class);
		
		// 检查这个权限以及其下任何一个子权限，是否被角色或者账号给关联着
		RelatedCheckPriorityOperation relatedCheckOperation = context.getBean(
				RelatedCheckPriorityOperation.class);
		Boolean relateCheckResult = priority.execute(relatedCheckOperation);
		
		if(relateCheckResult) {
			return false;
		}
		
		// 递归删除当前权限以及其下所有的子权限
		RemovePriorityOperation removeOperation = context.getBean(
				RemovePriorityOperation.class);
		priority.execute(removeOperation);
		
		return true;
	}
	
}
