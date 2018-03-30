package com.zhss.eshop.cart.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.cart.domain.ShoppingCartDO;
import com.zhss.eshop.common.util.DateProvider;

/**
 * 购物车管理模块的DAO组件的单元测试类
 * @author zhonghuashishan
 *
 */
@RunWith(SpringRunner.class) 
@SpringBootTest
@Transactional(rollbackFor = Exception.class) 
@Rollback(true) 
public class ShoppingCartDaoTest {
	
	/**
	 * 购物车管理模块的DAO组件
	 */
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	
	/**
	 * 日期辅助组件
	 */
	@Autowired
	private DateProvider dateProvider;
	
	/**
	 * 测试新增购物车
	 * @throws Exception
	 */
	@Test
	public void testSaveShoppingCart() throws Exception {
		Long userAccountId = 1L;
		ShoppingCartDO shoppingCartDO = createShoppingCart(userAccountId);
		Long shoppingCartId = shoppingCartDO.getId();
		
		assertNotNull(shoppingCartId);  
		assertThat(shoppingCartId, greaterThan(0L));
	}
	
	/**
	 * 测试根据用户账号id查询购物车
	 */
	@Test
	public void testGetShoppingCartByUserAccountId() throws Exception {
		Long userAccountId = 1L;
		ShoppingCartDO shoppingCartDO = createShoppingCart(userAccountId);
		
		ShoppingCartDO resultShoppingCartDO = shoppingCartDAO
				.getShoppingCartByUserAccountId(userAccountId);
		
		assertEquals(shoppingCartDO, resultShoppingCartDO);  
	}
	
	/**
	 * 创建一个购物车
	 * @return 购物车id
	 */
	private ShoppingCartDO createShoppingCart(Long userAccountId) throws Exception {		
		Date currentTime = dateProvider.getCurrentTime();
		
		ShoppingCartDO shoppingCartDO = new ShoppingCartDO();
		shoppingCartDO.setUserAccountId(userAccountId);
		shoppingCartDO.setGmtCreate(currentTime);
		shoppingCartDO.setGmtModified(currentTime);  
		
		shoppingCartDAO.saveShoppingCart(shoppingCartDO);
		
		return shoppingCartDO;
	}
	
}
