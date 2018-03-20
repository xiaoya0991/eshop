package com.zhss.eshop.wms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.dao.GoodsAllocationStockDetailDAO;
import com.zhss.eshop.wms.domain.GoodsAllocationStockDetailDO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderPutOnItemDO;
import com.zhss.eshop.wms.mapper.GoodsAllocationStockDetailMapper;

/**
 * 调度中心的货位库存明细管理的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsAllocationStockDetailDAOImpl implements GoodsAllocationStockDetailDAO {

	/**
	 * 调度中心的货位库存明细管理的mapper组件
	 */
	@Autowired
	private GoodsAllocationStockDetailMapper stockDetailMapper;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 根据商品sku id查询货位库存明细
	 * @param goodsSkuId 商品sku id 
	 * @return 货位库存明细
	 */
	public List<GoodsAllocationStockDetailDO> listByGoodsSkuId(
			Long goodsSkuId) throws Exception {
		return stockDetailMapper.listByGoodsSkuId(goodsSkuId);
	}
	
	/**
	 * 根据id查询货位库存明细
	 * @param id 货位库粗明细id
	 * @return 货位库存明细
	 */
	public GoodsAllocationStockDetailDO getById(Long id) throws Exception {
		return stockDetailMapper.getById(id);
	}
	
	/**
	 * 更新货位库存明细 
	 * @param stockDetail 货位库存明细
	 * @throws Exception
	 */
	public void update(GoodsAllocationStockDetailDO stockDetail) throws Exception {
		stockDetail.setGmtModified(dateProvider.getCurrentTime()); 
		stockDetailMapper.update(stockDetail); 
	}
	
	/**
	 * 新增货位库存明细
	 * @param stockDetail 货位库存明细
	 * @throws Exception
	 */
	public void save(GoodsAllocationStockDetailDO stockDetail) throws Exception {
		stockDetail.setGmtCreate(dateProvider.getCurrentTime()); 
		stockDetail.setGmtModified(dateProvider.getCurrentTime());
		stockDetailMapper.save(stockDetail); 
	}
	
	/**
	 * 根据上架条目新增一个货位库存明细
	 * @param putOnItem 上架条目
	 * @throws Exception
	 */
	public GoodsAllocationStockDetailDO saveByPutOnItem(
			PurchaseInputOrderPutOnItemDO putOnItem) throws Exception {
		GoodsAllocationStockDetailDO stockDetail = new GoodsAllocationStockDetailDO();
		stockDetail.setGoodsAllocationId(putOnItem.getGoodsAllocationId());
		stockDetail.setGoodsSkuId(putOnItem.getGoodsSkuId()); 
		stockDetail.setPutOnQuantity(putOnItem.getPutOnShelvesCount()); 
		stockDetail.setPutOnTime(putOnItem.getGmtCreate());  
		stockDetail.setCurrentStockQuantity(stockDetail.getPutOnQuantity()); 
		stockDetail.setLockedStockQuantity(0L); 
		
		save(stockDetail); 
		
		return stockDetail;
	}
	
}
