package com.zhss.eshop.comment.dao;

import com.zhss.eshop.comment.domain.CommentPictureDO;

/**
 * 评论晒图管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface CommentPictureDAO {

	/**
	 * 新增评论晒图
	 * @param commentPictureDO 评论晒图DO对象
	 */
	Boolean saveCommentPicture(CommentPictureDO commentPictureDO);
	
}
