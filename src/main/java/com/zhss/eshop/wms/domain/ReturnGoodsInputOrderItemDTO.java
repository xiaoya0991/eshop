package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货入库单条目DTO
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsInputOrderItemDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 退货入库单id
	 */
	private Long returnGoodsInputOrderId;
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
	 * 商品sku购买数量
	 */
	private Long purchaseQuantity;
	/**
	 * 商品sku购买价格
	 */
	private Double purchasePrice;
	/**
	 * 商品sku使用的促销活动id
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
	 * 退货商品到货后质检出来的合格商品数量
	 */
	private Long qualifiedCount;
	/**
	 * 退货商品的实际到货数量
	 */
	private Long arrivalCount;
	/**
	 * 退货入库单条目的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 退货入库单条目的修改时间
	 */
	private Date gmtModified;
	/**
	 * 退货入库单商品上架条目DTO集合
	 */
	private List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems;
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
	public Long getReturnGoodsInputOrderId() {
		return returnGoodsInputOrderId;
	}
	public void setReturnGoodsInputOrderId(Long returnGoodsInputOrderId) {
		this.returnGoodsInputOrderId = returnGoodsInputOrderId;
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
	public List<ReturnGoodsInputOrderPutOnItemDTO> getPutOnItems() {
		return putOnItems;
	}
	public void setPutOnItems(List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems) {
		this.putOnItems = putOnItems;
	}
	public List<GoodsAllocationStockDetailDTO> getStockDetails() {
		return stockDetails;
	}
	public void setStockDetails(List<GoodsAllocationStockDetailDTO> stockDetails) {
		this.stockDetails = stockDetails;
	}
	
	@Override
	public String toString() {
		return "ReturnGoodsInputOrderItemDTO [id=" + id + ", returnGoodsInputOrderId=" + returnGoodsInputOrderId
				+ ", goodsSkuId=" + goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName
				+ ", saleProperties=" + saleProperties + ", goodsGrossWeight=" + goodsGrossWeight
				+ ", purchaseQuantity=" + purchaseQuantity + ", purchasePrice=" + purchasePrice
				+ ", promotionActivityId=" + promotionActivityId + ", goodsLength=" + goodsLength + ", goodsWidth="
				+ goodsWidth + ", goodsHeight=" + goodsHeight + ", qualifiedCount=" + qualifiedCount + ", arrivalCount="
				+ arrivalCount + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", putOnItems="
				+ putOnItems + ", stockDetails=" + stockDetails + "]";
	}
	
}
