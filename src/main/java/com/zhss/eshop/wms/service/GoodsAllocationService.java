package com.zhss.eshop.wms.service;

import java.util.List;

import com.zhss.eshop.wms.domain.GoodsAllocationDTO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;

/**
 * 货位管理service接口
 * @author zhonghuashishan
 *
 */
public interface GoodsAllocationService {

	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	List<GoodsAllocationDTO> listByPage(GoodsAllocationQuery query) throws Exception;
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	void save(GoodsAllocationDTO goodsAllocation) throws Exception;
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	GoodsAllocationDTO getById(Long id) throws Exception;
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	void update(GoodsAllocationDTO goodsAllocation) throws Exception;
	
}
