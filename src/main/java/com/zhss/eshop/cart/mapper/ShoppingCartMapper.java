package com.zhss.eshop.cart.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.cart.domain.ShoppingCartDO;

/**
 * 购物车管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ShoppingCartMapper {

	/**
	 * 根据用户账号id查询购物车
	 * @param userAccountId 用户账号id
	 * @return 购物车
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM shopping_cart "
			+ "WHERE user_account_id=#{userAccountId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	ShoppingCartDO getShoppingCartByUserAccountId(
			@Param("userAccountId") Long userAccountId);
	
	/**
	 * 新增购物车
	 * @param shoppingCartDO 购物车DO对象
	 */
	@Insert("INSERT INTO shopping_cart ("
				+ "user_account_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void saveShoppingCart(ShoppingCartDO shoppingCartDO);
	
}
