package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品sku的销售属性值
 * @author zhonghuashishan
 *
 */
public class GoodsSkuSalePropertyValueDTO extends AbstractObject {

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
	public String toString() {
		return "GoodsSkuSalePropertyValueDTO [id=" + id + ", goodsSkuId=" + goodsSkuId + ", relationId=" + relationId
				+ ", propertyValue=" + propertyValue + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ "]";
	}
	
}
