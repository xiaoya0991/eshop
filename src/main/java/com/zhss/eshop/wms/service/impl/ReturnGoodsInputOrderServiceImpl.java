package com.zhss.eshop.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.dao.ReturnGoodsInputOrderDAO;
import com.zhss.eshop.wms.dao.ReturnGoodsInputOrderItemDAO;
import com.zhss.eshop.wms.dao.ReturnGoodsInputOrderPutOnItemDAO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderPutOnItemDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderItemDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;
import com.zhss.eshop.wms.service.ReturnGoodsInputOrderService;

/**
 * 退货入库单管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class ReturnGoodsInputOrderServiceImpl implements ReturnGoodsInputOrderService {

	/**
	 * 退货入库单管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderDAO returnGoodsInputOrderDAO;
	/**
	 * 退货入库单条目管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderItemDAO returnGoodsInputOrderItemDAO;
	/**
	 * 退货入库单上架条目管理DAO组件
	 */
	@Autowired
	private ReturnGoodsInputOrderPutOnItemDAO putOnItemDAO;
	
	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception
	 */
	public void save(ReturnGoodsInputOrderDTO returnGoodsInputOrder) throws Exception {
		Long returnGoodsInputOrderId = returnGoodsInputOrderDAO.save(
				returnGoodsInputOrder.clone(ReturnGoodsInputOrderDO.class)); 
		
		for(ReturnGoodsInputOrderItemDTO item : returnGoodsInputOrder.getItems()) {
			item.setReturnGoodsInputOrderId(returnGoodsInputOrderId); 
			returnGoodsInputOrderItemDAO.save(item.clone(ReturnGoodsInputOrderItemDO.class));  
		}
	}
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	public List<ReturnGoodsInputOrderDTO> listByPage(
			ReturnGoodsInputOrderQuery query) throws Exception {
		return ObjectUtils.convertList(
				returnGoodsInputOrderDAO.listByPage(query), 
				ReturnGoodsInputOrderDTO.class);
	}
	
	/**
	 * 根据id查询退货入库单
	 * @param id 退货入库单id
	 * @return 退货入库单
	 * @throws Exception
	 */
	public ReturnGoodsInputOrderDTO getById(Long id) throws Exception {
		ReturnGoodsInputOrderDTO returnGoodsInputOrder = returnGoodsInputOrderDAO.getById(id)
				.clone(ReturnGoodsInputOrderDTO.class); 
		
		List<ReturnGoodsInputOrderItemDTO> returnGoodsInputOrderItems = ObjectUtils.convertList(
				returnGoodsInputOrderItemDAO.listByReturnGoodsInputOrderId(id), 
				ReturnGoodsInputOrderItemDTO.class);  
		returnGoodsInputOrder.setItems(returnGoodsInputOrderItems);

		for(ReturnGoodsInputOrderItemDTO returnGoodsInputOrderItem : returnGoodsInputOrderItems) { 
			List<ReturnGoodsInputOrderPutOnItemDTO> putOnItems = ObjectUtils.convertList(
					putOnItemDAO.listByReturnGoodsInputOrderItemId(returnGoodsInputOrderItem.getId()), 
					ReturnGoodsInputOrderPutOnItemDTO.class);
			returnGoodsInputOrderItem.setPutOnItems(putOnItems);
		}
		
		return returnGoodsInputOrder;
	}
	
}
