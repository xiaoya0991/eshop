package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderDO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputOrderQuery;

/**
 * 退货入库单管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface ReturnGoodsInputOrderDAO {

	/**
	 * 新增退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @return 退货入库单id
	 * @throws Exception
	 */
	Long save(ReturnGoodsInputOrderDO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 分页查询退货入库单
	 * @param query 查询条件
	 * @return 退货入库单
	 * @throws Exception
	 */
	List<ReturnGoodsInputOrderDO> listByPage(ReturnGoodsInputOrderQuery query) throws Exception;
	
	/**
	 * 根据id查询退后入库单
	 * @param id 退货入库单id
	 * @return 退后入库单
	 * @throws Exception
	 */
	ReturnGoodsInputOrderDO getById(Long id) throws Exception;
	
	/**
	 * 更新退货入库单
	 * @param returnGoodsInputOrder 退货入库单
	 * @throws Exception
	 */
	void update(ReturnGoodsInputOrderDO returnGoodsInputOrder) throws Exception;
	
	/**
	 * 更新退货入库单的状态
	 * @param id 退货入库单id 
	 * @param status 退货入库单状态
	 * @throws Exception
	 */
	void updateStatus(Long id, Integer status) throws Exception;
	
}
