package com.zhss.eshop.logistics.service.impl;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.logistics.service.LogisticsService;
import com.zhss.eshop.membership.domain.DeliveryAddressDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.wms.domain.LogisticOrderDTO;

/**
 * 物流中心接口
 * @author zhonghuashishan
 *
 */
public class LogisticsServiceImpl implements LogisticsService {

	/**
	 * 计算商品sku的运费
	 * @param goodsSkuDTO 商品sku DTO
	 * @return 商品sku的运费
	 */
	public Double calculateFreight(GoodsSkuDTO goodsSkuDTO, 
			DeliveryAddressDTO deliveryAddress) {
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
	
}
