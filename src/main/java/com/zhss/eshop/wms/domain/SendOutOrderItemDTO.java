package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 返货单条目
 * @author zhonghuashishan
 *
 */
public class SendOutOrderItemDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 发货单id
	 */
	private Long sendOutOrderId;
	/**
	 * 商品id
	 */
	private Long goodsId;
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
	 * 商品长度
	 */
	private Double goodsLenght;
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
	public Double getGoodsLenght() {
		return goodsLenght;
	}
	public void setGoodsLenght(Double goodsLenght) {
		this.goodsLenght = goodsLenght;
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
	public Long getSendOutOrderId() {
		return sendOutOrderId;
	}
	public void setSendOutOrderId(Long sendOutOrderId) {
		this.sendOutOrderId = sendOutOrderId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	@Override
	public String toString() {
		return "SendOutOrderItemDTO [id=" + id + ", sendOutOrderId=" + sendOutOrderId + ", goodsId=" + goodsId
				+ ", goodsSkuId=" + goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName
				+ ", saleProperties=" + saleProperties + ", goodsGrossWeight=" + goodsGrossWeight
				+ ", purchaseQuantity=" + purchaseQuantity + ", purchasePrice=" + purchasePrice + ", goodsLenght="
				+ goodsLenght + ", goodsWidth=" + goodsWidth + ", goodsHeight=" + goodsHeight + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
