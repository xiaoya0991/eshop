package com.zhss.eshop.commodity.service;

import com.zhss.eshop.commodity.domain.GoodsDetailDTO;

/**
 * 商品详情管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailService {
	
	/**
	 * 根据商品id查询商品详情
	 * @param goodsId 商品id
	 * @return 商品详情
	 * @throws Exception
	 */
	GoodsDetailDTO getByGoodsId(Long goodsId) throws Exception;

	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 * @return 商品详情id
	 * @throws Exception
	 */
	Long save(GoodsDetailDTO goodsDetail) throws Exception;
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 * @throws Exception 
	 */
	void update(GoodsDetailDTO goodsDetail) throws Exception;
	
}
