package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.commodity.service.CommodityService;
import com.zhss.eshop.logistics.service.LogisticsService;
import com.zhss.eshop.membership.domain.DeliveryAddressDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 含赠品的运费计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class GiftIncludedFreightCalculator implements FreightCalculator {
	
	/**
	 * 物流中心接口
	 */
	@Autowired
	private LogisticsService logisticsService;
	/**
	 * 商品中心接口
	 */
	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 计算运费
	 */
	public Double calculate(OrderItemDTO item, DeliveryAddressDTO deliveryAddress, 
			PromotionActivityResult result) {
		Double freight = 0.0;
		
		GoodsSkuDTO goodsSku = commodityService.getGoodsSkuById(item.getGoodsSkuId());
		freight += logisticsService.calculateFreight(goodsSku, deliveryAddress);
		
		for(OrderItemDTO giftItem : result.getOrderItems()) {
			GoodsSkuDTO giftGoodsSku = commodityService.getGoodsSkuById(giftItem.getGoodsSkuId());
			freight += logisticsService.calculateFreight(giftGoodsSku, deliveryAddress);
		}
		
		return freight;
	}

}
