package com.zhss.eshop.wms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.common.util.CloneDirection;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.domain.LogisticOrderVO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderVO;
import com.zhss.eshop.wms.domain.SendOutOrderVO;
import com.zhss.eshop.wms.service.SaleDeliveryOrderService;

/**
 * 销售出库单管理controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/wms/saleDeliveryOrder")  
public class SaleDeliveryOrderController {

	private static final Logger logger = LoggerFactory.getLogger(SaleDeliveryOrderController.class);
	
	/**
	 * 销售出库单管理service组件
	 */
	@Autowired
	private SaleDeliveryOrderService saleDeliveryOrderService;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 查询销售出库单列表
	 * @param query 查询条件
	 * @return 销售出库单
	 */
	@GetMapping("/")  
	public List<SaleDeliveryOrderVO> listByPage(SaleDeliveryOrderQuery query) {
		try {
			return ObjectUtils.convertList(
					saleDeliveryOrderService.listByPage(query), 
					SaleDeliveryOrderVO.class);   
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询销售出库单
	 * @param id 销售出库单id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public SaleDeliveryOrderVO getById(@PathVariable("id") Long id) {
		try {
			SaleDeliveryOrderDTO saleDeliveryOrder = saleDeliveryOrderService.getById(id);
			
			SaleDeliveryOrderVO resultSaleDeliveryOrder = saleDeliveryOrder.clone(
					SaleDeliveryOrderVO.class, CloneDirection.OPPOSITE);
			resultSaleDeliveryOrder.setSendOutOrder(saleDeliveryOrder.getSendOutOrder().clone(
					SendOutOrderVO.class, CloneDirection.OPPOSITE)); 
			resultSaleDeliveryOrder.setLogisticOrder(saleDeliveryOrder.getLogisticOrder().clone(
					LogisticOrderVO.class, CloneDirection.OPPOSITE));  
			
			return resultSaleDeliveryOrder;
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 更新销售出库单的发货时间
	 * @param saleDeliveryOrder 销售出库单
	 */
	@PutMapping("/deliveryTime/{id}")  
	public Boolean updateDeliveryTime(@PathVariable("id") Long id, String deliveryTime) {
		try {
			saleDeliveryOrderService.updateDeliveryTime(id, 
					dateProvider.parseDatetime(deliveryTime));
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 对销售出库单提交审核
	 * @param id 销售出库单id
	 * @throws Exception
	 */
	@PutMapping("/submitApprove/{id}") 
	public Boolean submitApprove(@PathVariable("id") Long id) {
		try {
			saleDeliveryOrderService.submitApprove(id); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 审核销售出库单 
	 * @param id 销售出库单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	@PutMapping("/approve/{id}")
	public Boolean approve(@PathVariable("id") Long id, Integer approveResult) {
		try {
			saleDeliveryOrderService.approve(id, approveResult); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
}
