package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 类目属性关系DO
 * @author zhonghuashishan
 *
 */
public class CategoryPropertyRelationshipDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 类目id
	 */
	private Long categoryId;
	/**
	 * 属性id
	 */
	private Long propertyId;
	/**
	 * 属性是否必填
	 */
	private Integer required;
	/**
	 * 属性类型
	 */
	private String propertyTypes;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public Integer getRequired() {
		return required;
	}
	public void setRequired(Integer required) {
		this.required = required;
	}
	public String getPropertyTypes() {
		return propertyTypes;
	}
	public void setPropertyTypes(String propertyTypes) {
		this.propertyTypes = propertyTypes;
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
