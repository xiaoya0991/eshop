package com.zhss.eshop.cart.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 增加购物车条目的参数
 *
 * @author zhonghuashishan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShoppingCartItemQuery {

    @ApiModelProperty(value = "用户账号ID", required = true)
    @NotNull
    private Long userAccountId;

    @ApiModelProperty(value = "商品sku_id", required = true)
    @NotNull
    private Long goodsSkuId;

}
