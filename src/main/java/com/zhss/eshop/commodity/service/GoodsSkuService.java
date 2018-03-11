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
	 * 根据商品id查询商品sku
	 * @param goodsId 商品id 
	 * @return 商品sku
	 * @throws Exception
	 */
	List<GoodsSkuDTO> listByGoodsId(Long goodsId) throws Exception;

	/**
	 * 批量新增商品sku
	 * @param goodsSku 商品sku
	 * @throws Exception
	 */
	void batchSave(List<GoodsSkuDTO> goodsSkus) throws Exception;
	
	/**
	 * 根据商品id删除sku
	 * @param goodsId 商品id
	 */
	void removeByGoodsId(Long goodsId) throws Exception;
	
}
