package com.zhss.eshop.cart.controller;

import java.util.ArrayList;
import java.util.List;

import com.zhss.eshop.result.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.cart.domain.AddShoppingCartItemQuery;
import com.zhss.eshop.cart.domain.ShoppingCartDTO;
import com.zhss.eshop.cart.domain.ShoppingCartItemDTO;
import com.zhss.eshop.cart.domain.ShoppingCartItemVO;
import com.zhss.eshop.cart.domain.ShoppingCartVO;
import com.zhss.eshop.cart.service.ShoppingCartService;

import javax.validation.Valid;

import static com.zhss.eshop.cart.controller.CartRouts.CART_ITEM_ADD;
import static com.zhss.eshop.cart.controller.CartRouts.CART_ITEM_VIEW;

/**
 * 购物车管理模块的controller组件
 *
 * @author zhonghuashishan
 */
@RestController
public class ShoppingCartController {

    /**
     * 购物车管理模块的service组件
     */
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping(CART_ITEM_ADD)
    @ApiOperation(value = "添加购物车商品条目", notes = "添加购物车商品条目")
    public JsonResult addShoppingCartItem(@RequestBody @Valid AddShoppingCartItemQuery query) {
        shoppingCartService.addShoppingCartItem(query.getUserAccountId(), query.getGoodsSkuId());
        return JsonResult.ok();
    }

    @GetMapping(CART_ITEM_VIEW)
    @ApiOperation(value = "查看购物车", notes = "查看购物车")
    public JsonResult<ShoppingCartVO> getShoppingCartVO(@PathVariable("userAccountId") Long userAccountId) {
        ShoppingCartDTO shoppingCartDTO = shoppingCartService
                .getShoppingCartDTOByUserAccountId(userAccountId);

        ShoppingCartVO shoppingCartVO = shoppingCartDTO.clone(ShoppingCartVO.class);

        List<ShoppingCartItemVO> shoppingCartItemVOs = new ArrayList<ShoppingCartItemVO>();
        shoppingCartVO.setShoppingCartItemVOs(shoppingCartItemVOs);

        for (ShoppingCartItemDTO shoppingCartItemDTO : shoppingCartDTO.getShoppingCartItemDTOs()) {
            shoppingCartItemVOs.add(shoppingCartItemDTO.clone(ShoppingCartItemVO.class));
        }
        return JsonResult.ok(shoppingCartVO);
    }

}
