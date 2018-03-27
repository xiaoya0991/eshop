package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;

/**
 * 退货入库单管理service接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsInputOrderService {

	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception
	 */
	void save(ReturnGoodsInputOrderDTO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	List<ReturnGoodsInputOrderDTO> listByPage(ReturnGoodsInputOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询退货入库单
	 * @param id 退货入库单id
	 * @return 退货入库单
	 * @throws Exception
	 */
	ReturnGoodsInputOrderDTO getById(Long id) throws Exception;
	
	/**
	 * 更新退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception 
	 */
	void update(ReturnGoodsInputOrderDTO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 批量新增退货入库单上架条目
	 * @param putOnItems 上架条目
	 * @throws Exception
	 */
	void batchSavePutOnItems(ReturnGoodsInputOrderDTO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 退货入库单提交审核
	 * @param id 退货入库单id
	 * @throws Exception
	 */
	void submitApprove(Long id) throws Exception;
	
	/**
	 * 审核退货入库单
	 * @param id 退货入库单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	void approve(Long id, Integer approveResult) throws Exception;
	
}
