package com.zhss.eshop.wms.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.wms.constant.WmsStockUpdateEvent;

/**
 * 库存更新命令工厂接口
 * @author zhonghuashishan
 *
 */
@Component
public class WmsStockUpdaterFactory { 

	/**
	 * spring容器
	 */
	@Autowired
	private SpringApplicationContext context;
	
	/**
	 * 创建一个库存更新命令
	 * @param parameter 参数对象
	 * @return 库存更新命令
	 */
	public WmsStockUpdater create(Integer stockUpdateEvent, Object parameter) { 
		WmsStockUpdater stockUpdater = null;
		
		if(WmsStockUpdateEvent.PURCHASE_INPUT.equals(stockUpdateEvent)) {
			stockUpdater = context.getBean(PurchaseInputWmsStockUpdater.class);
		} else if(WmsStockUpdateEvent.RETURN_GOODS_INPUT.equals(stockUpdateEvent)) {
			stockUpdater = context.getBean(ReturnGoodsInputWmsStockUpdater.class);
		} else if(WmsStockUpdateEvent.SUBMIT_ORDER.equals(stockUpdateEvent)) {
			stockUpdater = context.getBean(SubmitOrderWmsStockUpdater.class);
		} else if(WmsStockUpdateEvent.CANCEL_ORDER.equals(stockUpdateEvent)) {
			stockUpdater = context.getBean(CancelOrderWmsStockUpdater.class);
		} else if(WmsStockUpdateEvent.PAY_ORDER.equals(stockUpdateEvent)) {
			stockUpdater = context.getBean(PayOrderWmsStockUpdater.class);
		}
		
		stockUpdater.setParameter(parameter); 
		
		return stockUpdater;
	}
	
}
