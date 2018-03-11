package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhss.eshop.commodity.domain.GoodsDetailDO;

/**
 * 商品详情管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsDetailMapper {
	
	/**
	 * 根据商品id查询商品详情
	 * @param goodsId 商品id
	 * @return 商品详情
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_id,"
				+ "detail_content,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_goods_detail "
			+ "WHERE goods_id=#{goodsId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "detail_content", property = "detailContent"), 
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	GoodsDetailDO getByGoodsId(@Param("goodsId") Long goodsId);
	
	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 */
	@Insert("INSERT INTO commodity_goods_detail("
				+ "goods_id,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsId},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsDetailDO goodsDetail);
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 */
	@Update("UPDATE commodity_goods_detail SET "
				+ "detail_content=#{detailContent} "
			+ "WHERE id=#{id}")  
	void update(GoodsDetailDO goodsDetail);
	
}
