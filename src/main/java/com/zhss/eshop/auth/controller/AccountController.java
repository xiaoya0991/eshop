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
import com.zhss.eshop.auth.service.AccountService;
import com.zhss.eshop.common.util.CloneDirection;
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
	
	/**
	 * 分页查询账号
	 * @param query 查询条件 
	 * @return 账号
	 */
	@GetMapping("/")   
	public List<AccountVO> listByPage(AccountQuery query) {
		try {
			List<AccountDTO> accounts = accountService.listByPage(query);
			List<AccountVO> resultAccounts = ObjectUtils.convertList(accounts, 
					AccountVO.class, CloneDirection.OPPOSITE);
			return resultAccounts;
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<AccountVO>(); 
		}
	}
	
	/**
	 * 根据id查询账号
	 * @param id 角色id
	 * @return 角色
	 */
	@GetMapping("/{id}")  
	public AccountVO getById(@PathVariable("id") Long id) {
		try {
			AccountDTO account = accountService.getById(id);
			AccountVO resultAccount = account.clone(AccountVO.class, 
					CloneDirection.OPPOSITE);
			return resultAccount;
		} catch (Exception e) {
			logger.error("error", e);
			return new AccountVO();  
		}
	}
	
	/**
	 * 新增账号
	 * @param account 账号
	 * @return 处理结果
	 */
	@PostMapping("/")  
	public Boolean save(@RequestBody AccountVO account) {
		try {
			AccountDTO targetAccount = account.clone(AccountDTO.class, 
					CloneDirection.FORWARD);
			accountService.save(targetAccount); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 更新账号
	 * @param account 账号
	 * @return 处理结果
	 */
	@PutMapping("/{id}")   
	public Boolean update(@RequestBody AccountVO account) {
		try {
			AccountDTO targetAccount = account.clone(AccountDTO.class, 
					CloneDirection.FORWARD);
			accountService.update(targetAccount); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 删除账号
	 * @param account 账号
	 * @return 处理结果
	 */
	@DeleteMapping("/{id}")  
	public Boolean update(@PathVariable("id") Long id) { 
		try {
			accountService.remove(id); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 修改密码
	 * @param account 账号
	 * @return 处理结果
	 */
	@PutMapping("/password/{id}")    
	public Boolean updatePassword(@RequestBody AccountVO account) {  
		try {
			accountService.updatePassword(account.clone(AccountDTO.class));   
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
