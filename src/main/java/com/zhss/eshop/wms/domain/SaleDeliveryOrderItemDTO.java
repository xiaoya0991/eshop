package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单条目
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderItemDTO extends AbstractObject {

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
	 * 拣货条目
	 */
	private List<SaleDeliveryOrderPickingItemDTO> pickingItems;
	/**
	 * 发货明细
	 */
	private List<SaleDeliveryOrderSendOutDetailDTO> sendOutItems;
	
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
	public List<SaleDeliveryOrderPickingItemDTO> getPickingItems() {
		return pickingItems;
	}
	public void setPickingItems(List<SaleDeliveryOrderPickingItemDTO> pickingItems) {
		this.pickingItems = pickingItems;
	}
	public List<SaleDeliveryOrderSendOutDetailDTO> getSendOutItems() {
		return sendOutItems;
	}
	public void setSendOutItems(List<SaleDeliveryOrderSendOutDetailDTO> sendOutItems) {
		this.sendOutItems = sendOutItems;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsGrossWeight == null) ? 0 : goodsGrossWeight.hashCode());
		result = prime * result + ((goodsHeight == null) ? 0 : goodsHeight.hashCode());
		result = prime * result + ((goodsLength == null) ? 0 : goodsLength.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsSkuCode == null) ? 0 : goodsSkuCode.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((goodsWidth == null) ? 0 : goodsWidth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pickingItems == null) ? 0 : pickingItems.hashCode());
		result = prime * result + ((promotionActivityId == null) ? 0 : promotionActivityId.hashCode());
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((purchaseQuantity == null) ? 0 : purchaseQuantity.hashCode());
		result = prime * result + ((saleDeliveryOrderId == null) ? 0 : saleDeliveryOrderId.hashCode());
		result = prime * result + ((saleProperties == null) ? 0 : saleProperties.hashCode());
		result = prime * result + ((sendOutItems == null) ? 0 : sendOutItems.hashCode());
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
		SaleDeliveryOrderItemDTO other = (SaleDeliveryOrderItemDTO) obj;
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
		if (goodsGrossWeight == null) {
			if (other.goodsGrossWeight != null) {
				return false;
			}
		} else if (!goodsGrossWeight.equals(other.goodsGrossWeight)) {
			return false;
		}
		if (goodsHeight == null) {
			if (other.goodsHeight != null) {
				return false;
			}
		} else if (!goodsHeight.equals(other.goodsHeight)) {
			return false;
		}
		if (goodsLength == null) {
			if (other.goodsLength != null) {
				return false;
			}
		} else if (!goodsLength.equals(other.goodsLength)) {
			return false;
		}
		if (goodsName == null) {
			if (other.goodsName != null) {
				return false;
			}
		} else if (!goodsName.equals(other.goodsName)) {
			return false;
		}
		if (goodsSkuCode == null) {
			if (other.goodsSkuCode != null) {
				return false;
			}
		} else if (!goodsSkuCode.equals(other.goodsSkuCode)) {
			return false;
		}
		if (goodsSkuId == null) {
			if (other.goodsSkuId != null) {
				return false;
			}
		} else if (!goodsSkuId.equals(other.goodsSkuId)) {
			return false;
		}
		if (goodsWidth == null) {
			if (other.goodsWidth != null) {
				return false;
			}
		} else if (!goodsWidth.equals(other.goodsWidth)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (pickingItems == null) {
			if (other.pickingItems != null) {
				return false;
			}
		} else if (!pickingItems.equals(other.pickingItems)) {
			return false;
		}
		if (promotionActivityId == null) {
			if (other.promotionActivityId != null) {
				return false;
			}
		} else if (!promotionActivityId.equals(other.promotionActivityId)) {
			return false;
		}
		if (purchasePrice == null) {
			if (other.purchasePrice != null) {
				return false;
			}
		} else if (!purchasePrice.equals(other.purchasePrice)) {
			return false;
		}
		if (purchaseQuantity == null) {
			if (other.purchaseQuantity != null) {
				return false;
			}
		} else if (!purchaseQuantity.equals(other.purchaseQuantity)) {
			return false;
		}
		if (saleDeliveryOrderId == null) {
			if (other.saleDeliveryOrderId != null) {
				return false;
			}
		} else if (!saleDeliveryOrderId.equals(other.saleDeliveryOrderId)) {
			return false;
		}
		if (saleProperties == null) {
			if (other.saleProperties != null) {
				return false;
			}
		} else if (!saleProperties.equals(other.saleProperties)) {
			return false;
		}
		if (sendOutItems == null) {
			if (other.sendOutItems != null) {
				return false;
			}
		} else if (!sendOutItems.equals(other.sendOutItems)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "SaleDeliveryOrderItemDTO [id=" + id + ", saleDeliveryOrderId=" + saleDeliveryOrderId + ", goodsSkuId="
				+ goodsSkuId + ", goodsSkuCode=" + goodsSkuCode + ", goodsName=" + goodsName + ", saleProperties="
				+ saleProperties + ", goodsGrossWeight=" + goodsGrossWeight + ", purchaseQuantity=" + purchaseQuantity
				+ ", purchasePrice=" + purchasePrice + ", promotionActivityId=" + promotionActivityId + ", goodsLength="
				+ goodsLength + ", goodsWidth=" + goodsWidth + ", goodsHeight=" + goodsHeight + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", pickingItems=" + pickingItems + ", sendOutItems="
				+ sendOutItems + ", getId()=" + getId() + ", getSaleDeliveryOrderId()=" + getSaleDeliveryOrderId()
				+ ", getGoodsSkuId()=" + getGoodsSkuId() + ", getGoodsSkuCode()=" + getGoodsSkuCode()
				+ ", getGoodsName()=" + getGoodsName() + ", getSaleProperties()=" + getSaleProperties()
				+ ", getGoodsGrossWeight()=" + getGoodsGrossWeight() + ", getPurchaseQuantity()="
				+ getPurchaseQuantity() + ", getPurchasePrice()=" + getPurchasePrice() + ", getPromotionActivityId()="
				+ getPromotionActivityId() + ", getGoodsLength()=" + getGoodsLength() + ", getGoodsWidth()="
				+ getGoodsWidth() + ", getGoodsHeight()=" + getGoodsHeight() + ", getGmtCreate()=" + getGmtCreate()
				+ ", getGmtModified()=" + getGmtModified() + ", getPickingItems()=" + getPickingItems()
				+ ", getSendOutItems()=" + getSendOutItems() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
}
