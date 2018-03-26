package com.zhss.eshop.pay.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.pay.dao.PayTransactionDAO;
import com.zhss.eshop.pay.domain.PayTransactionDO;
import com.zhss.eshop.pay.mapper.PayTransactionMapper;

/**
 * 支付交易流水管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class PayTransactionDAOImpl implements PayTransactionDAO {

	/**
	 * 支付交易流水管理mapper组件
	 */
	@Autowired
	private PayTransactionMapper payTransactionMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增支付交易流水
	 * @param payTransaction 支付交易流水
	 */
	public void save(PayTransactionDO payTransaction) throws Exception {
		payTransaction.setGmtCreate(dateProvider.getCurrentTime());
		payTransaction.setGmtModified(dateProvider.getCurrentTime()); 
		payTransactionMapper.save(payTransaction); 
	}
	
	/**
	 * 根据条件查询支付交易流水
	 * @param parameters 查询条件
	 * @return 支付交易流水
	 * @throws Exception
	 */
	public List<PayTransactionDO> listByCondition(Map<String, Object> parameters) throws Exception {
		return payTransactionMapper.listByCondition(parameters);
	}
	
	/**
	 * 更新支付交易流水
	 * @param payTransaction 支付交易流水
	 */
	public void update(PayTransactionDO payTransaction) throws Exception {
		payTransaction.setGmtModified(dateProvider.getCurrentTime()); 
		payTransactionMapper.update(payTransaction); 
	}
	
}
