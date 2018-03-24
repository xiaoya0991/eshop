package com.zhss.eshop.order.state;

import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单状态管理器接口
 * @author zhonghuashishan
 *
 */
public interface OrderStateManager {

	/**
	 * 创建订单
	 * @param order 订单
	 * @throws Exception
	 */
	void create(OrderInfoDTO order) throws Exception;
	
	/**
	 * 订单能否执行取消操作
	 * @param order 订单
	 * @return 能否执行取消操作
	 * @throws Exception
	 */
	Boolean canCancel(OrderInfoDTO order) throws Exception;
	
	/**
	 * 执行取消订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	void cancel(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断订单能否进行支付操作
	 * @param order 订单
	 * @return 能否进行支付操作
	 * @throws Exception
	 */
	Boolean canPay(OrderInfoDTO order) throws Exception;
	
	/**
	 * 执行支付订单操作
	 * @param order 订单
	 * @throws Exception
	 */
	void pay(OrderInfoDTO order) throws Exception;
	
	/**
	 * 完成商品发货
	 * @param order 订单
	 * @throws Exception
	 */
	void finishDelivery(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断能否确认收货
	 * @param order 订单
	 * @return 能否确认收货
	 * @throws Exception
	 */
	Boolean canConfirmReceipt(OrderInfoDTO order) throws Exception;
	
	/**
	 * 手动确认收货
	 * @param order 订单
	 * @throws Exception
	 */
	void confirmReceipt(OrderInfoDTO order) throws Exception;
	
	/**
	 * 判断能否申请退货
	 * @param order 订单
	 * @return 能否申请退货
	 * @throws Exception
	 */
	Boolean canApplyReturnGoods(OrderInfoDTO order) throws Exception;
	
	/**
	 * 申请退货
	 * @param order 订单
	 * @throws Exception
	 */
	void applyReturnGoods(OrderInfoDTO order) throws Exception;
	
	/**
	 * 拒绝退货申请
	 * @param order 订单
	 * @throws Exception
	 */
	void rejectReturnGoodsApply(OrderInfoDTO order) throws Exception;
	
	/**
	 * 退货申请审核通过
	 * @param order 订单
	 * @throws Exception
	 */
	void passedReturnGoodsApply(OrderInfoDTO order) throws Exception;
	
	/**
	 * 寄送退货商品
	 * @param order 订单
	 * @throws Exception
	 */
	void sendOutReturnGoods(OrderInfoDTO order) throws Exception;
	
	/**
	 * 确认收到退货商品
	 * @param order 订单
	 * @throws Exception
	 */
	void confirmReceivedReturnGoods(OrderInfoDTO order) throws Exception;
	
	/**
	 * 完成退货入库
	 * @param order 订单
	 * @throws Exception
	 */
	void finishedInputReturnGoods(OrderInfoDTO order) throws Exception;
	
	/**
	 * 完成退款
	 * @param order 订单
	 * @throws Exception
	 */
	void finishedRefund(OrderInfoDTO order) throws Exception;
	
}
