package com.zhss.eshop.logistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zhss.eshop.common.json.JsonExtractor;
import com.zhss.eshop.logistics.domain.FreightTemplateDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 满X元包邮运费计算器
 * @author zhonghuashishan
 *
 */
@Component
public class ReachFreeFreightCalculator implements FreightCalculator {
	
	@Autowired
	private JsonExtractor jsonExtractor;

	/**
	 * 计算订单条目的运费
	 * @param freightTemplate 运费模板
	 * @param order 订单
	 * @param orderItem 订单条目
	 * @return 运费
	 * @throws Exception
	 */
	public Double calculate(FreightTemplateDTO freightTemplate, 
			OrderInfoDTO order, OrderItemDTO orderItem) throws Exception {
		JSONObject rule = JSONObject.parseObject(freightTemplate.getRule());
		Double threshold = jsonExtractor.getDouble(rule, "threshold"); 
		Double lessThanThresholdFreight = jsonExtractor.getDouble(rule, "less_than_threshold_freight");
		 
		Double amount = orderItem.getPurchaseQuantity() * orderItem.getPurchasePrice();
	
		if(amount >= threshold) {
			return 0.0;
		} else {
			return lessThanThresholdFreight;
		}
	}
	
}
