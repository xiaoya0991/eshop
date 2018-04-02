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

import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDO;

/**
 * 调度中心的货位库存明细管理的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsAllocationStockDetailMapper {

	/**
	 * 根据商品sku id查询货位库存明细
	 * @param goodsSkuId 商品sku id 
	 * @return 货位库存明细
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_sku_id,"
				+ "goods_allocation_id,"
				+ "put_on_time,"
				+ "put_on_quantity,"
				+ "current_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_goods_allocation_stock_detail "
			+ "WHERE goods_sku_id=#{goodsSkuId} "
			+ "AND current_stock_quantity>0 "
			+ "ORDER BY put_on_time")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_sku_id", property = "goodsSkuId"), 
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "put_on_time", property = "putOnTime"),
		@Result(column = "put_on_quantity", property = "putOnQuantity"),
		@Result(column = "current_stock_quantity", property = "currentStockQuantity"),
		@Result(column = "locked_stock_quantity", property = "lockedStockQuantity"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")  
	})
	List<GoodsAllocationStockDetailDO> listByGoodsSkuId(
			@Param("goodsSkuId") Long goodsSkuId);
	
	/**
	 * 根据id查询货位库存明细
	 * @param id 货位库粗明细id
	 * @return 货位库存明细
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_sku_id,"
				+ "goods_allocation_id,"
				+ "put_on_time,"
				+ "put_on_quantity,"
				+ "current_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_goods_allocation_stock_detail "
			+ "WHERE id=#{id}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_sku_id", property = "goodsSkuId"), 
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "put_on_time", property = "putOnTime"),
		@Result(column = "put_on_quantity", property = "putOnQuantity"),
		@Result(column = "current_stock_quantity", property = "currentStockQuantity"),
		@Result(column = "locked_stock_quantity", property = "lockedStockQuantity"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")  
	})
	GoodsAllocationStockDetailDO getById(@Param("id") Long id);
	
	/**
	 * 更新货位库存明细
	 * @param stockDetail 货位库存明细
	 */
	@Update("UPDATE wms_goods_allocation_stock_detail SET "
				+ "current_stock_quantity=#{currentStockQuantity},"
				+ "locked_stock_quantity=#{lockedStockQuantity},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}")  
	void update(GoodsAllocationStockDetailDO stockDetail);
	
	/**
	 * 新增货位库存明细
	 * @param stockDetail 货位库存明细
	 */
	@Insert("INSERT INTO wms_goods_allocation_stock_detail("
				+ "id,"
				+ "goods_sku_id,"
				+ "goods_allocation_id,"
				+ "put_on_time,"
				+ "put_on_quantity,"
				+ "current_stock_quantity,"
				+ "locked_stock_quantity,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{id}," 
				+ "#{goodsSkuId},"
				+ "#{goodsAllocationId},"
				+ "#{putOnTime},"
				+ "#{putOnQuantity},"
				+ "#{currentStockQuantity},"
				+ "#{lockedStockQuantity},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsAllocationStockDetailDO stockDetail);
	
}
