package com.zhss.eshop.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.schedule.service.ScheduleService;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;

/**
 * 通知调度中心的handler
 * @author zhonghuashishan
 *
 */
@Component
public class InformScheduleCenterHandler extends AbstractPurchaseInputOrderHandler {

	/**
	 * 调度中心接口
	 */
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 执行处理逻辑
	 */
	public PurchaseInputOrderHandlerResult doExecute(
			PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		scheduleService.informPurchaseInputFinished(purchaseInputOrder);
		return new PurchaseInputOrderHandlerResult(true); 
	}

}
