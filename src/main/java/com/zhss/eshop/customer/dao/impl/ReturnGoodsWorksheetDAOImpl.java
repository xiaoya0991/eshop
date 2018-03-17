package com.zhss.eshop.customer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.customer.dao.ReturnGoodsWorksheetDAO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDO;
import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetQuery;
import com.zhss.eshop.customer.mapper.ReturnGoodsWorksheetMapper;

/**
 * 退货工单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ReturnGoodsWorksheetDAOImpl implements ReturnGoodsWorksheetDAO {

	/**
	 * 退货工单管理mapper组件
	 */
	@Autowired
	private ReturnGoodsWorksheetMapper returnGoodsWorksheetMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 新增退货工单
	 * @param worksheet 退货工单
	 */
	public void save(ReturnGoodsWorksheetDO worksheet) throws Exception {
		worksheet.setGmtCreate(dateProvider.getCurrentTime()); 
		worksheet.setGmtModified(dateProvider.getCurrentTime()); 
		returnGoodsWorksheetMapper.save(worksheet); 
	}
	
	/**
	 * 分页查询退货工单
	 * @param query 查询条件
	 * @return 退货工单
	 */
	public List<ReturnGoodsWorksheetDO> listByPage(
			ReturnGoodsWorksheetQuery query) throws Exception {
		return returnGoodsWorksheetMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询退货工单
	 * @param id 退货工单id
	 * @return 退货工单
	 */
	public ReturnGoodsWorksheetDO getById(Long id) throws Exception {
		return returnGoodsWorksheetMapper.getById(id);
	}
	
}
