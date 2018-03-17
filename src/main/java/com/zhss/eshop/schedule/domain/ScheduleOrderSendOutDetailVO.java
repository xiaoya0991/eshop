package com.zhss.eshop.schedule.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 发货明细
 * @author zhonghuashishan
 *
 */
public class ScheduleOrderSendOutDetailVO extends AbstractObject {

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
	private Long sendOutQuantity;
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
	public Long getSendOutQuantity() {
		return sendOutQuantity;
	}
	public void setSendOutQuantity(Long sendOutQuantity) {
		this.sendOutQuantity = sendOutQuantity;
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
