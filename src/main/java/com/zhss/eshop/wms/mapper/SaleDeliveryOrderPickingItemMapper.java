package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDO;

/**
 * 销售出库单拣货条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface SaleDeliveryOrderPickingItemMapper {

	/**
	 * 新增销售出库单拣货条目
	 * @param pickingItem
	 */
	@Insert("INSERT INTO wms_sale_delivery_order_picking_item("
				+ "sale_delivery_order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "picking_count,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{saleDeliveryOrderItemId},"
				+ "#{goodsAllocationId},"
				+ "#{goodsSkuId},"
				+ "#{pickingCount},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(SaleDeliveryOrderPickingItemDO pickingItem);
	
	/**
	 * 根据销售出库单条目id查询拣货条目
	 * @param saleDeliveryOrderItemId 销售出库单条目id
	 * @return 拣货条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "sale_delivery_order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "picking_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_sale_delivery_order_picking_item "
			+ "WHERE sale_delivery_order_item_id=#{saleDeliveryOrderItemId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "sale_delivery_order_item_id", property = "saleDeliveryOrderItemId"),
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "picking_count", property = "pickingCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<SaleDeliveryOrderPickingItemDO> listBySaleDeliveryOrderItemId(
			@Param("saleDeliveryOrderItemId") Long saleDeliveryOrderItemId);
	
}
