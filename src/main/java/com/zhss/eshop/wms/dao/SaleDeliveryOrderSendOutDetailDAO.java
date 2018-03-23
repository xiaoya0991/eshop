package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDO;

/**
 * 销售出库单发货明细管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderSendOutDetailDAO {

	/**
	 * 新增销售出库单发货明细
	 * @param sendOutDetail 销售出库单发货明细
	 */
	void save(SaleDeliveryOrderSendOutDetailDO sendOutDetail) throws Exception;
	
}
