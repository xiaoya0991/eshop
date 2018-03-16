package com.zhss.eshop.schedule.dao;

import java.util.List;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDTO;

/**
 * 拣货条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ScheduleOrderPickingItemDAO {

	/**
	 * 新增拣货条目
	 * @param pickingItem 拣货条目
	 */
	void batchSave(List<SaleDeliveryOrderPickingItemDTO> saleDeliveryOrderPickingItems,
			OrderItemDTO orderItem) throws Exception;
	
}
