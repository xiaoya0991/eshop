package com.zhss.eshop.finance.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购结算单条目
 * @author zhonghuashishan
 *
 */
public class PurchaseSettlementOrderItemDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 采购结算单id
	 */
	private Long purchaseSettlementOrderId;
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
	public Long getPurchaseSettlementOrderId() {
		return purchaseSettlementOrderId;
	}
	public void setPurchaseSettlementOrderId(Long purchaseSettlementOrderId) {
		this.purchaseSettlementOrderId = purchaseSettlementOrderId;
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
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((purchaseSettlementOrderId == null) ? 0 : purchaseSettlementOrderId.hashCode());
		result = prime * result + ((qualifiedCount == null) ? 0 : qualifiedCount.hashCode());
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
		PurchaseSettlementOrderItemDO other = (PurchaseSettlementOrderItemDO) obj;
		if (arrivalCount == null) {
			if (other.arrivalCount != null)
				return false;
		} else if (!arrivalCount.equals(other.arrivalCount))
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
		if (purchaseCount == null) {
			if (other.purchaseCount != null)
				return false;
		} else if (!purchaseCount.equals(other.purchaseCount))
			return false;
		if (purchasePrice == null) {
			if (other.purchasePrice != null)
				return false;
		} else if (!purchasePrice.equals(other.purchasePrice))
			return false;
		if (purchaseSettlementOrderId == null) {
			if (other.purchaseSettlementOrderId != null)
				return false;
		} else if (!purchaseSettlementOrderId.equals(other.purchaseSettlementOrderId))
			return false;
		if (qualifiedCount == null) {
			if (other.qualifiedCount != null)
				return false;
		} else if (!qualifiedCount.equals(other.qualifiedCount))
			return false;
		return true;
	}
	
}
