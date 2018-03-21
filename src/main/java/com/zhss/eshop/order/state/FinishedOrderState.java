package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 已完成状态
 * @author zhonghuashishan
 *
 */
@Component
public class FinishedOrderState implements OrderState {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	
	/**
	 * 订单流转到当前这个状态
	 * @param order 订单
	 */
	public void doTransition(OrderInfoDTO order) throws Exception {
		order.setOrderStatus(OrderStatus.FINISHED); 
		order.setGmtModified(dateProvider.getCurrentTime()); 
		orderInfoDAO.updateStatus(order.clone(OrderInfoDO.class));  
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

}
