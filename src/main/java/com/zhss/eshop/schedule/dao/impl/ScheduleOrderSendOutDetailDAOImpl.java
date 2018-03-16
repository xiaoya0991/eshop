package com.zhss.eshop.schedule.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.schedule.dao.ScheduleOrderSendOutDetailDAO;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDO;
import com.zhss.eshop.schedule.mapper.ScheduleOrderSendOutDetailMapper;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDTO;

/**
 * 发货明细管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ScheduleOrderSendOutDetailDAOImpl implements ScheduleOrderSendOutDetailDAO {

	/**
	 * 发货明细管理mapper组件
	 */
	@Autowired
	private ScheduleOrderSendOutDetailMapper sendOutDetailMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增拣货条目
	 * @param pickingItem 拣货条目
	 */
	public void batchSave(List<SaleDeliveryOrderSendOutDetailDTO> saleDeliveryOrderSendOutDetails,
			OrderItemDTO orderItem) throws Exception {
		for(SaleDeliveryOrderSendOutDetailDTO saleDeliveryOrderSendOutDetail : saleDeliveryOrderSendOutDetails) {
			ScheduleOrderSendOutDetailDO sendOutDetail = saleDeliveryOrderSendOutDetail.clone(
					ScheduleOrderSendOutDetailDO.class);
			
			sendOutDetail.setId(null); 
			sendOutDetail.setOrderInfoId(orderItem.getOrderInfoId()); 
			sendOutDetail.setOrderItemId(orderItem.getId()); 
			sendOutDetail.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutDetail.setGmtModified(dateProvider.getCurrentTime());  
			
			sendOutDetailMapper.save(sendOutDetail); 
		}
	}
	
}
