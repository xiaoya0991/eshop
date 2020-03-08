package com.zhss.eshop.cart.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.cart.dao.ShoppingCartDAO;
import com.zhss.eshop.cart.domain.ShoppingCartDO;
import com.zhss.eshop.cart.mapper.ShoppingCartMapper;

/**
 * 购物车管理模块的DAO组件
 *
 * @author zhonghuashishan
 */
@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    /**
     * 购物车管理模块的mapper组件
     */
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    /**
     * 根据用户账号id查询购物车
     *
     * @param userAccountId 用户账号id
     * @return 购物车
     */
    @Override
    public ShoppingCartDO getShoppingCartByUserAccountId(Long userAccountId) {
        return shoppingCartMapper.getShoppingCartByUserAccountId(userAccountId);
    }

    /**
     * 新增购物车
     *
     * @param shoppingCartDO 购物车DO对象
     */
    @Override
    public Long saveShoppingCart(ShoppingCartDO shoppingCartDO) {
        shoppingCartMapper.saveShoppingCart(shoppingCartDO);
        return shoppingCartDO.getId();
    }

}
