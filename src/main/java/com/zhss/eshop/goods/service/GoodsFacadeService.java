package com.zhss.eshop.goods.service;

import com.zhss.eshop.goods.dto.GoodsSkuDTO;

/**
 * 商品中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface GoodsFacadeService {

	/**
	 * 根据id查询商品sku
	 * @param goodsSkuId 商品sku id
	 * @return 商品sku DTO
	 */
	GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
	
}
