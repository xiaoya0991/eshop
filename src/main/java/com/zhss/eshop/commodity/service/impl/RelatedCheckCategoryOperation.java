package com.zhss.eshop.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zhss.eshop.commodity.dao.CategoryDAO;
import com.zhss.eshop.commodity.dao.GoodsDAO;

/**
 * 类目是否被商品关联的检查操作
 * 
 * spring默认情况下对每个bean都是维护一个单例的，bean scope是singleton，每次都是获取到同一个实例
 * 但是对于我们的这种情况下，我们需要的是类，prototype，bean scope是prototype，每次都是获取到一个新的实例
 * 
 * @author zhonghuashishan
 *
 */
@Component
@Scope("prototype")   
public class RelatedCheckCategoryOperation extends AbstractCategoryOperation<Boolean> {    
	
	/**
	 * 是否被商品关联
	 */
	private Boolean related = false;
	/**
	 * 商品管理DAO组件
	 */
	private GoodsDAO goodsDAO;
	
	/**
	 * 构造函数
	 * @param categoryDAO 类目管理DAO组件
	 */
	@Autowired
	public RelatedCheckCategoryOperation(
			CategoryDAO categoryDAO, GoodsDAO goodsDAO) {  
		super(categoryDAO);
		this.goodsDAO = goodsDAO;
	}
	
	/**
	 * 执行实际的操作
	 */
	@Override
	protected void doRealExecute(Category category) throws Exception {
		Long count = goodsDAO.countByCategoryId(category.getCategoryId());
		if(count > 0) {
			this.related = true;
		}
	}

	/**
	 * 获取操作的执行结果
	 */
	@Override
	protected Boolean getResult() throws Exception {
		return related;
	}

}
