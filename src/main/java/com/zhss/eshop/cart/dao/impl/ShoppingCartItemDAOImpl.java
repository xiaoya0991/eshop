package com.zhss.eshop.cart.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.cart.dao.ShoppingCartItemDAO;
import com.zhss.eshop.cart.domain.ShoppingCartItemDO;
import com.zhss.eshop.cart.mapper.ShoppingCartItemMapper;

/**
 * 购物车条目管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ShoppingCartItemDAOImpl implements ShoppingCartItemDAO {
	
	/**
	 * 购物车条目管理模块的mapper组件
	 */
	@Autowired
	private ShoppingCartItemMapper shoppingCartItemMapper;
	
	/**
	 * 新增购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Override
	public Long saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) throws Exception {
		shoppingCartItemMapper.saveShoppingCartItem(shoppingCartItemDO); 
		return shoppingCartItemDO.getId();
	}
	
	/**
	 * 根据商品sku id查询购物车中是否存在商品条目
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @return 商品条目
	 */
	@Override
	public ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
			Long shoppingCartId,Long goodsSkuId) throws Exception {
		return shoppingCartItemMapper.getShoppingCartItemByGoodsSkuId(
				shoppingCartId, goodsSkuId);
	}
	
	/**
	 * 更新购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Override
	public void updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) throws Exception {
		shoppingCartItemMapper.updateShoppingCartItem(shoppingCartItemDO); 
	}
	
	/**
	 * 查询购物车中的所有条目
	 * @param shoppingCartId 购物车id
	 * @return 商品条目
	 */
	@Override
	public List<ShoppingCartItemDO> listShoppingCartItemByCartId(Long shoppingCartId) throws Exception {
		return shoppingCartItemMapper.listShoppingCartItemByCartId(shoppingCartId);
	}
	
	/**
	 * 删除购物车条目
	 * @param id 购物车条目id
	 */ 
	@Override
	public void remove(Long id) throws Exception {
		shoppingCartItemMapper.remove(id);
	}
	
}
