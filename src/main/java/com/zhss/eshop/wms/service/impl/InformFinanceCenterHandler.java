package com.zhss.eshop.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.finance.service.FinanceService;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;

/**
 * 通知财务中心的handler
 * @author zhonghuashishan
 *
 */
@Component
public class InformFinanceCenterHandler extends AbstractPurchaseInputOrderHandler {

	/**
	 * 财务中心接口
	 */
	@Autowired
	private FinanceService financeService;
	
	/**
	 * 执行处理结果
	 */
	public PurchaseInputOrderHandlerResult doExecute(
			PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		financeService.createPurchaseSettlementOrder(purchaseInputOrder);
		return new PurchaseInputOrderHandlerResult(true); 
	}

}
