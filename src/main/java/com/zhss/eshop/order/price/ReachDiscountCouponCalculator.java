package com.zhss.eshop.order.price;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.promotion.domain.CouponDTO;

/**
 * 满减券计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class ReachDiscountCouponCalculator implements CouponCalculator {

	public Double calculate(OrderInfoDTO order, CouponDTO coupon) {
		Double payableAmount = order.getPayableAmount();
		
		JSONArray rules = JSONArray.parseArray(coupon.getRule());

		for(int i = 0; i < rules.size(); i++) {
			JSONObject rule = rules.getJSONObject(i);
		
			Double thresholdAmount = rule.getDouble("thresholdAmount");
			Double reduceAmount = rule.getDouble("reduceAmount");
			
			if(payableAmount > thresholdAmount) {
				return reduceAmount;
			}
		}
		
		return 0.0;
	}

}
