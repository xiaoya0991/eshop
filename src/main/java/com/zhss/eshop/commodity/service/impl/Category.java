package com.zhss.eshop.commodity.service.impl;

/**
 * 类目
 * @author zhonghuashishan
 *
 */
public class Category { 
	
	/**
	 * 类目id
	 */
	private Long categoryId;
	
	public Category() {
		
	}
	
	public Category(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 对类目执行某个操作
	 * @param operation 操作
	 */
	public <T> T execute(CategoryOperation<T> operation) throws Exception {
		return operation.doExecute(this);   
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}
