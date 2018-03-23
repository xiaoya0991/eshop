package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单发货明细
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderSendOutDetailVO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 销售出库单条目id
	 */
	private Long saleDeliveryOrderItemId;
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
	public Long getSaleDeliveryOrderItemId() {
		return saleDeliveryOrderItemId;
	}
	public void setSaleDeliveryOrderItemId(Long saleDeliveryOrderItemId) {
		this.saleDeliveryOrderItemId = saleDeliveryOrderItemId;
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
	
}
