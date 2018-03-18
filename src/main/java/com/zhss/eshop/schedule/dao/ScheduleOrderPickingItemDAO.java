package com.zhss.eshop.schedule.dao;

import java.util.List;

import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDO;

/**
 * 拣货条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ScheduleOrderPickingItemDAO {

	/**
	 * 批量插入拣货条目
	 * @param orderItem 订单条目 
	 * @param pickingItems 拣货条目
	 * @throws Exception
	 */
	void batchSave(Long orderInfoId, Long orderItemId, 
			List<ScheduleOrderPickingItemDO> pickingItems) throws Exception;
	
	/**
	 * 根据订单id和订单条目id查询拣货条目
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 * @return
	 */
	List<ScheduleOrderPickingItemDO> listByOrderItemId(
			Long orderInfoId, Long orderItemId) throws Exception;
	
	/**
	 * 根据订单条目id删除拣货条目
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 */
	void removeByOrderItemId(Long orderInfoId, Long orderItemId) throws Exception;
	
}
