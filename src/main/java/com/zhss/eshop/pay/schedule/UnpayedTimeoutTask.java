package com.zhss.eshop.pay.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhss.eshop.pay.constant.PayTransactionStatus;
import com.zhss.eshop.pay.dao.PayTransactionDAO;
import com.zhss.eshop.pay.domain.PayTransactionDO;

/**
 * 未支付订单超时检查任务
 * @author zhonghuashishan
 *
 */
@Component
public class UnpayedTimeoutTask {

	private static final Logger logger = LoggerFactory.getLogger(UnpayedTimeoutTask.class);
	
	/**
	 * 支付交易流水管理DAO组件
	 */
	@Autowired
	private PayTransactionDAO payTransactionDAO;
	
	@Scheduled(fixedRate = 10 * 1000)
	public void execute() {
		try {
			List<PayTransactionDO> payTransactions = listUnpayedTransactions();
			
			for(PayTransactionDO payTransaction : payTransactions) {
				if(new Date().getTime() - payTransaction.getGmtCreate().getTime() > 30 * 60 * 1000) {
					payTransaction.setStatus(PayTransactionStatus.CLOSED); 
					payTransactionDAO.update(payTransaction); 
				}
			}
		} catch (Exception e) {
			logger.error("error", e); 
		}
	}
	
	/**
	 * 查询未支付的支付宝交易流水
	 * @return 交易流水
	 */ 
	private List<PayTransactionDO> listUnpayedTransactions() throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("status", PayTransactionStatus.UNPAYED);
		return payTransactionDAO.listByCondition(parameters);
	}
	
}
