package com.zhss.eshop.wms.service.impl;

/**
 * 采购入库单处理结果
 * @author zhonghuashishan
 *
 */
public class PurchaseInputOrderHandlerResult {

	/**
	 * 处理结果
	 */
	private Boolean result;
	/**
	 * 是否执行下一个handler
	 */
	private Boolean doNext = true;
	
	public PurchaseInputOrderHandlerResult(Boolean result) {
		this.result = result;
	}

	public PurchaseInputOrderHandlerResult(Boolean result, Boolean doNext) {
		this.result = result;
		this.doNext = doNext;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Boolean getDoNext() {
		return doNext;
	}

	public void setDoNext(Boolean doNext) {
		this.doNext = doNext;
	}
	
}
