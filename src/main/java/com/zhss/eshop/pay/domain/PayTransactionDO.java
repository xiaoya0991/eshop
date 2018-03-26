package com.zhss.eshop.pay.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 支付交易流水
 * @author zhonghuashishan
 *
 */
public class PayTransactionDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单应付金额
	 */
	private Double payableAmount;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 用户支付账号
	 */
	private String userPayAccount;
	/**
	 * 交易渠道
	 */
	private Integer transactionChannel;
	/**
	 * 第三方支付交易编号
	 */
	private String transactionNumber;
	/**
	 * 第三方支付完成支付的时间
	 */
	private Date finishPayTime;
	/**
	 * 第三方支付的响应状态码
	 */
	private String responseCode;
	/**
	 * 支付交易状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUserPayAccount() {
		return userPayAccount;
	}
	public void setUserPayAccount(String userPayAccount) {
		this.userPayAccount = userPayAccount;
	}
	public Integer getTransactionChannel() {
		return transactionChannel;
	}
	public void setTransactionChannel(Integer transactionChannel) {
		this.transactionChannel = transactionChannel;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
