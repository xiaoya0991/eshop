package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 促销活动处理组件接口
 * @author zhonghuashishan
 *
 */
public interface PromotionActivityCalculator {  

	/**
	 * 处理促销活动
	 * @return
	 */
	PromotionActivityResult calculate(OrderItemDTO item, 
			PromotionActivityDTO promotionActivity);
	
}
