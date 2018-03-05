package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 商品管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsMapper {

	/**
	 * 根据类目id查询商品数量
	 * @param categoryId 类目id
	 * @return 商品数量
	 */
	@Select("SELECT count(*) "
			+ "FROM commodity_goods "
			+ "WHERE category_id=#{categoryId}") 
	Long countByCategoryId(@Param("categoryId") Long categoryId);
	
}
