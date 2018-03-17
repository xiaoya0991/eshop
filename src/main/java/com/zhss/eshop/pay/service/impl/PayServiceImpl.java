package com.zhss.eshop.pay.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.pay.service.PayService;

/**
 * 支付中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PayServiceImpl implements PayService {

	/**
	 * 获取支付二维码
	 * @param order 订单
	 * @return 支付二维码
	 */
	public String getQrCode(OrderInfoDTO order) {
		return null;
	}
	
}
