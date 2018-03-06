package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 商品条目总金额计算器
 * @author zhonghuashishan
 *
 */
public interface TotalPriceCalculator {

	Double calculate(OrderItemDTO item);
	
}
