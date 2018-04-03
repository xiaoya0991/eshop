package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.commodity.domain.PropertyDO;
import com.zhss.eshop.commodity.domain.PropertyQuery;

/**
 * 商品属性管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PropertyMapper {

	/**
	 * 分页查询商品属性
	 * @param propertyQuery 查询条件
	 * @return 商品属性
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.property_name,"
				+ "a.property_desc,"
				+ "a.input_type,"
				+ "a.input_values,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM commodity_property a, "
				
			+ "("
			+ "SELECT id FROM commodity_property "
			+ "<if test='propertyName != null'>"
				+ "WHERE property_name like '${propertyName}%' "
			+ "</if>"
			+ "LIMIT #{offset}, #{size} "
			+ ") b "
			
			+ "WHERE a.id=b.id"
			
			+ "</script>")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "property_name", property = "propertyName"),
		@Result(column = "property_desc", property = "propertyDesc"),
		@Result(column = "input_type", property = "inputType"),
		@Result(column = "input_values", property = "inputValues"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PropertyDO> listPropertiesByPage(PropertyQuery propertyQuery);
	
	/**
	 * 新增商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	@Insert("INSERT INTO commodity_property("
				+ "property_name,"
				+ "property_desc,"
				+ "input_type,"
				+ "input_values,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{propertyName},"
				+ "#{propertyDesc},"
				+ "#{inputType},"
				+ "#{inputValues},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void saveProperty(PropertyDO propertyDO);
	
	/**
	 * 根据id查询商品属性 
	 * @param id 商品属性id
	 * @return 商品属性
	 */
	@Select("SELECT "
				+ "id,"
				+ "property_name,"
				+ "property_desc,"
				+ "input_type,"
				+ "input_values,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_property "
			+ "WHERE id=#{id}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "property_name", property = "propertyName"),
		@Result(column = "property_desc", property = "propertyDesc"),
		@Result(column = "input_type", property = "inputType"),
		@Result(column = "input_values", property = "inputValues"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	PropertyDO getPropertyById(@Param("id") Long id);
	
	/**
	 * 更新商品属性
	 * @param propertyDO 商品属性DO对象
	 */
	@Update("UPDATE commodity_property SET "
				+ "property_desc=#{propertyDesc},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updateProperty(PropertyDO propertyDO);
	
}
