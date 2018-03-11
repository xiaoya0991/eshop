package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsDetailDO;

/**
 * 商品详情管理DAO组件
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailDAO {

	/**
	 * 根据商品id查询商品详情
	 * @param goodsId 商品id
	 * @return 商品详情
	 */
	GoodsDetailDO getByGoodsId(Long goodsId);
	
	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 */
	Long save(GoodsDetailDO goodsDetail);
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 */
	void update(GoodsDetailDO goodsDetail);
	
}
