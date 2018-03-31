package com.zhss.eshop.wms.dao;

import java.util.List;

import com.zhss.eshop.wms.domain.GoodsAllocationDO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;

/**
 * 货位管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface GoodsAllocationDAO {

	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 * @throws Exception
	 */
	List<GoodsAllocationDO> listByPage(GoodsAllocationQuery query) throws Exception;
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 * @throws Exception
	 */
	void save(GoodsAllocationDO goodsAllocation) throws Exception;
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 * @throws Exception
	 */
	GoodsAllocationDO getById(Long id) throws Exception;
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 * @throws Exception
	 */
	void update(GoodsAllocationDO goodsAllocation) throws Exception;
	
}
