package com.zhss.eshop.auth.domain;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 权限DO类
 * @author zhonghuashishan
 *
 */
public class PriorityDO {

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
	
	/**
	 * 克隆方法
	 * @param clazz 目标Class对象
	 * @return 克隆后的对象
	 */
	public <T> T clone(Class<T> clazz) {
//		T target = null;
//		try {
//			target = clazz.newInstance();
//			
//			Method setIdMethod = clazz.getMethod("setId", Long.class);
//			setIdMethod.invoke(target, id);
//			
//			Method setCodeMethod = clazz.getMethod("setCode", Long.class);
//			setCodeMethod.invoke(target, code);
//			
//			BeanUtils.copyProperties(this, clazz.newInstance());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return target;
		return null;
	}
	
	@Override
	public String toString() {
		return "PriorityDO [id=" + id + ", code=" + code + ", url=" + url + ", priorityComment=" + priorityComment
				+ ", priorityType=" + priorityType + ", parentId=" + parentId + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
