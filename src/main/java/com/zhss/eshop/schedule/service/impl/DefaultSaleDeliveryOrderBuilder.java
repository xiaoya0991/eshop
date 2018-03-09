package com.zhss.eshop.schedule.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDTO;
import com.zhss.eshop.wms.domain.SendOutOrderDTO;
import com.zhss.eshop.wms.domain.SendOutOrderItemDTO;

/**
 * 默认的销售出库单构造器
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype") 
public class DefaultSaleDeliveryOrderBuilder implements SaleDeliveryOrderBuilder {

	/**
	 * 要构造的销售出库单
	 */
	private SaleDeliveryOrderDTO saleDeliveryOrder = new SaleDeliveryOrderDTO();
	
	/**
	 * 销售出库调度器
	 */
	@Autowired
	private SaleDeliveryScheduler saleDeliveryScheduler;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 设置订单相关的数据
	 * @param order 订单
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder setOrderRelatedData(
			OrderInfoDTO order) throws Exception {
		saleDeliveryOrder.setOrderId(order.getId()); 
		order.clone(saleDeliveryOrder);
		return this;
 	}
	
	/**
	 * 创建销售出库单条目
	 * @param orderItems 订单条目
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder createSaleDeliveryOrderItems(
			List<OrderItemDTO> orderItems) throws Exception {
		List<SaleDeliveryOrderItemDTO> saleDeliveryOrderItems = 
				new ArrayList<SaleDeliveryOrderItemDTO>();
	
		for(OrderItemDTO orderItem : orderItems) {
			SaleDeliveryOrderItemDTO saleDeliveryOrderItem = 
					saleDeliveryScheduler.schedule(orderItem);
			orderItem.clone(saleDeliveryOrderItem);
			saleDeliveryOrderItem.setGmtCreate(dateProvider.getCurrentTime());
			saleDeliveryOrderItem.setGmtModified(dateProvider.getCurrentTime());  
			saleDeliveryOrderItems.add(saleDeliveryOrderItem);
		}
		
		saleDeliveryOrder.setSaleDeliveryOrderItems(saleDeliveryOrderItems);  
		
		return this;
	}
	
	/**
	 * 创建发货单
	 * @param order 订单
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder createSendOutOrder(
			OrderInfoDTO order) throws Exception {
		SendOutOrderDTO sendOutOrder = new SendOutOrderDTO();
		sendOutOrder.setSendOutOrderItems(new ArrayList<SendOutOrderItemDTO>());  
		
		order.clone(sendOutOrder);
		sendOutOrder.setOrderId(order.getId());
		sendOutOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		sendOutOrder.setGmtModified(dateProvider.getCurrentTime()); 
		
		for(OrderItemDTO orderItem : order.getOrderItems()) {
			SendOutOrderItemDTO sendOutOrderItem = orderItem.clone(SendOutOrderItemDTO.class);
			sendOutOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
			sendOutOrder.getSendOutOrderItems().add(sendOutOrderItem);
		}

		saleDeliveryOrder.setSendOutOrder(sendOutOrder);
		
		return this;
	}
	
	/**
	 * 创建物流单
	 * @param order 订单
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder createLogisticOrder(
			OrderInfoDTO order) throws Exception {
		
		
		return this;
	}
	
	/**
	 * 初始化销售出库单的状态
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder initStatus() throws Exception {
		return this;
	}
	
	/**
	 * 初始化时间相关的字段
	 * @return 销售出库单builder
	 */
	public SaleDeliveryOrderBuilder initTimes() throws Exception {
		return this;
	}
	
	/**
	 * 创建最终构造好的销售出库单
	 * @return 销售出库单
	 */
	public SaleDeliveryOrderDTO create() throws Exception {
		return saleDeliveryOrder;
	}
	
}
