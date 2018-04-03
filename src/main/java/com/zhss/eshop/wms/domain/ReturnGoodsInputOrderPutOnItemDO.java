package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货入库单商品上架条目
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsInputOrderPutOnItemDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 退货入库单条目id
	 */
	private Long returnGoodsInputOrderItemId;
	/**
	 * 货位id
	 */
	private Long goodsAllocationId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品上架数量
	 */
	private Long putOnShelvesCount;
	/**
	 * 退货入库单商品上架条目的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 退货入库单商品上架条目的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReturnGoodsInputOrderItemId() {
		return returnGoodsInputOrderItemId;
	}
	public void setReturnGoodsInputOrderItemId(Long returnGoodsInputOrderItemId) {
		this.returnGoodsInputOrderItemId = returnGoodsInputOrderItemId;
	}
	public Long getGoodsAllocationId() {
		return goodsAllocationId;
	}
	public void setGoodsAllocationId(Long goodsAllocationId) {
		this.goodsAllocationId = goodsAllocationId;
	}
	public Long getPutOnShelvesCount() {
		return putOnShelvesCount;
	}
	public void setPutOnShelvesCount(Long putOnShelvesCount) {
		this.putOnShelvesCount = putOnShelvesCount;
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
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsAllocationId == null) ? 0 : goodsAllocationId.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((putOnShelvesCount == null) ? 0 : putOnShelvesCount.hashCode());
		result = prime * result + ((returnGoodsInputOrderItemId == null) ? 0 : returnGoodsInputOrderItemId.hashCode());
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
		ReturnGoodsInputOrderPutOnItemDO other = (ReturnGoodsInputOrderPutOnItemDO) obj;
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
		if (goodsAllocationId == null) {
			if (other.goodsAllocationId != null) {
				return false;
			}
		} else if (!goodsAllocationId.equals(other.goodsAllocationId)) {
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
		if (putOnShelvesCount == null) {
			if (other.putOnShelvesCount != null) {
				return false;
			}
		} else if (!putOnShelvesCount.equals(other.putOnShelvesCount)) {
			return false;
		}
		if (returnGoodsInputOrderItemId == null) {
			if (other.returnGoodsInputOrderItemId != null) {
				return false;
			}
		} else if (!returnGoodsInputOrderItemId.equals(other.returnGoodsInputOrderItemId)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "ReturnGoodsInputOrderPutOnItemDO [id=" + id + ", returnGoodsInputOrderItemId="
				+ returnGoodsInputOrderItemId + ", goodsAllocationId=" + goodsAllocationId + ", goodsSkuId="
				+ goodsSkuId + ", putOnShelvesCount=" + putOnShelvesCount + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
