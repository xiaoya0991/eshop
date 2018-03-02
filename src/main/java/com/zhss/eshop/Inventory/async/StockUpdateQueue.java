package com.zhss.eshop.Inventory.async;

/**
 * 商品库存更新消息的队列接口
 * @author zhonghuashishan
 *
 */
public interface StockUpdateQueue {

	/**
	 * 将一个消息放入队列
	 * @param message 消息
	 * @throws Exception
	 */
	public void put(StockUpdateMessage message) throws Exception;
	
	/**
	 * 从队列中取出一个消息
	 * @return
	 * @throws Exception
	 */
	public StockUpdateMessage get() throws Exception;
	
	/**
	 * 直接将消息放入队列
	 * @param message
	 * @throws Exception
	 */
	public void putDirect(StockUpdateMessage message) throws Exception;
	
}
