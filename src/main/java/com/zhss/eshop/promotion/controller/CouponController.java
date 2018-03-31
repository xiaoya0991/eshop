package com.zhss.eshop.promotion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.promotion.domain.CouponVO;

/**
 * 优惠券管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/promotion/coupon") 
public class CouponController {

	/**
	 * 查询用户可以使用的有效优惠券
	 * @param userAccountId
	 * @return
	 */
	@GetMapping("/user/{userAccountId}")  
	public List<CouponVO> listValidByUserAccountId(
			@PathVariable("userAccountId") Long userAccountId) {
		return null;
	}
	
}
