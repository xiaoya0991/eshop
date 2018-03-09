package com.zhss.eshop.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
	
}
