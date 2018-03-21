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
		} else if(OrderOperateType.MANUAL_CANCEL_ORDER.equals(operateType)) {
			operateContent = "手动取消订单，订单编号为：" + order.getOrderNo();
		} else if(OrderOperateType.AUTO_CANCEL_ORDER.equals(operateType)) {
			operateContent = "自动取消订单，订单编号为：" + order.getOrderNo();
		} else if(OrderOperateType.PAY_ORDER.equals(operateType)) {
			operateContent = "支付订单，订单编号为：" + order.getOrderNo() + "，支付金额为：" + order.getPayableAmount();
		} else if(OrderOperateType.GOODS_DELIVERY.equals(operateType)) {
			operateContent = "已经将订单中的商品进行发货"; 
		} else if(OrderOperateType.MANUAL_CONFIRM_RECEIPT.equals(operateType)) {
			operateContent = "手动完成确认收货"; 
		} else if(OrderOperateType.AUTO_CONFIRM_RECEIPT.equals(operateType)) {
			operateContent = "系统自动完成确认收货"; 
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
