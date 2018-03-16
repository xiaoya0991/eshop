package com.zhss.eshop.commodity.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品sku
 * @author zhonghuashishan
 *
 */
public class GoodsSkuDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品sku编号
	 */
	private String skuCode;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品毛重
	 */
	private Double grossWeight;
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
	 * 商品sku编号
	 */
	private String goodsSkuCode;
	/**
	 * 销售属性
	 */
	private String saleProperties;
	/**
	 * 采购价格
	 */
	private Double purchasePrice;
	/**
	 * 销售价格
	 */
	private Double salePrice;
	/**
	 * 折扣价格
	 */
	private Double discountPrice;
	/**
	 * 销售库存
	 */
	private Long saleStockQuantity;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改文件
	 */
	private Date gmtModified;
	/**
	 * 销售属性值
	 */
	List<GoodsSkuSalePropertyValueDTO> propertyValues;
	
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsSkuCode() {
		return goodsSkuCode;
	}
	public void setGoodsSkuCode(String goodsSkuCode) {
		this.goodsSkuCode = goodsSkuCode;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
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
	public String getSaleProperties() {
		return saleProperties;
	}
	public void setSaleProperties(String saleProperties) {
		this.saleProperties = saleProperties;
	}
	public List<GoodsSkuSalePropertyValueDTO> getPropertyValues() {
		return propertyValues;
	}
	public void setPropertyValues(List<GoodsSkuSalePropertyValueDTO> propertyValues) {
		this.propertyValues = propertyValues;
	}
	public Long getSaleStockQuantity() {
		return saleStockQuantity;
	}
	public void setSaleStockQuantity(Long saleStockQuantity) {
		this.saleStockQuantity = saleStockQuantity;
	}
	
}
