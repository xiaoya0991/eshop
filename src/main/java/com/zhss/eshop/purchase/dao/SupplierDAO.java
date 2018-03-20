package com.zhss.eshop.purchase.dao;

import java.util.List;

import com.zhss.eshop.purchase.domain.SupplierDO;
import com.zhss.eshop.purchase.domain.SupplierQuery;

/**
 * 供应商管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SupplierDAO {

	/**
	 * 新增供应商
	 * @param supplier 供应商
	 */
	void save(SupplierDO supplier) throws Exception;
	
	/**
	 * 分页查询供应商
	 * @param query 供应商查询条件
	 * @return 供应商
	 */
	List<SupplierDO> listByPage(SupplierQuery query) throws Exception;
	
	/**
	 * 根据id查询供应商
	 * @param id 供应商id 
	 * @return 供应商
	 */
	SupplierDO getById(Long id) throws Exception;
	
}
