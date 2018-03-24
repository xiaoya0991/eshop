package com.zhss.eshop.purchase.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.purchase.domain.SupplierDTO;
import com.zhss.eshop.purchase.service.PurchaseService;
import com.zhss.eshop.purchase.service.SupplierService;

/**
 * 采购中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
	
	/**
	 * 供应商管理service组件
	 */
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 判断是否有关联商品sku的采购单
	 * @param goodsSkuId 商品sku id
	 * @return 是否有采购单关联了商品sku
	 */
	public Boolean existRelatedPurchaseOrder(Long goodsSkuId) {
		return true;
	}
	
	/**
	 * 通知采购中心，“创建采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informCreatePurchaseInputOrderEvent(Long purcaseOrderId) {
		return true;
	}
	
	/**
	 * 通知采购中心，“完成采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informFinishedPurchaseInputOrderEvent(Long purcaseOrderId) {
		return true;
	}
	
	/**
	 * 通知采购中心，“创建采购结算单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	public Boolean informCreatePurchaseSettlementOrderEvent(Long purcaseOrderId) {
		return true;
	}
	
	/**
	 * 通知采购中心，“完成采购结算单”事件发生了
	 * @param purchaseOrderId
	 * @return
	 */
	public Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseOrderId) {
		return true;
	}
	
	/**
	 * 根据结算周期来查询供应商
	 * @param settlementPeriod 结算周期
 	 * @return 供应商
	 */
	public List<SupplierDTO> listSuppliersBySettlementPeriod(Integer settlementPeriod) {
		try {
			return supplierService.listBySettlementPeriod(settlementPeriod);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
