package com.zhss.eshop.order.service.impl;

import org.springframework.stereotype.Component;

import com.zhss.eshop.order.constant.OrderOperateType;
import com.zhss.eshop.order.domain.OrderInfoDTO;

/**
 * 订单操作内容工厂
 * @author zhonghuashishan
 *
 */
@Component
public class OrderOperateContentFactory {

	/**
	 * 获取订单操作内容
	 * @param operateType 订单操作类型
	 * @return 订单操作内容
	 */
	public String getOperateContent(OrderInfoDTO order, Integer operateType) {
		if(OrderOperateType.CREATE_ORDER.equals(operateType)) {
			return "完成订单创建，订单编号为：" + order.getOrderNo(); 
		}
		return "";
	}
	
}
