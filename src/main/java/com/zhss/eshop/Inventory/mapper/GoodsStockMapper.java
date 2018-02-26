package com.zhss.eshop.Inventory.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.Inventory.domain.GoodsStockDO;

/**
 * 商品sku库存管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsStockMapper {

	/**
	 * 根据商品sku id查询商品库存
	 * @param goodsSkuId 商品sku id
	 * @return 商品库存
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_sku_id,"
				+ "sale_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "saled_stock_quantity,"
				+ "stock_status,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM inventory_goods_stock "
			+ "WHERE goods_sku_id=#{goodsSkuId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "sale_stock_quantity", property = "saleStockQuantity"),
		@Result(column = "locked_stock_quantity", property = "lockedStockQuantity"),
		@Result(column = "saled_stock_quantity", property = "saledStockQuantity"),
		@Result(column = "stock_status", property = "stockStatus"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	GoodsStockDO getGoodsStockBySkuId(@Param("goodsSkuId") Long goodsSkuId);
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	@Insert("INSERT INTO inventory_goods_stock ("
				+ "goods_sku_id,"
				+ "sale_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "saled_stock_quantity,"
				+ "stock_status,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsSkuId},"
				+ "#{saleStockQuantity},"
				+ "#{lockedStockQuantity},"
				+ "#{saledStockQuantity},"
				+ "#{stockStatus},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	void saveGoodsStock(GoodsStockDO goodsStockDO);
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	@Update("UPDATE inventory_goods_stock SET "
				+ "sale_stock_quantity=#{saleStockQuantity},"
				+ "locked_stock_quantity=#{lockedStockQuantity},"
				+ "saled_stock_quantity=#{saledStockQuantity},"
				+ "stock_status=#{stockStatus},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updateGoodsStock(GoodsStockDO goodsStockDO);
	
}
