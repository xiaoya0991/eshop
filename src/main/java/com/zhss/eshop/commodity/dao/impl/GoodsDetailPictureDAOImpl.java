package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsDetailPictureDAO;
import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;
import com.zhss.eshop.commodity.mapper.GoodsDetailPictureMapper;

/**
 * 商品详情图片管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsDetailPictureDAOImpl implements GoodsDetailPictureDAO {

	/**
	 * 商品详情图片管理mapper组件
	 */
	@Autowired
	private GoodsDetailPictureMapper goodsDetailPictureMapper;
	
	/**
	 * 新增商品详情图片
	 * @param picture 图片
	 */
	public Long save(GoodsDetailPictureDO picture) {
		goodsDetailPictureMapper.save(picture); 
		return picture.getId();
	}
	
}
