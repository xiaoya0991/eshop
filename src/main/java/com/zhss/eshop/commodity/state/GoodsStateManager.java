package com.zhss.eshop.commodity.state;

import com.zhss.eshop.commodity.domain.GoodsDTO;

/**
 * 商品状态管理器接口
 * @author zhonghuashishan
 *
 */
public interface GoodsStateManager {

	/**
	 * 创建一个商品
	 * @param goods
	 * @throws Exception
	 */
	void create(GoodsDTO goods) throws Exception;
	
	/**
	 * 当前这个商品能否执行编辑操作  
	 * @param goods 商品
	 * @return 能否执行编辑操作
	 * @throws Exception
	 */
	Boolean canEdit(GoodsDTO goods) throws Exception;
	
	/**
	 * 执行编辑商品的操作
	 * @param goods 商品
	 * @throws Exception
	 */
	void edit(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断能否执行审核操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canApprove(GoodsDTO goods) throws Exception;
	
	/**
	 * 执行审核操作
	 * @param goods
	 * @param approveResult
	 * @throws Exception
	 */
	void approve(GoodsDTO goods, Integer approveResult) throws Exception;
	
	/**
	 * 判断能否执行上架操作
	 * @param goods 商品
	 * @return 能否执行上架操作
	 * @throws Exception
	 */
	Boolean canPutOnShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 执行上架操作
	 * @param goods
	 * @throws Exception
	 */
	void putOnShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断能否执行下架操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canPullOffShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 执行下架操作
	 * @param goods 商品
	 * @throws Exception
	 */
	void pullOffShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 能否执行删除操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canRemove(GoodsDTO goods) throws Exception;
	
}
