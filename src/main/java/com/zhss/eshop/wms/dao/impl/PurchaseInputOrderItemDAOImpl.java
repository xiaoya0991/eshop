package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.PurchaseInputOrderItemDAO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDO;
import com.zhss.eshop.wms.mapper.PurchaseInputOrderItemMapper;

/**
 * 采购入库单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PurchaseInputOrderItemDAOImpl implements PurchaseInputOrderItemDAO {

	/**
	 * 采购入库单条目管理mapper组件
	 */
	@Autowired
	private PurchaseInputOrderItemMapper purchaseInputOrderItemMapper;
	
	/**
	 * 批量新增采购入库单条目
	 * @param purchaseInputOrderId 采购入库单id
	 * @param purchaseInputOrderItems 采购入库单条目
	 * @throws Exception
	 */
	public void batchSave(Long purchaseInputOrderId, 
			List<PurchaseInputOrderItemDO> purchaseInputOrderItems) throws Exception {
		for(PurchaseInputOrderItemDO purchaseInputOrderItem : purchaseInputOrderItems) {
			purchaseInputOrderItem.setPurchaseInputOrderId(purchaseInputOrderId);
			purchaseInputOrderItemMapper.save(purchaseInputOrderItem); 
		}
	}
	
	/**
	 * 根据采购入库单id查询采购入库单条目
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 采购入库单条目
	 */
	public List<PurchaseInputOrderItemDO> listByPurchaseInputOrderId(
			Long purchaseInputOrderId) throws Exception {
		return purchaseInputOrderItemMapper.listByPurchaseInputOrderId(
				purchaseInputOrderId);
	}
	
	/**
	 * 更新采购入库单条目
	 * @param purchaseInputOrderItem 采购入库单条目
	 */
	public void update(PurchaseInputOrderItemDO purchaseInputOrderItem) throws Exception {
		purchaseInputOrderItemMapper.update(purchaseInputOrderItem);
	}
	
}
