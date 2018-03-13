package com.zhss.eshop.order.state;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态
 * @author zhonghuashishan
 *
 */
public interface OrderState {

	/**
	 * 订单流转到当前这个状态
	 * @param order 订单
	 */
	void doTransition(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断当前状态下能否执行取消订单操作
	 * @param order 订单
	 * @return 能否执行取消订单操作
	 */
	Boolean canCancel(OrderInfoDTO order) throws Exception;
	
}
