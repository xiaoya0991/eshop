package com.zhss.eshop.wms.service.impl;

import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;

/**
 * 采购入库单处理的handler接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseInputOrderHandler {

	/**
	 * 执行处理逻辑
	 * @param purchaseInputOrder 采购入库单
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean execute(PurchaseInputOrderDTO purchaseInputOrder) throws Exception;
	
}
