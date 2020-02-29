package com.zhss.eshop.auth.domain.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhss.eshop.common.util.AbstractObject;
import lombok.Data;

/**
 * 权限PO类
 * @author gongshengjie
 *
 */
@TableName("priority")
@Data
public class PriorityPO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 权限编号
	 */
	private String code;
	/**
	 * 权限URL
	 */
	private String url;
	/**
	 * 权限备注
	 */
	private String priorityComment;
	/**
	 * 权限类型
	 */
	private Integer priorityType;
	/**
	 * 父权限id
	 */
	private Long parentId;
	/**
	 * 权限的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 权限的修改时间
	 */
	private Date gmtModified;

}
