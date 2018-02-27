package com.zhss.eshop.auth.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.BeanCopierUtils;

/**
 * 权限VO类
 * @author zhonghuashishan
 *
 */
public class PriorityVO {
	
	private static final Logger logger = LoggerFactory.getLogger(PriorityVO.class);

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
	
	/**
	 * 克隆方法
	 * @param clazz 目标Class对象
	 * @return 克隆后的对象
	 */
	public <T> T clone(Class<T> clazz) {
		T target = null;
		
		try {
			target = clazz.newInstance();
		} catch (Exception e) {
			logger.error("error", e);  
		}
		
		BeanCopierUtils.copyProperties(this, target); 
		
		return target;
	}
	
}
