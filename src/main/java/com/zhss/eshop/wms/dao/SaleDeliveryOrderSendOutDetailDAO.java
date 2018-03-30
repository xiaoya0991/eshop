package com.zhss.eshop.wms.dao;

import java.util.List;

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
	 * @throws Exception
	 */
	void save(SaleDeliveryOrderSendOutDetailDO sendOutDetail) throws Exception;
	
	/**
	 * 根据销售出库单条目id查询发货明细
	 * @param saleDeliveryOrderItemId 销售出库单id
	 * @return 发货明细
	 * @throws Exception
	 */
	List<SaleDeliveryOrderSendOutDetailDO> listBySaleDeliveryOrderItemId(
			Long saleDeliveryOrderItemId) throws Exception;
	
}
