package com.zhss.eshop.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhss.eshop.cart.dao.ShoppingCartItemDAO;
import com.zhss.eshop.cart.domain.ShoppingCartItemDO;
import com.zhss.eshop.cart.service.ShoppingCartItemService;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 购物车条目管理service组件
 * @author zhonghuashishan
 *
 */
@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
	
	/**
	 * 购物车条目管理DAO组件
	 */
	@Autowired
	private ShoppingCartItemDAO shoppingCartItemDAO;
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 删除购物车条目
	 * @param id 购物车条目id
	 */ 
	@Override
	public void remove(Long id) throws Exception {
		shoppingCartItemDAO.remove(id);
	}
	
	/**
	 * 更新购物车条目的购买数量
	 * @param id 购物车条目id
	 * @param purchaseQuantity 购买数量
	 * @return 处理结果
	 */
	@Override
	public void updatePurchaseQuantity(Long id, Long purchaseQuantity) throws Exception {
		ShoppingCartItemDO item = new ShoppingCartItemDO();
		item.setId(id); 
		item.setPurchaseQuantity(purchaseQuantity); 
		item.setGmtModified(dateProvider.getCurrentTime()); 
		shoppingCartItemDAO.updateShoppingCartItem(item);
	}

}
