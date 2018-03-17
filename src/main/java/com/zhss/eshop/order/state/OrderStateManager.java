package com.zhss.eshop.order.state;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态管理器接口
 * @author zhonghuashishan
 *
 */
public interface OrderStateManager {

	/**
	 * 创建订单
	 * @param order 订单
	 * @throws Exception
	 */
	void create(OrderInfoDTO order) throws Exception;
	
	/**
	 * 订单能否执行取消操作
	 * @param order 订单
	 * @return 能否执行取消操作
	 * @throws Exception
	 */
	Boolean canCancel(OrderInfoDTO order) throws Exception;
	
	/**
	 * 执行取消订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	void cancel(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断订单能否进行支付操作
	 * @param order 订单
	 * @return 能否进行支付操作
	 * @throws Exception
	 */
	Boolean canPay(OrderInfoDTO order) throws Exception;
	
	/**
	 * 执行支付订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	void pay(OrderInfoDTO order) throws Exception;
	
}
