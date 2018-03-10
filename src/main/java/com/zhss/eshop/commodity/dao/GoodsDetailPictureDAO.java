package com.zhss.eshop.commodity.dao;

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;

/**
 * 商品详情图片管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailPictureDAO {

	/**
	 * 新增商品详情图片
	 * @param picture 图片
	 */
	Long save(GoodsDetailPictureDO picture);
	
}
