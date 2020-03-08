package com.zhss.eshop.result;

import com.zhss.eshop.exception.Errors;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * API调用结果类
 */
@Data
public class JsonResult<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 响应结果
     */
    private Optional<T> data = Optional.empty();

    /**
     * 错误码
     */
    private Optional<Integer> errCode = Optional.empty();

    /**
     * 错误消息
     */
    private Optional<String> errMessage = Optional.empty();

    /**
     * 生成服务调用成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> ok() {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        return result;
    }

    /**
     * 生成服务调用成功响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> ok(@NotNull T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setData(Optional.of(data));
        return result;
    }

    /**
     * 生成服务调用成功响应--Optional
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> ok(@NotNull Optional<T> data) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    /**
     * 生成服务调用错误响应
     *
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error() {
        return error(Errors.SERVER_ERROR);
    }

    /**
     * 生成服务调用错误响应
     *
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(String errorMessage) {
        return error(Errors.SERVER_ERROR.getCode(), errorMessage);
    }

    /**
     * 生成服务调用错误响应
     *
     * @param error
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(Errors error) {
        return error(error.getCode(), error.getMessage());
    }

    /**
     * 生成服务调用错误响应
     *
     * @param errorCode
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> result = new JsonResult<>();
        result.setErrCode(Optional.of(errorCode));
        result.setErrMessage(Optional.ofNullable(errorMessage));
        return result;
    }
}
