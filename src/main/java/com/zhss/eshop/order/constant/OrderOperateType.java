package com.zhss.eshop.order.constant;

/**
 * 订单操作类型
 * @author zhonghuashishan
 *
 */
public class OrderOperateType {

	/**
	 * 创建订单
	 */
	public static final Integer CREATE_ORDER = 1;
	/**
	 * 手动取消订单
	 */
	public static final Integer MANUAL_CANCEL_ORDER = 2;
	/**
	 * 自动取消订单
	 */
	public static final Integer AUTO_CANCEL_ORDER = 3;
	/**
	 * 支付订单
	 */
	public static final Integer PAY_ORDER = 4;
	/**
	 * 手动确认收货
	 */
	public static final Integer MANUAL_CONFIRM_RECEIPT = 5;
	/**
	 * 自动确认收货
	 */
	public static final Integer AUTO_CONFIRM_RECEIPT = 6;
	/**
	 * 商品发货
	 */
	public static final Integer GOODS_DELIVERY = 7;
	/**
	 * 申请退货
	 */
	public static final Integer APPLY_RETURN_GOODS = 8;
	/**
	 * 退货审核不通过
	 */
	public static final Integer RETURN_GOODS_REJECTED = 9;
	/**
	 * 退货审核通过
	 */
	public static final Integer RETURN_GOODS_APPROVED = 10;
	/**
	 * 寄送退货商品
	 */
	public static final Integer SEND_OUT_RETURN_GOODS = 11;
	/**
	 * 确认收到退货
	 */
	public static final Integer CONFIRM_RETURN_GOODS_RECEIPT = 12;
	/**
	 * 完成退货入库
	 */
	public static final Integer FINISHED_RETURN_GOODS_INPUT = 13;
	/**
	 * 完成退货退款
	 */
	public static final Integer FINISHED_RETURN_GOODS_REFUND = 14;
	
	private OrderOperateType() {
		
	}
	
}
