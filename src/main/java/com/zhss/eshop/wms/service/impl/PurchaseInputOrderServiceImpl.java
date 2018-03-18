package com.zhss.eshop.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.dao.PurchaseInputOrderDAO;
import com.zhss.eshop.wms.dao.PurchaseInputOrderItemDAO;
import com.zhss.eshop.wms.dao.PurchaseInputOrderPutOnItemDAO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderQuery;
import com.zhss.eshop.wms.service.PurchaseInputOrderService;

/**
 * 采购入库单管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class PurchaseInputOrderServiceImpl implements PurchaseInputOrderService {

	/**
	 * 采购入库单管理DAO组件
	 */
	@Autowired
	private PurchaseInputOrderDAO purchaseInputOrderDAO;
	/**
	 * 采购入库单条目管理DAO组件
	 */
	@Autowired
	private PurchaseInputOrderItemDAO purchaseInputOrderItemDAO;
	/**
	 * 采购入库单上架条目管理的DAO组件
	 */
	@Autowired
	private PurchaseInputOrderPutOnItemDAO purchaseInputOrderPutOnItemDAO;
	
	/**
	 * 新增采购入库单
	 * @param purchaseInputOrder 采购入库单
	 */
	public void save(PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		Long purchaseInputOrderId = purchaseInputOrderDAO.save(
				purchaseInputOrder.clone(PurchaseInputOrderDO.class));  
		
		List<PurchaseInputOrderItemDO> purchaseInputOrderItems = ObjectUtils.convertList(
				purchaseInputOrder.getItems(), PurchaseInputOrderItemDO.class);
		
		purchaseInputOrderItemDAO.batchSave(purchaseInputOrderId, purchaseInputOrderItems);
	}
	
	/**
	 * 分页查询采购入库单
	 * @return 采购入库单
	 * @throws Exception
	 */
	public List<PurchaseInputOrderDTO> listByPage(
			PurchaseInputOrderQuery query) throws Exception {
		return ObjectUtils.convertList(
				purchaseInputOrderDAO.listByPage(query), 
				PurchaseInputOrderDTO.class); 
	}
	
	/**
	 * 根据id查询采购入库单
	 * @return 采购入库单
	 * @throws Exception
	 */
	public PurchaseInputOrderDTO getById(Long id) throws Exception {
		PurchaseInputOrderDTO purchaseInputOrder = purchaseInputOrderDAO.getById(id)
				.clone(PurchaseInputOrderDTO.class); 
		
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItems = ObjectUtils.convertList(
				purchaseInputOrderItemDAO.listByPurchaseInputOrderId(id), 
				PurchaseInputOrderItemDTO.class);  
		purchaseInputOrder.setItems(purchaseInputOrderItems);

		for(PurchaseInputOrderItemDTO purchaseInputOrderItem : purchaseInputOrderItems) { 
			List<PurchaseInputOrderPutOnItemDTO> putOnItems = ObjectUtils.convertList(
					purchaseInputOrderPutOnItemDAO.listByPurchaseInputOrderItemId(purchaseInputOrderItem.getId()), 
					PurchaseInputOrderPutOnItemDTO.class);
			purchaseInputOrderItem.setPutOnItemDTOs(putOnItems);
		}
		
		return purchaseInputOrder;
	}
	
	/** 
	 * 更新采购入库单
	 * @param purchaseInputOrder 采购入库单
	 * @throws Exception
	 */
	public void update(PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		purchaseInputOrderDAO.update(purchaseInputOrder.clone(PurchaseInputOrderDO.class));  
		purchaseInputOrderDAO.updateStatus(purchaseInputOrder.clone(PurchaseInputOrderDO.class)); 
		
		for(PurchaseInputOrderItemDTO purchaseInputOrderItem : purchaseInputOrder.getItems()) {
			purchaseInputOrderItemDAO.update(purchaseInputOrderItem.clone(PurchaseInputOrderItemDO.class));  
		}
	}
	
	/**
	 * 批量新增采购入库单的上架条目
	 * @param putOnItems 上架条目
	 * @throws Exception
	 */
	public void batchSavePutOnItems(List<PurchaseInputOrderPutOnItemDTO> putOnItems) throws Exception {
		purchaseInputOrderPutOnItemDAO.batchSave(ObjectUtils.convertList(
				putOnItems, PurchaseInputOrderPutOnItemDO.class)); 
	}
	
}
