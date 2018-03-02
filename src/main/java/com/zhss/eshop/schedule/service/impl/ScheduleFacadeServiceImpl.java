package com.zhss.eshop.schedule.service.impl;

import org.springframework.stereotype.Service;

import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.schedule.service.ScheduleFacadeService;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;

/**
 * 调度中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
public class ScheduleFacadeServiceImpl implements ScheduleFacadeService {

	/**
	 * 通知库存中心，“采购入库完成”事件发生了
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	public Boolean informPurchaseInputFinished(
			PurchaseInputOrderDTO purchaseInputOrderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“提交订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“支付订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informPayOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“取消订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informCancelOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知库存中心，“完成退货入库”事件发生了
	 * @param returnGoodsInputOrderDTO 退货入库单DTO
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsInputFinished(
			ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO) {
		return true;
	}
	
	/**
	 * 调度采购入库
	 * @param purchaseOrderDTO 采购单DTO
	 * @return 处理结果
	 */
	public Boolean schedulePurchaseInput(PurchaseOrderDTO purchaseOrderDTO) {
		return true;
	}

	/**
	 * 调度销售出库
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean scheduleSaleDelivery(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 调度退货入库
	 * @param orderDTO 订单DTO
	 * @param returnGoodsWorksheetDTO 退货工单DTO
	 * @return 处理结果
	 */
	public Boolean scheduleReturnGoodsInput(OrderInfoDTO orderDTO, 
			ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO) {
		return true;
	}
	
}
