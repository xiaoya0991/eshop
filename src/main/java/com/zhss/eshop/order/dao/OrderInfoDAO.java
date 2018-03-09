package com.zhss.eshop.order.dao;

import com.zhss.eshop.order.domain.OrderInfoDO;

/**
 * 订单管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface OrderInfoDAO {

	/**
	 * 新增订单
	 * @param order
	 */
	Long save(OrderInfoDO order);
	
}
