package com.zhss.eshop.auth.domain;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 权限VO类
 * @author zhonghuashishan
 *
 */
public class PriorityVO extends AbstractObject {
	
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
	private String gmtCreate;
	/**
	 * 权限的修改时间
	 */
	private String gmtModified;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPriorityComment() {
		return priorityComment;
	}
	public void setPriorityComment(String priorityComment) {
		this.priorityComment = priorityComment;
	}
	public Integer getPriorityType() {
		return priorityType;
	}
	public void setPriorityType(Integer priorityType) {
		this.priorityType = priorityType;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public String getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	@Override
	public String toString() {
		return "PriorityVO [id=" + id + ", code=" + code + ", url=" + url + ", priorityComment=" + priorityComment
				+ ", priorityType=" + priorityType + ", parentId=" + parentId + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
