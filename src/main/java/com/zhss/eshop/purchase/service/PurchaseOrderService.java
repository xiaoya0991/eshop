package com.zhss.eshop.purchase.service;

import java.util.List;

import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderQuery;

/**
 * 采购单管理service接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseOrderService {

	/**
	 * 新增采购单
	 * @param purchaseOrder 采购单
	 */
	void save(PurchaseOrderDTO purchaseOrder) throws Exception;
	
	/**
	 * 分页查询采购单
	 * @return 采购单
	 * @throws Exception
	 */
	List<PurchaseOrderDTO> listByPage(PurchaseOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询采购单
	 * @return 采购单
	 * @throws Exception
	 */
	PurchaseOrderDTO getById(Long id) throws Exception;
	
}
