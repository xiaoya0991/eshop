package com.zhss.eshop.customer.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货工单
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsWorksheetVO extends AbstractObject {

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
	 * 退货工单的状态
	 */
	private Integer status;
	/**
	 * 退货原因
	 */
	private Integer returnGoodsReason;
	/**
	 * 退货备注
	 */
	private String returnGoodsRemark;
	/**
	 * 退货物流单号
	 */
	private String returnGoodsLogisticsCode;
	/**
	 * 退货工单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 退货工单的修改时间
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReturnGoodsReason() {
		return returnGoodsReason;
	}
	public void setReturnGoodsReason(Integer returnGoodsReason) {
		this.returnGoodsReason = returnGoodsReason;
	}
	public String getReturnGoodsRemark() {
		return returnGoodsRemark;
	}
	public void setReturnGoodsRemark(String returnGoodsRemark) {
		this.returnGoodsRemark = returnGoodsRemark;
	}
	public String getReturnGoodsLogisticsCode() {
		return returnGoodsLogisticsCode;
	}
	public void setReturnGoodsLogisticsCode(String returnGoodsLogisticsCode) {
		this.returnGoodsLogisticsCode = returnGoodsLogisticsCode;
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
	
	@Override
	public String toString() {
		return "ReturnGoodsWorksheetVO [id=" + id + ", orderInfoId=" + orderInfoId + ", orderNo=" + orderNo
				+ ", status=" + status + ", returnGoodsReason=" + returnGoodsReason + ", returnGoodsRemark="
				+ returnGoodsRemark + ", returnGoodsLogisticsCode=" + returnGoodsLogisticsCode + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
