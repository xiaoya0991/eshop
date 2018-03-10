package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsSkuDO;

/**
 * 商品sku管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface GoodsSkuDAO {

	/**
	 * 新增商品sku
	 * @param goodsSku
	 */
	Long save(GoodsSkuDO goodsSku);
	
}
