package com.zhss.eshop.schedule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.schedule.service.SaleDeliveryOrderBuilder;

/**
 * 销售出库单builder工厂
 * @author zhonghuashishan
 *
 */
@Component
public class SaleDeliveryOrderBuilderFactory {

	/**
	 * spring容器
	 */
	@Autowired
	private SpringApplicationContext context;
	
	/**
	 * 获取一个销售出库单builder
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder get() {
		return context.getBean(DefaultSaleDeliveryOrderBuilder.class);
	}
	
}
