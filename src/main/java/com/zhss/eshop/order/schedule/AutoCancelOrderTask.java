package com.zhss.eshop.order.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.Inventory.service.InventoryService;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.dao.OrderItemDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.order.state.LoggedOrderStateManager;

/**
 * 自动取消订单任务
 * @author zhonghuashishan
 *
 */
@Component
@Transactional
public class AutoCancelOrderTask {
	
	private static final Logger logger = LoggerFactory.getLogger(AutoCancelOrderTask.class);
	
	/**
	 * 订单管理DAO组件
	 */
	@Autowired
	private OrderInfoDAO orderInfoDAO;
	/**
	 * 订单条目管理DAO组件
	 */
	@Autowired
	private OrderItemDAO orderItemDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	/**
	 * 订单状态管理组件
	 */
	@Autowired
	private LoggedOrderStateManager orderStateManager;
	/**
	 * 库存中心接口
	 */
	@Autowired
	private InventoryService inventoryService;
	
	/**
	 * 执行任务逻辑
	 */
	 @Scheduled(fixedRate = 1 * 60 * 1000)
	 public void execute() {
		 try {
			 for(OrderInfoDO orderInfoDO : orderInfoDAO.listAllUnpayed()) { 
				 OrderInfoDTO order = getOrderInfoDTO(orderInfoDO);
				 
				 if(dateProvider.getCurrentTime().getTime() - 
						 order.getGmtCreate().getTime() <= 24 * 60 * 60 * 1000) {
					 continue;
				 }
				 
				 orderStateManager.cancel(order);
				 inventoryService.informCancelOrderEvent(order);
			 }
		} catch (Exception e) {
			logger.error("error", e); 
		}
	 }
	 
	 /**
	  * 将订单DO转换为订单DTO
	  * @param orderInfoDO 订单DO 
	  * @return 订单DTO
	  * @throws Exception
	  */
	 private OrderInfoDTO getOrderInfoDTO(OrderInfoDO orderInfoDO) throws Exception {
		 OrderInfoDTO orderInfoDTO = orderInfoDO.clone(OrderInfoDTO.class);
		 List<OrderItemDTO> orderItems = ObjectUtils.convertList(
				orderItemDAO.listByOrderInfoId(orderInfoDTO.getId()), OrderItemDTO.class);
		 orderInfoDTO.setOrderItems(orderItems);
		return orderInfoDTO;	
	 }
	
}
