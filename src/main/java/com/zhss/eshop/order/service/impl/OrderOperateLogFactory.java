package com.zhss.eshop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderOperateType;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderOperateLogDO;

/**
 * 订单操作内容工厂
 * @author zhonghuashishan
 *
 */
@Component
public class OrderOperateLogFactory {

	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 获取订单操作内容
	 * @param operateType 订单操作类型
	 * @return 订单操作内容
	 */
	public OrderOperateLogDO get(OrderInfoDTO order, Integer operateType) throws Exception {
		String operateContent = null;
		
		if(OrderOperateType.CREATE_ORDER.equals(operateType)) {
			operateContent = "完成订单创建，订单编号为：" + order.getOrderNo(); 
		} else if(OrderOperateType.CANCEL_ORDER.equals(operateType)) {
			operateContent = "取消订单，订单编号为：" + order.getOrderNo();
		} else if(OrderOperateType.PAY_ORDER.equals(operateType)) {
			operateContent = "支付订单，订单编号为：" + order.getOrderNo() + "，支付金额为：" + order.getPayableAmount();
		} else if(OrderOperateType.GOODS_DELIVERY.equals(operateType)) {
			operateContent = "已经将订单中的商品进行发货"; 
		} else if(OrderOperateType.CONFIRM_RECEIPT.equals(operateType)) {
			operateContent = "完成确认收货"; 
		} else if(OrderOperateType.APPLY_RETURN_GOODS.equals(operateType)) {
			operateContent = "申请退货"; 
		} else if(OrderOperateType.RETURN_GOODS_REJECTED.equals(operateType)) {
			operateContent = "退货申请审核不通过"; 
		} else if(OrderOperateType.RETURN_GOODS_APPROVED.equals(operateType)) {
			operateContent = "退货申请审核已通过"; 
		} else if(OrderOperateType.SEND_OUT_RETURN_GOODS.equals(operateType)) {
			operateContent = "寄送退货商品"; 
		} else if(OrderOperateType.CONFIRM_RETURN_GOODS_RECEIPT.equals(operateType)) {
			operateContent = "确认收到退货商品"; 
		} else if(OrderOperateType.FINISHED_RETURN_GOODS_INPUT.equals(operateType)) {
			operateContent = "完成退货商品入库"; 
		} else if(OrderOperateType.FINISHED_RETURN_GOODS_REFUND.equals(operateType)) {
			operateContent = "完成退款"; 
		}     
		
		OrderOperateLogDO log = create(order, operateType, operateContent);
		
		return log;
	}
	
	/**
	 * 创建订单操作日志
	 * @param operateType 订单操作类型
	 * @param operateContent 订单操作内容
	 * @return 订单操作日志
	 * @throws Exception
	 */
	private OrderOperateLogDO create(OrderInfoDTO order ,
			Integer operateType, String operateContent) throws Exception {
		OrderOperateLogDO log = new OrderOperateLogDO();
		
		log.setOrderInfoId(order.getId()); 
		log.setOperateType(operateType);
		log.setOperateContent(operateContent); 
		log.setGmtCreate(dateProvider.getCurrentTime());
		log.setGmtModified(dateProvider.getCurrentTime()); 
		
		return log;
	}
	
}
