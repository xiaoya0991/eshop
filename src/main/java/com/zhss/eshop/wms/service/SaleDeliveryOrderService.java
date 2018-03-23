package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;

/**
 * 销售出库单管理service接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderService {

	/**
	 * 新增销售出库单
	 * @param saleDeliveryOrder 销售出库单
	 * @throws Exception
	 */
	void save(SaleDeliveryOrderDTO saleDeliveryOrder) throws Exception;
	
	/**
	 * 分页查询销售出库单
	 * @param query 查询条件
	 * @return 销售出库单
	 */
	List<SaleDeliveryOrderDTO> listByPage(SaleDeliveryOrderQuery query) throws Exception;
	
}
