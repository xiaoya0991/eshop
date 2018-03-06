package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.commodity.service.CommodityService;
import com.zhss.eshop.logistics.service.LogisticsService;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 默认的运费计算组件
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultFreightCalculator implements FreightCalculator {

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
	public Double calculate(OrderItemDTO item , PromotionActivityResult result) {
		GoodsSkuDTO goodsSku = commodityService.getGoodsSkuById(item.getGoodsSkuId());
		return logisticsService.calculateFreight(goodsSku);
	}

}
