package com.zhss.eshop.schedule.dao;

import java.util.List;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDTO;

/**
 * 发货明细管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ScheduleOrderSendOutDetailDAO {

	/**
	 * 新增发货明细
	 * @param pickingItem 拣货条目
	 */
	void batchSave(List<SaleDeliveryOrderSendOutDetailDTO> saleDeliveryOrderSendOutDetails,
			OrderItemDTO orderItem) throws Exception;
	
}
