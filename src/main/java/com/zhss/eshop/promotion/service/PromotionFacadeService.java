package com.zhss.eshop.promotion.service;

import java.util.List;

import com.zhss.eshop.promotion.dto.PromotionActivityDTO;

/**
 * 促销中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface PromotionFacadeService {
	
	/**
	 * 根据商品id查询促销活动
	 * @param goodsId 商品id
	 * @return 促销活动
	 */
	List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(Long goodsId);
	
}
