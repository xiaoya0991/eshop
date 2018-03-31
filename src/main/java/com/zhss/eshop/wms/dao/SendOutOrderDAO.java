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
	 * @param sendOutOrder 发货单
	 * @return 发货单id
	 * @throws Exception
	 */
	Long save(SendOutOrderDO sendOutOrder) throws Exception;
	
	/**
	 * 根据销售出库单id查询发货单
	 * @param saleDeliveryOrderId 销售出库单id
	 * @return 发货单
	 * @throws Exception
	 */
	SendOutOrderDO getBySaleDeliveryOrderId(Long saleDeliveryOrderId) throws Exception;
	
}
