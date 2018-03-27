package com.zhss.eshop.pay.api;

/**
 * 支付宝接口
 * @author zhonghuashishan
 *
 */
public interface PayApi {

	/**
	 * 预创建支付订单：获取用于支付的二维码
	 * @param transacionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @param totalAmount 订单总金额
	 * @return 支付二维码
	 * @throws Exception
	 */
	String getQrCode(Integer transactionChannel, 
			String orderNo, Double totalAmount) throws Exception;
	
	/**
	 * 查询支付状态
	 * @param transacionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @return 支付状态
	 * @throws Exception
	 */
	QueryPayStatusResponse queryPayStatus(Integer transactionChannel, 
			String orderNo) throws Exception;

	/**
	 * 退款
	 * @param transactionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @param refundAmount 退款金额
	 * @return 退款结果
	 * @throws Exception
	 */
	Boolean refund(Integer transactionChannel, 
			String orderNo, Double refundAmount) throws Exception;
	
}
