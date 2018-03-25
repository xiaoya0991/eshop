package com.zhss.eshop.order.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.Inventory.service.InventoryService;
import com.zhss.eshop.membership.service.MembershipService;
import com.zhss.eshop.order.constant.OrderOperateType;
import com.zhss.eshop.order.constant.PublishedComment;
import com.zhss.eshop.order.constant.ReturnGoodsApplyStatus;
import com.zhss.eshop.order.dao.OrderOperateLogDAO;
import com.zhss.eshop.order.dao.ReturnGoodsApplyDAO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.service.OrderInfoService;
import com.zhss.eshop.order.service.OrderService;
import com.zhss.eshop.order.state.OrderStateManager;
import com.zhss.eshop.schedule.service.ScheduleService;

/**
 * 订单中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	/**
	 * 订单状态管理器
	 */
	@Autowired
	private OrderStateManager orderStateManager;
	/**
	 * 订单管理service组件
	 */
	@Autowired
	private OrderInfoService orderInfoService;
	/**
	 * 库存中心接口
	 */
	@Autowired
	private InventoryService inventoryService;
	/**
	 * 调度中心接口
	 */
	@Autowired
	private ScheduleService scheduleService;
	/**
	 * 会员中心接口
	 */
	@Autowired
	private MembershipService membershipService;
	/**
	 * 订单操作日志管理DAO组件
	 */
	@Autowired
	private OrderOperateLogDAO orderOperateLogDAO;
	/**
	 * 订单操作日志工厂
	 */
	@Autowired
	private OrderOperateLogFactory orderOperateLogFactory;
	/**
	 * 退货申请管理DAO
	 */
	@Autowired
	private ReturnGoodsApplyDAO returnGoodsApplyDAO;
	
	/**
	 * 通知订单中心，“商品完成发货”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informGoodsDeliveryFinishedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.finishDelivery(order);
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.GOODS_DELIVERY));  
			
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“退货工单审核不通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.rejectReturnGoodsApply(order);
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.RETURN_GOODS_REJECTED));  
			returnGoodsApplyDAO.updateStatus(orderId, ReturnGoodsApplyStatus.REJECTED); 
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“退货工单审核通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsWorsheetApprovedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.passedReturnGoodsApply(order); 
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.RETURN_GOODS_APPROVED));  
			returnGoodsApplyDAO.updateStatus(orderId, ReturnGoodsApplyStatus.PASSED); 
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“确认收到退货商品”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsReceivedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.confirmReceivedReturnGoods(order); 
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.CONFIRM_RETURN_GOODS_RECEIPT));  
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“退货入库单审核通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.finishedInputReturnGoods(order); 
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.FINISHED_RETURN_GOODS_INPUT));  
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“完成退款”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informRefundFinishedEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			orderStateManager.finishedRefund(order); 
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.FINISHED_RETURN_GOODS_REFUND));  
			return true;
		} catch (Exception e) {
			logger.error("error", e);
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“支付订单成功了”
	 * @param orderInfoId 订单id
	 * @return 处理结果
	 */
	public Boolean informPayOrderSuccessed(Long orderInfoId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderInfoId);
			orderStateManager.pay(order);
			orderOperateLogDAO.save(orderOperateLogFactory.get(order, OrderOperateType.PAY_ORDER));  
			inventoryService.informPayOrderEvent(order);
			scheduleService.scheduleSaleDelivery(order);
			membershipService.informPayOrderEvent(order.getUserAccountId(), order.getPayableAmount());
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“订单发表评论”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informPublishCommentEvent(Long orderId) {
		try {
			OrderInfoDTO order = orderInfoService.getById(orderId);
			order.setPublishedComment(PublishedComment.YES);  
			orderInfoService.update(order); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知订单中心，“订单批量发表评论”事件发生了
	 * @param orderIds 订单id集合
	 * @return 处理结果
	 */
	public Boolean informBatchPublishCommentEvent(List<Long> orderIds) {
		try {
			for(Long orderId : orderIds) {
				informPublishCommentEvent(orderId);
			}
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 从订单中心获取，确认收货时间超过了7天，而且还没有发表评论的订单
	 * @return 订单信息DTO集合
	 */
	public List<OrderInfoDTO> listNotPublishedCommentOrders() {
		try {
			return orderInfoService.listNotPublishedCommentOrders();
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询订单
	 * @param orderInfoId 订单id
	 * @return 订单
	 */
	public OrderInfoDTO getOrderById(Long orderInfoId) {
		try {
			return orderInfoService.getById(orderInfoId); 
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
