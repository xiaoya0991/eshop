package com.zhss.eshop.customer.service;

/**
 * 客服中心对外提供的接口
 * @author zhonghuashishan
 *
 */
public interface CustomerService {

	/**
	 * 创建退货工单
	 * @param orderId 订单id
	 * @param orderNo 订单编号
	 * @param returnGoodsReason 退货原因
	 * @param returnGoodsRemark 退货备注
	 * @return 处理结果
	 */
	Boolean createReturnGoodsWorksheet(Long orderId, String orderNo, 
			Integer returnGoodsReason, String returnGoodsRemark);
	
	/**
	 * 同步物流单号
	 * @param orderInfoId 订单id
	 * @param returnGoodsLogisticsCode 退货物流单号
	 * @return 处理结果
	 */
	Boolean syncReturnGoodsLogisticsCode(Long orderInfoId, 
			String returnGoodsLogisticsCode);
	
	/**
	 * 通知客服中心，“完成退货入库”事件发生了
	 * @param returnGoodsWorksheetId 退货工单id
	 * @return 处理结果
	 */
	Boolean informReturnGoodsInputFinishedEvent(Long returnGoodsWorksheetId);
	
	/**
	 * 通知客服中心，“完成退款”事件发生了
	 * @param returnGoodsWorkwheetId 退货工单id
	 * @return 处理结果
	 */
	Boolean informRefundFinishedEvent(Long returnGoodsWorkwheetId);
	
}
