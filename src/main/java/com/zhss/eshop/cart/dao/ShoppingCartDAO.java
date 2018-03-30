package com.zhss.eshop.cart.dao;

import com.zhss.eshop.cart.domain.ShoppingCartDO;

/**
 * 购物车管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface ShoppingCartDAO {

	/**
	 * 根据用户账号id查询购物车
	 * @param userAccountId 用户账号id
	 * @return 购物车
	 * @throws Exception
	 */
	ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId) throws Exception;
	
	/**
	 * 新增购物车
	 * @param shoppingCartDO 购物车DO对象
	 * @return 购物车id
	 * @throws Exception
	 */
	Long saveShoppingCart(ShoppingCartDO shoppingCartDO) throws Exception;
	
}
