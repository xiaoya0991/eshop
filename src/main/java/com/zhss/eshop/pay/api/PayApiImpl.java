package com.zhss.eshop.pay.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.pay.constant.PayTransactionStatus;

/**
 * 支付宝接口
 * @author zhonghuashishan
 *
 */
@Component
public class PayApiImpl implements PayApi {
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 预创建支付订单：获取用于支付的二维码
	 * @param transacionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @param totalAmount 订单总金额
	 * @return 支付二维码
	 * @throws Exception
	 */
	@Override
	public String getQrCode(Integer transactionChannel, 
			String orderNo, Double totalAmount) throws Exception {
		// 根据交易渠道自己选择调用了远程的支付宝/微信支付的接口，同时指定了二维码的有效期是30分钟
		return UUID.randomUUID().toString().replace("-", ""); 
	}
	
	/**
	 * 查询支付状态
	 * @param transacionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @return 支付状态
	 * @throws Exception
	 */
	@Override
	public QueryPayStatusResponse queryPayStatus(Integer transactionChannel, 
			String orderNo) throws Exception {
		// 根据交易渠道选择调用支付宝或者微信支付的远程接口，根据订单号去查询支付状态
		// 接口里需要判断，当前支付的一个状态
		
		QueryPayStatusResponse response = new QueryPayStatusResponse();
		response.setUserPayAccount(UUID.randomUUID().toString().replace("-", "")); 
		response.setTransactionNumber(UUID.randomUUID().toString().replace("-", "")); 
		response.setResponseCode("SUCCESS");
		response.setFinishPayTime(dateProvider.getCurrentTime()); 
		response.setPayTransactionStatus(PayTransactionStatus.SUCCESS); 
		
		return response;
	}
	
	/**
	 * 退款
	 * @param transactionChannel 交易渠道
	 * @param orderNo 订单编号
	 * @param refundAmount 退款金额
	 * @return 退款结果
	 * @throws Exception
	 */
	@Override
	public Boolean refund(Integer transactionChannel, 
			String orderNo, Double refundAmount) throws Exception {
		// 根据交易渠道选择支付宝或者微信的api接口，去发送请求，申请退款
		// 根据退款的结果判断来返回true或者false
		// true就代表退款成功了，false就代表退款失败了
		return true;
	}
	
}
