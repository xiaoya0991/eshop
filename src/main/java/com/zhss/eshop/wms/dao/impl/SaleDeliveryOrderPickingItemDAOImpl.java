package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SaleDeliveryOrderPickingItemDAO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderPickingItemDO;
import com.zhss.eshop.wms.mapper.SaleDeliveryOrderPickingItemMapper;

/**
 * 销售出库单拣货条目管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SaleDeliveryOrderPickingItemDAOImpl implements SaleDeliveryOrderPickingItemDAO {

	/**
	 * 销售出库单拣货条目管理mapper组件
	 */
	@Autowired
	private SaleDeliveryOrderPickingItemMapper pickingItemMapper;
	
	/**
	 * 新增销售出库单拣货条目
	 * @param pickingItem
	 */
	@Override
	public void save(SaleDeliveryOrderPickingItemDO pickingItem) throws Exception {
		pickingItemMapper.save(pickingItem); 
	}
	
	/**
	 * 根据销售出库单条目id查询拣货条目
	 * @param saleDeliveryOrderItemId 销售出库单条目id
	 * @return 拣货条目
	 */
	@Override
	public List<SaleDeliveryOrderPickingItemDO> listBySaleDeliveryOrderItemId(
			Long saleDeliveryOrderItemId) throws Exception {
		return pickingItemMapper.listBySaleDeliveryOrderItemId(saleDeliveryOrderItemId);
	}
	
}
