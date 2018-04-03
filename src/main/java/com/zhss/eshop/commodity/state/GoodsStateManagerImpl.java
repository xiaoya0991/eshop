package com.zhss.eshop.commodity.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhss.eshop.commodity.constant.ApproveResult;
import com.zhss.eshop.commodity.domain.GoodsDTO;

/**
 * 商品状态管理器实现
 * @author zhonghuashishan
 *
 */
@Component
public class GoodsStateManagerImpl implements GoodsStateManager {

	/**
	 * 待审核状态
	 */
	@Autowired
	private WaitForApproveGoodsState waitForApproveGoodsState;
	/**
	 * 待上架状态
	 */
	@Autowired
	private WaitForPutOnShelvesGoodsState waitForPutOnShelvesGoodsState;
	/**
	 * 审核未通过状态
	 */
	@Autowired
	private ApproveRejectGoodsState approveRejectGoodsState;
	/**
	 * 已上架状态
	 */
	@Autowired
	private PuttedOnShelvesGoodsState puttedOnShelvesGoodsState;
	/**
	 * 商品状态工厂
	 */
	@Autowired
	private GoodsStateFactory goodsStateFactory;
	
	/**
	 * 创建一个商品
	 * @param goods
	 * @throws Exception
	 */
	@Override
	public void create(GoodsDTO goods) throws Exception {
		waitForApproveGoodsState.doTransition(goods); 
	}
	
	/**
	 * 当前这个商品能否执行编辑操作  
	 * @param goods 商品
	 * @return 能否执行编辑操作
	 * @throws Exception
	 */
	@Override
	public Boolean canEdit(GoodsDTO goods) throws Exception {
		GoodsState state = goodsStateFactory.get(goods);
		return state.canEdit(goods);
	}
	
	/**
	 * 执行编辑商品的操作
	 * @param goods 商品
	 * @throws Exception
	 */
	@Override
	public void edit(GoodsDTO goods) throws Exception {
		waitForApproveGoodsState.doTransition(goods); 
	}
	
	/**
	 * 判断能否执行审核操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean canApprove(GoodsDTO goods) throws Exception {
		GoodsState state = goodsStateFactory.get(goods);
		return state.canApprove(goods);
	}
	
	/**
	 * 执行审核操作
	 * @param goods
	 * @param approveResult
	 * @throws Exception
	 */
	@Override
	public void approve(GoodsDTO goods, Integer approveResult) throws Exception {
		if(ApproveResult.APPROVE_PASS.equals(approveResult)) {
			waitForPutOnShelvesGoodsState.doTransition(goods); 
		} else if(ApproveResult.APPROVE_REJECT.equals(approveResult)) {
			approveRejectGoodsState.doTransition(goods); 
		}
	}
	
	/**
	 * 判断能否执行上架操作
	 * @param goods 商品
	 * @return 能否执行上架操作
	 * @throws Exception
	 */
	@Override
	public Boolean canPutOnShelves(GoodsDTO goods) throws Exception {
		GoodsState state = goodsStateFactory.get(goods);
		return state.canPutOnShelves(goods);
	}
	
	/**
	 * 执行上架操作
	 * @param goods
	 * @throws Exception
	 */
	@Override
	public void putOnShelves(GoodsDTO goods) throws Exception {
		puttedOnShelvesGoodsState.doTransition(goods); 
	}
	
	/**
	 * 判断能否执行下架操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean canPullOffShelves(GoodsDTO goods) throws Exception {
		GoodsState state = goodsStateFactory.get(goods);
		return state.canPullOffShelves(goods);
	}
	
	/**
	 * 执行下架操作
	 * @param goods 商品
	 * @throws Exception
	 */
	@Override
	public void pullOffShelves(GoodsDTO goods) throws Exception {
		waitForPutOnShelvesGoodsState.doTransition(goods); 
	}
	
	/**
	 * 能否执行删除操作
	 * @param goods 商品
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean canRemove(GoodsDTO goods) throws Exception {
		GoodsState state = goodsStateFactory.get(goods);
		return state.canRemove(goods);
	}
	
}
