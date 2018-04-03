package com.zhss.eshop.comment.service;

import com.zhss.eshop.comment.domain.CommentAggregateDTO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;

/**
 * 评论统计信息管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface CommentAggregateService {

	/**
	 * 更新评论统计信息
	 * @param commentInfoDTO 评论信息
	 * @return 处理结果
	 * @throws Exception
	 */
	CommentAggregateDTO refreshCommentAggregate(
			CommentInfoDTO commentInfoDTO) throws Exception;
	
	/**
	 * 根据商品id查询评论统计信息
	 * @param goodsId 商品id
	 * @return 评论统计信息
	 * @throws Exception
	 */
	CommentAggregateDTO getCommentAggregateByGoodsId(
			Long goodsId) throws Exception;
	
}
