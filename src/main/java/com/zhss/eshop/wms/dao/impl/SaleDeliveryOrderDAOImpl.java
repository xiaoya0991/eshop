package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SaleDeliveryOrderDAO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;
import com.zhss.eshop.wms.mapper.SaleDeliveryOrderMapper;

/**
 * 销售出库单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SaleDeliveryOrderDAOImpl implements SaleDeliveryOrderDAO {
	
	/**
	 * 销售出库单管理mapper组件
	 */
	@Autowired
	private SaleDeliveryOrderMapper saleDeliveryOrderMapper;
	
	/**
	 * 新增销售出库单
	 * @param saleDeliveryOrder
	 */
	public Long save(SaleDeliveryOrderDO saleDeliveryOrder) throws Exception {
		saleDeliveryOrderMapper.save(saleDeliveryOrder); 
		return saleDeliveryOrder.getId();
	}
	
	/**
	 * 分页查询销售出库单
	 * @param query 查询条件
	 * @return 销售出库单
	 */
	public List<SaleDeliveryOrderDO> listByPage(SaleDeliveryOrderQuery query) throws Exception {
		return saleDeliveryOrderMapper.listByPage(query);
	}
	
}
