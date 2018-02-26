package com.zhss.eshop.Inventory.command;

/**
 * 库存更新命令工厂接口
 * @author zhonghuashishan
 *
 */
public interface GoodsStockUpdateCommandFactory<T> { 

	/**
	 * 创建一个库存更新命令
	 * @param parameter 参数对象
	 * @return 库存更新命令
	 */
	GoodsStockUpdateCommand create(T parameter);
	
}
