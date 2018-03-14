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
	Boolean update(GoodsDTO goods) throws Exception;
	
	/**
	 * 审核商品
	 * @param goods 商品
	 * @return 处理结果
	 * @throws Exception
	 */
	Boolean approve(Long goodsId, Integer approveResult) throws Exception;  
	
	/**
	 * 执行上架操作
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	Boolean putOnShelves(Long goodsId) throws Exception;
	
	/**
	 * 执行下架操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean pullOffShelves(Long goodsId) throws Exception;
	
	/**
	 * 执行删除操作
	 * @param goodsId
	 * @return
	 * @throws Exception
	 */
	Boolean remove(Long goodsId) throws Exception;
	
}
