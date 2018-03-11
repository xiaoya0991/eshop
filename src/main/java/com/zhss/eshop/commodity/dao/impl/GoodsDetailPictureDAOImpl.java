package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

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
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	public GoodsDetailPictureDO getById(Long id) {
		return goodsDetailPictureMapper.getById(id);
	}
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	public List<GoodsDetailPictureDO> listByGoodsDetailId(Long goodsDetailId) {
		return goodsDetailPictureMapper.listByGoodsDetailId(goodsDetailId);
	}
	
	/**
	 * 新增商品详情图片
	 * @param picture 图片
	 */
	public Long save(GoodsDetailPictureDO picture) {
		goodsDetailPictureMapper.save(picture); 
		return picture.getId();
	}
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	public void removeByGoodsDetailId(Long goodsDetailId) {
		goodsDetailPictureMapper.removeByGoodsDetailId(goodsDetailId);
	}
	
}
