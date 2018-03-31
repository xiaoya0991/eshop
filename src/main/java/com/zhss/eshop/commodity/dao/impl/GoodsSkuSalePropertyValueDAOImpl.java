package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsSkuSalePropertyValueDAO;
import com.zhss.eshop.commodity.domain.GoodsSkuSalePropertyValueDO;
import com.zhss.eshop.commodity.mapper.GoodsSkuSalePropertyValueMapper;

/**
 * 商品sku销售属性值管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsSkuSalePropertyValueDAOImpl implements GoodsSkuSalePropertyValueDAO {

	/**
	 * 商品sku销售属性值管理mapper组件
	 */
	@Autowired
	private GoodsSkuSalePropertyValueMapper propertyValueMapper;
	
	/**
	 * 根据商品sku id查询属性值
	 * @param goodsSkuId 商品sku id
	 * @return 属性值
	 */
	@Override
	public List<GoodsSkuSalePropertyValueDO> listByGoodsSkuId(Long goodsSkuId) {
		return propertyValueMapper.listByGoodsSkuId(goodsSkuId);
	}
	
	/**
	 * 新增商品sku销售属性值
	 * @param propertyValue 商品sku销售属性值
	 */
	@Override
	public void save(GoodsSkuSalePropertyValueDO propertyValue) {
		propertyValueMapper.save(propertyValue); 
	}
	
	/**
	 * 根据商品sku id删除属性值
	 * @param goodsSkuId 商品sku id
	 */
	@Override
	public void removeByGoodsSkuId(Long goodsSkuId) {
		propertyValueMapper.removeByGoodsSkuId(goodsSkuId); 
	}
	
}
