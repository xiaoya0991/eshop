package com.zhss.eshop.Inventory.updater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.Inventory.dao.GoodsStockDAO;
import com.zhss.eshop.Inventory.domain.GoodsStockDO;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;

/**
 * 采购入库库存更新命令的工厂
 * @author zhonghuashishan
 *
 */
@Component
public class PurchaseInputStockUpdaterFactory<T> 
		extends AbstractGoodsStockUpdaterFactory<T> {
	
	/**
	 * 构造函数
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	@Autowired
	public PurchaseInputStockUpdaterFactory(
			GoodsStockDAO goodsStockDAO, 
			DateProvider dateProvider) {
		super(goodsStockDAO, dateProvider);
	}

	/**
	 * 获取商品sku id集合
	 * @return 商品sku id集合
	 * @throws Exception
	 */
	@Override
	protected List<Long> getGoodsSkuIds(T parameter) throws Exception {		
		PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs = 
				purchaseInputOrderDTO.getPurchaseInputOrderItemDTOs();
		
		if(purchaseInputOrderItemDTOs == null || purchaseInputOrderItemDTOs.size() == 0) {
			return new ArrayList<Long>();
		}
		
		List<Long> goodsSkuIds = new ArrayList<Long>(purchaseInputOrderItemDTOs.size());
		
		for(PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : purchaseInputOrderItemDTOs) {
			goodsSkuIds.add(purchaseInputOrderItemDTO.getGoodsSkuId());
		}
		
		return goodsSkuIds;
	}

	/**
	 * 创建库存更新命令
	 * @param goodsStockDOs 商品库存DO对象集合
	 * @return 库存更新命令
	 * @throws Exception
	 */
	@Override
	protected GoodsStockUpdater create(
			List<GoodsStockDO> goodsStockDOs,
			T parameter) throws Exception {
		PurchaseInputOrderDTO purchaseInputOrderDTO = (PurchaseInputOrderDTO) parameter;
		List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs = 
				purchaseInputOrderDTO.getPurchaseInputOrderItemDTOs();
		
		Map<Long, PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOMap = 
				new HashMap<Long, PurchaseInputOrderItemDTO>();
		
		if(purchaseInputOrderItemDTOs != null && purchaseInputOrderItemDTOs.size() > 0) {
			for(PurchaseInputOrderItemDTO purchaseInputOrderItemDTO : purchaseInputOrderItemDTOs) {
				purchaseInputOrderItemDTOMap.put(purchaseInputOrderItemDTO.getGoodsSkuId(), 
						purchaseInputOrderItemDTO);
			}
		}
		
		return new PurchaseInputStockUpdater(goodsStockDOs, goodsStockDAO, 
				dateProvider, purchaseInputOrderItemDTOMap); 
	}

}
