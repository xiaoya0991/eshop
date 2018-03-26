package com.zhss.eshop.logistics.api;

/**
 * 查询物流进度的请求
 * @author zhonghuashishan
 *
 */
public class QueryProgressRequest {

	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 物流单号
	 */
	private String logisticCode;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getLogisticCode() {
		return logisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
	
}
