package com.zhss.eshop.wms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.service.PurchaseInputOrderService;
import com.zhss.eshop.wms.service.ReturnGoodsInputOrderService;
import com.zhss.eshop.wms.service.SaleDeliveryOrderService;
import com.zhss.eshop.wms.service.WmsService;

/**
 * wms中心对外接口service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class WmsServiceImpl implements WmsService {
	
	private static final Logger logger = LoggerFactory.getLogger(WmsServiceImpl.class);
	
	/**
	 * 采购入库单管理service组件
	 */
	@Autowired
	private PurchaseInputOrderService purchaseInputOrderService;
	/**
	 * 销售出库单管理service组件
	 */
	@Autowired
	private SaleDeliveryOrderService saleDeliveryOrderService;
	/**
	 * 退货入库单管理service组件
	 */
	@Autowired
	private ReturnGoodsInputOrderService returnGoodsInputOrderService;
	
	/**
	 * 创建采购入库单
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	public Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrder) {
		try {
			purchaseInputOrderService.save(purchaseInputOrder); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 创建销售出库单
	 * @param saleDeliveryOrderDTO 销售出库单DTO
	 * @return 处理结果
	 */
	public Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrder) {
		try {
			saleDeliveryOrderService.save(saleDeliveryOrder); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 创建退货入库单
	 * @param returnGoodsInputOrder 退货入库单DTO
	 * @return 处理结果
	 */
	public Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrder) {
		try {
			returnGoodsInputOrderService.save(returnGoodsInputOrder); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知WMS中心，“提交订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informSubmitOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知WMS中心，“支付订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informPayOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 通知WMS中心，“取消订单”事件发生了
	 * @param orderDTO 订单DTO
	 * @return 处理结果
	 */
	public Boolean informCancelOrderEvent(OrderInfoDTO orderDTO) {
		return true;
	}
	
	/**
	 * 获取订单对应的物流单号 
	 * @param orderId 订单id
	 * @return 物流单号
	 */
	public String getLogisticCode(Long orderId) {
		return null;
	}
	
	/**
	 * 通知wms中心，“创建采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	public Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseInputOrderId) {
		return true;
	}
	
	/**
	 * 通知wms中心，“完成采购结算单”事件发生了
	 * @param purchaseInputOrderId 采购入库单id
	 * @return 处理结果
	 */
	public Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseInputOrderId) {
		return true;
	}

}
