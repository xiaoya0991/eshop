package com.zhss.eshop.cart.domain;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.BeanCopierUtils;

/**
 * 购物车DTO类
 * @author zhonghuashishan
 *
 */
public class ShoppingCartDTO {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartDTO.class);

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
