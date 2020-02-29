package com.zhss.eshop.common.result;

/**
 * @author wenliang
 */
public enum BusinessCodeEnum {

    /**
     * 用户基本信息返回码定义（1000开头，根据业务扩展 ...）
     */
    BUSI_USER_FAIL_1000(1000, "user is not exists"),
    BUSI_USER_FAIL_1001(1001, "user did not set a password"),

    /**
     * 运营用户管理相关返回码定义（2000开头，根据业务扩展）
     */
    BUSI_OPERATOR_USER_FAIL_2000(2000, "interface security verification failed"),
    BUSI_OPERATOR_USER_FAIL_2001(2001, "operator user info create failed"),
    BUSI_OPERATOR_TOKON_PARSE_FAIL_2002(2002,"operator token parse fail"),
    BUSI_OPERATOR_TOKON_CANNON_BE_EMPTY_2003(2003,"operator token cannon be empty");


    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    BusinessCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取枚举类型
     *
     * @param code 编码
     * @return
     */
    public static BusinessCodeEnum getByCode(String code) {
        //判空
        if (code == null) {
            return null;
        }
        //循环处理
        BusinessCodeEnum[] values = BusinessCodeEnum.values();
        for (BusinessCodeEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
