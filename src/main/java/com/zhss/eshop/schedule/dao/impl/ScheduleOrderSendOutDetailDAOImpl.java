package com.zhss.eshop.schedule.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.schedule.dao.ScheduleOrderSendOutDetailDAO;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDO;
import com.zhss.eshop.schedule.domain.ScheduleOrderSendOutDetailDTO;
import com.zhss.eshop.schedule.mapper.ScheduleOrderSendOutDetailMapper;

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
	 * 批量新增发货明细
	 * @param orderItem 订单条目
	 * @param sendOutDetails 发货明细
	 * @throws Exception
	 */
	public void batchSave(OrderItemDTO orderItem, 
			List<ScheduleOrderSendOutDetailDTO> sendOutDetails) throws Exception {
		for(ScheduleOrderSendOutDetailDTO sendOutDetail : sendOutDetails) {
			sendOutDetail.setOrderInfoId(orderItem.getOrderInfoId()); 
			sendOutDetail.setOrderItemId(orderItem.getId()); 
			sendOutDetail.setGmtCreate(dateProvider.getCurrentTime()); 
			sendOutDetail.setGmtModified(dateProvider.getCurrentTime());  
			sendOutDetailMapper.save(sendOutDetail.clone(ScheduleOrderSendOutDetailDO.class));   
		}
	}
	
	/**
	 * 根据订单id和订单条目id查询发货明细
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 * @return
	 */
	public List<ScheduleOrderSendOutDetailDO> listByOrderItemId(Long orderInfoId, 
			Long orderItemId) throws Exception {
		return sendOutDetailMapper.listByOrderItemId(orderInfoId, orderItemId);
	}
	
	/**
	 * 根据订单条目id删除发货明细
	 * @param orderInfoId 订单id
	 * @param orderItemId 订单条目id
	 */
	public void removeByOrderItemId(Long orderInfoId, 
			Long orderItemId) throws Exception {
		sendOutDetailMapper.removeByOrderItemId(orderInfoId, orderItemId);
	}
	
}
