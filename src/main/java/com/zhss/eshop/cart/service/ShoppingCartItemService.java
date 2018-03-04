package com.zhss.eshop.cart.service;

/**
 * 购物车条目管理service组件
 * @author zhonghuashishan
 *
 */
public interface ShoppingCartItemService {

	/**
	 * 删除购物车条目
	 * @param id 购物车条目id
	 */ 
	Boolean remove(Long id);
	
	/**
	 * 更新购物车条目的购买数量
	 * @param id 购物车条目id
	 * @param purchaseQuantity 购买数量
	 * @return 处理结果
	 */
	Boolean updatePurchaseQuantity(Long id, Long purchaseQuantity);
	
}
