package com.zhss.eshop.order.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.order.dao.OrderInfoDAO;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoQuery;
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
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	public List<OrderInfoDO> listByPage(OrderInfoQuery query) {
		return orderInfoMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	public OrderInfoDO getById(Long id) {
		return orderInfoMapper.getById(id);
	}
	
	/**
	 * 更新订单状态
	 * @param order 订单
	 */
	public void updateStatus(OrderInfoDO order) {
		orderInfoMapper.updateStatus(order);
	}
	
	/**
	 * 查询所有未付款的订单
	 * @return 所有未付款的订单
	 */
	public List<OrderInfoDO> listAllUnpayed() { 
		return orderInfoMapper.listAllUnpayed();
	}
	
}
