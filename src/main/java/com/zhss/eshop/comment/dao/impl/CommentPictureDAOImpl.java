package com.zhss.eshop.comment.dao.impl;

import java.util.List;

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
	
	/**
	 * 评论晒图管理模块的mapper组件
	 */
	@Autowired
	private CommentPictureMapper commentPictureMapper;
	
	/**
	 * 新增评论晒图
	 * @param commentPictureDO 评论晒图DO对象
	 */
	@Override
	public Long saveCommentPicture(CommentPictureDO commentPictureDO) throws Exception {
		commentPictureMapper.saveCommentPicture(commentPictureDO);
		return commentPictureDO.getId();
	}
	
	/**
	 * 根据评论信息id查询图片
	 * @param commentId 评论信息id
	 * @return 评论图片
	 */
	@Override
	public List<CommentPictureDO> listByCommentId(Long commentId) throws Exception {
		return commentPictureMapper.listByCommentId(commentId);
	}
	
	/**
	 * 根据id查询图片
	 * @param id 评论图片id
	 * @return 评论图片
	 */
	@Override
	public CommentPictureDO getById(Long id) throws Exception {
		return commentPictureMapper.getById(id);
	}
	
}
