package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDO;

/**
 * 销售出库单条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SaleDeliveryOrderItemMapper {

	/**
	 * 新增销售出库单条目
	 * @param saleDeliveryOrderItem 销售出库单条目
	 */
	@Insert("INSRET INTO wms_sale_delivery_order_item("
				+ "sale_delivery_order_id,"
				+ "goods_sku_id,"
				+ "goods_sku_code,"
				+ "goods_name,"
				+ "sale_properties,"
				+ "goods_gross_weight,"
				+ "purchase_quantity,"
				+ "purchase_price,"
				+ "promotion_activity_id,"
				+ "goods_length,"
				+ "goods_width,"
				+ "goods_height,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{saleDeliveryOrderId},"
				+ "#{goodsSkuId},"
				+ "#{goodsSkuCode},"
				+ "#{goodsName},"
				+ "#{saleProperties},"
				+ "#{goodsGrossWeight},"
				+ "#{purchaseQuantity},"
				+ "#{purchasePrice},"
				+ "#{promotionActivityId},"
				+ "#{goodsLength},"
				+ "#{goodsWidth},"
				+ "#{goodsHeight},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(SaleDeliveryOrderItemDO saleDeliveryOrderItem);
	
	/**
	 * 根据销售出库单id查询销售出库单条目
	 * @param saleDeliveryOrderId 销售出库单idi
	 * @return 销售出库单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "sale_delivery_order_id,"
				+ "goods_sku_id,"
				+ "goods_sku_code,"
				+ "goods_name,"
				+ "sale_properties,"
				+ "goods_gross_weight,"
				+ "purchase_quantity,"
				+ "purchase_price,"
				+ "promotion_activity_id,"
				+ "goods_length,"
				+ "goods_width,"
				+ "goods_height,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_sale_delivery_order_item "
			+ "WHERE sale_delivery_order_id=#{saleDeliveryOrderId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "sale_delivery_order_id", property = "saleDeliveryOrderId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "goods_sku_code", property = "goodsSkuCode"),
		@Result(column = "goods_name", property = "goodsName"),
		@Result(column = "sale_properties", property = "saleProperties"),
		@Result(column = "goods_gross_weight", property = "goodsGrossWeight"),
		@Result(column = "purchase_quantity", property = "purchaseQuantity"),
		@Result(column = "purchase_price", property = "purchasePrice"),
		@Result(column = "promotion_activity_id", property = "promotionActivityId"),
		@Result(column = "goods_length", property = "goodsLength"),
		@Result(column = "goods_width", property = "goodsWidth"),
		@Result(column = "goods_height", property = "goodsHeight"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<SaleDeliveryOrderItemDO> listBySaleDeliveryOrderId(
			@Param("saleDeliveryOrderId") Long saleDeliveryOrderId);
	
}
