package com.zhss.eshop.commodity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;

/**
 * 商品详情图片管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsDetailPictureMapper {

	/**
	 * 新增商品详情图片
	 * @param picture 图片
	 */
	@Insert("INSERT INTO commodity_goods_detail_picture("
				+ "goods_detail_id,"
				+ "picture_path,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{goodsDetailId},"
				+ "#{picturePath},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(GoodsDetailPictureDO picture);
	
}
