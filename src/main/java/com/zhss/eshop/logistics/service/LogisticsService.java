package com.zhss.eshop.logistics.service;

import java.util.Date;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.LogisticOrderDTO;

/**
 * 物流中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface LogisticsService {

	/**
	 * 计算商品sku的运费
	 * @param goodsSkuDTO 商品sku DTO
	 * @return 商品sku的运费
	 */
	Double calculateFreight(OrderInfoDTO order, OrderItemDTO orderItem);
	
	/**
	 * 申请物流单
	 * @param order 订单
	 * @return 物流单
	 */
	LogisticOrderDTO applyLogisticOrder(OrderInfoDTO order);
	
	/**
	 * 获取订单的签收时间
	 * @param orderId 订单id
	 * @param orderNo 订单编号
	 * @return 签收时间
	 */
	Date getSignedTime(Long orderId, Long orderNo);
	
}
