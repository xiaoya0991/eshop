package com.zhss.eshop.order.exception;

import com.zhss.eshop.exception.ServiceException;

/**
 * @author wenliang
 */
public class OrderInfoException extends ServiceException {


    public OrderInfoException(Integer code, String message) {
        super(code, message);
    }


}
