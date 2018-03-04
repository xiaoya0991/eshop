package com.zhss.eshop.cart.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 测试查询购物车中的所有条目
	 * @throws Exception
	 */
	@Test
	public void testListShoppingCartItemByCartId() throws Exception {
		// 构造购物车条目数据
		Long shoppingCartId = 1L;
		
		Map<Long, ShoppingCartItemDO> itemMap = 
				new HashMap<Long, ShoppingCartItemDO>();
		
		ShoppingCartItemDO item = null;
		
		item = createShoppingCartItem(shoppingCartId, 1L, 3L);
		itemMap.put(item.getId(), item);
		
		item = createShoppingCartItem(shoppingCartId, 2L, 4L);
		itemMap.put(item.getId(), item);
		
		item = createShoppingCartItem(shoppingCartId, 3L, 1L);
		itemMap.put(item.getId(), item);
		
		// 执行方法
		List<ShoppingCartItemDO> resultItems = shoppingCartItemDAO
				.listShoppingCartItemByCartId(shoppingCartId);
		
		// 执行断言
		assertEquals(3, resultItems.size());  
		
		for(ShoppingCartItemDO resultItem : resultItems) {
			ShoppingCartItemDO targetItem = itemMap.get(resultItem.getId());
			assertEquals(targetItem, resultItem);  
		}
	}
	
	/**
	 * 测试删除购物车条目
	 * @throws Exception
	 */
	@Test
	public void testRemove() throws Exception {
		Long shoppingCartId = 1L;
		Long goodsSkuId = 1L;
		Long purchaseQuantity = 3L;
		
		ShoppingCartItemDO item = createShoppingCartItem(
				shoppingCartId, goodsSkuId, purchaseQuantity);
		shoppingCartItemDAO.remove(item.getId());
		
		ShoppingCartItemDO resultItem = shoppingCartItemDAO.getShoppingCartItemByGoodsSkuId(
				shoppingCartId, goodsSkuId);		
		
		assertNull(resultItem); 
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
		ShoppingCartItemDO item = shoppingCartItemDAO.getShoppingCartItemByGoodsSkuId(
				shoppingCartId, goodsSkuId);
		
		if(item != null) {
			shoppingCartItemDAO.remove(item.getId());
		}
		
		ShoppingCartItemDO shoppingCartItemDO = new ShoppingCartItemDO();
		shoppingCartItemDO.setShoppingCartId(shoppingCartId);
		shoppingCartItemDO.setGoodsSkuId(goodsSkuId); 
		shoppingCartItemDO.setPurchaseQuantity(purchaseQuantity); 
		shoppingCartItemDO.setGmtCreate(dateProvider.getCurrentTime());
		shoppingCartItemDO.setGmtModified(dateProvider.getCurrentTime()); 
		
		shoppingCartItemDAO.saveShoppingCartItem(shoppingCartItemDO);
		
		return shoppingCartItemDO;
	}
	
}
