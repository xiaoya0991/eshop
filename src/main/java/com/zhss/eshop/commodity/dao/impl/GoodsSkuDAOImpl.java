package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsSkuDAO;
import com.zhss.eshop.commodity.domain.GoodsSkuDO;
import com.zhss.eshop.commodity.mapper.GoodsSkuMapper;

/**
 * 商品sku管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsSkuDAOImpl implements GoodsSkuDAO {

	/**
	 * 商品sku管理mapper组件
	 */
	@Autowired
	private GoodsSkuMapper goodsSkuMapper;
	
	/**
	 * 新增商品sku
	 * @param goodsSku
	 */
	public Long save(GoodsSkuDO goodsSku) {
		goodsSkuMapper.save(goodsSku); 
		return goodsSku.getId();
	}
	
}
