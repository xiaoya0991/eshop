package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;

/**
 * 采购入库单上架条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseInputOrderPutOnItemMapper {

	/**
	 * 新增采购入库单上架条目
	 * @param putOnItem 上架条目
	 */
	@Insert("INSERT INTO wms_purchase_input_order_put_on_item("
				+ "purchase_input_order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "put_on_shelves_count,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{purchaseInputOrderItemId},"
				+ "#{goodsAllocationId},"
				+ "#{goodsSkuId},"
				+ "#{putOnShelvesCount},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)  
 	void save(PurchaseInputOrderPutOnItemDO putOnItem);
	
	/**
	 * 根据采购入库单条目id查询采购入库单上架条目
	 * @param purchaseInputOrderItemId 采购入库单id
	 * @return 采购入库单上架条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_input_order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "put_on_shelves_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_purchase_input_order_put_on_item "
			+ "WHERE purchase_input_order_item_id=#{purchaseInputOrderItemId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_input_order_item_id", property = "purchaseInputOrderItemId"),
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "put_on_shelves_count", property = "putOnShelvesCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseInputOrderPutOnItemDO> listByPurchaseInputOrderItemId(
			@Param("purchaseInputOrderItemId") Long purchaseInputOrderItemId);
	
}
