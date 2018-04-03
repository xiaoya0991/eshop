package com.zhss.eshop.commodity.state;

import com.zhss.eshop.commodity.domain.GoodsDTO;

/**
 * 商品状态接口
 * @author zhonghuashishan
 *
 */
public interface GoodsState {
	
	/**
	 * 执行商品流转到当前状态来的业务逻辑
	 * @param goods 商品
	 * @throws Exception
	 */
	void doTransition(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断当前商品能否执行编辑操作
	 * @param goods 商品
	 * @return 能否执行编辑操作
	 * @throws Exception
	 */
	Boolean canEdit(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断能否执行审核操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canApprove(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断能否执行上架操作
	 * @param goods 商品
	 * @return 能否执行上架操作
	 * @throws Exception
	 */
	Boolean canPutOnShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 判断能否执行下架操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canPullOffShelves(GoodsDTO goods) throws Exception;
	
	/**
	 * 能否执行删除操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	Boolean canRemove(GoodsDTO goods) throws Exception;

}
