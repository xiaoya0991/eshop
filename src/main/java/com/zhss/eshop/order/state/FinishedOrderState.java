package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 已完成状态
 * @author zhonghuashishan
 *
 */
@Component
public class FinishedOrderState extends AbstractOrderState {

	@Autowired
	public FinishedOrderState(DateProvider dateProvider,
			@Qualifier("orderInfoDAOImpl") OrderInfoDao orderInfoDAO) {
		super(dateProvider, orderInfoDAO);
	}

	@Override
	protected Integer getOrderStatus(OrderInfoDTO order){
		return OrderStatus.FINISHED;
	}
	
	@Override
	public Boolean canApplyReturnGoods(OrderInfoDTO order) {
		return true;
	}

}
