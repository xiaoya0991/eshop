package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;

/**
 * 商品sku销售属性值管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsSkuSalePropertyValueMapper {

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
	
}
