package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsPropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsPropertyValueDO;
import com.zhss.eshop.commodity.mapper.GoodsPropertyValueMapper;

/**
 * 商品属性值管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsPropertyValueDAOImpl implements GoodsPropertyValueDAO {

	/**
	 * 商品属性值管理mapper组件
	 */
	@Autowired
	private GoodsPropertyValueMapper goodsPropertyValueMapper;
	
	/**
	 * 根据商品id查询属性值
	 * @param goodsId 商品id
	 * @return 属性值
	 */
	@Override
	public List<GoodsPropertyValueDO> listByGoodsId(Long goodsId) {
		return goodsPropertyValueMapper.listByGoodsId(goodsId);
	}
	
	/**
	 * 新增商品属性值
	 * @param goodsPropertyValue 商品属性值
	 */
	@Override
	public void save(GoodsPropertyValueDO goodsPropertyValue) {
		goodsPropertyValueMapper.save(goodsPropertyValue);
	}
	
	/**
	 * 根据商品id删除属性值
	 * @param goodsId 商品id
	 */
	@Override
	public void removeByGoodsId(Long goodsId) {
		goodsPropertyValueMapper.removeByGoodsId(goodsId);
	}
	
}
