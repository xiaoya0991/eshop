package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDO;

/**
 * 销售出库单拣货条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderPickingItemDAO {

	/**
	 * 新增销售出库单拣货条目
	 * @param pickingItem
	 */
	void save(SaleDeliveryOrderPickingItemDO pickingItem) throws Exception;
	
}
