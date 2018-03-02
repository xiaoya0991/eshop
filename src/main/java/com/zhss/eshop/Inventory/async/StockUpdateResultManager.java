package com.zhss.eshop.Inventory.async;

/**
 * 商品库存更新结果管理组件接口
 * @author zhonghuashishan
 *
 */
public interface StockUpdateResultManager {

	/**
	 * 设置对商品库存更新结果的观察
	 * @param messageId 消息id
	 * @param result 商品库存更新结果
	 * @param observer 商品库存更新结果的观察者
	 */
	void observe(String messageId);
	
	/**
	 * 获取商品库存更新结果的观察目标
	 * @param messageId 商品库存更新消息id
	 * @return 商品库存更新结果的观察目标
	 */
	void inform(String messageId, Boolean result);
	
}
