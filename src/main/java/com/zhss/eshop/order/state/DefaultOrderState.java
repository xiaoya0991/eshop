package com.zhss.eshop.order.state;

import org.springframework.stereotype.Component;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 默认的订单状态组件
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultOrderState implements OrderState {

	/**
	 * 订单流转到当前这个状态
	 * @param order 订单
	 */
	public void doTransition(OrderInfoDTO order) throws Exception {
		
	}
	
	/**
	 * 判断当前状态下能否执行取消订单操作
	 * @param order 订单
	 * @return 能否执行取消订单操作
	 */
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		return false;
	}
	
}
