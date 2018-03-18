package com.zhss.eshop.pay.service;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 支付中心接口
 * @author zhonghuashishan
 *
 */
public interface PayService {

	/**
	 * 获取支付二维码
	 * @param order 订单
	 * @return 支付二维码
	 */
	String getQrCode(OrderInfoDTO order);
	
}
