package com.zhss.eshop.cart.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 购物车DTO类
 * @author zhonghuashishan
 *
 */
public class ShoppingCartDTO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 购物车的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 购物车的修改时间
	 */
	private Date gmtModified;
	/**
	 * 购物车条目集合
	 */
	private List<ShoppingCartItemDTO> shoppingCartItemDTOs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
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
	public List<ShoppingCartItemDTO> getShoppingCartItemDTOs() {
		return shoppingCartItemDTOs;
	}
	public void setShoppingCartItemDTOs(List<ShoppingCartItemDTO> shoppingCartItemDTOs) {
		this.shoppingCartItemDTOs = shoppingCartItemDTOs;
	}
	
	@Override
	public String toString() {
		return "ShoppingCartDTO [id=" + id + ", userAccountId=" + userAccountId + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + ", shoppingCartItemDTOs=" + shoppingCartItemDTOs + "]";
	}
	
}
