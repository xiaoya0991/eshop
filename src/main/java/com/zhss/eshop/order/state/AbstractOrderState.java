package com.zhss.eshop.order.state;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractOrderState implements OrderState {

	/**
	 * 日期辅助组件
	 */
	protected DateProvider dateProvider;
	/**
	 * 订单管理DAO组件
	 */
	protected OrderInfoDAO orderInfoDAO;

	
	public AbstractOrderState(DateProvider dateProvider, OrderInfoDAO orderInfoDAO) {
		this.dateProvider = dateProvider;
		this.orderInfoDAO = orderInfoDAO;
	}
	
	/**
	 * 订单流转到当前这个状态
	 * @param order 订单
	 */
	@Override
	public void doTransition(OrderInfoDTO order) throws Exception {
		orderInfoDAO.updateStatus(order.getId(), getOrderStatus(order));  
	}
	
	/**
	 * 获取订单状态
	 * @param order 订单
	 * @return 订单状态
	 * @throws Exception
	 */
	protected abstract Integer getOrderStatus(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断当前状态下能否执行取消订单操作
	 * @param order 订单
	 * @return 能否执行取消订单操作
	 */
	@Override
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断订单能否执行支付操作
	 * @param order 订单
	 * @return 能否执行支付操作
	 * @throws Exception
	 */
	@Override
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断能否执行手动确认收货的操作
	 * @param order 订单
	 * @return 能否执行手动确认收货的操作
	 * @throws Exception
	 */
	@Override
	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return false;
	}
	
	/**
	 * 判断能否申请退货
	 * @param order 订单
	 * @return 能否申请退货
	 * @throws Exception
	 */
	@Override
	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return false;
	}
	
}
