package com.zhss.eshop.wms.service;

import com.zhss.eshop.schedule.domain.SaleDeliveryScheduleResult;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * WMS中心接口
 * @author zhonghuashishan
 *
 */
public interface WmsService {

	/**
	 * 创建采购入库单
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);
	
	/**
	 * 创建销售出库单
	 * @param saleDeliveryOrderDTO 销售出库单DTO
	 * @return 处理结果
	 */
	Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrder);
	
	/**
	 * 创建退货入库单
	 * @param returnGoodsInputOrder 退货入库单DTO
	 * @return 处理结果
	 */
	Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrder);
	
	/**
	 * 通知WMS中心，“提交订单”事件发生了
	 * @param scheduleResult 调度结果
	 * @return 处理结果
	 */
	Boolean informSubmitOrderEvent(SaleDeliveryScheduleResult scheduleResult);
	
	/**
	 * 通知WMS中心，“支付订单”事件发生了
	 * @param scheduleResult 调度结果
	 * @return 处理结果
	 */
	Boolean informPayOrderEvent(SaleDeliveryScheduleResult scheduleResult);
	
	/**
	 * 通知WMS中心，“取消订单”事件发生了
	 * @param scheduleResult 调度结果
	 * @return 处理结果
	 */
	Boolean informCancelOrderEvent(SaleDeliveryScheduleResult scheduleResult);
	
	/**
	 * 获取订单对应的物流单号 
	 * @param orderId 订单id
	 * @return 物流单号
	 */
	String getLogisticCode(Long orderId);
	
	/**
	 * 通知wms中心，“创建采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseInputOrderId);
	
	/**
	 * 通知wms中心，“完成采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseInputOrderId);
	
}
