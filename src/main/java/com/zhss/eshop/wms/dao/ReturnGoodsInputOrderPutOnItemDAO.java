package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDO;

/**
 * 退货入库单上架条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsInputOrderPutOnItemDAO {

	/**
	 * 根据退货入库单条目id查询上架条目
	 * @param returnGoodsInputOrderItemId 退货入库单条目id
	 * @return 上架条目
	 * @throws Exception
	 */
	List<ReturnGoodsInputOrderPutOnItemDO> listByReturnGoodsInputOrderItemId(
			Long returnGoodsInputOrderItemId) throws Exception;
	
	/**
	 * 新增退货入库单上架条目
	 * @param putOnItem 上架条目
	 * @throws Exception
	 */
 	void save(ReturnGoodsInputOrderPutOnItemDO putOnItem) throws Exception;
	
}
