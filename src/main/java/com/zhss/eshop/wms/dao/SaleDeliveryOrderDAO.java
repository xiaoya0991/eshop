package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderDO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;

/**
 * 销售出库单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderDAO {

	/**
	 * 新增销售出库单
	 * @param saleDeliveryOrder
	 */
	Long save(SaleDeliveryOrderDO saleDeliveryOrder) throws Exception;
	
	/**
	 * 分页查询销售出库单
	 * @param query 查询条件
	 * @return 销售出库单
	 */
	List<SaleDeliveryOrderDO> listByPage(SaleDeliveryOrderQuery query) throws Exception;
	
}
