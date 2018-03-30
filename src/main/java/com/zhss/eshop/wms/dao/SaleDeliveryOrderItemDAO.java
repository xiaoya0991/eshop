package com.zhss.eshop.wms.dao;

import java.util.List;

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
	 * @return 销售出库单条目id
	 * @throws Exception
	 */
	Long save(SaleDeliveryOrderItemDO saleDeliveryOrderItem) throws Exception;
	
	/**
	 * 根据销售出库单id查询销售出库单条目
	 * @param saleDeliveryOrderId 销售出库单idi
	 * @return 销售出库单条目
	 * @throws Exception
	 */
	List<SaleDeliveryOrderItemDO> listBySaleDeliveryOrderId(
			Long saleDeliveryOrderId) throws Exception;
	
}
