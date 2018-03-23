package com.zhss.eshop.finance.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.finance.dao.PurchaseSettlementOrderItemDAO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderItemDO;
import com.zhss.eshop.finance.mapper.PurchaseSettlementOrderItemMapper;

/**
 * 采购结算单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PurchaseSettlementOrderItemDAOImpl implements PurchaseSettlementOrderItemDAO {

	/**
	 * 采购结算单条目管理mapper组件
	 */
	@Autowired
	private PurchaseSettlementOrderItemMapper purchaseSettlementOrderItemMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 批量新增采购结算单条目
	 * @param purchaseSettlementOrderId 采购结算单id
	 * @param purchaseSettlementOrderItems 采购结算单条目
	 * @throws Exception
	 */
	public void batchSave(Long purchaseSettlementOrderId, 
			List<PurchaseSettlementOrderItemDO> purchaseSettlementOrderItems) throws Exception {
		for(PurchaseSettlementOrderItemDO purchaseSettlementOrderItem : purchaseSettlementOrderItems) {
			purchaseSettlementOrderItem.setGmtCreate(dateProvider.getCurrentTime());
			purchaseSettlementOrderItem.setGmtModified(dateProvider.getCurrentTime()); 
			purchaseSettlementOrderItem.setPurchaseSettlementOrderId(purchaseSettlementOrderId);
			purchaseSettlementOrderItemMapper.save(purchaseSettlementOrderItem); 
		}
	}
	
	/**
	 * 根据采购结算单id查询采购结算单条目
	 * @param purchaseSettlementOrderId 采购结算单id
	 * @return 采购结算单条目
	 */
	public List<PurchaseSettlementOrderItemDO> listByPurchaseSettlementOrderId(
			Long purchaseSettlementOrderId) throws Exception {
		return purchaseSettlementOrderItemMapper.listByPurchaseSettlementOrderId(
				purchaseSettlementOrderId);
	}
	
}
