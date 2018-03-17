package com.zhss.eshop.schedule.service;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.schedule.domain.SaleDeliveryScheduleResult;

/**
 * 销售出库调度器接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryScheduler {
	
	/**
	 * 调度销售出库
	 * @param orderItem 订单条目
	 * @return 调度结果
	 * @throws Exception
	 */
	SaleDeliveryScheduleResult schedule(OrderItemDTO orderItem) throws Exception;
	
	/**
	 * 获取订单条目的调度结果
	 * @param order 订单
	 * @return 调度结果
	 * @throws Exception
	 */
	SaleDeliveryScheduleResult getScheduleResult(OrderItemDTO orderItem) throws Exception;

}
