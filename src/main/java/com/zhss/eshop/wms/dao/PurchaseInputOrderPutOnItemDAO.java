package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;

/**
 * 采购入库单上架条目DAO接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseInputOrderPutOnItemDAO {

	/**
	 * 批量新增采购入库单上架条目
	 * @param putOnItem 上架条目
	 */
 	void batchSave(List<PurchaseInputOrderPutOnItemDO> putOnItems) throws Exception; 
	
	/**
	 * 根据采购入库单条目id查询采购入库单上架条目
	 * @param purchaseInputOrderItemId 采购入库单id
	 * @return 采购入库单上架条目
	 */
	List<PurchaseInputOrderPutOnItemDO> listByPurchaseInputOrderItemId(
			Long purchaseInputOrderItemId) throws Exception;
	
}
