package com.zhss.eshop.pay.api;

import java.util.Date;

/**
 * 查询支付状态的响应结果
 * @author zhonghuashishan
 *
 */
public class QueryPayStatusResponse {

	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 用户支付账号
	 */
	private String userPayAccount;
	/**
	 * 第三方支付交易流水号
	 */
	private String transactionNumber;
	/**
	 * 第三方支付完成支付的时间
	 */
	private Date finishPayTime;
	/**
	 * 第三方支付响应状态码
	 */
	private String responseCode;
	/**
	 * 支付交易状态
	 */
	private Integer payTransactionStatus;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserPayAccount() {
		return userPayAccount;
	}
	public void setUserPayAccount(String userPayAccount) {
		this.userPayAccount = userPayAccount;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Date getFinishPayTime() {
		return finishPayTime;
	}
	public void setFinishPayTime(Date finishPayTime) {
		this.finishPayTime = finishPayTime;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public Integer getPayTransactionStatus() {
		return payTransactionStatus;
	}
	public void setPayTransactionStatus(Integer payTransactionStatus) {
		this.payTransactionStatus = payTransactionStatus;
	}
	
}
