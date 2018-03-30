package com.zhss.eshop.inventory.async;

import java.util.List;

/**
 * 定义离线存储数据的迭代器接口
 * @author zhonghuashishan
 *
 */
public interface OfflineStorageIterator {

	/**
	 * 判断是否还有下一批库存更新消息
	 * @return 是否还有下一批库存更新消息
	 * @throws Exception
	 */
	public Boolean hasNext() throws Exception;
	
	/**
	 * 获取下一批库存更新消息
	 * @return 下一批库存更新消息
	 * @throws Exception
	 */
	List<StockUpdateMessage> next() throws Exception;
	
}
