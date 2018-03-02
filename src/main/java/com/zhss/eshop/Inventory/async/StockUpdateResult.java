package com.zhss.eshop.Inventory.async;

/**
 * 商品库存更新结果
 * @author zhonghuashishan
 *
 */
public class StockUpdateResult {

	/**
	 * 商品库存更新消息id
	 */
	private String messageId;
	/**
	 * 商品库存更新结果
	 */
	private Boolean result;
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	
}
