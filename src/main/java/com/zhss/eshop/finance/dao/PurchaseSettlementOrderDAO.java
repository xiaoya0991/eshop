package com.zhss.eshop.finance.dao;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.finance.domain.PurchaseSettlementOrderDO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderQuery;

/**
 * 采购结算单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseSettlementOrderDAO {

	/**
	 * 新增采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 * @return 采购结算单id
	 * @throws Exception
	 */
	Long save(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception;
	
	/**
	 * 分页查询采购结算单
	 * @param query 查询条件
	 * @return 采购结算单
	 * @throws Exception
	 */
	List<PurchaseSettlementOrderDO> listByPage(PurchaseSettlementOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询采购结算单
	 * @param id 采购结算单id
	 * @return 采购结算单
	 * @throws Exception
	 */
	PurchaseSettlementOrderDO getById(Long id) throws Exception; 
	
	/**
	 * 更新采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 * @throws Exception
	 */
	void update(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception;
	
	/**
	 * 更新采购结算单状态
	 * @param purchaseSettlementOrder 采购结算单
	 * @throws Exception
	 */
	void updateStatus(PurchaseSettlementOrderDO purchaseSettlementOrder) throws Exception;

	/**
	 * 更新采购结算单状态
	 * @param id 采购结算单id
	 * @param status 采购结算单状态
	 * @throws Exception
	 */
	void updateStatus(Long id, Integer status) throws Exception;
	
	/**
	 * 查询指定供应商在指定时间范围内的已完成的采购结算单
	 * @param supplierId 供应商id
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @return 采购结算单
	 * @throws Exception
	 */
	List<PurchaseSettlementOrderDO> listFinishedBySettlementPeriod(
			Long supplierId, Date startTime, Date endTime) throws Exception; 
	
}
