package com.zhss.eshop.membership.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.membership.domain.DeliveryAddressVO;

/**
 * 收货地址管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/membership/deliveryAddress")  
public class DeliveryAddressController {

	/**
	 * 查询指定用户的收货地址
	 * @param userAccountId
	 * @return
	 */
	@GetMapping("/user/{userAccountId}") 
	public List<DeliveryAddressVO> listByUserAccountId(
			@PathVariable("userAccountId") Long userAccountId) {
		return null;
	}
	
}
