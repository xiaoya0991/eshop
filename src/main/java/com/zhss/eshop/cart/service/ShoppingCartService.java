package com.zhss.eshop.cart.service;

/**
 * 购物车管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface ShoppingCartService {

	/**
	 * 添加购物车商品条目
	 * @param userAccountId 用户账号id
	 * @param goodsSkuId 商品sku id
	 * @return 处理结果
	 */
	Boolean addShoppingCartItem(Long userAccountId, Long goodsSkuId);
	
}
