package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品属性DO类
 * @author zhonghuashishan
 *
 */
public class PropertyDTO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 属性名称
	 */
	private String propertyName;
	/**
	 * 属性描述
	 */
	private String propertyDesc;
	/**
	 * 输入类型
	 */
	private Integer inputType;
	/**
	 * 输入可选值
	 */
	private String inputValues;
	/**
	 * 商品属性的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 商品属性的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyDesc() {
		return propertyDesc;
	}
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	public Integer getInputType() {
		return inputType;
	}
	public void setInputType(Integer inputType) {
		this.inputType = inputType;
	}
	public String getInputValues() {
		return inputValues;
	}
	public void setInputValues(String inputValues) {
		this.inputValues = inputValues;
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
	
	@Override
	public String toString() {
		return "PropertyDTO [id=" + id + ", propertyName=" + propertyName + ", propertyDesc=" + propertyDesc
				+ ", inputType=" + inputType + ", inputValues=" + inputValues + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}

}
