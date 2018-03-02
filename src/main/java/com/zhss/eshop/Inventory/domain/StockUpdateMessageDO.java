package com.zhss.eshop.Inventory.domain;

import java.util.Date;

/**
 * 库存更新消息DO类
 * @author zhonghuashishan
 *
 */
public class StockUpdateMessageDO {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 库存更新消息id
	 */
	private String messageId;
	/**
	 * 库存更新操作
	 */
	private Integer operation;
	/**
	 * 参数对象：json格式
	 */
	private String parameter;
	/**
	 * 参数类型
	 */
	private String paramterClazz;
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
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Integer getOperation() {
		return operation;
	}
	public void setOperation(Integer operation) {
		this.operation = operation;
	}
	public String getParamterClazz() {
		return paramterClazz;
	}
	public void setParamterClazz(String paramterClazz) {
		this.paramterClazz = paramterClazz;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
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
