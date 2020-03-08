package com.zhss.eshop.cart.service;

import com.zhss.eshop.cart.domain.ShoppingCartDTO;

/**
 * 购物车管理模块的service组件接口
 *
 * @author zhonghuashishan
 */
public interface ShoppingCartService {

    /**
     * 添加购物车商品条目
     *
     * @param userAccountId 用户账号id
     * @param goodsSkuId    商品sku id
     * @return 处理结果
     * @throws Exception
     */
    void addShoppingCartItem(Long userAccountId, Long goodsSkuId);

    /**
     * 查看用户的购物车中的数据
     *
     * @param userAccountId 用户账号id
     * @return 购物车DTO对象
     * @throws Exception
     */
    ShoppingCartDTO getShoppingCartDTOByUserAccountId(Long userAccountId);

}
