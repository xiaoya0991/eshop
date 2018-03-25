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
	
	/**
	 * 根据id查询发货单
	 * @param id 发货单id
	 * @return 发货单
	 */
	SendOutOrderDO getBySaleDeliveryOrderId(Long saleDeliveryOrderId) throws Exception;
	
}
