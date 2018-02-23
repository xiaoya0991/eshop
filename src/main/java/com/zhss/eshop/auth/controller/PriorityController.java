package com.zhss.eshop.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;

/**
 * 权限管理模块的controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/auth")  
public class PriorityController {

	/**
	 * 权限管理模块的service组件
	 */
	@Autowired
	private PriorityService priorityService;
	
	/**
	 * 查询根权限
	 * @return 根权限集合
	 */
	@GetMapping("/priority/root")
	public List<PriorityVO> listRootPriorities() {
		return null;
	}
	
}
