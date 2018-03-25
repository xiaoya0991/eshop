package com.zhss.eshop.order.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
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
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增订单
	 * @param order
	 */
	public Long save(OrderInfoDO order) throws Exception {
		orderInfoMapper.save(order);  
		return order.getId();
	}
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	public List<OrderInfoDO> listByPage(OrderInfoQuery query) throws Exception {
		return orderInfoMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	public OrderInfoDO getById(Long id) throws Exception {
		return orderInfoMapper.getById(id);
	}
	
	/**
	 * 查询所有未付款的订单
	 * @return 所有未付款的订单
	 */
	public List<OrderInfoDO> listAllUnpayed() throws Exception { 
		return orderInfoMapper.listAllUnpayed();
	}
	
	/**
	 * 更新订单
	 * @param order 订单
	 * @throws Exception
	 */
	public void update(OrderInfoDO order) throws Exception {
		order.setGmtModified(dateProvider.getCurrentTime()); 
		orderInfoMapper.update(order); 
	}
	
	/**
	 * 更新订单状态
	 * @param order 订单
	 */
	public void updateStatus(Long id, Integer status) throws Exception {
		OrderInfoDO order = getById(id);
		order.setOrderStatus(status);
		update(order);
	}
	 
	/**
	 * 更新订单的确认收货时间
	 * @param order 订单
	 */
	public void updateConfirmReceiptTime(Long id, Date confirmReceiptTime) throws Exception {
		OrderInfoDO order = getById(id);
		order.setConfirmReceiptTime(confirmReceiptTime); 
		order.setGmtModified(dateProvider.getCurrentTime());
		update(order); 
	}
	
	/**
	 * 查询待收货的订单
	 * @return 订单
	 * @throws Exception
	 */
	public List<OrderInfoDO> listUnreceived() throws Exception {
		return orderInfoMapper.listByStatus(OrderStatus.WAIT_FOR_RECEIVE);
	}
	
	/**
	 * 查询确认收货时间超过了7天而且还没有发表评论的订单
	 * @return 订单
	 */
	public List<OrderInfoDO> listNotPublishedCommentOrders() throws Exception {
		return orderInfoMapper.listNotPublishedCommentOrders();
	}
	
}
