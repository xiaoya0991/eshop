package com.zhss.eshop.wms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SaleDeliveryOrderItemDAO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderItemDO;
import com.zhss.eshop.wms.mapper.SaleDeliveryOrderItemMapper;

/**
 * 销售出库单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SaleDeliveryOrderItemDAOImpl implements SaleDeliveryOrderItemDAO {

	/**
	 * 销售出库单条目管理mapper组件
	 */
	@Autowired
	private SaleDeliveryOrderItemMapper saleDeliveryOrderItemMapper;
	
	/**
	 * 新增销售出库单条目
	 * @param saleDeliveryOrderItem 销售出库单条目
	 */
	public Long save(SaleDeliveryOrderItemDO saleDeliveryOrderItem) throws Exception {
		saleDeliveryOrderItemMapper.save(saleDeliveryOrderItem); 
		return saleDeliveryOrderItem.getId();
	}
	
}
