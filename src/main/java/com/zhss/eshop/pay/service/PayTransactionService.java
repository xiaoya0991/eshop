package com.zhss.eshop.pay.service;

import java.util.List;

import com.zhss.eshop.pay.domain.PayTransactionDTO;
import com.zhss.eshop.pay.domain.PayTransactionQuery;

/**
 * 支付交易流水管理service接口
 * @author zhonghuashishan
 *
 */
public interface PayTransactionService {

	/**
	 * 新增支付交易流水
	 * @param payTransaction 支付交易流水
	 */
	void save(PayTransactionDTO payTransaction) throws Exception;
	
	/**
	 * 更新支付交易流水
	 * @param payTransaction 支付交易流水
	 * @throws Exception
	 */
	void update(PayTransactionDTO payTransaction) throws Exception;
	
	/**
	 * 根据订单编号查询支付交易流水
	 * @param orderNo 订单编号
	 * @return 支付交易流水
	 * @throws Exception
	 */
	PayTransactionDTO getByOrderNo(String orderNo) throws Exception;
	
	/**
	 * 分页查询支付交易流水
	 * @param query 查询条件
	 * @return 支付交易流水
	 */
	List<PayTransactionDTO> listByPage(PayTransactionQuery query) throws Exception; 
	
}
