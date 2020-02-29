package com.zhss.eshop.order.constant.enums;

/**
 * @author wenliang
 */

public enum OrderInfoErrorCode {
    RETURN_GOODS_APPLY_DO_NOT_EXIST(1000, "退货申请不存在"),
    ORDER_INFO_DO_NOT_EXIST(1001,"订单信息不存在"),
    ORDER_STATUS_CANNOT_CANCEL(1002,"无法取消订单");
    private final int code;
    private final String message;


    OrderInfoErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
