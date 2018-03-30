package com.zhss.eshop.order.price;

import org.springframework.stereotype.Component;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 没有促销活动的计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultPromotionActivityCalculator implements PromotionActivityCalculator {
	
	/**
	 * 计算促销活动减免的金额
	 */
	@Override
	public PromotionActivityResult calculate(OrderItemDTO item, 
			PromotionActivityDTO promotionActivity) {
		return new PromotionActivityResult(); 
	}

}
