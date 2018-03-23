package com.zhss.eshop.purchase.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.dao.PurchaseOrderItemDAO;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDO;
import com.zhss.eshop.purchase.mapper.PurchaseOrderItemMapper;

/**
 * 采购单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PurchaseOrderItemDAOImpl implements PurchaseOrderItemDAO {

	/**
	 * 采购单条目管理mapper组件
	 */
	@Autowired
	private PurchaseOrderItemMapper purchaseOrderItemMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 批量新增采购单条目
	 * @param purchaseOrderId 采购单id
	 * @param purchaseOrderItems 采购单条目
	 * @throws Exception
	 */
	public void batchSave(Long purchaseOrderId, List<PurchaseOrderItemDO> purchaseOrderItems) throws Exception {
		for(PurchaseOrderItemDO purchaseOrderItem : purchaseOrderItems) {
			purchaseOrderItem.setPurchaseOrderId(purchaseOrderId);
			purchaseOrderItem.setGmtCreate(dateProvider.getCurrentTime()); 
			purchaseOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
			purchaseOrderItemMapper.save(purchaseOrderItem); 
		}
	}
	
	/**
	 * 根据采购单id查询采购单条目
	 * @param purchaseOrderId 采购单id
	 * @return 采购单条目
	 */
	public List<PurchaseOrderItemDO> listByPurchaseOrderId(Long purchaseOrderId) throws Exception {
		return purchaseOrderItemMapper.listByPurchaseOrderId(purchaseOrderId);
	}
	
}
