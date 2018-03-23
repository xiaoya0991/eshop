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
	
	/**
	 * 判断订单能否执行支付操作
	 * @param order 订单
	 * @return 能否执行支付操作
	 * @throws Exception
	 */
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return false;
	}

	/**
	 * 判断能否执行手动确认收货的操作
	 * @param order 订单
	 * @return 能否执行手动确认收货的操作
	 * @throws Exception
	 */
	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断能否申请退货
	 * @param order 订单
	 * @return 能否申请退货
	 * @throws Exception
	 */
	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return false;
	}
	
}
