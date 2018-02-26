package com.zhss.eshop.Inventory.command;

import java.util.List;
import java.util.Map;

import com.zhss.eshop.Inventory.dao.GoodsStockDAO;
import com.zhss.eshop.Inventory.domain.GoodsStockDO;
import com.zhss.eshop.common.util.DateProvider;
import com.zhss.eshop.wms.domain.PurchaseInputOrderItemDTO;

/**
 * 采购入库库存更新命令
 * @author zhonghuashishan
 *
 */
public class PurchaseInputStockUpdateCommand extends AbstractGoodsStockUpdateCommand {

	/**
	 * 采购入库单条目DTO集合
	 */
	private Map<Long, PurchaseInputOrderItemDTO> purcahseInputOrderItemDTOMap;
	
	/**
	 * 构造函数
	 * @param goodsStockDO 商品库存DO对象
	 * @param goodsStockDAO 商品库存管理模块的DAO组件
	 * @param dateProvider 日期辅助组件
	 */
	public PurchaseInputStockUpdateCommand(
			List<GoodsStockDO> goodsStockDOs, 
			GoodsStockDAO goodsStockDAO,
			DateProvider dateProvider,
			Map<Long, PurchaseInputOrderItemDTO> purcahseInputOrderItemDTOMap) {
		super(goodsStockDOs, goodsStockDAO, dateProvider);
		this.purcahseInputOrderItemDTOMap = purcahseInputOrderItemDTOMap;
	}
	
	/**
	 * 更新销售库存
	 */
	@Override
	protected void updateSaleStockQuantity() throws Exception {
		for(GoodsStockDO goodsStockDO : goodsStockDOs) {
			PurchaseInputOrderItemDTO purchaseInputOrderItemDTO = 
					purcahseInputOrderItemDTOMap.get(goodsStockDO.getId());
			goodsStockDO.setSaleStockQuantity(goodsStockDO.getSaleStockQuantity() 
					+ purchaseInputOrderItemDTO.getArrivalCount()); 
		}
	}

	/**
	 * 更新锁定库存
	 */
	@Override
	protected void updateLockedStockQuantity() throws Exception {
		
	}

	/**
	 * 更新已销售库存
	 */
	@Override
	protected void updateSaledStockQuantity() throws Exception {
		
	}

}
