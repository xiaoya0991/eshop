package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 运费计算组件接口
 * @author zhonghuashishan
 *
 */
public interface FreightCalculator {
	
	Double calculate(OrderItemDTO item, PromotionActivityResult result); 

}
