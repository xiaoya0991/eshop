package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.GoodsSkuDO;

/**
 * 商品sku管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsSkuMapper {

	/**
	 * 新增商品sku
	 * @param goodsSku
	 */
	@Insert("INSERT INTO commodity_goods_sku("
				+ "goods_id,"
				+ "sku_code,"
				+ "purchase_price,"
				+ "sale_price,"
				+ "discount_price,"
				+ "sale_properties,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsId},"
				+ "#{skuCode},"
				+ "#{purchasePrice},"
				+ "#{salePrice},"
				+ "#{discountPrice},"
				+ "#{saleProperties},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsSkuDO goodsSku);
	
}
