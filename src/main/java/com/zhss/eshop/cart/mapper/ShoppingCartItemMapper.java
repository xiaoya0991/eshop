package com.zhss.eshop.cart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.cart.domain.ShoppingCartItemDO;

/**
 * 购物车条目管理模块的mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface ShoppingCartItemMapper {

	/**
	 * 新增购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Insert("INSERT INTO shopping_cart_item("
				+ "shopping_cart_id,"
				+ "goods_sku_id,"
				+ "purchase_quantity,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{shoppingCartId},"
				+ "#{goodsSkuId},"
				+ "#{purchaseQuantity},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void saveShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO);
	
	/**
	 * 根据商品sku id查询购物车中是否存在商品条目
	 * @param shoppingCartId 购物车id
	 * @param goodsSkuId 商品sku id
	 * @return 商品条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "shopping_cart_id,"
				+ "goods_sku_id,"
				+ "purchase_quantity,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM shopping_cart_item "
			+ "WHERE shopping_cart_id=#{shoppingCartId} "
			+ "AND goods_sku_id=#{goodsSkuId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "shopping_cart_id", property = "shoppingCartId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "purchase_quantity", property = "purchaseQuantity"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	ShoppingCartItemDO getShoppingCartItemByGoodsSkuId(
			@Param("shoppingCartId") Long shoppingCartId,
			@Param("goodsSkuId") Long goodsSkuId);
	
	/**
	 * 更新购物车条目
	 * @param shoppingCartItemDO 购物车条目DO对象
	 */
	@Update("UPDATE shopping_cart_item SET "
				+ "purchase_quantity=#{purchaseQuantity},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void updateShoppingCartItem(ShoppingCartItemDO shoppingCartItemDO);
	
	/**
	 * 查询购物车中的所有条目
	 * @param shoppingCartId 购物车id
	 * @return 商品条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "shopping_cart_id,"
				+ "goods_sku_id,"
				+ "purchase_quantity,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM shopping_cart_item "
			+ "WHERE shopping_cart_id=#{shoppingCartId} ") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "shopping_cart_id", property = "shoppingCartId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "purchase_quantity", property = "purchaseQuantity"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<ShoppingCartItemDO> listShoppingCartItemByCartId(
			@Param("shoppingCartId") Long shoppingCartId);
	
	/**
	 * 删除购物车条目
	 * @param id 购物车条目id
	 */ 
	@Delete("DELETE FROM shopping_cart_item WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
}
