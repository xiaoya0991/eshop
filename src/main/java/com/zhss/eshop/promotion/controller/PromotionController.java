package com.zhss.eshop.promotion.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.promotion.domain.CouponVO;
import com.zhss.eshop.promotion.domain.PromotionActivityVO;
import com.zhss.eshop.promotion.service.PromotionService;

/**
 * 促销中心接口
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/promotion")  
public class PromotionController {

	private static final Logger logger = LoggerFactory.getLogger(
			PromotionController.class);
	
	/**
	 * 促销中心接口
	 */
	@Autowired
	private PromotionService promotionService;
	
	/**
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	@GetMapping("/activity/enabled/{goodsId}") 
	public List<PromotionActivityVO> listEnabledByGoodsId(
			@PathVariable("goodsId") Long goodsId) {
		try {
			return ObjectUtils.convertList(promotionService.listByGoodsId(goodsId), 
					PromotionActivityVO.class);  
		} catch (Exception e) {
			logger.error("error", e); 
			return new ArrayList<PromotionActivityVO>();
		}
	}
	
	/**
	 * 查询用户可以使用的有效优惠券
	 * @param userAccountId
	 * @return
	 */
	@GetMapping("/user/{userAccountId}")  
	public List<CouponVO> listValidByUserAccountId(
			@PathVariable("userAccountId") Long userAccountId) {
		try {
			return ObjectUtils.convertList(
					promotionService.listValidByUserAccountId(userAccountId), 
					CouponVO.class);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return new ArrayList<CouponVO>();
	}
	
}
