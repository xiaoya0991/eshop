package com.zhss.eshop.commodity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsDAO;
import com.zhss.eshop.commodity.domain.GoodsDO;
import com.zhss.eshop.commodity.domain.GoodsQuery;
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
	
	/**
	 * 分页查询商品
	 * @param query 查询条件
	 * @return 商品
	 */
	public List<GoodsDO> listByPage(GoodsQuery query) {
		return goodsMapper.listByPage(query);
	}
	
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品
	 */
	public GoodsDO getById(Long id) {
		return goodsMapper.getById(id);
	}
	
	/**
	 * 新增商品
	 * @param goods 商品
	 */
	public Long save(GoodsDO goods) {
		goodsMapper.save(goods); 
		return goods.getId();
	}
	
	/**
	 * 更新商品
	 * @param goods 商品
	 */
	public void update(GoodsDO goods) {
		goodsMapper.update(goods);
	}
	
	/**
	 * 更新商品状态
	 * @param goods
	 */
	public void updateStatus(GoodsDO goods) {
		goodsMapper.updateStatus(goods);
	}
	
}
