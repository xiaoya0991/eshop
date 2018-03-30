package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.GoodsAllocationDAO;
import com.zhss.eshop.wms.domain.GoodsAllocationDO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;

/**
 * 货位管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsAllocationDAOImpl implements GoodsAllocationDAO {

	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	@Override
	public List<GoodsAllocationDO> listByPage(GoodsAllocationQuery query) throws Exception {
		return null;
	}
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	@Override
	public void save(GoodsAllocationDO goodsAllocation) throws Exception {
		
	}
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	@Override
	public GoodsAllocationDO getById(Long id) throws Exception {
		return null;
	}
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	@Override
	public void update(GoodsAllocationDO goodsAllocation) throws Exception {
		
	}
	
}
