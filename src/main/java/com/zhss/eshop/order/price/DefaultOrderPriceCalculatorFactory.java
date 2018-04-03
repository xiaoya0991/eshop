package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 默认的订单价格计算组件工厂
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultOrderPriceCalculatorFactory implements OrderPriceCalculatorFactory {

	/**
	 * 默认的总金额计算组件
	 */
	@Autowired
	private DefaultTotalPriceCalculator totalPriceCalculator;
	/**
	 * 没有促销活动的计算组件
	 */
	@Autowired
	private DefaultPromotionActivityCalculator promotionActivityCalculator;
	/**
	 * 默认的运费计算组件
	 */
	@Autowired
	private DefaultFreightCalculator freightCalculator;
	
	/**
	 * 创建订单总金额价格计算组件
	 * @return 订单总金额价格计算组件
	 */
	@Override
	public TotalPriceCalculator createTotalPriceCalculator() {
		return totalPriceCalculator;
	}
	
	/**
	 * 创建促销活动价格计算组件
	 * @return 促销活动价格计算组件
	 */
	@Override
	public PromotionActivityCalculator createPromotionActivityCalculator(
			PromotionActivityDTO promotionActivity) {
		return promotionActivityCalculator;
	}
	
	/**
	 * 创建运费价格计算组件
	 * @return 运费价格计算组件
	 */
	@Override
	public FreightCalculator createFreightCalculator() {
		return freightCalculator;
	}
	
}
