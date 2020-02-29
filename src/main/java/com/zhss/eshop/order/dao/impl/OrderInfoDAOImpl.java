package com.zhss.eshop.order.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhss.eshop.order.domain.po.OrderInfoPO;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.order.constant.OrderStatus;
import com.zhss.eshop.order.dao.OrderInfoDao;
import com.zhss.eshop.order.domain.OrderInfoDO;
import com.zhss.eshop.order.domain.OrderInfoQuery;
import com.zhss.eshop.order.mapper.OrderInfoMapper;

/**
 * 订单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class OrderInfoDAOImpl implements OrderInfoDao {

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
	@Override
	public Long save(OrderInfoDO order) throws Exception {
		orderInfoMapper.save(order);  
		return order.getId();
	}
	
	/**
	 * 分页查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	@Override
	public List<OrderInfoDO> listByPage(OrderInfoQuery query) throws Exception {
		return orderInfoMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询订单
	 * @param query 查询条件
	 * @return 订单
	 */
	@Override
	public OrderInfoDO getById(Long id) {
		return orderInfoMapper.getById(id);
	}
	
	/**
	 * 查询所有未付款的订单
	 * @return 所有未付款的订单
	 */
	@Override
	public List<OrderInfoDO> listAllUnpayed() throws Exception { 
		return orderInfoMapper.listByStatus(OrderStatus.WAIT_FOR_PAY);
	}
	
	/**
	 * 更新订单
	 * @param order 订单
	 * @throws Exception
	 */
	@Override
	public void update(OrderInfoDO order) throws Exception {
		order.setGmtModified(dateProvider.getCurrentTime()); 
		orderInfoMapper.update(order); 
	}
	
	/**
	 * 更新订单状态
	 * @param order 订单
	 */
	@Override
	public void updateStatus(Long id, Integer status){
		OrderInfoDO order = getById(id);
		order.setOrderStatus(status);
		update(order);
	}
	
	/**
	 * 查询待收货的订单
	 * @return 订单
	 * @throws Exception
	 */
	@Override
	public List<OrderInfoDO> listUnreceived() throws Exception {
		return orderInfoMapper.listByStatus(OrderStatus.WAIT_FOR_RECEIVE);
	}
	
	/**
	 * 查询确认收货时间超过了7天而且还没有发表评论的订单
	 * @return 订单
	 */
	@Override
	public List<OrderInfoDO> listNotPublishedCommentOrders() throws Exception {
		return orderInfoMapper.listNotPublishedCommentOrders();
	}

	@Override
	public int insert(OrderInfoPO entity) {
		return 0;
	}

	@Override
	public int deleteById(Serializable id) {
		return 0;
	}

	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		return 0;
	}

	@Override
	public int delete(Wrapper<OrderInfoPO> wrapper) {
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		return 0;
	}

	@Override
	public int updateById(OrderInfoPO entity) {
		return 0;
	}

	@Override
	public int update(OrderInfoPO entity, Wrapper<OrderInfoPO> updateWrapper) {
		return 0;
	}

	@Override
	public OrderInfoPO selectById(Serializable id) {
		return null;
	}

	@Override
	public List<OrderInfoPO> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<OrderInfoPO> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public OrderInfoPO selectOne(Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public List<OrderInfoPO> selectList(Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<OrderInfoPO>> E selectPage(E page, Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Wrapper<OrderInfoPO> queryWrapper) {
		return null;
	}
}
