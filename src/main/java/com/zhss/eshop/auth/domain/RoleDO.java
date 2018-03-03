package com.zhss.eshop.auth.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 角色DO类
 * @author zhonghuashishan
 *
 */
public class RoleDO extends AbstractObject {

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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}
