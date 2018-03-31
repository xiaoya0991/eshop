package com.zhss.eshop.inventory.async;

import java.util.Observable;

/**
 * 商品库存更新结果观察目标
 * @author zhonghuashishan
 *
 */
public class StockUpdateObservable extends Observable {
	
	/**
	 * 消息id
	 */
	private String messageId;
	
	/**
	 * 构造函数
	 * @param messageId 消息id
	 */
	public StockUpdateObservable(String messageId) {
		this.messageId = messageId;
	}
	
	/**
	 * 设置商品库存更新结果
	 * @param result 商品库存更新结果
	 */
	public void setResult(Boolean result) {
		StockUpdateResult goodsStockUpdateResult = new StockUpdateResult();
		goodsStockUpdateResult.setMessageId(messageId); 
		goodsStockUpdateResult.setResult(result); 
		
		this.setChanged();
		this.notifyObservers(goodsStockUpdateResult);  
	}

	public String getMessageId() {
		return messageId;
	}
	
}
