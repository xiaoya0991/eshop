package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.SaleDeliveryOrderSendOutDetailDAO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderSendOutDetailDO;
import com.zhss.eshop.wms.mapper.SaleDeliveryOrderSendOutDetailMapper;

/**
 * 销售出库单发货明细管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SaleDeliveryOrderSendOutDetailDAOImpl implements SaleDeliveryOrderSendOutDetailDAO {

	/**
	 * 销售出库单发货明细管理Mapper组件
	 */
	@Autowired
	private SaleDeliveryOrderSendOutDetailMapper sendOutDetailMapper;
	
	/**
	 * 新增销售出库单发货明细
	 * @param sendOutDetail 销售出库单发货明细
	 */
	public void save(SaleDeliveryOrderSendOutDetailDO sendOutDetail) throws Exception {
		sendOutDetailMapper.save(sendOutDetail); 
	}
	
	/**
	 * 根据销售出库单条目id查询发货明细
	 * @param saleDeliveryOrderItemId 销售出库单id
	 * @return 发货明细
	 */
	public List<SaleDeliveryOrderSendOutDetailDO> listBySaleDeliveryOrderItemId(
			Long saleDeliveryOrderItemId) throws Exception {
		return sendOutDetailMapper.listBySaleDeliveryOrderItemId(saleDeliveryOrderItemId);
	}
	
}
