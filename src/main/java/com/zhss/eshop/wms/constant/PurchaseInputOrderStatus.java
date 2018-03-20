package com.zhss.eshop.wms.constant;

/**
 * 采购入库单状态
 * @author zhonghuashishan
 *
 */
public class PurchaseInputOrderStatus {

	/**
	 * 编辑中
	 */
	public static final Integer EDITING = 1;
	/**
	 * 待审核
	 */
	public static final Integer WAIT_FOR_APPROVE = 2;
	/**
	 * 已入库
	 */
	public static final Integer FINISH_INPUT = 3;
	/**
	 * 待结算
	 */
	public static final Integer WAIT_FOR_SETTLEMENT = 4;
	/**
	 * 已完成
	 */
	public static final Integer FINISHED = 5;
	
	private PurchaseInputOrderStatus() {
		
	}
	
}
