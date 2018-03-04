package com.zhss.eshop.Inventory.async;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 商品库存更新结果管理组件
 * @author zhonghuashishan
 *
 */
@Component
public class StockUpdateResultManagerImpl 
		implements StockUpdateResultManager {

	/**
	 * 商品库存更新结果map
	 */
	private Map<String, StockUpdateObservable> observableMap = 
			new ConcurrentHashMap<String, StockUpdateObservable>();
	
	/**
	 * 商品库存更新结果观察者
	 */
	@Autowired
	private StockUpdateObserver observer;
	
	/**
	 * 设置对商品库存更新结果的观察
	 * @param messageId 消息id
	 * @param result 商品库存更新结果
	 * @param observer 商品库存更新结果的观察者
	 */
	public void observe(String messageId) {
		StockUpdateObservable observable = new StockUpdateObservable(messageId);
		observable.addObserver(observer);  
		observableMap.put(messageId, observable);
	}
	
	/**
	 * 获取商品库存更新结果的观察目标
	 * @param messageId 商品库存更新消息id
	 * @return 商品库存更新结果的观察目标
	 */
	public void inform(String messageId, Boolean result) {
		StockUpdateObservable observable = observableMap.get(messageId);
		observable.setResult(result); 
		observableMap.remove(messageId);
	}
	
	/**
	 * 获取库存更新结果观察目标
	 * @param messageId 消息id
	 * @return
	 */
	public StockUpdateObservable getObservable(String messageId) {
		return observableMap.get(messageId);
	}
	
}
