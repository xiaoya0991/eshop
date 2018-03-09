package com.zhss.eshop.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.mapper.OrderInfoMapper;

/**
 * 订单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class OrderInfoDAOImpl implements OrderInfoDAO {

	/**
	 * 订单管理mapper组件
	 */
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	/**
	 * 新增订单
	 * @param order
	 */
	public Long save(OrderInfoDO order) {
		orderInfoMapper.save(order);  
		return order.getId();
	}
	
}
