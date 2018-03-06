package com.zhss.eshop.order.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.promotion.constant.PromotionActivityType;
import com.zhss.eshop.promotion.domain.PromotionActivityDTO;

/**
 * 折扣减免型的订单价格计算组件工厂
 * @author zhonghuashishan
 *
 */
@Component
public class DiscountOrderPriceCalculatorFactory implements OrderPriceCalculatorFactory {

	/**
	 * 默认的总金额计算组件
	 */
	@Autowired
	private DefaultTotalPriceCalculator totalPriceCalculator;
	/**
	 * 满减类型的促销活动计算组件
	 */
	@Autowired
	private ReachDiscountPromotionActivityCalculator reachDiscountPromotionActivityCalculator;
	/**
	 * 多买优惠型的促销活动计算组件
	 */
	@Autowired
	private MultiDiscountPromotionActivityCalculator multiDiscountPromotionActivityCalculator;
	/**
	 * 单品促销型的促销活动计算组件
	 */
	@Autowired
	private DirectDiscountPromotionActivityCalcualtor directDiscountPromotionActivityCalcualtor;
	/**
	 * 默认的促销活动计算组件
	 */
	@Autowired
	private DefaultPromotionActivityCalculator defaultPromotionActivityCalculator;
	/**
	 * 默认的运费计算组件
	 */
	@Autowired
	private DefaultFreightCalculator freightCalculator;
	
	/**
	 * 创建总金额计算组件
	 */
	public TotalPriceCalculator createTotalPriceCalculator() {
		return totalPriceCalculator;
	}

	/**
	 * 创建促销活动计算组件
	 */
	public PromotionActivityCalculator createPromotionActivityCalculator(
			PromotionActivityDTO promotionActivity) {
		if(promotionActivity == null) { 
			return defaultPromotionActivityCalculator;
		}
		
		Integer promotionActivityType = promotionActivity.getType();
		
		if(PromotionActivityType.REACH_DISCOUNT.equals(promotionActivityType)) {
			return reachDiscountPromotionActivityCalculator;
		} else if(PromotionActivityType.MULTI_DISCOUNT.equals(promotionActivityType)) {
			return multiDiscountPromotionActivityCalculator;
		} else if(PromotionActivityType.DIRECT_DISCOUNT.equals(promotionActivityType)) {
			return directDiscountPromotionActivityCalcualtor;
		}
		return defaultPromotionActivityCalculator;
	}
	
	/**
	 * 创建运费计算组件
	 */
	public FreightCalculator createFreightCalculator() {
		return freightCalculator;
	}

}
