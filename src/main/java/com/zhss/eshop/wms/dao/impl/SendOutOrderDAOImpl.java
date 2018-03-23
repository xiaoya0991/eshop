package com.zhss.eshop.wms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SendOutOrderDAO;
import com.zhss.eshop.wms.domain.SendOutOrderDO;
import com.zhss.eshop.wms.mapper.SendOutOrderMapper;

/**
 * 发货单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SendOutOrderDAOImpl implements SendOutOrderDAO {

	/**
	 * 发货单管理mapper组件
	 */
	@Autowired
	private SendOutOrderMapper sendOutOrderMapper;
	
	/**
	 * 新增发货单
	 * @param order
	 */
	public Long save(SendOutOrderDO sendOutOrder) throws Exception {
		sendOutOrderMapper.save(sendOutOrder); 
		return sendOutOrder.getId();
	}
	
}
