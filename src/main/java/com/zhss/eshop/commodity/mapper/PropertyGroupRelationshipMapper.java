package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.PropertyGroupRelationshipDO;

/**
 * 属性分组与属性关系管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PropertyGroupRelationshipMapper {

	/**
	 * 新增属性分组与属性关系
	 * @param relation 属性分组与属性关系
	 */
	@Insert("INSERT INTO commodity_property_group_relationship("
				+ "property_group_id,"
				+ "property_id,"
				+ "is_required,"
				+ "property_types,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{propertyGroupId},"  
				+ "#{propertyId},"
				+ "#{required},"
				+ "#{propertyTypes},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(PropertyGroupRelationshipDO relation);
	
}
