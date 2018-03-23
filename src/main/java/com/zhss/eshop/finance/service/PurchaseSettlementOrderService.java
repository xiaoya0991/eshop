package com.zhss.eshop.finance.service;

import java.util.List;

import com.zhss.eshop.finance.domain.PurchaseSettlementOrderDTO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderQuery;

/**
 * 采购结算单管理service接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseSettlementOrderService {

	/**
	 * 新增采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 */
	void save(PurchaseSettlementOrderDTO purchaseSettlementOrder) throws Exception;
	
	/**
	 * 分页查询采购结算单
	 * @return 采购结算单
	 * @throws Exception
	 */
	List<PurchaseSettlementOrderDTO> listByPage(PurchaseSettlementOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询采购结算单
	 * @return 采购结算单
	 * @throws Exception
	 */
	PurchaseSettlementOrderDTO getById(Long id) throws Exception;
	
	/**
	 * 更新采购结算单
	 * @param purchaseSettlementOrder 采购结算单
	 * @throws Exception
	 */
	void update(PurchaseSettlementOrderDTO purchaseSettlementOrder) throws Exception;
	
	/**
	 * 对采购结算单提交审核
	 * @param id 采购结算单id
	 * @throws Exception 
	 */
	void submitApprove(Long id) throws Exception;
	
	/**
	 * 审核采购结算单
	 * @param id 采购结算单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	void approve(Long id, Integer approveResult) throws Exception;
	
}
