package com.zhss.eshop.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.auth.domain.AccountDTO;
import com.zhss.eshop.auth.domain.AccountQuery;
import com.zhss.eshop.auth.domain.AccountVO;
import com.zhss.eshop.auth.domain.RoleDTO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipDTO;
import com.zhss.eshop.auth.domain.RolePriorityRelationshipVO;
import com.zhss.eshop.auth.domain.RoleQuery;
import com.zhss.eshop.auth.domain.RoleVO;
import com.zhss.eshop.auth.service.AccountService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 账号管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/auth/account") 
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * 账号管理service组件
	 */
	@Autowired
	private AccountService accountService;
	
//	/**
//	 * 分页查询账号
//	 * @param query 查询条件 
//	 * @return 角色VO集合
//	 */
//	@GetMapping("/")   
//	public List<AccountVO> listByPage(AccountQuery query) {
//		try {
//			List<AccountDTO> accounts = accountService.listByPage(query);
//			List<AccountVO> resultAccounts = 
//			return resultRoles;
//		} catch (Exception e) {
//			logger.error("error", e); 
//			return new ArrayList<RoleVO>();
//		}
//	}
//	
//	/**
//	 * 根据id查询角色
//	 * @param id 角色id
//	 * @return 角色
//	 */
//	@GetMapping("/{id}")  
//	public RoleVO getById(@PathVariable("id") Long id) {
//		try {
//			RoleDTO role = roleService.getById(id);
//			RoleVO resultRole = role.clone(RoleVO.class);
//			
//			List<RolePriorityRelationshipDTO> relations = role.getRolePriorityRelations();
//			List<RolePriorityRelationshipVO> resultRelations = ObjectUtils.convertList(
//					relations, RolePriorityRelationshipVO.class);
//			
//			resultRole.setRolePriorityRelations(resultRelations);
//			
//			return resultRole;
//		} catch (Exception e) {
//			logger.error("error", e);
//			return new RoleVO();
//		}
//	}
//	
//	/**
//	 * 新增角色
//	 * @param role 角色
//	 * @return 处理结果
//	 */
//	@PostMapping("/")  
//	public Boolean save(@RequestBody RoleVO role) {
//		try {
//			RoleDTO targetRole = role.clone(RoleDTO.class);
//			List<RolePriorityRelationshipDTO> targetRelations = ObjectUtils.convertList(
//					role.getRolePriorityRelations(), RolePriorityRelationshipDTO.class);
//			targetRole.setRolePriorityRelations(targetRelations); 
//			
//			return roleService.save(targetRole);
//		} catch (Exception e) {
//			logger.error("error", e); 
//			return false;
//		}
//	}
//	
//	/**
//	 * 更新角色
//	 * @param role 角色
//	 * @return 处理结果
//	 */
//	@PutMapping("/{id}")    
//	public Boolean update(@RequestBody RoleVO role) {
//		try {
//			RoleDTO targetRole = role.clone(RoleDTO.class);
//			List<RolePriorityRelationshipDTO> targetRelations = ObjectUtils.convertList(
//					role.getRolePriorityRelations(), RolePriorityRelationshipDTO.class);
//			targetRole.setRolePriorityRelations(targetRelations); 
//			
//			return roleService.update(targetRole);
//		} catch (Exception e) {
//			logger.error("error", e); 
//			return false;
//		}
//	}
//	
//	/**
//	 * 删除角色
//	 * @param id 角色id
//	 * @return 角色
//	 */
//	@DeleteMapping("/{id}")  
//	public Boolean remove(@PathVariable("id") Long id) {
//		try {
//			return roleService.remove(id);
//		} catch (Exception e) {
//			logger.error("error", e);
//			return false;
//		}
//	}
	
}
