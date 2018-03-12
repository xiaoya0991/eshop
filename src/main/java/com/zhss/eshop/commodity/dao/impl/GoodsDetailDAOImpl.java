package com.zhss.eshop.commodity.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.commodity.dao.GoodsDetailDAO;
import com.zhss.eshop.commodity.domain.GoodsDetailDO;
import com.zhss.eshop.commodity.mapper.GoodsDetailMapper;

/**
 * 商品详情管理DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class GoodsDetailDAOImpl implements GoodsDetailDAO {
	
	/**
	 * 商品详情管理mapper组件
	 */
	@Autowired
	private GoodsDetailMapper goodsDetailMapper;
	
	/**
	 * 根据商品id查询商品详情
	 * @param goodsId 商品id
	 * @return 商品详情
	 */
	public GoodsDetailDO getByGoodsId(Long goodsId) {
		return goodsDetailMapper.getByGoodsId(goodsId);
	}
	
	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 */
	public Long save(GoodsDetailDO goodsDetail) {
		goodsDetailMapper.save(goodsDetail);
		return goodsDetail.getId();
	}
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 */
	public void update(GoodsDetailDO goodsDetail) {
		goodsDetailMapper.update(goodsDetail); 
	}
	
	/**
	 * 删除商品详情
	 * @param id 商品详情id
	 */ 
	public void remove(Long id) {
		goodsDetailMapper.remove(id);
	}

}
