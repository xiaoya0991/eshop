package com.zhss.eshop.auth.domain.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhss.eshop.common.util.AbstractObject;
import lombok.Data;

/**
 * 账号PO类
 * @author gongshengjie
 *
 */
@TableName("account")
@Data
public class AccountPO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 员工姓名
	 */
	private String name;
	/**
	 * 账号备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
