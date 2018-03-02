package com.zhss.eshop.commodity.domain;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.BeanCopierUtils;

/**
 * 商品属性DO类
 * @author zhonghuashishan
 *
 */
public class PropertyDO {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertyDO.class);

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
	
	public <T> T clone(Class<T> clazz) {
		T target = null;
		try {
			target = clazz.newInstance();
			BeanCopierUtils.copyProperties(this, target);  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return target;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inputType == null) ? 0 : inputType.hashCode());
		result = prime * result + ((inputValues == null) ? 0 : inputValues.hashCode());
		result = prime * result + ((propertyDesc == null) ? 0 : propertyDesc.hashCode());
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyDO other = (PropertyDO) obj;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inputType == null) {
			if (other.inputType != null)
				return false;
		} else if (!inputType.equals(other.inputType))
			return false;
		if (inputValues == null) {
			if (other.inputValues != null)
				return false;
		} else if (!inputValues.equals(other.inputValues))
			return false;
		if (propertyDesc == null) {
			if (other.propertyDesc != null)
				return false;
		} else if (!propertyDesc.equals(other.propertyDesc))
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PropertyDO [id=" + id + ", propertyName=" + propertyName + ", propertyDesc=" + propertyDesc
				+ ", inputType=" + inputType + ", inputValues=" + inputValues + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
