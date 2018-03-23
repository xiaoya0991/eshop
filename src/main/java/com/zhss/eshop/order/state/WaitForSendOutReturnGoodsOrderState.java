package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 待寄送退货商品状态
 * @author zhonghuashishan
 *
 */
@Component
public class WaitForSendOutReturnGoodsOrderState implements OrderState {

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
	
	public void doTransition(OrderInfoDTO order) throws Exception {
		order.setOrderStatus(OrderStatus.WAIT_FOR_SEND_OUT_RETURN_GOODS); 
		order.setGmtModified(dateProvider.getCurrentTime()); 
		orderInfoDAO.updateStatus(order.clone(OrderInfoDO.class));  
	}

	public Boolean canCancel(OrderInfoDTO order) throws Exception {
		return false;
	}

	public Boolean canPay(OrderInfoDTO order) throws Exception {
		return false;
	}

	public Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception {
		return false;
	}

	public Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception {
		return false;
	}

}
