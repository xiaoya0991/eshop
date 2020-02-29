package com.zhss.eshop.auth.domain.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhss.eshop.common.util.AbstractObject;
import lombok.Data;

/**
 * 角色PO类
 * @author gongshengjie
 *
 */
@TableName("role")
@Data
public class RolePO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 角色编号
	 */
	private String code;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色备注
	 */
	private String remark;
	/**
	 * 角色的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 角色的修改时间
	 */
	private Date gmtModified;

}
