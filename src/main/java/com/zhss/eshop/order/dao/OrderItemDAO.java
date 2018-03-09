package com.zhss.eshop.order.dao;

import com.zhss.eshop.order.domain.OrderItemDO;

/**
 * 订单条目管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface OrderItemDAO {

	/**
	 * 新增订单条目
	 * @param orderItem
	 */
	void save(OrderItemDO orderItem);
	
}
