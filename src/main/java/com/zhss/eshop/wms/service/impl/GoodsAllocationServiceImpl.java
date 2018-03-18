package com.zhss.eshop.wms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.wms.domain.GoodsAllocationDTO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;
import com.zhss.eshop.wms.service.GoodsAllocationService;

/**
 * 货位管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsAllocationServiceImpl implements GoodsAllocationService {

	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	public List<GoodsAllocationDTO> listByPage(GoodsAllocationQuery query) throws Exception {
		return null;
	}
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	public void save(GoodsAllocationDTO goodsAllocation) throws Exception {
		
	}
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	public GoodsAllocationDTO getById(Long id) throws Exception {
		return null;
	}
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	public void update(GoodsAllocationDTO goodsAllocation) throws Exception {
		
	}
	
}
