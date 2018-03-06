package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsDAO;
import com.zhss.eshop.commodity.mapper.GoodsMapper;

/**
 * 商品管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsDAOImpl implements GoodsDAO {

	/**
	 * 商品管理mapper组件
	 */
	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 根据类目id查询商品数量
	 * @param categoryId 类目id
	 * @return 商品数量
	 */
	public Long countByCategoryId(Long categoryId) throws Exception {
		return goodsMapper.countByCategoryId(categoryId);
	}
	
	/**
	 * 根据品牌id查询商品数量
	 * @param categoryId 类目id
	 * @return 商品数量
	 */
	public Long countByBrandId(Long brandId) {
		return goodsMapper.countByBrandId(brandId);
	}
	
}
