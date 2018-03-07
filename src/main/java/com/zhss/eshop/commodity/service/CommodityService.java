package com.zhss.eshop.commodity.service;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;

/**
 * 商品中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface CommodityService {

	/**
	 * 根据id查询商品sku
	 * @param goodsSkuId 商品sku id
	 * @return 商品sku DTO
	 */
	GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
	
}
