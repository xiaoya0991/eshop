package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderQuery;

/**
 * 采购入库单管理service接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseInputOrderService {

	/**
	 * 新增采购入库单
	 * @param purchaseInputOrder 采购入库单
	 * @throws Exception
	 */
	void save(PurchaseInputOrderDTO purchaseInputOrder) throws Exception;
	
	/**
	 * 分页查询采购入库单
	 * @param query 查询条件
	 * @return 采购入库单
	 * @throws Exception
	 */
	List<PurchaseInputOrderDTO> listByPage(PurchaseInputOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询采购入库单
	 * @param id 采购入库单id
	 * @return 采购入库单
	 * @throws Exception
	 */
	PurchaseInputOrderDTO getById(Long id) throws Exception;
	
	/**
	 * 更新采购入库单
	 * @param purchaseInputOrder 采购入库单
	 * @throws Exception
	 */
	void update(PurchaseInputOrderDTO purchaseInputOrder) throws Exception;
	
	/**
	 * 批量新增采购入库单的上架条目
	 * @param putOnItems 上架条目
	 * @throws Exception
	 */
	void batchSavePutOnItems(List<PurchaseInputOrderPutOnItemDTO> putOnItems) throws Exception;
	
	/**
	 * 对采购入库单提交审核
	 * @param id 采购入库单id
	 * @throws Exception 
	 */
	void submitApprove(Long id) throws Exception;
	
	/**
	 * 审核采购入库单
	 * @param id 采购入库单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	void approve(Long id, Integer approveResult) throws Exception;
	
	/**
	 * 更新采购入库单状态
	 * @param id 采购入库单id
	 * @param status 采购入库单状态
	 * @throws Exception
	 */
	void updateStatus(Long id, Integer status) throws Exception;
	
}
