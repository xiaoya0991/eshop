package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsPictureDAO;
import com.zhss.eshop.commodity.domain.GoodsPictureDO;
import com.zhss.eshop.commodity.mapper.GoodsPictureMapper;

/**
 * 商品图片管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsPictureDAOImpl implements GoodsPictureDAO {
	
	/**
	 * 商品图片管理mapper组件
	 */
	@Autowired
	private GoodsPictureMapper goodsPictureMapper;
	
	/**
	 * 根据商品id查询商品图片id
	 * @param goodsId 商品id
	 * @return 商品图片id
	 */
	@Override
	public List<Long> listIdsByGoodsId(Long goodsId) {
		return goodsPictureMapper.listIdsByGoodsId(goodsId);
	}
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	@Override
	public List<GoodsPictureDO> listByGoodsId(Long goodsId) {
		return goodsPictureMapper.listByGoodsId(goodsId);
	}
	
	/**
	 * 根据id查询商品图片
	 * @param id 商品图片id
	 * @return 商品图片
	 */
	@Override
	public GoodsPictureDO getById(Long id) {
		return goodsPictureMapper.getById(id);
	}
	
	/**
	 * 新增商品图片
	 * @param picture 图片
	 */
	@Override
	public void save(GoodsPictureDO picture) {
		goodsPictureMapper.save(picture); 
	}
	
	/**
	 * 根据商品id删除图片
	 * @param goodsId 商品id
	 */
	@Override
	public void removeByGoodsId(Long goodsId) {
		goodsPictureMapper.removeByGoodsId(goodsId);
	}

}
