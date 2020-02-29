package com.zhss.eshop.order.schedule;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.logistics.service.LogisticsService;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.state.LoggedOrderStateManager;

/**
 * 自动确认收货任务
 * @author zhonghuashishan
 *
 */
@Component
public class AutoConfirmReceiptTask {
	
	private static final Logger logger = LoggerFactory.getLogger(AutoConfirmReceiptTask.class);
	
	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDao orderInfoDAO;
	/**
	 * 物流中心接口
	 */
	@Autowired
	private LogisticsService logisticsService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 订单状态管理器
	 */
	@Autowired
	private LoggedOrderStateManager orderStateManager;
	
	@Scheduled(fixedRate = 1 * 60 * 1000)
	public void execute() {
		try {
			List<OrderInfoDO> unreceivedOrders = orderInfoDAO.listUnreceived();
			
			for(OrderInfoDO unreceivedOrder : unreceivedOrders) {
				Date signedTime = logisticsService.getSignedTime(unreceivedOrder.getId(), 
						unreceivedOrder.getOrderNo());
				
				if(signedTime == null) {
					continue;
				}
				
				if(dateProvider.getCurrentTime().getTime() - signedTime.getTime() > 7 * 24 * 60 * 60 * 1000) {
					orderStateManager.confirmReceipt(unreceivedOrder.clone(OrderInfoDTO.class));   
					
					unreceivedOrder.setConfirmReceiptTime(dateProvider.getCurrentTime()); 
					orderInfoDAO.update(unreceivedOrder); 
				} 
			}
		} catch (Exception e) {
			logger.error("error", e); 
		}
	}
	
}
