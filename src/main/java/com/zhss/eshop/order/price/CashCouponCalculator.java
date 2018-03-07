package com.zhss.eshop.order.price;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.promotion.domain.CouponDTO;

/**
 * 现金券抵扣金额计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class CashCouponCalculator implements CouponCalculator {

	public Double calculate(OrderInfoDTO order, CouponDTO coupon) {
		JSONObject rule = JSONObject.parseObject(coupon.getRule());
		Double discountAmount = rule.getDouble("discountAmount"); 
		Double payableAmount = order.getPayableAmount();
		
		if(discountAmount > payableAmount) {
			return payableAmount;
		}
		
		return discountAmount;
	}

}
