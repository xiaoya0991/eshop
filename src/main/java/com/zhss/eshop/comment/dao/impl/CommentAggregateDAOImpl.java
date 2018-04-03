package com.zhss.eshop.comment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.comment.dao.CommentAggregateDAO;
import com.zhss.eshop.comment.domain.CommentAggregateDO;
import com.zhss.eshop.comment.mapper.CommentAggregateMapper;

/**
 * 评论统计信息管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CommentAggregateDAOImpl implements CommentAggregateDAO {
	
	/**
	 * 评论信息管理模块的mapper组件
	 */
	@Autowired
	private CommentAggregateMapper commentAggregateMapper;
	
	/**
	 * 根据商品id查询评论统计信息
	 * @param goodsId 商品id
	 * @return 评论统计信息
	 */
	@Override
	public CommentAggregateDO getCommentAggregateByGoodsId(Long goodsId) throws Exception {
		return commentAggregateMapper.getCommentAggregateByGoodsId(goodsId);
	}
	
	/**
	 * 新增评论统计信息
	 * @param commentAggregateDO 评论统计信息DO对象
	 */
	@Override
	public void saveCommentAggregate(CommentAggregateDO commentAggregateDO) throws Exception {
		commentAggregateMapper.saveCommentAggregate(commentAggregateDO); 
	}
	
	/**
	 * 更新评论统计信息
	 * @param commentAggregateDO 评论统计信息DO对象
	 */
	@Override
	public void updateCommentAggregate(CommentAggregateDO commentAggregateDO) throws Exception {
		commentAggregateMapper.updateCommentAggregate(commentAggregateDO);
	}
	
}
