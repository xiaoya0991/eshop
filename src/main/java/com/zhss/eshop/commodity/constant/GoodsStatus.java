package com.zhss.eshop.commodity.constant;

/**
 * 商品状态
 * @author zhonghuashishan
 *
 */
public class GoodsStatus {

	/**
	 * 未知类型
	 */
	public static final Integer UNKNOWN = 0;
	/**
	 * 待审核
	 */
	public static final Integer WAIT_FOR_APPROVE = 1;
	/**
	 * 待上架
	 */
	public static final Integer WAIT_FOR_PUT_ON_SHELVES = 2;
	/**
	 * 审核不通过
	 */
	public static final Integer APPROVE_REJECT = 3;
	/**
	 * 已上架
	 */
	public static final Integer PUTTED_ON_SHELVES = 4;
	
	private GoodsStatus() {
		
	}
	
}
