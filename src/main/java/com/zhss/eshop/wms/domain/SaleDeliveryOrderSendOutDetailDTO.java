package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单发货明细
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderSendOutDetailDTO extends AbstractObject {

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result
				+ ((goodsAllocationStockDetailId == null) ? 0 : goodsAllocationStockDetailId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((saleDeliveryOrderItemId == null) ? 0 : saleDeliveryOrderItemId.hashCode());
		result = prime * result + ((sendOutCount == null) ? 0 : sendOutCount.hashCode());
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
		SaleDeliveryOrderSendOutDetailDTO other = (SaleDeliveryOrderSendOutDetailDTO) obj;
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
		if (goodsAllocationStockDetailId == null) {
			if (other.goodsAllocationStockDetailId != null) {
				return false;
			}
		} else if (!goodsAllocationStockDetailId.equals(other.goodsAllocationStockDetailId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (saleDeliveryOrderItemId == null) {
			if (other.saleDeliveryOrderItemId != null) {
				return false;
			}
		} else if (!saleDeliveryOrderItemId.equals(other.saleDeliveryOrderItemId)) {
			return false;
		}
		if (sendOutCount == null) {
			if (other.sendOutCount != null) {
				return false;
			}
		} else if (!sendOutCount.equals(other.sendOutCount)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "SaleDeliveryOrderSendOutDetailDTO [id=" + id + ", saleDeliveryOrderItemId=" + saleDeliveryOrderItemId
				+ ", goodsAllocationStockDetailId=" + goodsAllocationStockDetailId + ", sendOutCount=" + sendOutCount
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
