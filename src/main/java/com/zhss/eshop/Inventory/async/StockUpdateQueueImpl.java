package com.zhss.eshop.Inventory.async;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品库存更新队列实现类
 * @author zhonghuashishan
 *
 */
@Component
public class StockUpdateQueueImpl implements StockUpdateQueue {
	
	private static final Integer QUEUE_MAX_SIZE = 1000;
	
	/**
	 * 离线存储管理组件
	 */
	@Autowired
	private OfflineStorageManager offlineStorageManager;
	
	/**
	 * 商品库存更新队列
	 */
	private ArrayBlockingQueue<StockUpdateMessage> queue = 
			new ArrayBlockingQueue<StockUpdateMessage>(QUEUE_MAX_SIZE); 

	/**
	 * 将一个消息放入队列
	 * @param message 消息
	 * @throws Exception
	 */
	public void put(StockUpdateMessage message) throws Exception {
		// 每次要往内存队列放消息之前，先检查一下离线存储标识
		// 如果触发了离线存储，直接就往离线存储去写入，不要走后面的逻辑了
		// 写完离线存储之后，需要检查一下内存队列的大小，如果内存队列已经清零，则启动一个后台线程
		// 让后台线程去将离线存储中的数据恢复写入内存队列中
		if(offlineStorageManager.getOffline()) {
			offlineStorageManager.store(message); 
			
			if(queue.size() == 0) {
				new OfflineResumeThread(offlineStorageManager, this).start(); 
			}
			
			return;
		}
		
		// 如果内存队列已经满了，此时就触发离线存储
		if(QUEUE_MAX_SIZE.equals(queue.size())) {  
			offlineStorageManager.store(message); 
			offlineStorageManager.setOffline(true);
			return;
		}
		
		queue.put(message); 
	}
	
	/**
	 * 从队列中取出一个消息
	 * @return
	 * @throws Exception
	 */
	public StockUpdateMessage get() throws Exception {	
		return queue.take();
	}
	
	/**
	 * 直接将消息放入队列
	 * @param message
	 * @throws Exception
	 */
	public void putDirect(StockUpdateMessage message) throws Exception {
		queue.put(message); 
	}
	
}
