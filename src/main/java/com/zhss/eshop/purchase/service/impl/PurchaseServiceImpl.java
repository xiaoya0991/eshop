package com.zhss.eshop.purchase.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.purchase.constant.PurchaseOrderStatus;
import com.zhss.eshop.purchase.domain.SupplierDTO;
import com.zhss.eshop.purchase.service.PurchaseOrderService;
import com.zhss.eshop.purchase.service.PurchaseService;
import com.zhss.eshop.purchase.service.SupplierService;

/**
 * 采购中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
	
	/**
	 * 供应商管理service组件
	 */
	@Autowired
	private SupplierService supplierService;
	/**
	 * 采购单管理service组件
	 */
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	/**
	 * 通知采购中心，“创建采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informCreatePurchaseInputOrderEvent(Long purchaseOrderId) {
		try {
			purchaseOrderService.updateStatus(purchaseOrderId, PurchaseOrderStatus.WAIT_FOR_INPUT);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知采购中心，“完成采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informFinishedPurchaseInputOrderEvent(Long purchaseOrderId) {
		try {
			purchaseOrderService.updateStatus(purchaseOrderId, PurchaseOrderStatus.FINISHED_INPUT);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知采购中心，“创建采购结算单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseOrderId) {
		try {
			purchaseOrderService.updateStatus(purchaseOrderId, PurchaseOrderStatus.WAIT_FOR_SETTLEMENT);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 通知采购中心，“完成采购结算单”事件发生了
	 * @param purchaseOrderId
	 * @return
	 */
	@Override
	public Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseOrderId) {
		try {
			purchaseOrderService.updateStatus(purchaseOrderId, PurchaseOrderStatus.FINISHED);
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 根据结算周期来查询供应商
	 * @param settlementPeriod 结算周期
 	 * @return 供应商
	 */
	@Override
	public List<SupplierDTO> listSuppliersBySettlementPeriod(Integer settlementPeriod) {
		try {
			return supplierService.listBySettlementPeriod(settlementPeriod);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
