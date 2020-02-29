package com.zhss.eshop.exception;

/**
 * @author wenliang
 */
public class DaoException extends RuntimeException {

    private final Integer code;

    public DaoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DaoException(Integer code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
