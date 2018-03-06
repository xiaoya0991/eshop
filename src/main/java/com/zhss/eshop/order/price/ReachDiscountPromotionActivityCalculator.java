package com.zhss.eshop.order.price;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 满减类型的促销活动价格计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class ReachDiscountPromotionActivityCalculator implements PromotionActivityCalculator {

	/**
	 * 计算促销活动的减免金额
	 */
	public PromotionActivityResult calculate(OrderItemDTO item, 
			PromotionActivityDTO promotionActivity) {
		Double totalAmount = item.getPurchaseQuantity() * item.getPurchasePrice();
		
		String rulesJson = promotionActivity.getRule();
		
		JSONArray rules = JSONArray.parseArray(rulesJson);
		
		for(int i = 0; i < rules.size(); i++) {
			JSONObject rule = rules.getJSONObject(i);
		
			Double thresholdAmount = rule.getDouble("thresholdAmount");
			Double reduceAmount = rule.getDouble("reduceAmount");
			
			if(totalAmount > thresholdAmount) {
				return new PromotionActivityResult(reduceAmount); 
			}
		}
		
		return new PromotionActivityResult(); 
	}

}
