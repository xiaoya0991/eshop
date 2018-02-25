package com.zhss.eshop.cart.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhss.eshop.cart.dao.ShoppingCartDAO;
import com.zhss.eshop.cart.dao.ShoppingCartItemDAO;
import com.zhss.eshop.cart.domain.ShoppingCartDO;
import com.zhss.eshop.cart.domain.ShoppingCartItemDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 购物车管理模块的service组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
public class ShoppingCartServiceTest {

	/**
	 * 购物车管理模块的service组件
	 */
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	/**
	 * 购物车管理模块的DAO组件
	 */
	@MockBean
	private ShoppingCartDAO shoppingCartDAO;
	
	/**
	 * 购物车条目管理模块的DAO组件
	 */
	@MockBean
	private ShoppingCartItemDAO shoppingCartItemDAO;
	
	/**
	 * 日期辅助组件
	 */
	@MockBean
	private DateProvider dateProvider;
	
	/**
	 * 测试添加购物车商品条目
	 * @throws Exception
	 */
	@Test
	public void testAddShoppingCartItem() throws Exception {
		// 准备一些参数
		Long userAccountId = 1L;
		Long goodsSkuId = 1L;
		
		ShoppingCartDO shoppingCartDO = createShoppingCartDO(userAccountId);
		ShoppingCartItemDO shoppingCartItemDO = createShoppingCartItemDO(
				shoppingCartDO.getId(), goodsSkuId);
		
		// mock一下两个dao的行为
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = formatter.parse(formatter.format(new Date()));  
		when(dateProvider.getCurrentTime()).thenReturn(currentTime);
		
		when(shoppingCartDAO.getShoppingCartByUserAccountId(userAccountId))
				.thenReturn(shoppingCartDO);
		when(shoppingCartItemDAO.getShoppingCartItemByGoodsSkuId(
				shoppingCartDO.getId(), goodsSkuId)).thenReturn(shoppingCartItemDO);
		
		shoppingCartItemDO.setPurchaseQuantity(shoppingCartItemDO.getPurchaseQuantity() + 1L); 
		when(shoppingCartItemDAO.updateShoppingCartItem(shoppingCartItemDO)).thenReturn(true); 
		
		// 执行service的方法
		Boolean addShoppingCartItemResult = shoppingCartService
				.addShoppingCartItem(userAccountId, goodsSkuId);
		
		// 执行断言
		assertTrue(addShoppingCartItemResult);
		verify(shoppingCartDAO, times(1)).getShoppingCartByUserAccountId(userAccountId);
		verify(shoppingCartItemDAO, times(1)).getShoppingCartItemByGoodsSkuId(
				shoppingCartDO.getId(), goodsSkuId);
		verify(shoppingCartItemDAO, times(1)).updateShoppingCartItem(shoppingCartItemDO);
	}
	
	/**
	 * 创建一个购物车DO对象
	 * @param userAccountId 用户账号id
	 * @return 购物车DO对象
	 * @throws Exception
	 */
	private ShoppingCartDO createShoppingCartDO(Long userAccountId) throws Exception {
		Long id = 1L;
		Date currentTime = dateProvider.getCurrentTime();
		
		ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
		shoppingCartDO.setId(id);
		shoppingCartDO.setUserAccountId(userAccountId); 
		shoppingCartDO.setGmtCreate(currentTime);
		shoppingCartDO.setGmtModified(currentTime); 
		
		return shoppingCartDO;
	}
	
	/**
	 * 创建一个购物车条目DO对象
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @return 购物车条目DO对象
	 * @throws Exception
	 */
	private ShoppingCartItemDO createShoppingCartItemDO(
			Long shoppingCartId, Long goodsSkuId) throws Exception {
		Long id = 1L;
		Long purchaseQuantity = 1L;
		Date currentTime = dateProvider.getCurrentTime();
		
		ShoppingCartItemDO shoppingCartItemDO = new ShoppingCartItemDO();
		shoppingCartItemDO.setId(id);
		shoppingCartItemDO.setShoppingCartId(shoppingCartId); 
		shoppingCartItemDO.setGoodsSkuId(goodsSkuId); 
		shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity);
		shoppingCartItemDO.setGmtCreate(currentTime);
		shoppingCartItemDO.setGmtModified(currentTime);
		
		return shoppingCartItemDO;
	}
	
}
