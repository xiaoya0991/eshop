package com.zhss.eshop.Inventory.updater;

/**
 * 商品库存更新命令的接口
 * @author zhonghuashishan
 *
 */
public interface GoodsStockUpdater {

	/**
	 * 更新商品库存
	 * @return 处理结果
	 */
	Boolean updateGoodsStock();
	
}
