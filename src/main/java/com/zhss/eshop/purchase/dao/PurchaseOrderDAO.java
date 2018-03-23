package com.zhss.eshop.purchase.dao;

import java.util.List;

import com.zhss.eshop.purchase.domain.PurchaseOrderDO;
import com.zhss.eshop.purchase.domain.PurchaseOrderQuery;

/**
 * 采购单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseOrderDAO {

	/**
	 * 新增采购单
	 * @param purchaseOrder 采购单
	 */
	Long save(PurchaseOrderDO purchaseOrder) throws Exception;
	
	/**
	 * 分页查询采购单
	 * @param query 查询条件
	 * @return 采购单
	 */
	List<PurchaseOrderDO> listByPage(PurchaseOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询采购单
	 * @param id 采购单id
	 * @return 采购单
	 */
	PurchaseOrderDO getById(Long id) throws Exception; 
	
}
