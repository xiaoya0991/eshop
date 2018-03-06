package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.promotion.constant.PromotionActivityType;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 赠品类型的订单价格计算组件工厂
 * @author zhonghuashishan
 *
 */
@Component
public class GiftOrderPriceCalculatorFactory implements OrderPriceCalculatorFactory {

	/**
	 * 默认的总金额计算组件
	 */
	@Autowired
	private DefaultTotalPriceCalculator totalPriceCalculator;
	/**
	 * 满赠类型的促销活动计算组件
	 */
	@Autowired
	private ReachGiftPromotionActivityCalculator reachGiftPromotionActivityCalculator;
	/**
	 * 赠品类型的促销活动计算组件
	 */
	@Autowired
	private DirectGiftPromotionActivityCalculator directGiftPromotionActivityCalculator;
	/**
	 * 默认的促销活动计算组件
	 */
	@Autowired
	private DefaultPromotionActivityCalculator defaultPromotionActivityCalculator;
	/**
	 * 包含赠品的运费计算组件
	 */
	@Autowired
	private GiftIncludedFreightCalculator freightCalculator;
	
	/**
	 * 创建订单总金额价格计算组件
	 * @return 订单总金额价格计算组件
	 */
	public TotalPriceCalculator createTotalPriceCalculator() {
		return totalPriceCalculator;
	}
	
	/**
	 * 创建促销活动价格计算组件
	 * @return 促销活动价格计算组件
	 */
	public PromotionActivityCalculator createPromotionActivityCalculator(
			PromotionActivityDTO promotionActivity) {
		if(promotionActivity == null) {
			return defaultPromotionActivityCalculator;
		}
		
		Integer promotionActivityType = promotionActivity.getType();
		
		if(PromotionActivityType.REACH_GIFT.equals(promotionActivityType)) {
			return reachGiftPromotionActivityCalculator;
		} else if(PromotionActivityType.DIRECT_GIFT.equals(promotionActivityType)) {
			return directGiftPromotionActivityCalculator;
		} 
		return defaultPromotionActivityCalculator;
	}
	
	/**
	 * 创建运费价格计算组件
	 * @return 运费价格计算组件
	 */
	public FreightCalculator createFreightCalculator() {
		return freightCalculator;
	}
	
}
