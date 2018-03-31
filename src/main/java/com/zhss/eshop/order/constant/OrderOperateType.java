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
	 * 取消订单
	 */
	public static final Integer CANCEL_ORDER = 2;
	/**
	 * 支付订单
	 */
	public static final Integer PAY_ORDER = 3;
	/**
	 * 确认收货
	 */
	public static final Integer CONFIRM_RECEIPT = 4;
	/**
	 * 商品发货
	 */
	public static final Integer GOODS_DELIVERY = 5;
	/**
	 * 申请退货
	 */
	public static final Integer APPLY_RETURN_GOODS = 6;
	/**
	 * 退货审核不通过
	 */
	public static final Integer RETURN_GOODS_REJECTED = 7;
	/**
	 * 退货审核通过
	 */
	public static final Integer RETURN_GOODS_APPROVED = 8;
	/**
	 * 寄送退货商品
	 */
	public static final Integer SEND_OUT_RETURN_GOODS = 9;
	/**
	 * 确认收到退货
	 */
	public static final Integer CONFIRM_RETURN_GOODS_RECEIPT = 10;
	/**
	 * 完成退货入库
	 */
	public static final Integer FINISHED_RETURN_GOODS_INPUT = 11;
	/**
	 * 完成退货退款
	 */
	public static final Integer FINISHED_RETURN_GOODS_REFUND = 12;
	
	private OrderOperateType() {
		
	}
	
}
