package com.zhss.eshop.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;

/**
 * 权限管理模块的service组件
 * @author zhonghuashishan
 *
 */
@Service
public class PriorityServiceImpl implements PriorityService {

	/**
	 * 权限管理模块的DAO组件
	 */
	@Autowired
	private PriorityDAO priorityDAO;
	
	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	@Override
	public List<PriorityDTO> listRootPriorities() {
//		List<PriorityDO> priorityDOs = priorityDAO.listRootPriorities(); 
//		
//		List<PriorityDTO> priorityDTOs = new ArrayList<PriorityDTO>();
//		for(PriorityDO priorityDO : priorityDOs) {
//			priorityDTOs.add(priorityDO.clone(PriorityDTO.class)); 
//		}
//		
//		ObjectUtils.cloneList(priorityDOs, PriorityDTO.class);
//		
//		return ObjectUtils.cloneList(priorityDAO.listRootPriorities(), 
//				PriorityDTO.class);
		
		
		
		return null;
	}
	
}
