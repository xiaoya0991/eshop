package com.zhss.eshop.commodity.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zhss.eshop.commodity.domain.GoodsPictureDO;

/**
 * 商品图片管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface GoodsPictureDAO {

	/**
	 * 新增商品图片
	 * @param picture 图片
	 */
	void save(GoodsPictureDO picture);
	
}
