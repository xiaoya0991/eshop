package com.zhss.eshop.customer.service;

import java.util.List;

import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;

/**
 * 退货工单管理service接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsWorksheetService {
	
	/**
	 * 分页查询退货工单
	 * @param query 查询条件
	 * @return 退货工单
	 */
	List<ReturnGoodsWorksheetDTO> listByPage(ReturnGoodsWorksheetQuery query) throws Exception;
	
	/**
	 * 根据id查询退货工单
	 * @param id 退货工单id
	 * @return 退货工单
	 */
	ReturnGoodsWorksheetDTO getById(Long id) throws Exception;
	
	/**
	 * 审核退货工单
	 * @param id 退货工单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	void approve(Long id, Integer approveResult) throws Exception;
	
	/**
	 * 确认退货工单已经收到了退货商品
	 * @param id 退货工单id
	 * @throws Exception
	 */
	void confirmReceivedReturnGoods(Long id) throws Exception;
	
}
