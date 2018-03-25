package com.zhss.eshop.Inventory.async;

import java.util.List;

/**
 * 离线存储管理组件接口
 * @author zhonghuashishan
 *
 */
public interface OfflineStorageManager {

	/**
	 * 离线存储库存更新消息
	 * @param message 库存更新消息
	 * @throws Exception
	 */
	void store(StockUpdateMessage message) throws Exception;
	
	/**
	 * 获取离线存储标识
	 * @return 离线存储标识
	 */
	Boolean getOffline();
	
	/**
	 * 设置离线存储标识
	 * @param offline 离线存储标识
	 */
	void setOffline(Boolean offline);
	
	/**
	 * 所谓的迭代器模式，什么时候用？
	 * 
	 * 其实只有一个场景，就是如果你需要基于一些不支持迭代的数据，来让我们业务代码进行迭代
	 * 那么你自己就要去实现基于那个数据的一套迭代代码
	 * 以迭代器的方式返回回去给业务方，来通过你定义的迭代器，进行数据的迭代
	 * 
	 * mysql数据库，本身是不支持迭代式访问的，但是我们可以自己实现一套基于mysql的迭代访问的代码
	 * 把一个迭代器给返回回去
	 * 
	 * 比如有的时候，我们可能还需要基于es、redis的数据，来提供业务方迭代式访问的功能，那么此时就只能我们自己
	 * 去封装迭代器，在里面封装基于es、redis的迭代访问数据的逻辑
	 * 
	 */
	OfflineStorageIterator iterator() throws Exception;
	
	/**
	 * 批量删除库存更新消息
	 * @param stockUpdateMessages 库存更新消息
	 * @throws Exception
	 */
	void removeByBatch(List<StockUpdateMessage> stockUpdateMessages) throws Exception;

}
