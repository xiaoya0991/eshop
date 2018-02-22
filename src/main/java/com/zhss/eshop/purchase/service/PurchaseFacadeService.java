package com.zhss.eshop.purchase.service;

/**
 * 采购中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseFacadeService {

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
	Boolean informFinishePurchaseInputOrderEvent(Long purcaseOrderId);
	
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
	Boolean informFinishePurchaseSettlementOrderEvent(Long purchaseOrderId);
	
}
