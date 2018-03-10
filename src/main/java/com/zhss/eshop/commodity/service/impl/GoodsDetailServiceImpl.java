package com.zhss.eshop.commodity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhss.eshop.commodity.dao.GoodsDetailDAO;
import com.zhss.eshop.commodity.domain.GoodsDetailDO;
import com.zhss.eshop.commodity.domain.GoodsDetailDTO;
import com.zhss.eshop.commodity.service.GoodsDetailService;

/**
 * 商品详情管理service组件
 * @author zhonghuashishan
 *
 */
@Service
@Transactional
public class GoodsDetailServiceImpl implements GoodsDetailService {

	/**
	 * 商品详情管理DAO组件
	 */
	@Autowired
	private GoodsDetailDAO goodsDetailDAO;
	
	/**
	 * 新增商品详情
	 * @param goodsDetail 商品详情
	 * @return 商品详情id
	 * @throws Exception
	 */
	public Long save(GoodsDetailDTO goodsDetail) throws Exception {
		return goodsDetailDAO.save(goodsDetail.clone(GoodsDetailDO.class));  
	}
	
	/**
	 * 更新商品详情
	 * @param goodsDetail 商品详情
	 * @throws Exception 
	 */
	public void update(GoodsDetailDTO goodsDetail) throws Exception {
		goodsDetailDAO.update(goodsDetail.clone(GoodsDetailDO.class));  
	}
	
}
