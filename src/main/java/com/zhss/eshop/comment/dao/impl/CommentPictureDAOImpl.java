package com.zhss.eshop.comment.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.comment.dao.CommentPictureDAO;
import com.zhss.eshop.comment.domain.CommentPictureDO;
import com.zhss.eshop.comment.mapper.CommentPictureMapper;

/**
 * 评论晒图管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CommentPictureDAOImpl implements CommentPictureDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentPictureDAOImpl.class);

	/**
	 * 评论晒图管理模块的mapper组件
	 */
	@Autowired
	private CommentPictureMapper commentPictureMapper;
	
	/**
	 * 新增评论晒图
	 * @param commentPictureDO 评论晒图DO对象
	 */
	public Long saveCommentPicture(CommentPictureDO commentPictureDO) {
		try {
			commentPictureMapper.saveCommentPicture(commentPictureDO);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return commentPictureDO.getId();
	}
	
	/**
	 * 根据评论信息id查询图片
	 * @param commentId 评论信息id
	 * @return 评论图片
	 */
	public List<CommentPictureDO> listByCommentId(Long commentId) {
		try {
			return commentPictureMapper.listByCommentId(commentId);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询图片
	 * @param id 评论图片id
	 * @return 评论图片
	 */
	public CommentPictureDO getById(Long id) {
		try {
			return commentPictureMapper.getById(id);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
}
