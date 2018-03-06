package com.zhss.eshop.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.order.price.DefaultOrderPriceCalculatorFactory;
import com.zhss.eshop.order.price.DiscountOrderPriceCalculatorFactory;
import com.zhss.eshop.order.price.FreightCalculator;
import com.zhss.eshop.order.price.GiftOrderPriceCalculatorFactory;
import com.zhss.eshop.order.price.OrderPriceCalculatorFactory;
import com.zhss.eshop.order.price.PromotionActivityCalculator;
import com.zhss.eshop.order.price.PromotionActivityResult;
import com.zhss.eshop.order.price.TotalPriceCalculator;
import com.zhss.eshop.order.service.OrderService;
import com.zhss.eshop.promotion.constant.PromotionActivityType;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;
import com.zhss.eshop.promotion.service.PromotionService;

/**
 * 订单中心接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	/**
	 * 折扣减免型的订单价格计算组件工厂
	 */
	@Autowired
	private DiscountOrderPriceCalculatorFactory discountOrderPriceCalculatorFactory;
	/**
	 * 赠品型的订单价格计算组件工厂
	 */
	@Autowired
	private GiftOrderPriceCalculatorFactory giftOrderPriceCalculatorFactory;
	/**
	 * 默认的订单价格计算组件工厂
	 */
	@Autowired
	private DefaultOrderPriceCalculatorFactory defaultOrderPriceCalculatorFactory;
	/**
	 * 促销中心接口
	 */
	@Autowired
	private PromotionService promotionService;
	
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
	
	/**
	 * 计算订单价格
	 * @param order 订单
	 */
	public OrderInfoDTO calculateOrderPrice(OrderInfoDTO order) {
		// 定义订单的各种价格
		Double totalAmount = 0.0;
		Double discountAmount = 0.0;
		Double freight = 0.0;
		
		for(OrderItemDTO item : order.getOrderItems()) {
			// 查询订单条目使用的促销活动
			PromotionActivityDTO promotionActivity = promotionService.getById(
					item.getPromotionActivityId());
			
			// 根据促销活动获取到订单计算组件的工厂
			OrderPriceCalculatorFactory orderPriceCalculatorFactory = 
					getOrderPriceCalculatorFactory(promotionActivity); 
			
			// 从订单计算组件工厂中获取一套订单的价格计算组件
			TotalPriceCalculator totalPriceCalculator = orderPriceCalculatorFactory
					.createTotalPriceCalculator();
			PromotionActivityCalculator promotionActivityCalculator = orderPriceCalculatorFactory
					.createPromotionActivityCalculator(promotionActivity); 
			FreightCalculator freightCalculator = orderPriceCalculatorFactory
					.createFreightCalculator();
			
			// 计算订单条目的总金额
			totalAmount += totalPriceCalculator.calculate(item);
			
			// 处理促销活动，计算促销活动的减免金额，以及促销活动的赠品
			PromotionActivityResult result = promotionActivityCalculator.calculate(
					item, promotionActivity); 
			discountAmount += result.getDiscountAmount();
			order.getOrderItems().addAll(result.getOrderItems());
			
			// 计算订单条目的运费
			freight += freightCalculator.calculate(item, result);
		}
		
		// 给订单设置计算后的结果（同时已经包含了所有的赠品）
		order.setTotalAmount(totalAmount);
		order.setDiscountAmount(discountAmount); 
		order.setFreight(freight); 
		
		return order;
	}
	
	/**
	 * 获取一个订单价格计算工厂
	 * @param promotionActivityType 促销活动类型
	 * @return 订单价格计算工厂
	 */
	private OrderPriceCalculatorFactory getOrderPriceCalculatorFactory(
			PromotionActivityDTO promotionActivity) {
		if(promotionActivity == null) {
			return defaultOrderPriceCalculatorFactory;
		}
		
		Integer promotionActivityType = promotionActivity.getType();
		
		if(PromotionActivityType.DIRECT_DISCOUNT.equals(promotionActivityType) 
				|| PromotionActivityType.MULTI_DISCOUNT.equals(promotionActivityType)
				|| PromotionActivityType.REACH_DISCOUNT.equals(promotionActivityType)) {  
			return discountOrderPriceCalculatorFactory;
		} else {
			return giftOrderPriceCalculatorFactory;
		}
	}
	
}
