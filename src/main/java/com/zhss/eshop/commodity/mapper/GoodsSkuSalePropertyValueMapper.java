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

import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;

/**
 * 商品sku销售属性值管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsSkuSalePropertyValueMapper {
	
	/**
	 * 根据商品sku id查询属性值
	 * @param goodsSkuId 商品sku id
	 * @return 属性值
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_sku_id,"
				+ "relation_id,"
				+ "property_value,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_goods_sku_sale_property_value "
			+ "WHERE goods_sku_id=#{goodsSkuId} ") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "relation_id", property = "relationId"),
		@Result(column = "property_value", property = "propertyValue"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<GoodsSkuSalePropertyValueDO> listByGoodsSkuId(
			@Param("goodsSkuId") Long goodsSkuId);
	
	/**
	 * 新增商品sku销售属性值
	 * @param propertyValue 商品sku销售属性值
	 */
	@Insert("INSERT INTO commodity_goods_sku_sale_property_value("
				+ "goods_sku_id,"
				+ "relation_id,"
				+ "property_value,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsSkuId},"
				+ "#{relationId},"
				+ "#{propertyValue},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsSkuSalePropertyValueDO propertyValue);
	
	/**
	 * 根据商品sku id删除属性值
	 * @param goodsSkuId 商品sku id
	 */
	@Delete("DELETE FROM commodity_goods_sku_sale_property_value "
			+ "WHERE goods_sku_id=#{goodsSkuId}")  
	void removeByGoodsSkuId(@Param("goodsSkuId") Long goodsSkuId);
	
}
