package com.zhss.eshop.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.logistics.domain.FreightTemplateDO;
import com.zhss.eshop.logistics.domain.FreightTemplateQuery;

/**
 * 运费模板管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface FreightTemplateMapper {

	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 */
	@Insert("INSERT INTO logistics_freight_template("
				+ "name,"
				+ "type,"
				+ "rule,"
				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{name},"
				+ "#{type},"
				+ "#{remark},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)  
	void save(FreightTemplateDO freightTemplate);
	
	/**
	 * 分页查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	@Select("<script>"
			
			+ "SELECT "
				+ "a.id,"
				+ "a.name,"
				+ "a.type,"
				+ "a.remark,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM logistics_freight_template a,"
			+ "("
				+ "SELECT id "
				+ "FROM logistics_freight_template "
				+ "WHERE 1=1 "
				
				+ "<if test='name != null'>"
				+ "AND name like '${name}%' "
				+ "</if>"
				
				+ "<if test='type != null'>"
				+ "AND type=#{type} "
				+ "</if>"
				
				+ "LIMTT #{offset},#{size} "
 			+ ") b "
			+ "WHERE a.id=b.id"
			
			+ "</script>")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type"),
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<FreightTemplateDO> listByPage(FreightTemplateQuery query);
	
	/**
	 * 根据id查询运费模板
	 * @param query 运费模板查询条件
	 * @return 运费模板
	 */
	@Select("SELECT "
				+ "id,"
				+ "name,"
				+ "type,"
				+ "rule,"
 				+ "remark,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM logistics_freight_template "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "name", property = "name"),
		@Result(column = "type", property = "type"),
		@Result(column = "rule", property = "rule"), 
		@Result(column = "remark", property = "remark"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	FreightTemplateDO getById(@Param("id") Long id);
	
	/**
	 * 更新运费模板
	 * @param freightTemplate 运费模板
	 */
	@Update("UPDATE logistics_freight_template SET "
				+ "name=#{name},"
				+ "type=#{type},"
				+ "rule=#{rule},"
				+ "remark=#{remark},"
				+ "gmt_create=#{gmtCreate} "
			+ "WHERE id=#{id}") 
	void update(FreightTemplateDO freightTemplate);
	
}
