package com.zhss.eshop.purchase.constant;

/**
 * 采购单状态
 * @author zhonghuashishan
 *
 */
public class PurchaseOrderStatus {

	/**
	 * 编辑中
	 */
	public static final Integer EDITING = 1;
	/**
	 * 待审核
	 */
	public static final Integer WAIT_FOR_APPROVE = 2;
	/**
	 * 已审核
	 */
	public static final Integer APPROVED = 3;
	/**
	 * 待入库
	 */
	public static final Integer WAIT_FOR_INPUT = 4;
	/**
	 * 待结算
	 */
	public static final Integer WAIT_FOR_SETTLEMENT = 5;
	/**
	 * 已完成
	 */
	public static final Integer FINISHED = 6;
	
	private PurchaseOrderStatus() {
		
	}
	
}
