package com.zhss.eshop.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 采购入库单handler工厂
 * @author zhonghuashishan
 *
 */
@Component
public class PurchaseInputOrderHandlerFactory {

	/**
	 * 更新采购入库单状态handler
	 */
	@Autowired
	private UpdatePurchaseInputOrderStatusHandler updatePurchaseInputOrderStatusHandler;
	/**
	 * 通知采购中心handler
	 */
	@Autowired
	private InformPurchaseCenterHandler informPurchaseCenterHandler;
	/**
	 * 更新本地库存handler
	 */
	@Autowired
	private UpdateStockHandler updateStockHandler;
	/**
	 * 通知调度中心handler
	 */
	@Autowired
	private InformScheduleCenterHandler informScheduleCenterHandler;
	/**
	 * 通知财务中心handler
	 */
	@Autowired
	private InformFinanceCenterHandler informFinanceCenterHandler;
	
	/**
	 * 构造函数：组装责任链条
	 */
	public PurchaseInputOrderHandlerFactory() {
		updatePurchaseInputOrderStatusHandler.setSuccessor(informPurchaseCenterHandler);
		informPurchaseCenterHandler.setSuccessor(updateStockHandler);
		updateStockHandler.setSuccessor(informScheduleCenterHandler); 
		informScheduleCenterHandler.setSuccessor(informFinanceCenterHandler); 
	}
	
	/**
	 * 创建采购入库单handler链条
	 * @param purchaseInputOrder 采购入库单
	 * @return handler链条
	 * @throws Exception
	 */
	public PurchaseInputOrderHandler getHandlerChain() throws Exception {
		return updatePurchaseInputOrderStatusHandler;
	}
	
}
