package com.zhss.eshop.logistics.service.impl;

import org.springframework.stereotype.Component;

import com.zhss.eshop.logistics.domain.FreightTemplateDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 默认运费计算器
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultFreightCalculator implements FreightCalculator {
	
	/**
	 * 计算订单条目的运费
	 * @param freightTemplate 运费模板
	 * @param order 订单
	 * @param orderItem 订单条目
	 * @return 运费
	 * @throws Exception
	 */
	@Override
	public Double calculate(FreightTemplateDTO freightTemplate, 
			OrderInfoDTO order, OrderItemDTO orderItem) throws Exception {
		return 0.0;
	}

}
