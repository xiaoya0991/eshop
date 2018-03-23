package com.zhss.eshop.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.purchase.dao.PurchaseOrderDAO;
import com.zhss.eshop.purchase.dao.PurchaseOrderItemDAO;
import com.zhss.eshop.purchase.domain.PurchaseOrderDO;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDO;
import com.zhss.eshop.purchase.domain.PurchaseOrderItemDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderQuery;
import com.zhss.eshop.purchase.service.PurchaseOrderService;

/**
 * 采购单管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	/**
	 * 采购单管理DAO组件
	 */
	@Autowired
	private PurchaseOrderDAO purchaseOrderDAO;
	/**
	 * 采购单条目管理DAO组件
	 */
	@Autowired
	private PurchaseOrderItemDAO purchaseOrderItemDAO;
	
	/**
	 * 新增采购单
	 * @param purchaseOrder 采购单
	 */
	public void save(PurchaseOrderDTO purchaseOrder) throws Exception {
		Long purchaseOrderId = purchaseOrderDAO.save(
				purchaseOrder.clone(PurchaseOrderDO.class));  
		
		List<PurchaseOrderItemDO> purchaseOrderItems = ObjectUtils.convertList(
				purchaseOrder.getItems(), PurchaseOrderItemDO.class);
		purchaseOrderItemDAO.batchSave(purchaseOrderId, purchaseOrderItems);
	}
	
	/**
	 * 分页查询采购单
	 * @return 采购单
	 * @throws Exception
	 */
	public List<PurchaseOrderDTO> listByPage(
			PurchaseOrderQuery query) throws Exception {
		return ObjectUtils.convertList(
				purchaseOrderDAO.listByPage(query), 
				PurchaseOrderDTO.class); 
	}
	
	/**
	 * 根据id查询采购单
	 * @return 采购单
	 * @throws Exception
	 */
	public PurchaseOrderDTO getById(Long id) throws Exception {
		PurchaseOrderDTO purchaseOrder = purchaseOrderDAO.getById(id)
				.clone(PurchaseOrderDTO.class); 
		
		List<PurchaseOrderItemDTO> purchaseOrderItems = ObjectUtils.convertList(
				purchaseOrderItemDAO.listByPurchaseOrderId(id), 
				PurchaseOrderItemDTO.class);  
		purchaseOrder.setItems(purchaseOrderItems);
		
		return purchaseOrder;
	}
	
}
