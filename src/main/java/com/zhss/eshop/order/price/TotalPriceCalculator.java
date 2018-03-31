package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 商品条目总金额计算器
 * @author zhonghuashishan
 *
 */
public interface TotalPriceCalculator {

	/**
	 * 计算订单条目总金额
	 * @param item 订单条目 
	 * @return 订单条目总金额
	 */
	Double calculate(OrderItemDTO item);
	
}
