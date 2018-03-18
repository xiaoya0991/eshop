package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.wms.dao.GoodsAllocationDAO;
import com.zhss.eshop.wms.domain.GoodsAllocationDO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;
import com.zhss.eshop.wms.mapper.GoodsAllocationMapper;

/**
 * 货位管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsAllocationDAOImpl implements GoodsAllocationDAO {

	/**
	 * 货位管理mapper组件
	 */
	@Autowired
	private GoodsAllocationMapper goodsAllocationMapper;
	
	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	public List<GoodsAllocationDO> listByPage(GoodsAllocationQuery query) throws Exception {
		return goodsAllocationMapper.listByPage(query); 
	}
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	public void save(GoodsAllocationDO goodsAllocation) throws Exception {
		goodsAllocationMapper.save(goodsAllocation); 
	}
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	public GoodsAllocationDO getById(Long id) throws Exception {
		return goodsAllocationMapper.getById(id);
	}
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	public void update(GoodsAllocationDO goodsAllocation) throws Exception {
		goodsAllocationMapper.update(goodsAllocation); 
	}
	
}
