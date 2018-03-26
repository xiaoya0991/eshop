package com.zhss.eshop.pay.domain;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.pay.constant.PayTransactionStatus;

/**
 * 支付交易流水builder
 * @author zhonghuashishan
 *
 */
public class PayTransactionBuilder {

	private PayTransactionBuilder() {
		
	}
	
	/**
	 * 获取builder实例
	 * @return
	 */
	public static PayTransactionBuilder get() {
		return new PayTransactionBuilder();
	}
	
	/**
	 * 支付交易流水
	 */
	private PayTransactionDTO payTransaction = new PayTransactionDTO();
	
	/**
	 * 构建订单相关的数据
	 * @param order 订单
	 * @return builder
	 * @throws Exception
	 */
	public PayTransactionBuilder buildOrderRelatedData(OrderInfoDTO order) throws Exception {
		payTransaction.setOrderInfoId(order.getId()); 
		payTransaction.setOrderNo(order.getOrderNo()); 
		payTransaction.setPayableAmount(order.getPayableAmount()); 
		payTransaction.setUserAccountId(order.getUserAccountId()); 
		payTransaction.setTransactionChannel(order.getPayType()); 
		return this;
	}
	
	/**
	 * 初始化状态
	 * @return builder
	 * @throws Exception
	 */
	public PayTransactionBuilder initStatus() throws Exception {
		payTransaction.setStatus(PayTransactionStatus.UNPAYED);
		return this;
	}
	
	/**
	 * 创建支付交易流水 
	 * @return 支付交易流水
	 * @throws Exception
	 */
	public PayTransactionDTO create() throws Exception {
		return payTransaction;
	}
	
}
