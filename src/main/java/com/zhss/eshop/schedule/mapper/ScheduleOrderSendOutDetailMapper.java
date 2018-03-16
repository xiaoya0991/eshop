package com.zhss.eshop.schedule.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDO;

/**
 * 发货明细管理的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ScheduleOrderSendOutDetailMapper {

	/**
	 * 新增发货明细
	 * @param sendOutDetail 发货明细
	 */
	@Insert("INSERT INTO schedule_order_send_out_detail("
				+ "order_info_id,"
				+ "order_item_id,"
				+ "goods_allocation_stock_detail_id,"
				+ "send_out_count," 
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{orderInfoId},"
				+ "#{orderItemId},"
				+ "#{goodsAllocationStockDetailId},"
				+ "#{sendOutCount}," 
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(ScheduleOrderSendOutDetailDO sendOutDetail);
	
}
