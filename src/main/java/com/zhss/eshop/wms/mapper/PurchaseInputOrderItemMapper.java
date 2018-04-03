package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDO;

/**
 * 采购入库单条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseInputOrderItemMapper {

	/**
	 * 新增采购入库单条目
	 * @param purchaseInputOrderItem 采购入库单条目
	 * @throws Exception
	 */
	@Insert("INSERT INTO wms_purchase_input_order_item("
				+ "purchase_input_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{purchaseInputOrderId},"
				+ "#{goodsSkuId},"
				+ "#{purchaseCount},"
				+ "#{purchasePrice},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseInputOrderItemDO purchaseInputOrderItem);
	
	/**
	 * 根据采购入库单id查询采购入库单条目
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 采购入库单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_input_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "qualified_count,"
				+ "arrival_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_purchase_input_order_item "
			+ "WHERE purchase_input_order_id=#{purchaseInputOrderId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_input_order_id", property = "purchaseInputOrderId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "purchase_count", property = "purchaseCount"),
		@Result(column = "purchase_price", property = "purchasePrice"),
		@Result(column = "qualified_count", property = "qualifiedCount"),
		@Result(column = "arrival_count", property = "arrivalCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseInputOrderItemDO> listByPurchaseInputOrderId(
			@Param("purchaseInputOrderId") Long purchaseInputOrderId);
	
	/**
	 * 更新采购入库单条目
	 * @param purchaseInputOrderItem 采购入库单条目
	 */
	@Update("UPDATE wms_purchase_input_order_item SET "
				+ "qualified_count=#{qualifiedCount},"
				+ "arrival_count=#{arrivalCount},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void update(PurchaseInputOrderItemDO purchaseInputOrderItem);
	
}
