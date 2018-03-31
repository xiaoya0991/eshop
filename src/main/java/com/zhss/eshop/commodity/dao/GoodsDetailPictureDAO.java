package com.zhss.eshop.commodity.dao;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsDetailPictureDO;

/**
 * 商品详情图片管理DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsDetailPictureDAO {
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	GoodsDetailPictureDO getById(Long id);

	/**
	 * 根据id查询商品图片
	 * @param goodsDetailId 商品图片id
	 * @return 商品图片
	 */
	List<GoodsDetailPictureDO> listByGoodsDetailId(Long goodsDetailId);
	
	/**
	 * 新增商品详情图片
	 * @param picture 图片
	 * @return 商品详情图片id
	 */
	Long save(GoodsDetailPictureDO picture);
	
	/**
	 * 根据商品id删除图片
	 * @param goodsDetailId 商品id
	 */
	void removeByGoodsDetailId(Long goodsDetailId);
	
}
