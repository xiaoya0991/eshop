package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;

/**
 * 退货入库单管理service接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsInputOrderService {

	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception
	 */
	void save(ReturnGoodsInputOrderDTO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 */
	List<ReturnGoodsInputOrderDTO> listByPage(ReturnGoodsInputOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询退货入库单
	 * @param id 退货入库单id
	 * @return 退货入库单
	 * @throws Exception
	 */
	ReturnGoodsInputOrderDTO getById(Long id) throws Exception;
	
}
