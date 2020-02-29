package com.zhss.eshop.order.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhss.eshop.order.domain.po.OrderItemPO;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.order.dao.OrderItemDao;
import com.zhss.eshop.order.domain.OrderItemDO;
import com.zhss.eshop.order.mapper.OrderItemMapper;

/**
 * 订单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class OrderItemDAOImpl implements OrderItemDao {

	/**
	 * 订单条目管理mapper组件
	 */
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	/**
	 * 新增订单条目
	 * @param orderItem
	 */
	@Override
	public Long save(OrderItemDO orderItem) {
		orderItemMapper.save(orderItem);
		return orderItem.getId();
	}
	
	/**
	 * 查询订单条目
	 * @param orderInfoId 订单id
	 * @return 订单条目
	 */
	@Override
	public List<OrderItemDO> listByOrderInfoId(Long orderInfoId){
		return orderItemMapper.listByOrderInfoId(orderInfoId);
	}

	@Override
	public int insert(OrderItemPO entity) {
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
	public int delete(Wrapper<OrderItemPO> wrapper) {
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		return 0;
	}

	@Override
	public int updateById(OrderItemPO entity) {
		return 0;
	}

	@Override
	public int update(OrderItemPO entity, Wrapper<OrderItemPO> updateWrapper) {
		return 0;
	}

	@Override
	public OrderItemPO selectById(Serializable id) {
		return null;
	}

	@Override
	public List<OrderItemPO> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<OrderItemPO> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public OrderItemPO selectOne(Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public List<OrderItemPO> selectList(Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<OrderItemPO>> E selectPage(E page, Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Wrapper<OrderItemPO> queryWrapper) {
		return null;
	}
}
