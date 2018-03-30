package com.zhss.eshop.customer.dao;

import java.util.List;

import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;

/**
 * 退货工单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsWorksheetDAO {

	/**
	 * 新增退货工单
	 * @param worksheet 退货工单
	 * @throws Exception
	 */
	void save(ReturnGoodsWorksheetDO worksheet) throws Exception;
	
	/**
	 * 分页查询退货工单
	 * @param query 查询条件
	 * @return 退货工单
	 * @throws Exception
	 */
	List<ReturnGoodsWorksheetDO> listByPage(ReturnGoodsWorksheetQuery query) throws Exception;
	
	/**
	 * 根据id查询退货工单
	 * @param id 退货工单id
	 * @return 退货工单
	 * @throws Exception
	 */
	ReturnGoodsWorksheetDO getById(Long id) throws Exception;
	
	/**
	 * 更新退货工单的状态
	 * @param worksheet 退货工单
	 * @throws Exception
	 */ 
	void updateStatus(ReturnGoodsWorksheetDO worksheet) throws Exception;
	
	/**
	 * 更新退货工单的退货物流单号
	 * @param worksheet 退货工单
	 * @throws Exception
	 */ 
	void updateReturnGoodsLogisticsCode(ReturnGoodsWorksheetDO worksheet) throws Exception;
	
	/**
	 * 根据订单id查询退货工单
	 * @param orderInfoId 订单id
	 * @return 退货工单
	 * @throws Exception
	 */
	ReturnGoodsWorksheetDO getByOrderInfoId(Long orderInfoId) throws Exception; 
	
}
