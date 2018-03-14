package com.zhss.eshop.promotion.controller;

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

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.promotion.domain.CouponDTO;
import com.zhss.eshop.promotion.domain.CouponQuery;
import com.zhss.eshop.promotion.domain.CouponVO;
import com.zhss.eshop.promotion.service.CouponService;

/**
 * 优惠券管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/promotion/coupon") 
public class CouponController {
	
	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

	/**
	 * 优惠券管理service组件
	 */
	@Autowired
	private CouponService couponService;
	
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
	
	/**
	 * 分页查询优惠券
	 * @param query 查询条件
	 * @return 优惠券
	 */
	@GetMapping("/")  
	public List<CouponVO> listByPage(CouponQuery query) {
		try {
			return ObjectUtils.convertList(couponService.listByPage(query), CouponVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<CouponVO>();
		}
	}
	
	/**
	 * 新增优惠券
	 * @param coupon 优惠券
	 */
	@PostMapping("/") 
	public Boolean save(@RequestBody CouponVO coupon) {
		try {
			couponService.save(coupon.clone(CouponDTO.class));
			return true;
		} catch (Exception e) {
			logger.error("eror", e);
			return false;
		}
	}
	
	/**
	 * 根据id查询优惠券
	 * @param id 优惠券id
	 * @return 优惠券
	 */
	@GetMapping("/{id}")  
	public CouponVO getById(Long id) {
		try {
			return couponService.getById(id).clone(CouponVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
			return new CouponVO();
		}
	}
	
	/**
	 * 更新优惠券
	 * @param coupon 优惠券
	 */
	@PutMapping("/{id}")
	public Boolean update(@RequestBody CouponVO coupon) {
		try {
			return couponService.update(coupon.clone(CouponDTO.class));
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 删除优惠券
	 * @param id 优惠券id
	 */
	@DeleteMapping("/{id}") 
	public Boolean remove(@PathVariable("id") Long id) {
		try {
			return couponService.remove(id);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 领取优惠券
	 * @param couponId 优惠券id
	 * @param userAccountId 用户账号id
	 * @return 是否领取成功
	 * @throws Exception
	 */
	@PutMapping("/achieve")   
	public Boolean achieve(Long couponId, Long userAccountId) {
		try {
			return couponService.achieve(couponId, userAccountId);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 发放优惠券
	 * @param couponId 优惠券id
	 * @return 是否领取成功
	 * @throws Exception
	 */
	@PutMapping("/giveOut")  
	public Boolean giveOut(Long couponId) {
		try {
			return couponService.giveOut(couponId);
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
