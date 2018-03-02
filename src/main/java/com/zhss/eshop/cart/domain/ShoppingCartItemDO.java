package com.zhss.eshop.cart.domain;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.BeanCopierUtils;

/**
 * 购物车条目DO类
 * @author zhonghuashishan
 *
 */
public class ShoppingCartItemDO {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDO.class);

	/**
	 * id
	 */
	private Long id;
	/**
	 * 购物车id
	 */
	private Long shoppingCartId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 购买数量
	 */
	private Long purchaseQuantity;
	/**
	 * 购物车条目的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 购物车条目的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	public Long getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Long purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
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
		result = prime * result + ((purchaseQuantity == null) ? 0 : purchaseQuantity.hashCode());
		result = prime * result + ((shoppingCartId == null) ? 0 : shoppingCartId.hashCode());
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
		ShoppingCartItemDO other = (ShoppingCartItemDO) obj;
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
		if (purchaseQuantity == null) {
			if (other.purchaseQuantity != null)
				return false;
		} else if (!purchaseQuantity.equals(other.purchaseQuantity))
			return false;
		if (shoppingCartId == null) {
			if (other.shoppingCartId != null)
				return false;
		} else if (!shoppingCartId.equals(other.shoppingCartId))
			return false;
		return true;
	}
	
	public <T> T clone(Class<T> clazz) {
		T target = null;
		try {
			target = clazz.newInstance();
			BeanCopierUtils.copyProperties(this, target);  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return target;
	}
	
}
