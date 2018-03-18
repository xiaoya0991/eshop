package com.zhss.eshop.schedule.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 调度中心的货位库存明细
 * @author zhonghuashishan
 *
 */
public class ScheduleGoodsAllocationStockDetailDO extends AbstractObject {

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
	 * 上架时间
	 */
	private Date putOnTime;
	/**
	 * 上架数量
	 */
	private Long putOnQuantity;
	/**
	 * 当前剩余库存数量
	 */
	private Long currentStockQuantity;
	/**
	 * 当前锁定的库存数量
	 */
	private Long lockedStockQuantity;
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
	public Long getLockedStockQuantity() {
		return lockedStockQuantity;
	}
	public void setLockedStockQuantity(Long lockedStockQuantity) {
		this.lockedStockQuantity = lockedStockQuantity;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentStockQuantity == null) ? 0 : currentStockQuantity.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsAllocationId == null) ? 0 : goodsAllocationId.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lockedStockQuantity == null) ? 0 : lockedStockQuantity.hashCode());
		result = prime * result + ((putOnQuantity == null) ? 0 : putOnQuantity.hashCode());
		result = prime * result + ((putOnTime == null) ? 0 : putOnTime.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleGoodsAllocationStockDetailDO other = (ScheduleGoodsAllocationStockDetailDO) obj;
		if (currentStockQuantity == null) {
			if (other.currentStockQuantity != null)
				return false;
		} else if (!currentStockQuantity.equals(other.currentStockQuantity))
			return false;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (goodsAllocationId == null) {
			if (other.goodsAllocationId != null)
				return false;
		} else if (!goodsAllocationId.equals(other.goodsAllocationId))
			return false;
		if (goodsSkuId == null) {
			if (other.goodsSkuId != null)
				return false;
		} else if (!goodsSkuId.equals(other.goodsSkuId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lockedStockQuantity == null) {
			if (other.lockedStockQuantity != null)
				return false;
		} else if (!lockedStockQuantity.equals(other.lockedStockQuantity))
			return false;
		if (putOnQuantity == null) {
			if (other.putOnQuantity != null)
				return false;
		} else if (!putOnQuantity.equals(other.putOnQuantity))
			return false;
		if (putOnTime == null) {
			if (other.putOnTime != null)
				return false;
		} else if (!putOnTime.equals(other.putOnTime))
			return false;
		return true;
	}
	
}
