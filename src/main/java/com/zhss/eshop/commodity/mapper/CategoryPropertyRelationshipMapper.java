package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.CategoryPropertyRelationshipDO;

/**
 * 类目属性关系管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface CategoryPropertyRelationshipMapper {

	/**
	 * 新增类目属性关系
	 * @param relation 类目属性关系
	 */
	@Insert("INSERT INTO commodity_category_property_relationship("
				+ "category_id,"
				+ "property_id,"
				+ "is_required,"
				+ "property_types,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{categoryId},"
				+ "#{propertyId},"
				+ "#{required},"
				+ "#{propertyTypes},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(CategoryPropertyRelationshipDO relation);
	
}
