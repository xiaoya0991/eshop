package com.zhss.eshop.logistics.api;

/**
 * 创建电子面单接口的响应结果
 * @author zhonghuashishan
 *
 */
public class CreateEOrderResponse {
	
	public static final Integer SUCCESS = 1;
	public static final Integer FAILURE = 0;

	/**
	 * 物流单号
	 */
	private String logisticCode;
	/**
	 * 物流单内容
	 */
	private String logisticOrderContent;
	/**
	 * 响应状态
	 */
	private Integer status;
	
	public String getLogisticCode() {
		return logisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
	public String getLogisticOrderContent() {
		return logisticOrderContent;
	}
	public void setLogisticOrderContent(String logisticOrderContent) {
		this.logisticOrderContent = logisticOrderContent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
