package com.zhss.eshop.wms.service;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderQuery;

/**
 * 销售出库单管理service接口
 * @author zhonghuashishan
 *
 */
public interface SaleDeliveryOrderService {

	/**
	 * 新增销售出库单
	 * @param saleDeliveryOrder 销售出库单
	 * @throws Exception
	 */
	void save(SaleDeliveryOrderDTO saleDeliveryOrder) throws Exception;
	
	/**
	 * 分页查询销售出库单
	 * @param query 查询条件
	 * @return 销售出库单
	 * @throws Exception
	 */
	List<SaleDeliveryOrderDTO> listByPage(SaleDeliveryOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询销售出库单
	 * @param id 销售出库单id
	 * @return
	 * @throws Exception
	 */
	SaleDeliveryOrderDTO getById(Long id) throws Exception;
	
	/**
	 * 根据订单id查询销售出库单
	 * @param orderId 订单id
	 * @return 销售出库单
	 * @throws Exception
	 */
	SaleDeliveryOrderDTO getByOrderId(Long orderId) throws Exception;
	
	/**
	 * 更新销售出库单的发货时间
	 * @param id 销售出库单id
	 * @param deliveryTime 发货时间
	 * @throws Exception
	 */
	void updateDeliveryTime(Long id, Date deliveryTime) throws Exception;
	
	/**
	 * 对销售出库单提交审核
	 * @param id 销售出库单id
	 * @throws Exception
	 */
	void submitApprove(Long id) throws Exception; 
	
	/**
	 * 审核销售出库单 
	 * @param id 销售出库单id
	 * @param approveResult 审核结果
	 * @throws Exception
	 */
	void approve(Long id, Integer approveResult) throws Exception;
	
}
