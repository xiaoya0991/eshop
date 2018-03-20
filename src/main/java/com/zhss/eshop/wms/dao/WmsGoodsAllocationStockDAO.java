package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.WmsGoodsAllocationStockDO;

/**
 * 货位库存管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface WmsGoodsAllocationStockDAO {

	/**
	 * 根据商品sku id查询货位库存
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 */
	WmsGoodsAllocationStockDO getBySkuId(
			Long goodsAllocationId, Long goodsSkuId) throws Exception;
	
	/**
	 * 新增货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	void save(WmsGoodsAllocationStockDO goodsAllocationStock) throws Exception;
	
	/**
	 * 更新货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	void update(WmsGoodsAllocationStockDO goodsAllocationStock) throws Exception;
	
}
