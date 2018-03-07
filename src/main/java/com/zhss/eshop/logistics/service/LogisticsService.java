package com.zhss.eshop.logistics.service;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.membership.domain.DeliveryAddressDTO;

/**
 * 物流中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface LogisticsService {

	/**
	 * 计算商品sku的运费
	 * @param goodsSkuDTO 商品sku DTO
	 * @return 商品sku的运费
	 */
	Double calculateFreight(GoodsSkuDTO goodsSkuDTO, 
			DeliveryAddressDTO deliveryAddress);
	
}
