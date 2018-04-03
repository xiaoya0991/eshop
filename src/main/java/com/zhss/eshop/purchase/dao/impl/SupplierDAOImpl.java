package com.zhss.eshop.purchase.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.purchase.dao.SupplierDAO;
import com.zhss.eshop.purchase.domain.SupplierDO;
import com.zhss.eshop.purchase.domain.SupplierQuery;
import com.zhss.eshop.purchase.mapper.SupplierMapper;

/**
 * 供应商管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	/**
	 * 供应商管理mapper组件
	 */
	@Autowired
	private SupplierMapper supplierMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;

	/**
	 * 新增供应商
	 * @param supplier 供应商
	 */
	@Override
	public void save(SupplierDO supplier) throws Exception {
		supplier.setGmtCreate(dateProvider.getCurrentTime()); 
		supplier.setGmtModified(dateProvider.getCurrentTime()); 
		supplierMapper.save(supplier);
	}
	
	/**
	 * 分页查询供应商
	 * @param query 供应商查询条件
	 * @return 供应商
	 */
	@Override
	public List<SupplierDO> listByPage(SupplierQuery query) throws Exception {
		return supplierMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询供应商
	 * @param id 供应商id 
	 * @return 供应商
	 */
	@Override
	public SupplierDO getById(Long id) throws Exception {
		return supplierMapper.getById(id);
	}
	
	/**
	 * 根据结算周期查询供应商
	 * @param settlementPeriod 结算周期
	 * @return 供应商
	 */
	@Override
	public List<SupplierDO> listBySettlementPeriod(Integer settlementPeriod) throws Exception {
		return supplierMapper.listBySettlementPeriod(settlementPeriod);
	}
	
}
