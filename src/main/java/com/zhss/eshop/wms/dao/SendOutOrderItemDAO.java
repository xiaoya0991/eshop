package com.zhss.eshop.wms.dao;

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
	
}
