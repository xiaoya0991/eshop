package com.zhss.eshop.commodity.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipVO;
import com.zhss.eshop.commodity.domain.PropertyGroupVO;
import com.zhss.eshop.commodity.domain.PropertyVO;

public class Properties {
	
	/**
	 * 类目与属性的关联关系
	 */
	private List<CategoryPropertyRelationshipVO> propertyRelations = 
			new ArrayList<CategoryPropertyRelationshipVO>(); 
	/**
	 * 类目关联的属性
	 */
	private List<PropertyVO> properties = 
			new ArrayList<PropertyVO>();  
	/**
	 * 属性分组
	 */
	private List<PropertyGroupVO> propertyGroups = 
			new ArrayList<PropertyGroupVO>();  
	
	public List<CategoryPropertyRelationshipVO> getPropertyRelations() {
		return propertyRelations;
	}

	public void setPropertyRelations(List<CategoryPropertyRelationshipVO> propertyRelations) {
		this.propertyRelations = propertyRelations;
	}
	public List<PropertyVO> getProperties() {
		return properties;
	}
	public void setProperties(List<PropertyVO> properties) {
		this.properties = properties;
	}
	public List<PropertyGroupVO> getPropertyGroups() {
		return propertyGroups;
	}
	public void setPropertyGroups(List<PropertyGroupVO> propertyGroups) {
		this.propertyGroups = propertyGroups;
	}

}
