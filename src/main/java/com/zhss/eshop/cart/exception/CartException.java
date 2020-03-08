package com.zhss.eshop.cart.exception;

import com.zhss.eshop.exception.ServiceException;

/**
 * 购物车端异常
 *
 * @author : huyining
 * @since :  2020/2/29
 */
public class CartException extends ServiceException {

    public CartException(Integer code, String message) {
        super(code, message);
    }
}
