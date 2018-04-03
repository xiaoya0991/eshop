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
	 * @throws Exception
	 */ 
	void remove(Long id) throws Exception;
	
	/**
	 * 更新购物车条目的购买数量
	 * @param id 购物车条目id
	 * @param purchaseQuantity 购买数量
	 * @return 处理结果
	 * @throws Exception
	 */
	void updatePurchaseQuantity(Long id, Long purchaseQuantity) throws Exception;
	
}
