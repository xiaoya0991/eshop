package com.zhss.eshop.wms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderVO;
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
	
}
