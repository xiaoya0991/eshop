package com.zhss.eshop.Inventory.async;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 离线数据恢复线程
 * @author zhonghuashishan
 *
 */
public class OfflineResumeThread extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(OfflineResumeThread.class);
	
	/**
	 * 离线存储管理组件
	 */
	private OfflineStorageManager offlineStorageManager;
	/**
	 * 库存更新队列
	 */
	private StockUpdateQueue stockUpdateQueue;

	/**
	 * 构造函数
	 * @param offlineStorageManager 离线存储管理组件
	 */
	public OfflineResumeThread(OfflineStorageManager offlineStorageManager,
			StockUpdateQueue stockUpdateQueue) {
		this.offlineStorageManager = offlineStorageManager;
		this.stockUpdateQueue = stockUpdateQueue;
	}
	
	/**
	 * 执行线程
	 */
	@Override
	public void run() {
		// 如果表中还有数据的话
		while(offlineStorageManager.hasNext()) {
			try {
				// 每次就从mysql中查询50条数据，批量查询，批量处理，批量删除
				List<StockUpdateMessage> stockUpdateMessages = 
						offlineStorageManager.getNextBatch();
				
				// 将这批数据写入内存队列中
				for(StockUpdateMessage message : stockUpdateMessages) {
					stockUpdateQueue.putDirect(message);
				}
				
				// 批量删除这批数据
				offlineStorageManager.removeByBatch(stockUpdateMessages); 
			} catch (Exception e) {
				logger.error("error", e); 
			}
		}
		
		// 此时mysql中的数据全部恢复完，更新内存标识
		offlineStorageManager.setOffline(false); 
	}
	
}
