package com.zhss.eshop.cart.domain;

/**
 * 增加购物车条目的参数
 * @author zhonghuashishan
 *
 */
public class AddShoppingCartItemQuery {

	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 商品sku id
	 */
	private Long goodsSkuId;
	
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	
}
