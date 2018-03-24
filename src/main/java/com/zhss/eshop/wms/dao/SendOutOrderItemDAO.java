package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.SendOutOrderItemDO;

/**
 * 发货单条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SendOutOrderItemDAO {

	/**
	 * 新增发货单条目
	 * @param orderItem
	 */
	void save(SendOutOrderItemDO sendOutOrderItem) throws Exception;
	
	/**
	 * 查询发货单条目
	 * @param sendOutOrderId 发货单id
	 * @return 发货单条目
	 */
	List<SendOutOrderItemDO> listByOrderInfoId(Long sendOutOrderId) throws Exception;
	
}
