package com.zhss.eshop.commodity.service;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;

/**
 * 商品sku管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsSkuService {

	/**
	 * 批量新增商品sku
	 * @param goodsSku 商品sku
	 * @throws Exception
	 */
	void batchSave(List<GoodsSkuDTO> goodsSkus) throws Exception;
	
}
