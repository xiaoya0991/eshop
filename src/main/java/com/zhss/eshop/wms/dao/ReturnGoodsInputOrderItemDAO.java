package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDO;

/**
 * 退货入库单条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsInputOrderItemDAO {

	/**
	 * 新增退货入库单条目
	 * @param returnGoodsInputOrderItem 退货入库单条目
	 * @throws Exception
	 */
	void save(ReturnGoodsInputOrderItemDO returnGoodsInputOrderItem) throws Exception;
	
	/**
	 * 查询退货入库单条目
	 * @param returnGoodsInputOrderId 退货入库单id
	 * @return 退货入库单条目
	 * @throws Exception
	 */
	List<ReturnGoodsInputOrderItemDO> listByReturnGoodsInputOrderId(
			Long returnGoodsInputOrderId) throws Exception; 
	
	/**
	 * 更新退货入库单条目
	 * @param returnGoodsInputOrderItem 退货入库单条目
	 * @throws Exceptions
	 */
	void update(ReturnGoodsInputOrderItemDO returnGoodsInputOrderItem) throws Exception;
	
}
