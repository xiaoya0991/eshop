package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;

/**
 * 调度中心的货位库存明细管理的DAO接口
 * @author zhonghuashishan
 *
 */
public interface GoodsAllocationStockDetailDAO {

	/**
	 * 根据商品sku id查询货位库存明细
	 * @param goodsSkuId 商品sku id 
	 * @return 货位库存明细
	 */
	List<GoodsAllocationStockDetailDO> listByGoodsSkuId(
			Long goodsSkuId) throws Exception;
	
	/**
	 * 根据id查询货位库存明细
	 * @param id 货位库粗明细id
	 * @return 货位库存明细
	 */
	GoodsAllocationStockDetailDO getById(Long id) throws Exception;
	
	/**
	 * 更新货位库存明细 
	 * @param stockDetail 货位库存明细
	 * @throws Exception
	 */
	void update(GoodsAllocationStockDetailDO stockDetail) throws Exception;
	
	/**
	 * 新增货位库存明细
	 * @param stockDetail 货位库存明细
	 * @throws Exception
	 */
	void save(GoodsAllocationStockDetailDO stockDetail) throws Exception;
	
	/**
	 * 根据上架条目新增一个货位库存明细
	 * @param putOnItem 上架条目
	 * @throws Exception
	 */
	GoodsAllocationStockDetailDO saveByPutOnItem(
			PurchaseInputOrderPutOnItemDO putOnItem) throws Exception;
	
}
