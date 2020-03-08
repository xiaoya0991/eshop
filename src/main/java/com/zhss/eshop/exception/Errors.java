package com.zhss.eshop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {

    /**
     * 服务异常
     */
    SERVER_ERROR("服务异常", 1),

    /**
     * 资源不存在
     */
    BASE_NOT_FOUND("资源不存在", 2),

    /**
     * 未授权
     */
    BASE_UNAUTHORIZED("未授权", 3),

    /**
     * 拒绝访问
     */
    BASE_FORBIDDEN("拒绝访问", 4),

    /**
     * 请求参数错误
     */
    BASE_BAD_PARAMS("请求参数错误", 5);
    private String message;
    private Integer code;
}
