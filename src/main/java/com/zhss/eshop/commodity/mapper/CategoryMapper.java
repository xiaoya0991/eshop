package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.commodity.domain.CategoryDO;

/**
 * 类目管理模块mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface CategoryMapper {

	/**
	 * 查询根类目
	 * @return 根类目集合
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "description,"
				+ "parent_id,"
				+ "is_leaf,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_category "
			+ "WHERE parent_id IS NULL") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
		@Result(column = "parent_id", property = "parentId"),
		@Result(column = "is_leaf", property = "leaf"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
 	List<CategoryDO> listRoots();
	
	/**
	 * 查询子类目
	 * @param id 父类目id
	 * @return 子类目集合
	 */
	@Select("SELECT "
			+ "id,"
			+ "name,"
			+ "description,"
			+ "parent_id,"
			+ "is_leaf,"
			+ "gmt_create,"
			+ "gmt_modified "
		+ "FROM commodity_category "
		+ "WHERE parent_id=#{id}")   
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "description", property = "description"),
		@Result(column = "parent_id", property = "parentId"),
		@Result(column = "is_leaf", property = "leaf"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<CategoryDO> listChildren(@Param("id") Long id); 
	
	/**
	 * 新增类目
	 * @param category 类目
	 */
	@Insert("INSERT INTO commodity_category("
				+ "name,"
				+ "description,"
				+ "parent_id,"
				+ "is_leaf,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{description},"
				+ "#{parentId},"
				+ "#{leaf},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(CategoryDO category);
	
}
