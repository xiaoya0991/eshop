package com.zhss.eshop.schedule.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 发货明细
 * @author zhonghuashishan
 *
 */
public class ScheduleOrderSendOutDetailDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 订单条目id
	 */
	private Long orderItemId;
	/**
	 * 货位库存明细id
	 */
	private Long goodsAllocationStockDetailId;
	/**
	 * 发货数量
	 */
	private Long sendOutCount;
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
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getGoodsAllocationStockDetailId() {
		return goodsAllocationStockDetailId;
	}
	public void setGoodsAllocationStockDetailId(Long goodsAllocationStockDetailId) {
		this.goodsAllocationStockDetailId = goodsAllocationStockDetailId;
	}
	public Long getSendOutCount() {
		return sendOutCount;
	}
	public void setSendOutCount(Long sendOutCount) {
		this.sendOutCount = sendOutCount;
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
		return "ScheduleOrderSendOutDetailDTO [id=" + id + ", orderInfoId=" + orderInfoId + ", orderItemId="
				+ orderItemId + ", goodsAllocationStockDetailId=" + goodsAllocationStockDetailId + ", sendOutCount="
				+ sendOutCount + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
