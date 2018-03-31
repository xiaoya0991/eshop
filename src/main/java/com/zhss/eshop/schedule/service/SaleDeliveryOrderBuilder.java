package com.zhss.eshop.schedule.service;

import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * 销售出库单builder接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderBuilder {

	/**
	 * 设置订单相关的数据
	 * @param order 订单
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder setOrderRelatedData(
			OrderInfoDTO order) throws Exception;
	
	/**
	 * 创建销售出库单条目
	 * @param orderItems 订单条目
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder createSaleDeliveryOrderItems(
			List<OrderItemDTO> orderItems) throws Exception;
	
	/**
	 * 创建发货单
	 * @param order 订单
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder createSendOutOrder(
			OrderInfoDTO order) throws Exception;
	
	/**
	 * 创建物流单
	 * @param order 订单
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder createLogisticOrder(
			OrderInfoDTO order) throws Exception;
	
	/**
	 * 初始化销售出库单的状态
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder initStatus() throws Exception;
	
	/**
	 * 初始化时间相关的字段
	 * @return 销售出库单builder
	 * @throws Exception
	 */
	SaleDeliveryOrderBuilder initTimes() throws Exception;
	
	/**
	 * 创建最终构造好的销售出库单
	 * @return 销售出库单
	 * @throws Exception
	 */
	SaleDeliveryOrderDTO create() throws Exception;
	
}
