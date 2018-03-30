package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品sku
 * @author zhonghuashishan
 *
 */
public class GoodsSkuDO extends AbstractObject {

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
	 * 商品sku的采购价格
	 */
	private Double purchasePrice;
	/**
	 * 商品sku的销售价格
	 */
	private Double salePrice;
	/**
	 * 商品sku的促销价格
	 */
	private Double discountPrice;
	/**
	 * 销售属性
	 */
	private String saleProperties;
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
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
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
	public String getSaleProperties() {
		return saleProperties;
	}
	public void setSaleProperties(String saleProperties) {
		this.saleProperties = saleProperties;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((salePrice == null) ? 0 : salePrice.hashCode());
		result = prime * result + ((saleProperties == null) ? 0 : saleProperties.hashCode());
		result = prime * result + ((skuCode == null) ? 0 : skuCode.hashCode());
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
		GoodsSkuDO other = (GoodsSkuDO) obj;
		if (discountPrice == null) {
			if (other.discountPrice != null) {
				return false;
			}
		} else if (!discountPrice.equals(other.discountPrice)) {
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
		if (goodsId == null) {
			if (other.goodsId != null) {
				return false;
			}
		} else if (!goodsId.equals(other.goodsId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (purchasePrice == null) {
			if (other.purchasePrice != null) {
				return false;
			}
		} else if (!purchasePrice.equals(other.purchasePrice)) {
			return false;
		}
		if (salePrice == null) {
			if (other.salePrice != null) {
				return false;
			}
		} else if (!salePrice.equals(other.salePrice)) {
			return false;
		}
		if (saleProperties == null) {
			if (other.saleProperties != null) {
				return false;
			}
		} else if (!saleProperties.equals(other.saleProperties)) {
			return false;
		}
		if (skuCode == null) {
			if (other.skuCode != null) {
				return false;
			}
		} else if (!skuCode.equals(other.skuCode)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "GoodsSkuDO [id=" + id + ", goodsId=" + goodsId + ", skuCode=" + skuCode + ", purchasePrice="
				+ purchasePrice + ", salePrice=" + salePrice + ", discountPrice=" + discountPrice + ", saleProperties="
				+ saleProperties + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
