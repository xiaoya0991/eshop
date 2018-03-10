package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;

/**
 * 商品属性值管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsPropertyValueMapper {

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
	
}
