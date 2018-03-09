package com.zhss.eshop.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.order.dao.OrderItemDAO;
import com.zhss.eshop.order.domain.OrderItemDO;
import com.zhss.eshop.order.mapper.OrderItemMapper;

/**
 * 订单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

	/**
	 * 订单条目管理mapper组件
	 */
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	/**
	 * 新增订单条目
	 * @param orderItem
	 */
	public void save(OrderItemDO orderItem) {
		orderItemMapper.save(orderItem);
	}
	
}
