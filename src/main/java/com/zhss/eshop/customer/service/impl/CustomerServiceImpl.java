package com.zhss.eshop.customer.service.impl;

import org.springframework.stereotype.Service;

import com.zhss.eshop.customer.service.CustomerService;

/**
 * 客服中心接口
 * @author zhonghuashishan
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/**
	 * 创建退货工单
	 * @param orderId 订单id
	 * @param orderNo 订单编号
	 * @param returnGoodsReason 退货原因
	 * @param returnGoodsRemark 退货备注
	 * @return 处理结果
	 */
	public Boolean createReturnGoodsWorksheet(Long orderId, String orderNo, 
			String returnGoodsReason, String returnGoodsRemark) {
		return true;
	}
	
	/**
	 * 同步物流单号
	 * @param orderId 订单id
	 * @param returnGoodsLogisticsCode 退货物流单号
	 * @return 处理结果
	 */
	public Boolean syncReturnGoodsCourierNumber(Long orderId, 
			String returnGoodsLogisticsCode) {
		return true;
	}
	
	/**
	 * 通知客服中心，“完成退货入库”事件发生了
	 * @param returnGoodsWorksheetId 退货工单id
	 * @return 处理结果
	 */
	public Boolean informReturnGoodsInputFinishedEvent(Long returnGoodsWorksheetId) {
		return true;
	}
	
	/**
	 * 通知客服中心，“完成退款”事件发生了
	 * @param returnGoodsWorkwheetId 退货工单id
	 * @return 处理结果
	 */
	public Boolean informRefundFinishedEvent(Long returnGoodsWorkwheetId) {
		return true;
	}
	
}
