package com.zhss.eshop.purchase.dao;

import java.util.List;

import com.zhss.eshop.purchase.domain.PurchaseOrderItemDO;

/**
 * 采购单条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseOrderItemDAO {

	/**
	 * 批量新增采购单条目
	 * @param purchaseOrderId 采购单id
	 * @param purchaseOrderItems 采购单条目
	 * @throws Exception
	 */
	void batchSave(Long purchaseOrderId, 
			List<PurchaseOrderItemDO> purchaseOrderItems) throws Exception;
	
	/**
	 * 根据采购单id查询采购单条目
	 * @param purchaseOrderId 采购单id
	 * @return 采购单条目
	 * @throws Exception
	 */
	List<PurchaseOrderItemDO> listByPurchaseOrderId(Long purchaseOrderId) throws Exception;
	
	/**
	 * 根据采购单id删除采购单条目
	 * @param purchaseOrderId 采购单id
	 * @throws Exception
	 */
	void removeByPurchaseOrderId(Long purchaseOrderId) throws Exception;
	
}
