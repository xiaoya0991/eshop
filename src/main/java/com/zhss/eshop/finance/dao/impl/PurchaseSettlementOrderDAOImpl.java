package com.zhss.eshop.finance.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.finance.dao.PurchaseSettlementOrderDAO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderDO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderQuery;
import com.zhss.eshop.finance.mapper.PurchaseSettlementOrderMapper;

/**
 * 采购结算单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PurchaseSettlementOrderDAOImpl implements PurchaseSettlementOrderDAO {

	/**
	 * 采购结算单管理mapper组件
	 */
	@Autowired
	private PurchaseSettlementOrderMapper purchaseSettlementOrderMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 */
	public Long save(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception {
		purchaseSettlementOrder.setGmtCreate(dateProvider.getCurrentTime()); 
		purchaseSettlementOrder.setGmtModified(dateProvider.getCurrentTime()); 
		purchaseSettlementOrderMapper.save(purchaseSettlementOrder); 
		return purchaseSettlementOrder.getId();
	}
	
	/**
	 * 分页查询采购结算单
	 * @param query 查询条件
	 * @return 采购结算单
	 */
	public List<PurchaseSettlementOrderDO> listByPage(
			PurchaseSettlementOrderQuery query) throws Exception {
		return purchaseSettlementOrderMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询采购结算单
	 * @param id 采购结算单id
	 * @return 采购结算单
	 */
	public PurchaseSettlementOrderDO getById(Long id) throws Exception {
		return purchaseSettlementOrderMapper.getById(id);
	}
	
	/**
	 * 更新采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 */
	public void update(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception {
		purchaseSettlementOrder.setGmtModified(dateProvider.getCurrentTime()); 
		purchaseSettlementOrderMapper.update(purchaseSettlementOrder); 
	}
	
	/**
	 * 更新采购结算单状态
	 * @param purchaseSettlementOrder 采购结算单
	 */
	public void updateStatus(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception {
		purchaseSettlementOrder.setGmtModified(dateProvider.getCurrentTime()); 
		purchaseSettlementOrderMapper.updateStatus(purchaseSettlementOrder);
	}
	
	/**
	 * 更新采购结算单状态
	 * @param id 采购结算单id
	 * @param status 采购结算单状态
	 * @throws Exception
	 */
	public void updateStatus(Long id, Integer status) throws Exception {
		PurchaseSettlementOrderDO purchaseSettlementOrder = getById(id);
		purchaseSettlementOrder.setStatus(status);   
		updateStatus(purchaseSettlementOrder);  
	}
	
}
