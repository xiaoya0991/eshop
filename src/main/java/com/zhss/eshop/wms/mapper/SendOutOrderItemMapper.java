package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.SendOutOrderItemDO;

/**
 * 发货单条目管理Mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SendOutOrderItemMapper {

	/**
	 * 新增发货单条目
	 * @param orderItem
	 */
	@Insert("INSERT INTO wms_send_out_order_item("
				+ "send_out_order_id,"
				+ "goods_id,"
				+ "goods_sku_id,"
				+ "goods_sku_code,"
				+ "goods_name,"
				+ "sale_properties,"
				+ "goods_gross_weight,"
				+ "purchase_quantity,"
				+ "purchase_price,"
				+ "goods_length,"
				+ "goods_width,"
				+ "goods_height,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{sendOutOrderId}," 
				+ "#{goodsId}," 
				+ "#{goodsSkuId},"
				+ "#{goodsSkuCode},"
				+ "#{goodsName},"
				+ "#{saleProperties},"
				+ "#{goodsGrossWeight},"
				+ "#{purchaseQuantity},"
				+ "#{purchasePrice},"
				+ "#{goodsLength},"
				+ "#{goodsWidth},"
				+ "#{goodsHeight},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(SendOutOrderItemDO sendOutOrderItem);
	
	/**
	 * 查询发货单条目
	 * @param sendOutOrderId 发货单id
	 * @return 发货单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "send_out_order_id,"
				+ "goods_id,"
				+ "goods_sku_id,"
				+ "goods_sku_code,"
				+ "goods_name,"
				+ "sale_properties,"
				+ "goods_gross_weight,"
				+ "purchase_quantity,"
				+ "purchase_price,"
				+ "goods_length,"
				+ "goods_width,"
				+ "goods_height,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_send_out_order_item "
			+ "WHERE send_out_order_id=#{sendOutOrderId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "send_out_order_id", property = "sendOutOrderId"), 
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "goods_sku_code", property = "goodsSkuCode"),
		@Result(column = "goods_name", property = "goodsName"),
		@Result(column = "sale_properties", property = "saleProperties"),
		@Result(column = "goods_gross_weight", property = "goodsGrossWeight"),
		@Result(column = "purchase_quantity", property = "purchaseQuantity"),
		@Result(column = "purchase_price", property = "purchasePrice"),
		@Result(column = "goods_length", property = "goodsLength"),
		@Result(column = "goods_width", property = "goodsWidth"),
		@Result(column = "goods_height", property = "goodsHeight"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<SendOutOrderItemDO> listByOrderInfoId(
			@Param("sendOutOrderId") Long sendOutOrderId);
	
}
