package com.zhss.eshop.schedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDO;

/**
 * 拣货条目管理的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ScheduleOrderPickingItemMapper {

	/**
	 * 新增拣货条目
	 * @param pickingItem 拣货条目
	 */
	@Insert("INSERT INTO schedule_order_picking_item("
				+ "order_info_id,"
				+ "order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "picking_count,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{orderInfoId},"
				+ "#{orderItemId},"
				+ "#{goodsAllocationId},"
				+ "#{goodsSkuId},"
				+ "#{pickingCount},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(ScheduleOrderPickingItemDO pickingItem);
	
	/**
	 * 根据订单id和订单条目id查询拣货条目
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 * @return
	 */
	@Select("SELECT "
				+ "id,"
				+ "order_info_id,"
				+ "order_item_id,"
				+ "goods_allocation_id,"
				+ "goods_sku_id,"
				+ "picking_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM schedule_order_picking_item "
			+ "WHERE order_info_id=#{orderInfoId} "
			+ "AND order_item_id=#{orderItemId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_info_id", property = "orderInfoId"),
		@Result(column = "order_item_id", property = "orderItemId"),
		@Result(column = "goods_allocation_id", property = "goodsAllocationId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "picking_count", property = "pickingCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<ScheduleOrderPickingItemDO> listByOrderItemId(
			@Param("orderInfoId") Long orderInfoId, 
			@Param("orderItemId") Long orderItemId);
	
	/**
	 * 根据订单条目id删除拣货条目
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 */
	@Delete("DELETE FROM schedule_order_picking_item "
			+ "WHERE order_info_id=#{orderInfoId} "
			+ "AND order_item_id=#{orderItemId}")  
	void removeByOrderItemId(
			@Param("orderInfoId") Long orderInfoId, 
			@Param("orderItemId") Long orderItemId);
	
}
