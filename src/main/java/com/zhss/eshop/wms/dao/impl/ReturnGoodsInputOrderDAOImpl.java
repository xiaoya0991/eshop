package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.ReturnGoodsInputOrderDAO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;
import com.zhss.eshop.wms.mapper.ReturnGoodsInputOrderMapper;

/**
 * 退货入库单管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ReturnGoodsInputOrderDAOImpl implements ReturnGoodsInputOrderDAO {

	/**
	 * 退货入库单管理mapper组件
	 */
	@Autowired
	private ReturnGoodsInputOrderMapper returnGoodsInputOrderMapper;
	
	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 */
	public Long save(ReturnGoodsInputOrderDO returnGoodsInputOrder) throws Exception {
		returnGoodsInputOrderMapper.save(returnGoodsInputOrder); 
		return returnGoodsInputOrder.getId();
	}
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	public List<ReturnGoodsInputOrderDO> listByPage(
			ReturnGoodsInputOrderQuery query) throws Exception {
		return returnGoodsInputOrderMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询退后入库单
	 * @param id 退货入库单id
	 * @return 退后入库单
	 */
	public ReturnGoodsInputOrderDO getById(Long id) throws Exception {
		return returnGoodsInputOrderMapper.getById(id);
	}
	
}
