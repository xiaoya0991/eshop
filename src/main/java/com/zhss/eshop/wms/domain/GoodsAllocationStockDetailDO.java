package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 货位库存明细
 * @author zhonghuashishan
 *
 */
public class GoodsAllocationStockDetailDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 货位id
	 */
	private Long goodsAllocationId;
	/**
	 * 这一批商品的上架时间
	 */
	private Date putOnTime;
	/**
	 * 这一批商品本次上架的数量
	 */
	private Long putOnQuantity;
	/**
	 * 这一批上架的商品当前还剩余的库存数量
	 */
	private Long currentStockQuantity;
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
	public Long getGoodsAllocationId() {
		return goodsAllocationId;
	}
	public void setGoodsAllocationId(Long goodsAllocationId) {
		this.goodsAllocationId = goodsAllocationId;
	}
	public Date getPutOnTime() {
		return putOnTime;
	}
	public void setPutOnTime(Date putOnTime) {
		this.putOnTime = putOnTime;
	}
	public Long getPutOnQuantity() {
		return putOnQuantity;
	}
	public void setPutOnQuantity(Long putOnQuantity) {
		this.putOnQuantity = putOnQuantity;
	}
	public Long getCurrentStockQuantity() {
		return currentStockQuantity;
	}
	public void setCurrentStockQuantity(Long currentStockQuantity) {
		this.currentStockQuantity = currentStockQuantity;
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
