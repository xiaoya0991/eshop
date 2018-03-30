package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.common.json.JsonExtractor;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 单品促销活动的价格计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class DirectDiscountPromotionActivityCalcualtor implements PromotionActivityCalculator {

	@Autowired
	private JsonExtractor jsonExtractor;
	
	/**
	 * 计算促销活动的减免金额
	 */
	@Override
	public PromotionActivityResult calculate(OrderItemDTO item, 
			PromotionActivityDTO promotionActivity) throws Exception {
		Double totalAmount = item.getPurchaseQuantity() * item.getPurchasePrice();
		JSONObject rule = JSONObject.parseObject(promotionActivity.getRule());
		Double discountRate = jsonExtractor.getDouble(rule, "discountRate"); 
		return new PromotionActivityResult(totalAmount * (1.0 - discountRate));   
	}
	
}
