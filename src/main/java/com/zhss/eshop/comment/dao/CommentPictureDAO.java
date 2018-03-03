package com.zhss.eshop.comment.dao;

import java.util.List;

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
	Long saveCommentPicture(CommentPictureDO commentPictureDO);
	
	/**
	 * 根据评论信息id查询图片
	 * @param commentId 评论信息id
	 * @return 评论图片
	 */
	List<CommentPictureDO> listByCommentId(Long commentId);
	
	/**
	 * 根据id查询图片
	 * @param id 评论图片id
	 * @return 评论图片
	 */
	CommentPictureDO getById(Long id);
	
}
