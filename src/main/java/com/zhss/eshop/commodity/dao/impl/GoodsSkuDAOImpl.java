package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsSkuDAO;
import com.zhss.eshop.commodity.domain.GoodsSkuDO;
import com.zhss.eshop.commodity.domain.GoodsSkuQuery;
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
	 * 根据商品id查询商品sku
	 * @param goodsId 商品id
	 * @return 商品sku
	 */
	@Override
	public List<GoodsSkuDO> listByGoodsId(Long goodsId) {
		return goodsSkuMapper.listByGoodsId(goodsId);
	}
	
	/**
	 * 新增商品sku
	 * @param goodsSku
	 */
	@Override
	public Long save(GoodsSkuDO goodsSku) {
		goodsSkuMapper.save(goodsSku); 
		return goodsSku.getId();
	}
	
	/**
	 * 根据商品id删除sku
	 * @param goodsId 商品id
	 */
	@Override
	public void removeByGoodsId(Long goodsId) {
		goodsSkuMapper.removeByGoodsId(goodsId); 
	}
	
	/**
	 * 根据id查询商品sku
	 * @param id 商品sku id
	 * @return 商品sku
	 */
	@Override
	public GoodsSkuDO getById(Long id) {
		return goodsSkuMapper.getById(id);
	}
	
	/**
	 * 分页查询商品sku
	 * @param query 查询条件
	 * @return 商品sku
	 */
	@Override
	public List<GoodsSkuDO> listByPage(GoodsSkuQuery query) {
		return goodsSkuMapper.listByPage(query);
	}
	
}
