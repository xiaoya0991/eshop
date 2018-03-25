package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.order.constant.OrderOperateType;
import com.zhss.eshop.order.dao.OrderOperateLogDAO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.service.impl.OrderOperateLogFactory;

/**
 * 会自动记录日志的订单状态管理器
 * @author zhonghuashishan
 *
 */
@Component
public class LoggedOrderStateManager implements OrderStateManager {

	/**
	 * 订单状态管理器
	 */
	@Autowired
	private OrderStateManagerImpl orderStateManager;
	/**
	 * 订单操作日志DAO组件
	 */
	@Autowired
	private OrderOperateLogDAO orderOperateLogDAO;
	/**
	 * 订单操作内容工厂
	 */
	@Autowired
	private OrderOperateLogFactory orderOperateLogFactory;

	public void create(OrderInfoDTO order) throws Exception {
		orderStateManager.create(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.CREATE_ORDER));      
	}
	
	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		return orderStateManager.canCancel(order);
	}

	public void cancel(OrderInfoDTO order) throws Exception {
		orderStateManager.cancel(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.CANCEL_ORDER)); 
	}
	
	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return orderStateManager.canPay(order);
	}

	public void pay(OrderInfoDTO order) throws Exception {
		orderStateManager.pay(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.PAY_ORDER));  
	}

	public void finishDelivery(OrderInfoDTO order) throws Exception {
		orderStateManager.finishDelivery(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.GOODS_DELIVERY));  
	}

	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return orderStateManager.canConfirmReceipt(order);
	}

	public void confirmReceipt(OrderInfoDTO order) throws Exception {
		orderStateManager.confirmReceipt(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.CONFIRM_RECEIPT));  
	}

	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return orderStateManager.canApplyReturnGoods(order);
	}

	public void applyReturnGoods(OrderInfoDTO order) throws Exception {
		orderStateManager.applyReturnGoods(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.APPLY_RETURN_GOODS));  
	}

	public void rejectReturnGoodsApply(OrderInfoDTO order) throws Exception {
		orderStateManager.rejectReturnGoodsApply(order);
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.RETURN_GOODS_REJECTED));  
	}

	public void passedReturnGoodsApply(OrderInfoDTO order) throws Exception {
		orderStateManager.passedReturnGoodsApply(order);
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.RETURN_GOODS_APPROVED));  
	}

	public void sendOutReturnGoods(OrderInfoDTO order) throws Exception {
		orderStateManager.sendOutReturnGoods(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.SEND_OUT_RETURN_GOODS));  
	}

	public void confirmReceivedReturnGoods(OrderInfoDTO order) throws Exception {
		orderStateManager.confirmReceivedReturnGoods(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.CONFIRM_RETURN_GOODS_RECEIPT));  
	}

	public void finishedInputReturnGoods(OrderInfoDTO order) throws Exception {
		orderStateManager.finishedInputReturnGoods(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.FINISHED_RETURN_GOODS_INPUT));  
	}

	public void finishedRefund(OrderInfoDTO order) throws Exception {
		orderStateManager.finishedRefund(order); 
		orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.FINISHED_RETURN_GOODS_REFUND));  
	}
	
}
