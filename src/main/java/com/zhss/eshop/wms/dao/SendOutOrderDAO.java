package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.SendOutOrderDO;

/**
 * 发货单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SendOutOrderDAO {

	/**
	 * 新增发货单
	 * @param order
	 */
	Long save(SendOutOrderDO sendOutOrder) throws Exception;
	
}
