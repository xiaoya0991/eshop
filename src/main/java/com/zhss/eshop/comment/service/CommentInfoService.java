package com.zhss.eshop.comment.service;

import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.order.domain.OrderItemDTO;

/**
 * 评论信息管理模块的service组件接口
 * @author zhonghuashishan
 *
 */
public interface CommentInfoService {

	/**
	 * 新增手动发表的评论信息
	 * @param commentInfoDTO 评论信息DTO对象
	 */
	Boolean saveManualPublishedCommentInfo(CommentInfoDTO commentInfoDTO);
	
	/**
	 * 新增自动发表的评论信息
	 * @param orderInfoDTO 订单信息DTO对象
	 * @param orderItemDTO 订单条目DTO对象
	 * @return 处理结果
	 */
	CommentInfoDTO saveAutoPublishedCommentInfo(
			OrderInfoDTO orderInfoDTO, OrderItemDTO orderItemDTO);
	
}
