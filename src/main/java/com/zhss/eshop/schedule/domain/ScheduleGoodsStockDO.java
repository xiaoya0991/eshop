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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableStockQuantity == null) ? 0 : availableStockQuantity.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lockedStockQuantity == null) ? 0 : lockedStockQuantity.hashCode());
		result = prime * result + ((outputStockQuantity == null) ? 0 : outputStockQuantity.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ScheduleGoodsStockDO other = (ScheduleGoodsStockDO) obj;
		if (availableStockQuantity == null) {
			if (other.availableStockQuantity != null) {
				return false;
			}
		} else if (!availableStockQuantity.equals(other.availableStockQuantity)) {
			return false;
		}
		if (gmtCreate == null) {
			if (other.gmtCreate != null) {
				return false;
			}
		} else if (!gmtCreate.equals(other.gmtCreate)) {
			return false;
		}
		if (gmtModified == null) {
			if (other.gmtModified != null) {
				return false;
			}
		} else if (!gmtModified.equals(other.gmtModified)) {
			return false;
		}
		if (goodsSkuId == null) {
			if (other.goodsSkuId != null) {
				return false;
			}
		} else if (!goodsSkuId.equals(other.goodsSkuId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lockedStockQuantity == null) {
			if (other.lockedStockQuantity != null) {
				return false;
			}
		} else if (!lockedStockQuantity.equals(other.lockedStockQuantity)) {
			return false;
		}
		if (outputStockQuantity == null) {
			if (other.outputStockQuantity != null) {
				return false;
			}
		} else if (!outputStockQuantity.equals(other.outputStockQuantity)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "ScheduleGoodsStockDO [id=" + id + ", goodsSkuId=" + goodsSkuId + ", availableStockQuantity="
				+ availableStockQuantity + ", lockedStockQuantity=" + lockedStockQuantity + ", outputStockQuantity="
				+ outputStockQuantity + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
