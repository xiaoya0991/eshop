package com.zhss.eshop.commodity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zhss.eshop.commodity.domain.GoodsPictureDO;

/**
 * 商品图片管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsPictureMapper {
	
	/**
	 * 根据商品id查询商品图片id
	 * @param goodsId 商品id
	 * @return 商品图片id
	 */
	@Select("SELECT id "
			+ "FROM commodity_goods_picture "
			+ "WHERE goods_id=#{goodsId}")  
	List<Long> listIdsByGoodsId(@Param("goodsId") Long goodsId);
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_id,"
				+ "picture_path,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_goods_picture "
			+ "WHERE id=#{id}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "picture_path", property = "picturePath"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	GoodsPictureDO getById(@Param("id") Long id);
	
	/**
	 * 根据id查询商品图片
	 * @param goodsId 商品图片id
	 * @return 商品图片
	 */
	@Select("SELECT "
				+ "id,"
				+ "goods_id,"
				+ "picture_path,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM commodity_goods_picture "
			+ "WHERE goods_id=#{goodsId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "goods_id", property = "goodsId"),
		@Result(column = "picture_path", property = "picturePath"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<GoodsPictureDO> listByGoodsId(@Param("goodsId") Long goodsId);
	
	/**
	 * 新增商品图片
	 * @param picture 图片
	 */
	@Insert("INSERT INTO commodity_goods_picture("
				+ "goods_id,"
				+ "picture_path,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsId},"
				+ "#{picturePath},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsPictureDO picture);
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	@Delete("DELETE FROM commodity_goods_picture WHERE goods_id=#{goodsId}")  
	void removeByGoodsId(@Param("goodsId") Long goodsId);
	
}
