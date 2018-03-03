package com.zhss.eshop.comment.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoQuery;
import com.zhss.eshop.comment.mapper.CommentInfoMapper;

/**
 * 评论信息管理模块的DAO组件
 * @author zhonghuashishan
 *
 */
@Repository
public class CommentInfoDAOImpl implements CommentInfoDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentInfoDAOImpl.class);

	/**
	 * 评论信息管理模块的mapper组件
	 */
	@Autowired
	private CommentInfoMapper commentInfoMapper;
	
	/**
	 * 新增评论信息
	 * @param commentInfoDO 评论信息DO对象
	 */
	public Long saveCommentInfo(CommentInfoDO commentInfoDO) {
		try {
			commentInfoMapper.saveCommentInfo(commentInfoDO); 
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
		return commentInfoDO.getId();
	}
	
	/**
	 * 分页查询评论信息
	 * @param query 评论查询条件
	 * @return 评论信息
	 */
	public List<CommentInfoDO> listByPage(CommentInfoQuery query) {
		try {
			return commentInfoMapper.listByPage(query);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}
	
	/**
	 * 根据id查询评论信息
	 * @param id 评论信息id
	 * @return 评论信息
	 */
	public CommentInfoDO getById(Long id) {
		try {
			return commentInfoMapper.getById(id);
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
	}

}
