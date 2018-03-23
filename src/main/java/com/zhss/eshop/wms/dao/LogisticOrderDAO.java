package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.LogisticOrderDO;

/**
 * 物流单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface LogisticOrderDAO {

	/**
	 * 新增物流单
	 * @param logisticOrder 物流单
	 */
	void save(LogisticOrderDO logisticOrder) throws Exception;
	
}
