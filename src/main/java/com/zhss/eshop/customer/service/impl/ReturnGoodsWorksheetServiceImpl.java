package com.zhss.eshop.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.common.util.ObjectUtils;
import com.zhss.eshop.customer.dao.ReturnGoodsWorksheetDAO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;
import com.zhss.eshop.customer.service.ReturnGoodsWorksheetService;

/**
 * 退货工单管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class ReturnGoodsWorksheetServiceImpl implements ReturnGoodsWorksheetService {

	/**
	 * 退货工单管理DAO组件
	 */
	@Autowired
	private ReturnGoodsWorksheetDAO returnGoodsWorksheetDAO;
	
	/**
	 * 分页查询退货工单
	 * @param query 查询条件
	 * @return 退货工单
	 */
	public List<ReturnGoodsWorksheetDTO> listByPage(
			ReturnGoodsWorksheetQuery query) throws Exception {
		return ObjectUtils.convertList(returnGoodsWorksheetDAO.listByPage(query), 
				ReturnGoodsWorksheetDTO.class);
	}
	
	/**
	 * 根据id查询退货工单
	 * @param id 退货工单id
	 * @return 退货工单
	 */
	public ReturnGoodsWorksheetDTO getById(Long id) throws Exception {
		return returnGoodsWorksheetDAO.getById(id).clone(ReturnGoodsWorksheetDTO.class);
	}
	
}
