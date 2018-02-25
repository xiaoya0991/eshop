package com.zhss.eshop.cart.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.cart.domain.ShoppingCartItemDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 购物车条目管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional 
@Rollback(true) 
public class ShoppingCartItemDAOTest {

	/**
	 * 购物车条目管理模块的DAO组件
	 */
	@Autowired
	private ShoppingCartItemDAO shoppingCartItemDAO;
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增购物车条目
	 * @throws Exception
	 */
	@Test
	public void testSaveShoppingCartItem() throws Exception {
		Long shoppingCartId = 1L;
		Long goodsSkuId = 1L;
		Long purchaseQuantity = 1L;
		
		ShoppingCartItemDO shoppingCartItemDO = createShoppingCartItem(
				shoppingCartId, goodsSkuId, purchaseQuantity);
		Long shoppingCartItemId = shoppingCartItemDO.getId();
		
		assertNotNull(shoppingCartItemId);
		assertThat(shoppingCartItemId, greaterThan(0L));  
	}
	
	/**
	 * 测试根据商品sku id查询购物车中是否存在商品条目
	 * @throws Exception
	 */
	@Test
	public void testGetShoppingCartItemByGoodsSkuId() throws Exception {
		Long shoppingCartId = 1L;
		Long goodsSkuId = 1L;
		Long purchaseQuantity = 1L;
		
		ShoppingCartItemDO shoppingCartItemDO = createShoppingCartItem(
				shoppingCartId, goodsSkuId, purchaseQuantity);
		
		ShoppingCartItemDO resultShoppingCartItemDO = shoppingCartItemDAO
				.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
		
		assertEquals(shoppingCartItemDO, resultShoppingCartItemDO); 
	}
	
	/**
	 * 测试更新购物车条目
	 * @throws Exception
	 */
	@Test
	public void testUpdateShoppingCartItem() throws Exception {
		// 构造一个购物车条目出来
		Long shoppingCartId = 1L;
		Long goodsSkuId = 1L;
		Long purchaseQuantity = 1L;
		
		ShoppingCartItemDO shoppingCartItemDO = createShoppingCartItem(
				shoppingCartId, goodsSkuId, purchaseQuantity);
		
		// 更新购物车条目的购买数量和修改时间
		Long newPurchaseQuantity = purchaseQuantity + 1L;
		Date newGmtModified = dateProvider.getCurrentTime();
		
		shoppingCartItemDO.setPurchaseQuantity(newPurchaseQuantity); 
		shoppingCartItemDO.setGmtModified(newGmtModified); 
		
		shoppingCartItemDAO.updateShoppingCartItem(shoppingCartItemDO);
		
		// 再次从数据库中查询购物车条目
		ShoppingCartItemDO resultShoppingCartItemDO = shoppingCartItemDAO
				.getShoppingCartItemByGoodsSkuId(shoppingCartId, goodsSkuId);
	
		// 断言比较数据是否更新
		assertEquals(newPurchaseQuantity, resultShoppingCartItemDO.getPurchaseQuantity()); 
		assertEquals(newGmtModified, resultShoppingCartItemDO.getGmtModified());  
	}
	
	/**
	 * 创建一个购物车条目
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @param purchaseQuantity 购买数量
	 * @return 购物车条目DO对象
	 * @throws Exception 
	 */
	private ShoppingCartItemDO createShoppingCartItem(Long shoppingCartId, 
			Long goodsSkuId, Long purchaseQuantity) throws Exception {
		Date currentTime = dateProvider.getCurrentTime();
		
		ShoppingCartItemDO shoppingCartItemDO = new ShoppingCartItemDO();
		shoppingCartItemDO.setShoppingCartId(shoppingCartId);
		shoppingCartItemDO.setGoodsSkuId(goodsSkuId); 
		shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity); 
		shoppingCartItemDO.setGmtCreate(currentTime);
		shoppingCartItemDO.setGmtModified(currentTime); 
		
		shoppingCartItemDAO.saveShoppingCartItem(shoppingCartItemDO);
		
		return shoppingCartItemDO;
	}
	
}
