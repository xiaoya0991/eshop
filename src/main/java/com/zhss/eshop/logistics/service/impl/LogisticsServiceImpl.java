package com.zhss.eshop.logistics.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.logistics.service.LogisticsService;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;
import com.zhss.eshop.wms.domain.LogisticOrderDTO;

/**
 * 物流中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class LogisticsServiceImpl implements LogisticsService {
	
	private static final Logger logger = LoggerFactory.getLogger(LogisticsServiceImpl.class);
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 计算商品sku的运费
	 * @param goodsSkuDTO 商品sku DTO
	 * @return 商品sku的运费
	 */
	public Double calculateFreight(OrderInfoDTO order, OrderItemDTO orderItem) {
		return 5.5;
	}
	
	/**
	 * 申请物流单
	 * @param order 订单
	 * @return 物流单
	 */
	public LogisticOrderDTO applyLogisticOrder(OrderInfoDTO order) {
		return null;
	}
	
	/**
	 * 获取订单的签收时间
	 * @param orderId 订单id
	 * @param orderNo 订单编号
	 * @return 签收时间
	 */
	public Date getSignedTime(Long orderId, String orderNo) {
		try {
			return dateProvider.getCurrentTime();
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
