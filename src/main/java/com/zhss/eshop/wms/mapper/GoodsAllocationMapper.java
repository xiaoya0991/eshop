package com.zhss.eshop.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhss.eshop.wms.domain.GoodsAllocationDO;
import com.zhss.eshop.wms.domain.GoodsAllocationQuery;

/**
 * 货位管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsAllocationMapper {

	/**
	 * 分页查询货位
	 * @param query 查询条件
	 * @return 货位
	 */
	List<GoodsAllocationDO> listByPage(GoodsAllocationQuery query);
	
	/**
	 * 新增货位
	 * @param goodsAllocation 货位
	 */
	void save(GoodsAllocationDO goodsAllocation);
	
	/**
	 * 根据id查询货位
	 * @param id 货位id
	 * @return 货位
	 */
	GoodsAllocationDO getById(Long id);
	
	/**
	 * 更新货位
	 * @param goodsAllocation 货位
	 */
	void update(GoodsAllocationDO goodsAllocation);
	
}
