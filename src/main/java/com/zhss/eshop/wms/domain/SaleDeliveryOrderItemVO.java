package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单条目
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderItemVO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 销售出库单id
	 */
	private Long saleDeliveryOrderId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku编号
	 */
	private String goodsSkuCode;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品sku的销售属性
	 */
	private String saleProperties;
	/**
	 * 商品毛重
	 */
	private Double goodsGrossWeight;
	/**
	 * 购买数量
	 */
	private Long purchaseQuantity;
	/**
	 * 购买价格
	 */
	private Double purchasePrice;
	/**
	 * 使用的促销活动的id
	 */
	private Long promotionActivityId;
	/**
	 * 商品长度
	 */
	private Double goodsLength;
	/**
	 * 商品宽度
	 */
	private Double goodsWidth;
	/**
	 * 商品高度
	 */
	private Double goodsHeight;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	/**
	 * 商品拣货条目
	 */
	private List<SaleDeliveryOrderPickingItemVO> pickingItems;
	/**
	 * 发货明细
	 */
	private List<SaleDeliveryOrderSendOutDetailVO> sendOutItems;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSaleDeliveryOrderId() {
		return saleDeliveryOrderId;
	}
	public void setSaleDeliveryOrderId(Long saleDeliveryOrderId) {
		this.saleDeliveryOrderId = saleDeliveryOrderId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	public String getGoodsSkuCode() {
		return goodsSkuCode;
	}
	public void setGoodsSkuCode(String goodsSkuCode) {
		this.goodsSkuCode = goodsSkuCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSaleProperties() {
		return saleProperties;
	}
	public void setSaleProperties(String saleProperties) {
		this.saleProperties = saleProperties;
	}
	public Double getGoodsGrossWeight() {
		return goodsGrossWeight;
	}
	public void setGoodsGrossWeight(Double goodsGrossWeight) {
		this.goodsGrossWeight = goodsGrossWeight;
	}
	public Long getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Long purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Long getPromotionActivityId() {
		return promotionActivityId;
	}
	public void setPromotionActivityId(Long promotionActivityId) {
		this.promotionActivityId = promotionActivityId;
	}
	public Double getGoodsLength() {
		return goodsLength;
	}
	public void setGoodsLength(Double goodsLength) {
		this.goodsLength = goodsLength;
	}
	public Double getGoodsWidth() {
		return goodsWidth;
	}
	public void setGoodsWidth(Double goodsWidth) {
		this.goodsWidth = goodsWidth;
	}
	public Double getGoodsHeight() {
		return goodsHeight;
	}
	public void setGoodsHeight(Double goodsHeight) {
		this.goodsHeight = goodsHeight;
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
	public List<SaleDeliveryOrderPickingItemVO> getPickingItems() {
		return pickingItems;
	}
	public void setPickingItems(List<SaleDeliveryOrderPickingItemVO> pickingItems) {
		this.pickingItems = pickingItems;
	}
	public List<SaleDeliveryOrderSendOutDetailVO> getSendOutItems() {
		return sendOutItems;
	}
	public void setSendOutItems(List<SaleDeliveryOrderSendOutDetailVO> sendOutItems) {
		this.sendOutItems = sendOutItems;
	}
	
	@Override
	public String toString() {
		return "SaleDeliveryOrderItemVO [id=" + id + ", saleDeliveryOrderId=" + saleDeliveryOrderId + ", goodsSkuId="
				+ goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName + ", saleProperties="
				+ saleProperties + ", goodsGrossWeight=" + goodsGrossWeight + ", purchaseQuantity=" + purchaseQuantity
				+ ", purchasePrice=" + purchasePrice + ", promotionActivityId=" + promotionActivityId + ", goodsLength="
				+ goodsLength + ", goodsWidth=" + goodsWidth + ", goodsHeight=" + goodsHeight + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", pickingItems=" + pickingItems + ", sendOutItems="
				+ sendOutItems + "]";
	}
	
}
