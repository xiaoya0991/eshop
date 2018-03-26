package com.zhss.eshop.pay.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.pay.api.PayApi;
import com.zhss.eshop.pay.domain.PayTransactionBuilder;
import com.zhss.eshop.pay.domain.PayTransactionDTO;
import com.zhss.eshop.pay.service.PayService;
import com.zhss.eshop.pay.service.PayTransactionService;

/**
 * 支付中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PayServiceImpl implements PayService {
	
	private static final Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);

	/**
	 * 支付接口
	 */
	@Autowired
	private PayApi payApi;
	/**
	 * 支付交易流水管理service组件
	 */
	@Autowired
	private PayTransactionService payTransactionService;
	
	/**
	 * 获取支付二维码
	 * @param order 订单
	 * @return 支付二维码
	 */
	public String getQrCode(OrderInfoDTO order) {
		try {
			String qrCode = payApi.getQrCode(order.getPayType(), 
					order.getOrderNo(), order.getPayableAmount()); ;
			
			PayTransactionDTO payTransaction = PayTransactionBuilder.get()
					.buildOrderRelatedData(order) 
					.initStatus()
					.create();
			payTransactionService.save(payTransaction); 
			
			return qrCode;
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
}
