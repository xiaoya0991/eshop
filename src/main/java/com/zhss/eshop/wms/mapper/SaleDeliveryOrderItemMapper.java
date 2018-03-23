package com.zhss.eshop.wms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
	
}
