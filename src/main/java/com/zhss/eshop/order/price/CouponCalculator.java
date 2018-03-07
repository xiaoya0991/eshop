package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.promotion.domain.CouponDTO;

/**
 * 优惠券抵扣金额计算接口
 * @author zhonghuashishan
 *
 */
public interface CouponCalculator {

	/**
	 * 计算优惠券对当前订单的抵扣金额
	 * @param order
	 * @param coupon
	 * @return
	 */
	Double calculate(OrderInfoDTO order, CouponDTO coupon);
	
}
