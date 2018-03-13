package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态工厂
 * @author zhonghuashishan
 *
 */
@Component
public class OrderStateFactory {

	/**
	 * 待付款状态组件
	 */
	@Autowired
	private WaitForPayOrderState waitiForPayOrderState;
	/**
	 * 已取消状态组件
	 */
	@Autowired
	private CanceledOrderState canceledOrderState;
	/**
	 * 默认的订单状态组件
	 */
	@Autowired
	private DefaultOrderState defaultOrderState;
	
	/**
	 * 获取订单状态组件
	 * @param order 订单
	 * @return 订单状态组件
	 * @throws Exception
	 */
	public OrderState get(OrderInfoDTO order) throws Exception {
		if(OrderStatus.WAIT_FOR_PAY.equals(order.getOrderStatus())) {
			return waitiForPayOrderState;
		} else if(OrderStatus.CANCELED.equals(order.getOrderStatus())) {
			return canceledOrderState;
		}
		return defaultOrderState;
	}
	
}
