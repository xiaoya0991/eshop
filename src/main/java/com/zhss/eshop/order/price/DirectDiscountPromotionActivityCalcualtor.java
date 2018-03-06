package com.zhss.eshop.order.price;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 单品促销活动的价格计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class DirectDiscountPromotionActivityCalcualtor implements PromotionActivityCalculator {

	/**
	 * 计算促销活动的减免金额
	 */
	public PromotionActivityResult calculate(OrderItemDTO item, 
			PromotionActivityDTO promotionActivity) {
		Double totalAmount = item.getPurchaseQuantity() * item.getPurchasePrice();
		JSONObject rule = JSONObject.parseObject(promotionActivity.getRule());
		Double discountRate = rule.getDouble("discountRate");
		return new PromotionActivityResult(totalAmount * (1.0 - discountRate));   
	}
	
}
