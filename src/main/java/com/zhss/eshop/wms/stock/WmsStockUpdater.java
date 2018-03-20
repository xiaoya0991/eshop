package com.zhss.eshop.wms.stock;

/**
 * 商品库存更新命令的接口
 * @author zhonghuashishan
 *
 */
public interface WmsStockUpdater { 

	/**
	 * 更新商品库存
	 * @return 处理结果
	 */
	Boolean update() throws Exception;
	
	/**
	 * 设置这个更新组件需要的参数
	 * @param parameter 参数
	 * @throws Exception
	 */
	void setParameter(Object parameter);
	
}
