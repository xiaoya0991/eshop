package com.zhss.eshop.comment.service;

import com.zhss.eshop.comment.domain.CommentAggregateDO;
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
	 */
	CommentAggregateDO refreshCommentAggregate(CommentInfoDTO commentInfoDTO);
	
}
