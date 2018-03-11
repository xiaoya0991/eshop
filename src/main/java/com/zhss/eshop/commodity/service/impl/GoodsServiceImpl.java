package com.zhss.eshop.commodity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.GoodsDAO;
import com.zhss.eshop.commodity.domain.GoodsDO;
import com.zhss.eshop.commodity.domain.GoodsDTO;
import com.zhss.eshop.commodity.domain.GoodsQuery;
import com.zhss.eshop.commodity.service.GoodsService;
import com.zhss.eshop.common.util.ObjectUtils;

/**
 * 商品管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	/**
	 * 商品管理DAO组件
	 */
	@Autowired
	private GoodsDAO goodsDAO;
	
	/**
	 * 分页查询商品
	 * @param query 查询条件
	 * @return 商品
	 */
	public List<GoodsDTO> listByPage(GoodsQuery query) throws Exception {
		return ObjectUtils.convertList(goodsDAO.listByPage(query), GoodsDTO.class); 
	}
	
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品
	 */
	public GoodsDTO getById(Long id) throws Exception {
		return goodsDAO.getById(id).clone(GoodsDTO.class);
	}
	
	/**
	 * 新增商品
	 * @param goods 商品
	 */
	public Long save(GoodsDTO goods) throws Exception {
		return goodsDAO.save(goods.clone(GoodsDO.class)); 
	}
	
	/**
	 * 更新商品
	 * @param goods 商品
	 */
	public void update(GoodsDTO goods) throws Exception {
		goodsDAO.update(goods.clone(GoodsDO.class));  
	}
	
}
