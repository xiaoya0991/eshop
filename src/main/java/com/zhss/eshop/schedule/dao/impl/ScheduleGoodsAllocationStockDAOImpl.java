package com.zhss.eshop.schedule.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.schedule.dao.ScheduleGoodsAllocationStockDAO;
import com.zhss.eshop.schedule.domain.ScheduleGoodsAllocationStockDO;
import com.zhss.eshop.schedule.mapper.ScheduleGoodsAllocationStockMapper;

/**
 * 货位库存管理dao组件
 * @author zhonghuashishan
 *
 */
@Repository
public class ScheduleGoodsAllocationStockDAOImpl implements ScheduleGoodsAllocationStockDAO {
	
	/**
	 * 货位库存管理mapper组件
	 */
	@Autowired
	private ScheduleGoodsAllocationStockMapper goodsAllocationStockMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 根据商品sku id查询货位库存
	 * @param goodsSkuId 商品sku id
	 * @return 货位库存
	 */
	@Override
	public ScheduleGoodsAllocationStockDO getBySkuId(
			Long goodsAllocationId, Long goodsSkuId) throws Exception {
		ScheduleGoodsAllocationStockDO goodsAllocationStock =
				goodsAllocationStockMapper.getBySkuId(goodsAllocationId, goodsSkuId);
		
		if(goodsAllocationStock == null) {
			goodsAllocationStock = new ScheduleGoodsAllocationStockDO();
			goodsAllocationStock.setGoodsAllocationId(goodsAllocationId); 
			goodsAllocationStock.setGoodsSkuId(goodsSkuId); 
			goodsAllocationStock.setAvailableStockQuantity(0L);
			goodsAllocationStock.setLockedStockQuantity(0L); 
			goodsAllocationStock.setOutputStockQuantity(0L); 
			save(goodsAllocationStock); 
		}
		
		return goodsAllocationStock;
	}
	
	/**
	 * 新增货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	@Override
	public void save(ScheduleGoodsAllocationStockDO goodsAllocationStock) throws Exception {
		goodsAllocationStock.setGmtCreate(dateProvider.getCurrentTime()); 
		goodsAllocationStock.setGmtModified(dateProvider.getCurrentTime()); 
		goodsAllocationStockMapper.save(goodsAllocationStock); 
	}
	
	/**
	 * 更新货位库存
	 * @param goodsAllocationStockDO 货位库存DO对象
	 */
	@Override
	public void update(ScheduleGoodsAllocationStockDO goodsAllocationStock) throws Exception {
		goodsAllocationStock.setGmtModified(dateProvider.getCurrentTime()); 
		goodsAllocationStockMapper.update(goodsAllocationStock); 
	}

}
