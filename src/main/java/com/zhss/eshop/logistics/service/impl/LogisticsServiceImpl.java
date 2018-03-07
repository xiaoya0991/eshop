package com.zhss.eshop.logistics.service.impl;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.logistics.service.LogisticsService;

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
	public Double calculateFreight(GoodsSkuDTO goodsSkuDTO) {
		return 5.5;
	}
	
}
