package com.zhss.eshop.commodity.service;

import java.util.List;

import com.zhss.eshop.commodity.domain.GoodsDTO;
import com.zhss.eshop.commodity.domain.GoodsQuery;

/**
 * 商品管理service组件接口
 * @author zhonghuashishan
 *
 */
public interface GoodsService {

	/**
	 * 分页查询商品
	 * @param query 查询条件
	 * @return 商品
	 */
	List<GoodsDTO> listByPage(GoodsQuery query) throws Exception;
	
	/**
	 * 根据id查询商品
	 * @param id 商品id
	 * @return 商品
	 */
	GoodsDTO getById(Long id) throws Exception;
	
	/**
	 * 新增商品
	 * @param goods 商品
	 */
	Long save(GoodsDTO goods) throws Exception;
	
	/**
	 * 更新商品
	 * @param goods 商品
	 */
	void update(GoodsDTO goods) throws Exception;
	
}
