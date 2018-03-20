package com.zhss.eshop.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.wms.constant.WmsStockUpdateEvent;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.stock.WmsStockUpdater;
import com.zhss.eshop.wms.stock.WmsStockUpdaterFactory;

/**
 * 更新本地库存的handler
 * @author zhonghuashishan
 *
 */
@Component
public class UpdateStockHandler extends AbstractPurchaseInputOrderHandler {

	/**
	 * 库存更新组件工厂
	 */
	@Autowired
	private WmsStockUpdaterFactory stockUpdaterFactory;
	
	/**
	 * 执行处理逻辑
	 */
	public PurchaseInputOrderHandlerResult doExecute(PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		WmsStockUpdater stockUpdater = stockUpdaterFactory.create(
				WmsStockUpdateEvent.PURCHASE_INPUT, purchaseInputOrder);
		stockUpdater.update();
		return new PurchaseInputOrderHandlerResult(true); 
	}

}
