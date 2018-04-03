package com.zhss.eshop.order.dao;

import java.util.List;

import com.zhss.eshop.order.domain.OrderOperateLogDO;

/**
 * 订单操作日志管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface OrderOperateLogDAO {

	/**
	 * 新增订单操作日志
	 * @param log 订单操作日志
	 * @throws Exception
	 */
	void save(OrderOperateLogDO log) throws Exception;
	
	/**
	 * 查询订单操作日志
	 * @param orderInfoId 订单id
	 * @return 订单操作日志
	 * @throws Exception
	 */
	List<OrderOperateLogDO> listByOrderInfoId(Long orderInfoId) throws Exception;
	
}
