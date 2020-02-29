package com.zhss.eshop.order.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 退货商品待入库状态
 * @author zhonghuashishan
 *
 */
@Component
public class WaitForInputReturnGoodsOrderState extends AbstractOrderState {

	@Autowired
	public WaitForInputReturnGoodsOrderState(DateProvider dateProvider, OrderInfoDao orderInfoDAO) {
		super(dateProvider, orderInfoDAO);
	}

	@Override
	protected Integer getOrderStatus(OrderInfoDTO order) throws Exception {
		return OrderStatus.WAIT_FOR_INPUT_RETURN_GOODS;
	}

}
