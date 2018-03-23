package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDO;

/**
 * 销售出库单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderItemDAO {

	/**
	 * 新增销售出库单条目
	 * @param saleDeliveryOrderItem 销售出库单条目
	 */
	Long save(SaleDeliveryOrderItemDO saleDeliveryOrderItem) throws Exception;
	
}
