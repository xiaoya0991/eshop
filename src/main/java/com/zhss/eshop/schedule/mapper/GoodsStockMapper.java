package com.zhss.eshop.schedule.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.schedule.domain.GoodsStockDO;

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
				+ "available_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "output_stock_quantity,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM schedule_goods_stock "
			+ "WHERE goods_sku_id=#{goodsSkuId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "available_stock_quantity", property = "availableStockQuantity"),
		@Result(column = "locked_stock_quantity", property = "lockedStockQuantity"),
		@Result(column = "output_stock_quantity", property = "outputpStockQuantity"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	GoodsStockDO getBySkuId(@Param("goodsSkuId") Long goodsSkuId);
	
	/**
	 * 新增商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	@Insert("INSERT INTO schedule_goods_stock ("
				+ "goods_sku_id,"
				+ "available_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "output_stock_quantity,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsSkuId},"
				+ "#{availableStockQuantity},"
				+ "#{lockedStockQuantity},"
				+ "#{outputStockQuantity},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(GoodsStockDO goodsStockDO);
	
	/**
	 * 更新商品库存
	 * @param goodsStockDO 商品库存DO对象
	 */
	@Update("UPDATE schedule_goods_stock SET "
				+ "available_stock_quantity=#{availableStockQuantity},"
				+ "locked_stock_quantity=#{lockedStockQuantity},"
				+ "output_stock_quantity=#{outputStockQuantity},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void update(GoodsStockDO goodsStockDO);
	
}
