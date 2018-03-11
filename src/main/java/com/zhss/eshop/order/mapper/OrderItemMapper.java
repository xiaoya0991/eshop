package com.zhss.eshop.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.order.domain.OrderItemDO;

/**
 * 订单条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface OrderItemMapper {

	/**
	 * 新增订单条目
	 * @param orderItem
	 */
	@Insert("INSERT INTO order_item("
				+ "order_info_id,"
				+ "goods_id,"
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
				+ "#{orderInfoId},"
				+ "#{goodsId},"
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
	void save(OrderItemDO orderItem);
	
	/**
	 * 查询订单条目
	 * @param orderInfoId 订单id
	 * @return 订单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "order_info_id,"
				+ "goods_id,"
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
			+ "FROM order_item "
			+ "WHERE order_info_id=#{orderInfoId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_info_id", property = "orderInfoId"),
		@Result(column = "goods_id", property = "goodsId"),
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
	List<OrderItemDO> listByOrderInfoId(@Param("orderInfoId") Long orderInfoId);
	
}
