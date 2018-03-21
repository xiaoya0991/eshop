package com.zhss.eshop.finance.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.finance.service.FinanceService;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;

/**
 * 财务中心接口
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class FinanceServiceImpl implements FinanceService {

	/**
	 * 创建采购结算单
	 * @param purchaseInputOrderDTO 采购入库单DTO
	 * @return 处理结果
	 */
	public Boolean createPurchaseSettlementOrder(PurchaseInputOrderDTO purchaseInputOrder) {
		return true;
	}
	
	/**
	 * 给物流公司打款
	 * @param saleDeliveryOrderDTO 销售出库单
	 * @return 处理结果
	 */
	public Boolean payForLogisticsCompany(SaleDeliveryOrderDTO saleDeliveryOrder) {
		return true;
	}
	
	/**
	 * 执行退货退款操作
	 * @param returnGoodsInputOrderDTO 退货入库单DTO
	 * @return 处理结果
	 */
	public Boolean executeReturnGoodsRefund(ReturnGoodsInputOrderDTO returnGoodsInputOrder) {
		return true;
	}
	
}
