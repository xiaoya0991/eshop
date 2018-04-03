package com.zhss.eshop.comment.dao.impl;

import java.util.List;

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
	
	/**
	 * 评论信息管理模块的mapper组件
	 */
	@Autowired
	private CommentInfoMapper commentInfoMapper;
	
	/**
	 * 新增评论信息
	 * @param commentInfoDO 评论信息DO对象
	 */
	@Override
	public Long saveCommentInfo(CommentInfoDO commentInfoDO) throws Exception {
		commentInfoMapper.saveCommentInfo(commentInfoDO); 
		return commentInfoDO.getId();
	}
	
	/**
	 * 分页查询评论信息
	 * @param query 评论查询条件
	 * @return 评论信息
	 */
	@Override
	public List<CommentInfoDO> listByPage(CommentInfoQuery query) throws Exception {
		return commentInfoMapper.listByPage(query);
	}
			
	/**
	 * 根据id查询评论信息
	 * @param id 评论信息id
	 * @return 评论信息
	 */
	@Override
	public CommentInfoDO getById(Long id) throws Exception {
		return commentInfoMapper.getById(id);
	}
	
	/**
	 * 更新评论
	 * @param comment 评论信息
	 */
	@Override
	public void update(CommentInfoDO comment) throws Exception {
		commentInfoMapper.update(comment);
	}
	
	/**
	 * 删除评论
	 * @param id 评论id
	 */
	@Override
	public void remove(Long id) throws Exception {
		commentInfoMapper.remove(id);
	}

}
