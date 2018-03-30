package com.zhss.eshop.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhss.eshop.cart.domain.AddShoppingCartItemQuery;
import com.zhss.eshop.cart.domain.ShoppingCartDTO;
import com.zhss.eshop.cart.domain.ShoppingCartItemDTO;
import com.zhss.eshop.cart.domain.ShoppingCartItemVO;
import com.zhss.eshop.cart.domain.ShoppingCartVO;
import com.zhss.eshop.cart.service.ShoppingCartService;

/**
 * 购物车管理模块的controller组件
 * @author zhonghuashishan
 *
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

	/**
	 * 购物车管理模块的service组件
	 */
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	/**
	 * 添加购物车商品条目
	 * @param userAccountId 用户账号id
	 * @param goodsSkuId 商品sku id
	 * @return 处理结果
	 */
	@PostMapping("/item/add") 
	public Boolean addShoppingCartItem(@RequestBody AddShoppingCartItemQuery query) {
		try {
			shoppingCartService.addShoppingCartItem(query.getUserAccountId(), 
					query.getGoodsSkuId()); 
			return true;
		} catch (Exception e) {
			logger.error("error", e); 
			return false;
		}
	}
	
	/**
	 * 查看购物车
	 * @param userAccountId 用户账号id
	 * @return
	 */
	@GetMapping("/{userAccountId}")   
	public ShoppingCartVO getShoppingCartVO(
			@PathVariable("userAccountId") Long userAccountId) {
		try {
			ShoppingCartDTO shoppingCartDTO = shoppingCartService
					.getShoppingCartDTOByUserAccountId(userAccountId);
			
			ShoppingCartVO shoppingCartVO = shoppingCartDTO.clone(ShoppingCartVO.class);
			
			List<ShoppingCartItemVO> shoppingCartItemVOs = new ArrayList<ShoppingCartItemVO>();
			shoppingCartVO.setShoppingCartItemVOs(shoppingCartItemVOs); 
			
			for(ShoppingCartItemDTO shoppingCartItemDTO : shoppingCartDTO.getShoppingCartItemDTOs()) {
				shoppingCartItemVOs.add(shoppingCartItemDTO.clone(ShoppingCartItemVO.class));  
			}
			
			return shoppingCartVO;
		} catch (Exception e) {
			logger.error("error", e);  
			return new ShoppingCartVO();
		}
	}
	
}
