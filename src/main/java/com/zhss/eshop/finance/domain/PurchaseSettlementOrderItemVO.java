package com.zhss.eshop.finance.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购结算单条目
 * @author zhonghuashishan
 *
 */
public class PurchaseSettlementOrderItemVO extends AbstractObject {

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
	
}
