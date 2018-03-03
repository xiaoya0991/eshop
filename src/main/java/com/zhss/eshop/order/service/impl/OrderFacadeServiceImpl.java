package com.zhss.eshop.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.service.OrderFacadeService;

/**
 * 订单中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class OrderFacadeServiceImpl implements OrderFacadeService {
	
	/**
	 * 通知订单中心，“商品完成发货”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informGoodsDeliveryFinishedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“退货工单审核不通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“退货工单审核通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsWorsheetApprovedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“确认收到退货商品”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsReceivedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“退货入库单审核通过”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“完成退款”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informRefundFinishedEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 通知订单中心，“订单发表评论”事件发生了
	 * @param orderId 订单id
	 * @return 处理结果
	 */
	public Boolean informPublishCommentEvent(Long orderId) {
		return true;
	}
	
	/**
	 * 从订单中心获取，确认收货时间超过了7天，而且还没有发表评论的订单
	 * @return 订单信息DTO集合
	 */
	public List<OrderInfoDTO> listNotPublishedCommentOrders() {
		return new ArrayList<OrderInfoDTO>();
	}
	
	/**
	 * 通知订单中心，“订单批量发表评论”事件发生了
	 * @param orderIds 订单id集合
	 * @return 处理结果
	 */
	public Boolean informBatchPublishCommentEvent(List<Long> orderIds) {
		return true;
	}

}
