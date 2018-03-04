package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.commodity.domain.PropertyGroupDO;

/**
 * 属性分组管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PropertyGroupMapper {

	/**
	 * 新增属性分组
	 * @param group 属性分组
	 */
	@Insert("INSERT INTO commodity_property_group("
				+ "name,"
				+ "category_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{categoryId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PropertyGroupDO group);
	
	/**
	 * 根据类目id查询属性分组
	 * @param categoryId 类目id
	 * @return 属性分组
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "category_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_property_group "
			+ "WHERE category_id=#{categoryId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "category_id", property = "categoryId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<PropertyGroupDO> listByCategoryId(
			@Param("categoryId") Long categoryId);
	
}
