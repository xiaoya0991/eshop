package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 默认的订单状态组件
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultOrderState extends AbstractOrderState {

	@Autowired
	public DefaultOrderState(DateProvider dateProvider,
			@Qualifier("orderInfoDAOImpl") OrderInfoDao orderInfoDAO) {
		super(dateProvider, orderInfoDAO);
	}
	
	@Override
	protected Integer getOrderStatus(OrderInfoDTO order) {
		return OrderStatus.UNKNOWN;
	}
	
}
