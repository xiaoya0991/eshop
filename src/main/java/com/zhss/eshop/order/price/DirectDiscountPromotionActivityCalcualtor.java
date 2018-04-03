package com.zhss.eshop.order.price;

import java.math.BigDecimal;

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
		BigDecimal totalAmount = BigDecimal.valueOf(item.getPurchaseQuantity() * item.getPurchasePrice());  
		
		JSONObject rule = JSONObject.parseObject(promotionActivity.getRule());
		BigDecimal discountRate = BigDecimal.valueOf(jsonExtractor.getDouble(rule, "discountRate"));   
		 
		BigDecimal discountAmountRate = BigDecimal.valueOf(1.0).subtract(discountRate);
		
		Double discountAmount = totalAmount.multiply(discountAmountRate).doubleValue();
		
		return new PromotionActivityResult(discountAmount);      
	}
	
}
