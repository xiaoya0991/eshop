package com.zhss.eshop.promotion.service;

import java.util.List;

import com.zhss.eshop.promotion.domain.CouponDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 促销中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface PromotionService {
	
	/**
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	List<PromotionActivityDTO> listByGoodsId(Long goodsId);
	
	/**
	 * 根据id查询促销活动
	 * @param id 促销活动id
	 * @return 促销活动
	 */
	PromotionActivityDTO getById(Long id);
	
	/**
	 * 查询用户当前可以使用的有效优惠券
	 * @param userAccountId 用户账号id
	 * @return 有效优惠券
	 */
	List<CouponDTO> listValidByUserAccountId(Long userAccountId);
	
}
