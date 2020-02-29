package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 退货已入库状态
 * @author zhonghuashishan
 *
 */
@Component
public class FinishedInputReturnGoodsOrderState extends AbstractOrderState {

	@Autowired
	public FinishedInputReturnGoodsOrderState(DateProvider dateProvider,
			@Qualifier("orderInfoDAOImpl") OrderInfoDao orderInfoDAO) {
		super(dateProvider, orderInfoDAO);
	}
	
	@Override
	protected Integer getOrderStatus(OrderInfoDTO order) {
		return OrderStatus.FINISHED_INPUT_RETURN_GOODS;
	}

}
