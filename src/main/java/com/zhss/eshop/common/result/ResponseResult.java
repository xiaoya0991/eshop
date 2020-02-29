package com.zhss.eshop.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.zhss.eshop.common.result.GlobalCodeEnum;
import lombok.*;

import java.io.Serializable;

/**
 * @author wenliang
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@JsonPropertyOrder({"code", "message", "data"})
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回的对象
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    /**
     * 返回的编码
     */
    private Integer code;
    /**
     * 返回的信息
     */
    private String message;

    /**
     * 用于只返回处理状态的数据（状态码：000000）
     *
     * @return 响应结果
     */
    public static ResponseResult<String> OK() {
        return packageObject("", GlobalCodeEnum.GL_SUCC_0);
    }

    /**
     * 正常返回数据（状态码：000000）
     *
     * @param data 返回的数据
     * @param <T>  返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> OK(T data) {
        return packageObject(data, GlobalCodeEnum.GL_SUCC_0);
    }

    /**
     * 对返回的消息进行打包
     *
     * @param data           返回的数据
     * @param globalCodeEnum 自定义的返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> packageObject(T data, GlobalCodeEnum globalCodeEnum) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(globalCodeEnum.getCode());
        responseResult.setMessage(globalCodeEnum.getDesc());
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 对返回的消息进行打包
     *
     * @param data    返回的数据
     * @param code    返回的状态码
     * @param message 返回的消息
     * @param <T>     返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> packageObject(T data, Integer code, String message) {
        ResponseResult<T> responseResult = new ResponseResult<T>();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 校验入参有误，不满足接口入参要求
     *
     * @param globalCodeEnum 入参有误的返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> paramsError(GlobalCodeEnum globalCodeEnum) {
        return packageObject(null, globalCodeEnum);
    }

    /**
     * 返回其它信息：若调用第三方接口返回失败
     *
     * @param globalCodeEnum 入参有误的返回码枚举类型
     * @param message        返回的消息
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> otherInfo(GlobalCodeEnum globalCodeEnum, String message) {
        return packageObject(null, globalCodeEnum.getCode(), message);
    }

    /**
     * 返回其它信息：若调用第三方接口返回失败
     *
     * @param globalCodeEnum 入参有误的返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> otherInfo(GlobalCodeEnum globalCodeEnum) {
        return packageObject(null, globalCodeEnum.getCode(), null);
    }

    /**
     * 校验入参有误，不满足接口入参要求
     *
     * @param globalCodeEnum 入参有误的返回码枚举类型
     * @param message        返回的消息
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> paramsError(GlobalCodeEnum globalCodeEnum, String message) {
        return packageObject(null, globalCodeEnum.getCode(), message);
    }

    /**
     * 系统服务不可用
     *
     * @param globalCodeEnum Feign依赖服务不可用的返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> systemError(GlobalCodeEnum globalCodeEnum) {
        return packageObject(null, globalCodeEnum);
    }

    /**
     * 系统服务不可用
     *
     * @param globalCodeEnum Feign依赖服务不可用的返回码枚举类型
     * @param message        返回消息
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> exceptionInfo(GlobalCodeEnum globalCodeEnum, String message) {
        return packageObject(null, globalCodeEnum.getCode(), message);
    }

    /**
     * 未查询到相关的数据
     *
     * @param globalCodeEnum 未查询到相关信息的返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> noData(GlobalCodeEnum globalCodeEnum) {
        return packageObject(null, globalCodeEnum);
    }

    /**
     * 系统异常（使用默认的异常返回码）
     *
     * @param <T> 返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> systemException() {
        return packageObject(null, GlobalCodeEnum.GL_FAIL_9999);
    }

    /**
     * 系统异常
     *
     * @param globalCodeEnum 异常返回码枚举类型
     * @param <T>            返回的数据类型
     * @return 响应结果
     */
    public static <T> ResponseResult<T> systemException(GlobalCodeEnum globalCodeEnum) {
        return packageObject(null, globalCodeEnum);
    }

    /**
     * 自定义系统异常信息
     *
     * @param code
     * @param message 自定义消息
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> systemException(Integer code, String message) {
        return packageObject(null, code, message);
    }
}