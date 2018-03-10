package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.GoodsPictureDO;

/**
 * 商品图片管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsPictureMapper {

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
	
}
