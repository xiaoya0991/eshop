package com.zhss.eshop.purchase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.purchase.domain.PurchaseOrderItemDO;

/**
 * 采购单条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseOrderItemMapper {

	/**
	 * 新增采购单条目
	 * @param purchaseOrderItem 采购单条目
	 * @throws Exception
	 */
	@Insert("INSERT INTO purchase_order("
				+ "purchase_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{purchaseOrderId},"
				+ "#{goodsSkuId},"
				+ "#{purchaseCount},"
				+ "#{purchasePrice},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseOrderItemDO purchaseOrderItem);
	
	/**
	 * 根据采购单id查询采购单条目
	 * @param purchaseOrderId 采购单id
	 * @return 采购单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM purchase_order "
			+ "WHERE purchase_order_id=#{purchaseOrderId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_order_id", property = "purchaseOrderId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "purchase_count", property = "purchaseCount"),
		@Result(column = "purchase_price", property = "purchasePrice"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseOrderItemDO> listByPurchaseOrderId(
			@Param("purchaseOrderId") Long purchaseOrderId);
	
}
