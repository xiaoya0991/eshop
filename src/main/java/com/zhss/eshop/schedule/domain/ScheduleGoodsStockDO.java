package com.zhss.eshop.schedule.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品库存
 * @author zhonghuashishan
 *
 */
public class ScheduleGoodsStockDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 可用库存
	 */
	private Long availableStockQuantity;
	/**
	 * 锁定库存
	 */
	private Long lockedStockQuantity;
	/**
	 * 已出库库存
	 */
	private Long outputStockQuantity;
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
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	public Long getAvailableStockQuantity() {
		return availableStockQuantity;
	}
	public void setAvailableStockQuantity(Long availableStockQuantity) {
		this.availableStockQuantity = availableStockQuantity;
	}
	public Long getLockedStockQuantity() {
		return lockedStockQuantity;
	}
	public void setLockedStockQuantity(Long lockedStockQuantity) {
		this.lockedStockQuantity = lockedStockQuantity;
	}
	public Long getOutputStockQuantity() {
		return outputStockQuantity;
	}
	public void setOutputStockQuantity(Long outputStockQuantity) {
		this.outputStockQuantity = outputStockQuantity;
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
