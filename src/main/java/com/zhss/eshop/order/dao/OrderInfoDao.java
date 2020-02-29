package com.zhss.eshop.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhss.eshop.order.domain.po.OrderInfoPO;
import java.util.List;

import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoQuery;
import org.springframework.stereotype.Repository;

/**
 * 订单管理DAO组件接口
 * @author zhonghuashishan
 *
 */
@Repository
public interface OrderInfoDao extends BaseMapper<OrderInfoPO> {

	/**
	 * 新增订单
	 * @param order
	 * @return 订单id
	 * @throws Exception
	 */
	Long save(OrderInfoDO order);
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 * @throws Exception
	 */
	List<OrderInfoDO> listByPage(OrderInfoQuery query) throws Exception;
	
	/**
	 * 根据订单id查询订单
	 * @param id 订单id
	 * @return 订单
	 * @throws Exception
	 */
	OrderInfoDO getById(Long id) ;
	
	/**
	 * 更新订单
	 * @param order 订单
	 * @throws Exception
	 */
	void update(OrderInfoDO order) throws Exception;
	
	/**
	 * 更新订单状态
	 * @param id 订单id
	 * @param status 订单状态
	 * @throws Exception
	 */
	void updateStatus(Long id, Integer status);
	
	/**
	 * 查询所有未付款的订单
	 * @return 所有未付款的订单
	 * @throws Exception
	 */
	List<OrderInfoDO> listAllUnpayed() throws Exception;
	
	/**
	 * 查询待收货的订单
	 * @return 订单
	 * @throws Exception
	 */
	List<OrderInfoDO> listUnreceived() throws Exception;
	
	/**
	 * 查询确认收货时间超过了7天而且还没有发表评论的订单
	 * @return 订单
	 * @throws Exception
	 */
	List<OrderInfoDO> listNotPublishedCommentOrders() throws Exception; 
	
}
