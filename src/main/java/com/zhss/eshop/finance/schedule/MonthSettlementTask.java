package com.zhss.eshop.finance.schedule;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.finance.dao.PurchaseSettlementOrderDAO;
import com.zhss.eshop.finance.domain.PurchaseSettlementOrderDO;
import com.zhss.eshop.purchase.constant.SettlementPeriod;
import com.zhss.eshop.purchase.domain.SupplierDTO;
import com.zhss.eshop.purchase.service.PurchaseService;

/**
 * 月结算任务
 * @author zhonghuashishan
 *
 */
@Component
public class MonthSettlementTask {

	private static final Logger logger = LoggerFactory.getLogger(MonthSettlementTask.class);
	
	/**
	 * 采购中心接口
	 */
	@Autowired
	private PurchaseService purchaseService;
	/**
	 * 采购结算单管理DAO组件
	 */
	@Autowired
	private PurchaseSettlementOrderDAO purchaseSettlementOrderDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 每月运行一次
	 */
	@Scheduled(fixedRate = 1 * 30 * 24 * 60 * 60 * 1000)
	public void execute() {
		try {
			List<SupplierDTO> suppliers = purchaseService.listSuppliersBySettlementPeriod(
					SettlementPeriod.MONTH); 
			
			for(SupplierDTO supplier : suppliers) { 
				Date endTime = dateProvider.getCurrentTime();
				Date startTime = new Date(endTime.getTime() - 30 * 24 * 60 * 60 * 1000);  
				
				List<PurchaseSettlementOrderDO> purchaseSettlementOrders = purchaseSettlementOrderDAO
						.listFinishedBySettlementPeriod(supplier.getId(), startTime, endTime);
				
				Double totalSettlementAmount = 0.0;
				for(PurchaseSettlementOrderDO purchaseSettlementOrder : purchaseSettlementOrders) {
					totalSettlementAmount += purchaseSettlementOrder.getTotalSettlementAmount();
				}
				
				payForSupplier(supplier.getBankName(), supplier.getBankAccount(), 
						supplier.getBankAccountHolder(), totalSettlementAmount); 
			}
		} catch (Exception e) {
			logger.error("error", e); 
		}
	}
	
	/**
	 * 向供应商支付采购货款
	 * @param bankName 银行名称
	 * @param bankAccount 银行账号
	 * @param bankAccountHolder 银行账号持有人
	 * @param totalSettlementAmount 总结算金额
	 */
	private void payForSupplier(String bankName, String bankAccount, 
			String bankAccountHolder, Double totalSettlementAmount) {
		
	}
	
}
