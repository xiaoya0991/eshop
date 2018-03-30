package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SendOutOrderItemDAO;
import com.zhss.eshop.wms.domain.SendOutOrderItemDO;
import com.zhss.eshop.wms.mapper.SendOutOrderItemMapper;

/**
 * 发货单条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SendOutOrderItemDAOImpl implements SendOutOrderItemDAO {

	/**
	 * 发货单条目管理mapper组件
	 */
	@Autowired
	private SendOutOrderItemMapper sendOutOrderItemMapper;
	
	/**
	 * 新增发货单条目
	 * @param orderItem
	 */
	@Override
	public void save(SendOutOrderItemDO sendOutOrderItem) throws Exception {
		sendOutOrderItemMapper.save(sendOutOrderItem); 
	}
	
	/**
	 * 查询发货单条目
	 * @param sendOutOrderId 发货单id
	 * @return 发货单条目
	 */
	@Override
	public List<SendOutOrderItemDO> listByOrderInfoId(Long sendOutOrderId) throws Exception {
		return sendOutOrderItemMapper.listByOrderInfoId(sendOutOrderId);
	}
	
}
