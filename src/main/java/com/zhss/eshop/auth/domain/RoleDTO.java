package com.zhss.eshop.auth.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 角色DO类
 * @author zhonghuashishan
 *
 */
public class RoleDTO extends AbstractObject {

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
	/**
	 * 角色权限关系集合
	 */
	private List<RolePriorityRelationshipDTO> rolePriorityRelations;
	
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
	public List<RolePriorityRelationshipDTO> getRolePriorityRelations() {
		return rolePriorityRelations;
	}
	public void setRolePriorityRelations(List<RolePriorityRelationshipDTO> rolePriorityRelations) {
		this.rolePriorityRelations = rolePriorityRelations;
	}
	
	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", code=" + code + ", name=" + name + ", remark=" + remark + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", rolePriorityRelations=" + rolePriorityRelations + "]";
	}
	
}
