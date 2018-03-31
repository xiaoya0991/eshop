package com.zhss.eshop.purchase.service;

import java.util.List;

import com.zhss.eshop.purchase.domain.SupplierDTO;

/**
 * 采购中心接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseService {
	
	/**
	 * 判断是否有关联商品sku的采购单
	 * @param goodsSkuId 商品sku id
	 * @return 是否有采购单关联了商品sku
	 */
	Boolean existRelatedPurchaseOrder(Long goodsSkuId);
	
	/**
	 * 通知采购中心，“创建采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	Boolean informCreatePurchaseInputOrderEvent(Long purcaseOrderId);
	
	/**
	 * 通知采购中心，“完成采购入库单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	Boolean informFinishedPurchaseInputOrderEvent(Long purcaseOrderId);
	
	/**
	 * 通知采购中心，“创建采购结算单”事件发生了
	 * @param purcaseOrderId 采购单id
	 * @return 处理结果
	 */
	Boolean informCreatePurchaseSettlementOrderEvent(Long purcaseOrderId);
	
	/**
	 * 通知采购中心，“完成采购结算单”事件发生了
	 * @param purchaseOrderId
	 * @return
	 */
	Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseOrderId);
	
	/**
	 * 根据结算周期来查询供应商
	 * @param settlementPeriod 结算周期
 	 * @return 供应商
	 */
	List<SupplierDTO> listSuppliersBySettlementPeriod(Integer settlementPeriod);
	
}
