package com.zhss.eshop.order.domain.po;

import java.util.Date;
import lombok.Data;

/**
 * @author wenliang
 */
@Data
public class OrderOperateLogPO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderInfoId;
    /**
     * 操作类型
     */
    private Integer operateType;
    /**
     * 操作内容
     */
    private String operateContent;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

}
