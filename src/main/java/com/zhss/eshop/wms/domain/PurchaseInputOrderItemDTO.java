package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购入库单条目DTO类
 * @author zhonghuashishan
 *
 */
public class PurchaseInputOrderItemDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 采购入库单id
	 */
	private Long purchaseInputOrderId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku的采购数量
	 */
	private Long purchaseCount;
	/**
	 * 商品sku的采购价格
	 */
	private Double purchasePrice;
	/**
	 * 商品sku到货后质检出来的合格商品数量
	 */
	private Long qualifiedCount;
	/**
	 * 商品sku实际到货的数量
	 */
	private Long arrivalCount;
	/**
	 * 采购入库单条目的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 采购入库单条目的修改时间
	 */
	private Date gmtModified;
	/**
	 * 采购入库单商品上架条目集合
	 */
	private List<PurchaseInputOrderPutOnItemDTO> putOnItemDTOs;
	/**
	 * 货位库存明细
	 */
	private List<GoodsAllocationStockDetailDTO> stockDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPurchaseInputOrderId() {
		return purchaseInputOrderId;
	}
	public void setPurchaseInputOrderId(Long purchaseInputOrderId) {
		this.purchaseInputOrderId = purchaseInputOrderId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	public Long getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(Long purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Long getQualifiedCount() {
		return qualifiedCount;
	}
	public void setQualifiedCount(Long qualifiedCount) {
		this.qualifiedCount = qualifiedCount;
	}
	public Long getArrivalCount() {
		return arrivalCount;
	}
	public void setArrivalCount(Long arrivalCount) {
		this.arrivalCount = arrivalCount;
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
	public List<PurchaseInputOrderPutOnItemDTO> getPutOnItemDTOs() {
		return putOnItemDTOs;
	}
	public void setPutOnItemDTOs(List<PurchaseInputOrderPutOnItemDTO> putOnItemDTOs) {
		this.putOnItemDTOs = putOnItemDTOs;
	}
	public List<GoodsAllocationStockDetailDTO> getStockDetails() {
		return stockDetails;
	}
	public void setStockDetails(List<GoodsAllocationStockDetailDTO> stockDetails) {
		this.stockDetails = stockDetails;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalCount == null) ? 0 : arrivalCount.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchaseCount == null) ? 0 : purchaseCount.hashCode());
		result = prime * result + ((purchaseInputOrderId == null) ? 0 : purchaseInputOrderId.hashCode());
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((putOnItemDTOs == null) ? 0 : putOnItemDTOs.hashCode());
		result = prime * result + ((qualifiedCount == null) ? 0 : qualifiedCount.hashCode());
		result = prime * result + ((stockDetails == null) ? 0 : stockDetails.hashCode());
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
		PurchaseInputOrderItemDTO other = (PurchaseInputOrderItemDTO) obj;
		if (arrivalCount == null) {
			if (other.arrivalCount != null) {
				return false;
			}
		} else if (!arrivalCount.equals(other.arrivalCount)) {
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
		if (purchaseCount == null) {
			if (other.purchaseCount != null) {
				return false;
			}
		} else if (!purchaseCount.equals(other.purchaseCount)) {
			return false;
		}
		if (purchaseInputOrderId == null) {
			if (other.purchaseInputOrderId != null) {
				return false;
			}
		} else if (!purchaseInputOrderId.equals(other.purchaseInputOrderId)) {
			return false;
		}
		if (purchasePrice == null) {
			if (other.purchasePrice != null) {
				return false;
			}
		} else if (!purchasePrice.equals(other.purchasePrice)) {
			return false;
		}
		if (putOnItemDTOs == null) {
			if (other.putOnItemDTOs != null) {
				return false;
			}
		} else if (!putOnItemDTOs.equals(other.putOnItemDTOs)) {
			return false;
		}
		if (qualifiedCount == null) {
			if (other.qualifiedCount != null) {
				return false;
			}
		} else if (!qualifiedCount.equals(other.qualifiedCount)) {
			return false;
		}
		if (stockDetails == null) {
			if (other.stockDetails != null) {
				return false;
			}
		} else if (!stockDetails.equals(other.stockDetails)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "PurchaseInputOrderItemDTO [id=" + id + ", purchaseInputOrderId=" + purchaseInputOrderId
				+ ", goodsSkuId=" + goodsSkuId + ", purchaseCount=" + purchaseCount + ", purchasePrice=" + purchasePrice
				+ ", qualifiedCount=" + qualifiedCount + ", arrivalCount=" + arrivalCount + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + ", putOnItemDTOs=" + putOnItemDTOs + ", stockDetails=" + stockDetails
				+ "]";
	}
	
}
