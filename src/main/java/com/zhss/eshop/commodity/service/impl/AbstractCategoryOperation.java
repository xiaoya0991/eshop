package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.domain.CategoryDO;

/**
 * 类目操作的抽象基类
 * @author zhonghuashishan
 *
 */
public abstract class AbstractCategoryOperation<T> implements CategoryOperation<T> {  

	/**
	 * 类目管理DAO组件
	 */
	protected CategoryDAO categoryDAO;
	
	/**
	 * 构造函数
	 * @param categoryDAO 类目管理DAO组件
	 */
	public AbstractCategoryOperation(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	/**
	 * 执行类目操作
	 * @param category 类目树节点
	 */
	public T doExecute(Category category) throws Exception {
		doExecuteForChildren(category); 
		doRealExecute(category); 
		return getResult();
	}
	
	/**
	 * 递归对子类目执行当前操作
	 * @param category 当前类目
	 * @throws Exception
	 */
	private void doExecuteForChildren(Category category) throws Exception {
		List<CategoryDO> children = categoryDAO.listChildren(
				category.getCategoryId());
		if(children != null && children.size() > 0) {
			for(CategoryDO child : children) {
				Category childCategory = new Category(child.getId());
				childCategory.execute(this); 
			}
		}
	}
	
	/**
	 * 执行实际的操作
	 * @param category 类目
	 * @throws Exception
	 */
	protected abstract void doRealExecute(Category category) throws Exception;
	
	/**
	 * 获取操作的执行结果
	 * @return 操作的执行结果
	 * @throws Exception
	 */
	protected abstract T getResult() throws Exception;
	
}
