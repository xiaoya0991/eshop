package com.zhss.eshop.schedule.service.impl;

import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDTO;

/**
 * 销售出库调度器接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryScheduler {
	
	/**
	 * 对订单条目进行发货调度
	 * @param orderItem 订单条目
	 * @return 销售出库单条目
	 */
	SaleDeliveryOrderItemDTO schedule(OrderItemDTO orderItem) throws Exception;
	
	/**
	 * 对订单进行调度销售出库
	 * @param order 订单
	 * @return 调度结果
	 * @throws Exception
	 */
	List<SaleDeliveryOrderItemDTO> scheduleOrder(OrderInfoDTO order) throws Exception;

}
