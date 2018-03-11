package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;

/**
 * 商品属性值管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsPropertyValueMapper {
	
	/**
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 */
	@Select("SELECT "
				+ "id,"
				+ "type,"
				+ "goods_id,"
				+ "relation_id,"
				+ "property_value,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_goods_property_value "
			+ "WHERE goods_id=#{goodsId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "type", property = "type"),
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "relation_id", property = "relationId"),
		@Result(column = "property_value", property = "propertyValue"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<GoodsPropertyValueDO> listByGoodsId(@Param("goodsId") Long goodsId);
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	@Insert("INSERT INTO commodity_goods_property_value("
				+ "type,"
				+ "goods_id,"
				+ "relation_id,"
				+ "property_value,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{type},"
				+ "#{goodsId},"
				+ "#{relationId},"
				+ "#{propertyValue},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsPropertyValueDO goodsPropertyValue);
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 */
	@Delete("DELETE FROM commodity_goods_property_value WHERE goods_id=#{goodsId}")  
	void removeByGoodsId(@Param("goodsId") Long goodsId);
	
}
