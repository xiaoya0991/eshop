package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态管理器
 * @author zhonghuashishan
 *
 */
@Component
public class OrderStateManagerImpl implements OrderStateManager {

	/**
	 * 订单状态工厂
	 */
	@Autowired
	private OrderStateFactory orderStateFactory;
	/**
	 * 待付款状态
	 */
	@Autowired
	private WaitForPayOrderState waitForPayOrderState;
	/**
	 * 已取消状态
	 */
	@Autowired
	private CanceledOrderState canceledOrderState;
	/**
	 * 待发货状态
	 */
	@Autowired
	private WaitForDeliveryOrderState waitForDeliveryOrderState;
	
	/**
	 * 创建订单
	 * @param order 订单
	 * @throws Exception
	 */
	public void create(OrderInfoDTO order) throws Exception {
		waitForPayOrderState.doTransition(order);
	}
	
	/**
	 * 订单能否执行取消操作
	 * @param order 订单
	 * @return 能否执行取消操作
	 * @throws Exception
	 */
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		OrderState orderState = orderStateFactory.get(order);
		return orderState.canCancel(order);
	}
	
	/**
	 * 执行取消订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	public void cancel(OrderInfoDTO order) throws Exception {
		canceledOrderState.doTransition(order); 
	}
	
	/**
	 * 判断订单能否进行支付操作
	 * @param order 订单
	 * @return 能否进行支付操作
	 * @throws Exception
	 */
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		OrderState orderState = orderStateFactory.get(order);
		return orderState.canPay(order);
	}
	
	/**
	 * 执行支付订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	public void pay(OrderInfoDTO order) throws Exception {
		waitForDeliveryOrderState.doTransition(order); 
	}
	
}
