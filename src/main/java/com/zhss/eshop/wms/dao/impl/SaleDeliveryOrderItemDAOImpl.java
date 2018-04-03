package com.zhss.eshop.wms.dao.impl;

import java.util.List;

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
	@Override
	public Long save(SaleDeliveryOrderItemDO saleDeliveryOrderItem) throws Exception {
		saleDeliveryOrderItemMapper.save(saleDeliveryOrderItem); 
		return saleDeliveryOrderItem.getId();
	}
	
	/**
	 * 根据销售出库单id查询销售出库单条目
	 * @param saleDeliveryOrderId 销售出库单idi
	 * @return 销售出库单条目
	 */
	@Override
	public List<SaleDeliveryOrderItemDO> listBySaleDeliveryOrderId(
			Long saleDeliveryOrderId) throws Exception {
		return saleDeliveryOrderItemMapper.listBySaleDeliveryOrderId(saleDeliveryOrderId);
	}
	
}
