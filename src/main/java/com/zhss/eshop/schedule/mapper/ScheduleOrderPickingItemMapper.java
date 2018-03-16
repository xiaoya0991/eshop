package com.zhss.eshop.schedule.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
	
}
