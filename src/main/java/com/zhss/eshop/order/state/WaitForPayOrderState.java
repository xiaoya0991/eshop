package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 待付款状态
 * @author zhonghuashishan
 *
 */
@Component
public class WaitForPayOrderState extends AbstractOrderState {

	@Autowired
	public WaitForPayOrderState(DateProvider dateProvider, OrderInfoDao orderInfoDAO) {
		super(dateProvider, orderInfoDAO);
	}

	@Override
	protected Integer getOrderStatus(OrderInfoDTO order)  {
		return OrderStatus.WAIT_FOR_PAY;
	}
	
	@Override
	public Boolean canPay(OrderInfoDTO order)  {
		return true;
	}
	
	@Override
	public Boolean canCancel(OrderInfoDTO order)  {
		return true;
	}

}
