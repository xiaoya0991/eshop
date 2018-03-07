package com.zhss.eshop.order.service;

import com.zhss.eshop.membership.domain.DeliveryAddressDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.promotion.domain.CouponDTO;

/**
 * 订单管理service组件
 * @author zhonghuashishan
 *
 */
public interface OrderInfoService {

	/**
	 * 计算订单价格
	 * @param order 订单
	 */
	OrderInfoDTO calculateOrderPrice(OrderInfoDTO order, 
			DeliveryAddressDTO deliveryAddress);
	
	/**
	 * 计算优惠券抵扣的金额
	 * @param order 
	 * @param coupon
	 * @return
	 */
	OrderInfoDTO calculateCouponDiscountPrice(
			OrderInfoDTO order, CouponDTO coupon);
	
}
