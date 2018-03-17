package com.zhss.eshop.commodity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;
import com.zhss.eshop.commodity.service.CommodityService;
import com.zhss.eshop.commodity.service.GoodsSkuService;

/**
 * 商品中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class CommodityServiceImpl implements CommodityService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);
	
	/**
	 * 商品sku管理service组件
	 */
	@Autowired
	private GoodsSkuService goodsSkuService;
	
	/**
	 * 根据id查询商品sku
	 * @param goodsSkuId 商品sku id
	 * @return 商品sku DTO
	 */
	public GoodsSkuDTO getGoodsSkuById(Long goodsSkuId) {
		try {
			return goodsSkuService.getById(goodsSkuId);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
