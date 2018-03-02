package com.zhss.eshop.cart.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartItemDAOImpl.class);

	/**
	 * 购物车条目管理模块的mapper组件
	 */
	@Autowired
	private ShoppingCartItemMapper shoppingCartItemMapper;
	
	/**
	 * 新增购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	public Long saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {
		try {
			shoppingCartItemMapper.saveShoppingCartItem(shoppingCartItemDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return shoppingCartItemDO.getId();
	}
	
	/**
	 * 根据商品sku id查询购物车中是否存在商品条目
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @return 商品条目
	 */
	public ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
			Long shoppingCartId,Long goodsSkuId) {
		try {
			return shoppingCartItemMapper.getShoppingCartItemByGoodsSkuId(
					shoppingCartId, goodsSkuId);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
	/**
	 * 更新购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	public Boolean updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO) {
		try {
			shoppingCartItemMapper.updateShoppingCartItem(shoppingCartItemDO); 
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
		return true;
	}
	
	/**
	 * 查询购物车中的所有条目
	 * @param shoppingCartId 购物车id
	 * @return 商品条目
	 */
	public List<ShoppingCartItemDO> listShoppingCartItemByCartId(Long shoppingCartId) {
		try {
			return shoppingCartItemMapper.listShoppingCartItemByCartId(shoppingCartId);
		} catch (Exception e) {
			logger.error("error", e); 
		}
		return null;
	}
	
}
