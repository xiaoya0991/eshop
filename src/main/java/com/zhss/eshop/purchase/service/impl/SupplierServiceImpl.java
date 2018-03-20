package com.zhss.eshop.purchase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.purchase.dao.SupplierDAO;
import com.zhss.eshop.purchase.domain.SupplierDO;
import com.zhss.eshop.purchase.domain.SupplierDTO;
import com.zhss.eshop.purchase.domain.SupplierQuery;
import com.zhss.eshop.purchase.service.SupplierService;

/**
 * 供应商管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	/**
	 * 供应商管理DAO组件
	 */
	@Autowired
	private SupplierDAO supplierDAO;

	/**
	 * 新增供应商
	 * @param supplier 供应商
	 */
	public void save(SupplierDTO supplier) throws Exception {
		supplierDAO.save(supplier.clone(SupplierDO.class));   
	}
	
	/**
	 * 分页查询供应商
	 * @param query 供应商查询条件
	 * @return 供应商
	 */
	public List<SupplierDTO> listByPage(SupplierQuery query) throws Exception {
		return ObjectUtils.convertList(supplierDAO.listByPage(query), SupplierDTO.class);
	}
	
	/**
	 * 根据id查询供应商
	 * @param id 供应商id 
	 * @return 供应商
	 */
	public SupplierDTO getById(Long id) throws Exception {
		return supplierDAO.getById(id).clone(SupplierDTO.class);
	}
	
}
