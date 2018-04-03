package com.zhss.eshop.wms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.LogisticOrderDAO;
import com.zhss.eshop.wms.domain.LogisticOrderDO;
import com.zhss.eshop.wms.mapper.LogisticOrderMapper;

/**
 * 物流单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class LogisticOrderDAOImpl implements LogisticOrderDAO {

	/**
	 * 物流单管理mapper组件
	 */
	@Autowired
	private LogisticOrderMapper logisticOrderMapper;
	
	/**
	 * 新增物流单
	 * @param logisticOrder 物流单
	 */
	@Override
	public void save(LogisticOrderDO logisticOrder) throws Exception {
		logisticOrderMapper.save(logisticOrder); 
	}
	
	/**
	 * 根据销售出库单id查询物流单
	 * @param saleDeliveryOrderId 销售出库单id
	 * @return 物流单
	 */
	@Override
	public LogisticOrderDO getBySaleDeliveryOrderId(
			Long saleDeliveryOrderId) throws Exception {
		return logisticOrderMapper.getBySaleDeliveryOrderId(saleDeliveryOrderId);
	}
	
}
