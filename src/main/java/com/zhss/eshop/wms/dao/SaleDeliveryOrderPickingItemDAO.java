package com.zhss.eshop.wms.dao;

import java.util.List;

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
	
	/**
	 * 根据销售出库单条目id查询拣货条目
	 * @param saleDeliveryOrderItemId 销售出库单条目id
	 * @return 拣货条目
	 */
	List<SaleDeliveryOrderPickingItemDO> listBySaleDeliveryOrderItemId(
			Long saleDeliveryOrderItemId) throws Exception;
	
}
