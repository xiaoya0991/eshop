package com.zhss.eshop.order.dao;

import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoQuery;

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
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	List<OrderInfoDO> listByPage(OrderInfoQuery query);
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	OrderInfoDO getById(Long id);
	
	/**
	 * 更新订单状态
	 * @param order 订单
	 */
	void updateStatus(OrderInfoDO order);
	
	/**
	 * 查询所有未付款的订单
	 * @return 所有未付款的订单
	 */
	List<OrderInfoDO> listAllUnpayed();
	
}
