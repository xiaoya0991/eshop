package com.zhss.eshop.schedule.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.schedule.dao.ScheduleOrderPickingItemDAO;
import com.zhss.eshop.schedule.domain.ScheduleOrderPickingItemDO;
import com.zhss.eshop.schedule.mapper.ScheduleOrderPickingItemMapper;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDTO;

/**
 * 拣货条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ScheduleOrderPickingItemDAOImpl implements ScheduleOrderPickingItemDAO {

	/**
	 * 拣货条目管理mapper组件
	 */
	@Autowired
	private ScheduleOrderPickingItemMapper pickingItemMapper;
	
	/**
	 * 新增拣货条目
	 * @param pickingItem 拣货条目
	 */
	public void save(OrderItemDTO orderItem, 
			List<SaleDeliveryOrderPickingItemDTO> saleDeliveryOrderPickingItems) {
		for(SaleDeliveryOrderPickingItemDTO saleDeliveryOrderPickingItem : saleDeliveryOrderPickingItems) {
			
		}
	}
	
}
