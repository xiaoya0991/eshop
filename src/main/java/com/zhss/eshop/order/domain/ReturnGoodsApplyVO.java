package com.zhss.eshop.order.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货申请
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsApplyVO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 退货原因
	 */
	private Integer returnGoodsReason;
	/**
	 * 退货备注
	 */
	private String returnGoodsComment;
	/**
	 * 退货申请状态
	 */
	private Integer returnGoodsApplyStatus;
	/**
	 * 退货物流单号
	 */
	private String returnGoodsLogisticCode;
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
	public Integer getReturnGoodsReason() {
		return returnGoodsReason;
	}
	public void setReturnGoodsReason(Integer returnGoodsReason) {
		this.returnGoodsReason = returnGoodsReason;
	}
	public String getReturnGoodsComment() {
		return returnGoodsComment;
	}
	public void setReturnGoodsComment(String returnGoodsComment) {
		this.returnGoodsComment = returnGoodsComment;
	}
	public Integer getReturnGoodsApplyStatus() {
		return returnGoodsApplyStatus;
	}
	public void setReturnGoodsApplyStatus(Integer returnGoodsApplyStatus) {
		this.returnGoodsApplyStatus = returnGoodsApplyStatus;
	}
	public String getReturnGoodsLogisticCode() {
		return returnGoodsLogisticCode;
	}
	public void setReturnGoodsLogisticCode(String returnGoodsLogisticCode) {
		this.returnGoodsLogisticCode = returnGoodsLogisticCode;
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
