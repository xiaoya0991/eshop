package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品sku的销售属性值
 * @author zhonghuashishan
 *
 */
public class GoodsSkuSalePropertyValueDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 类目与属性关联关系id
	 */
	private Long relationId;
	/**
	 * 属性值
	 */
	private String propertyValue;
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
	public Long getRelationId() {
		return relationId;
	}
	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((propertyValue == null) ? 0 : propertyValue.hashCode());
		result = prime * result + ((relationId == null) ? 0 : relationId.hashCode());
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
		GoodsSkuSalePropertyValueDO other = (GoodsSkuSalePropertyValueDO) obj;
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
		if (propertyValue == null) {
			if (other.propertyValue != null) {
				return false;
			}
		} else if (!propertyValue.equals(other.propertyValue)) {
			return false;
		}
		if (relationId == null) {
			if (other.relationId != null) {
				return false;
			}
		} else if (!relationId.equals(other.relationId)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "GoodsSkuSalePropertyValueDO [id=" + id + ", goodsSkuId=" + goodsSkuId + ", relationId=" + relationId
				+ ", propertyValue=" + propertyValue + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ "]";
	}
	
}
