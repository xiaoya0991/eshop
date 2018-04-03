package com.zhss.eshop.order.price;

import java.util.ArrayList;
import java.util.List;

import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 促销活动处理结果
 * @author zhonghuashishan
 *
 */
public class PromotionActivityResult {

	/**
	 * 促销减免金额
	 */
	private Double discountAmount = 0.0;
	/**
	 * 赠品对应的订单条目
	 */
	private List<OrderItemDTO> orderItems = new ArrayList<OrderItemDTO>();  
	
	public PromotionActivityResult() {
		
	}
	
	public PromotionActivityResult(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
	
}
