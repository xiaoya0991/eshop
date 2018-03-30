package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态管理器
 * @author zhonghuashishan
 *
 */
@Component
public class OrderStateManagerImpl implements OrderStateManager {
	
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
	 * 待收货状态
	 */
	@Autowired
	private WaitForReceiveOrderState waitForReceiveOrderState;
	/**
	 * 已完成状态
	 */
	@Autowired
	private FinishedOrderState finishedOrderState;
	/**
	 * 等待退货申请审核状态
	 */
	@Autowired
	private WaitForReturnGoodsApproveOrderState waitForReturnGoodsApproveOrderState;
	/**
	 * 退货申请被拒状态
	 */
	@Autowired
	private ReturnGoodsRejectedOrderState returnGoodsRejectedOrderState;
	/**
	 * 待寄送退货商品状态
	 */
	@Autowired
	private WaitForSendOutReturnGoodsOrderState waitForSendOutReturnGoodsOrderState;
	/**
	 * 退货商品待收货状态
	 */
	@Autowired
	private WaitForReceiveReturnGoodsOrderState waitForReceiveReturnGoodsOrderState;
	/**
	 * 退货商品待入库状态
	 */
	@Autowired
	private WaitForInputReturnGoodsOrderState waitForInputReturnGoodsOrderState;
	/**
	 * 完成退货入库状态
	 */
	@Autowired
	private FinishedInputReturnGoodsOrderState finishedInputReturnGoodsOrderState;
	/**
	 * 完成退款状态
	 */
	@Autowired
	private FinishedRefundOrderState finishedRefundOrderState;
	/**
	 * 默认状态
	 */
	@Autowired
	private DefaultOrderState defaultOrderState;
	
	/**
	 * 创建订单
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void create(OrderInfoDTO order) throws Exception {
		waitForPayOrderState.doTransition(order);
	}
	
	/**
	 * 订单能否执行取消操作
	 * @param order 订单
	 * @return 能否执行取消操作
	 * @throws Exception
	 */
	@Override
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		return getOrderState(order).canCancel(order);
	}
	
	/**
	 * 执行取消订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void cancel(OrderInfoDTO order) throws Exception {
		canceledOrderState.doTransition(order); 
	}
	
	/**
	 * 判断订单能否进行支付操作
	 * @param order 订单
	 * @return 能否进行支付操作
	 * @throws Exception
	 */
	@Override
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return getOrderState(order).canPay(order);
	}
	
	/**
	 * 执行支付订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void pay(OrderInfoDTO order) throws Exception {
		waitForDeliveryOrderState.doTransition(order); 
	}
	
	/**
	 * 完成商品发货
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void finishDelivery(OrderInfoDTO order) throws Exception {
		waitForReceiveOrderState.doTransition(order); 
	}
	
	/**
	 * 判断能否执行确认收货的操作
	 * @param order 订单
	 * @return 能否执行手动确认收货的操作
	 * @throws Exception
	 */
	@Override
	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return getOrderState(order).canConfirmReceipt(order);
	}
	
	/**
	 * 确认收货
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void confirmReceipt(OrderInfoDTO order) throws Exception {
		finishedOrderState.doTransition(order);  
	}
	
	/**
	 * 判断能否申请退货
	 * @param order 订单
	 * @return 能否申请退货
	 * @throws Exception
	 */
	@Override
	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return getOrderState(order).canApplyReturnGoods(order);
	}
	
	/**
	 * 申请退货
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void applyReturnGoods(OrderInfoDTO order) throws Exception {
		waitForReturnGoodsApproveOrderState.doTransition(order); 
	}
	
	/**
	 * 拒绝退货申请
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void rejectReturnGoodsApply(OrderInfoDTO order) throws Exception {
		returnGoodsRejectedOrderState.doTransition(order); 
	}
	
	/**
	 * 退货申请审核通过
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void passedReturnGoodsApply(OrderInfoDTO order) throws Exception {
		waitForSendOutReturnGoodsOrderState.doTransition(order); 
	}
	
	/**
	 * 寄送退货商品
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void sendOutReturnGoods(OrderInfoDTO order) throws Exception {
		waitForReceiveReturnGoodsOrderState.doTransition(order); 
	}
	
	/**
	 * 确认收到退货商品
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void confirmReceivedReturnGoods(OrderInfoDTO order) throws Exception {
		waitForInputReturnGoodsOrderState.doTransition(order); 
	}
	
	/**
	 * 完成退货入库
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void finishedInputReturnGoods(OrderInfoDTO order) throws Exception {
		finishedInputReturnGoodsOrderState.doTransition(order); 
	}
	
	/**
	 * 完成退款
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void finishedRefund(OrderInfoDTO order) throws Exception {
		finishedRefundOrderState.doTransition(order); 
	}
	
	/**
	 * 获取订单状态组件
	 * @param order 订单
	 * @return 订单状态组件
	 * @throws Exception
	 */
	private OrderState getOrderState(OrderInfoDTO order) throws Exception {
		if(OrderStatus.WAIT_FOR_PAY.equals(order.getOrderStatus())) {
			return waitForPayOrderState;
		} else if(OrderStatus.CANCELED.equals(order.getOrderStatus())) {
			return canceledOrderState;
		} else if(OrderStatus.WAIT_FOR_DELIVERY.equals(order.getOrderStatus())) {
			return waitForDeliveryOrderState;
		} else if(OrderStatus.WAIT_FOR_RECEIVE.equals(order.getOrderStatus())) {
			return waitForReceiveOrderState;
		} else if(OrderStatus.FINISHED.equals(order.getOrderStatus())) {
			return finishedOrderState;
		} else if(OrderStatus.WAIT_FOR_RETURN_GOODS_APPROVE.equals(order.getOrderStatus())) {
			return waitForReturnGoodsApproveOrderState;
		}
		return defaultOrderState;
	}
	
}
