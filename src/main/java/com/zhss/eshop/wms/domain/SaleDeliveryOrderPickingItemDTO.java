package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单拣货条目
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderPickingItemDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 销售出库单条目id
	 */
	private Long saleDeliveryOrderItemId;
	/**
	 * 货位id
	 */
	private Long goodsAllocationId;
	/**
	 * 拣货数量
	 */
	private Long pickingCount;
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
	public Long getGoodsAllocationId() {
		return goodsAllocationId;
	}
	public void setGoodsAllocationId(Long goodsAllocationId) {
		this.goodsAllocationId = goodsAllocationId;
	}
	public Long getPickingCount() {
		return pickingCount;
	}
	public void setPickingCount(Long pickingCount) {
		this.pickingCount = pickingCount;
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
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsAllocationId == null) ? 0 : goodsAllocationId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pickingCount == null) ? 0 : pickingCount.hashCode());
		result = prime * result + ((saleDeliveryOrderItemId == null) ? 0 : saleDeliveryOrderItemId.hashCode());
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
		SaleDeliveryOrderPickingItemDTO other = (SaleDeliveryOrderPickingItemDTO) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pickingCount == null) {
			if (other.pickingCount != null)
				return false;
		} else if (!pickingCount.equals(other.pickingCount))
			return false;
		if (saleDeliveryOrderItemId == null) {
			if (other.saleDeliveryOrderItemId != null)
				return false;
		} else if (!saleDeliveryOrderItemId.equals(other.saleDeliveryOrderItemId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SaleDeliveryOrderPickingItemDTO [id=" + id + ", saleDeliveryOrderItemId=" + saleDeliveryOrderItemId
				+ ", goodsAllocationId=" + goodsAllocationId + ", pickingCount=" + pickingCount + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
