package com.zhss.eshop.comment.dao;

import com.zhss.eshop.comment.domain.CommentInfoDO;

/**
 * 评论信息管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface CommentInfoDAO {

	/**
	 * 新增评论信息
	 * @param commentInfoDO 评论信息DO对象
	 */
	Boolean saveCommentInfo(CommentInfoDO commentInfoDO);
	
}
