package com.zhss.eshop.schedule.domain;

import java.util.List;

import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 调度销售出库的结果
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryScheduleResult {

	/**
	 * 订单条目
	 */
	private OrderItemDTO orderItem;
	/**
	 * 拣货条目
	 */
	private List<ScheduleOrderPickingItemDTO> pickingItems;
	/**
	 * 发货明细
	 */
	private List<ScheduleOrderSendOutDetailDTO> sendOutDetails;
	
	public OrderItemDTO getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItemDTO orderItem) {
		this.orderItem = orderItem;
	}
	public List<ScheduleOrderPickingItemDTO> getPickingItems() {
		return pickingItems;
	}
	public void setPickingItems(List<ScheduleOrderPickingItemDTO> pickingItems) {
		this.pickingItems = pickingItems;
	}
	public List<ScheduleOrderSendOutDetailDTO> getSendOutDetails() {
		return sendOutDetails;
	}
	public void setSendOutDetails(List<ScheduleOrderSendOutDetailDTO> sendOutDetails) {
		this.sendOutDetails = sendOutDetails;
	}
	
}
