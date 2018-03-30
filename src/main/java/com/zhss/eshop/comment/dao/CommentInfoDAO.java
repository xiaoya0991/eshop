package com.zhss.eshop.comment.dao;

import java.util.List;

import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoQuery;

/**
 * 评论信息管理模块的DAO组件接口
 * @author zhonghuashishan
 *
 */
public interface CommentInfoDAO {

	/**
	 * 新增评论信息
	 * @param commentInfoDO 评论信息DO对象
	 * @return 评论id
	 * @throws Exception
	 */
	Long saveCommentInfo(CommentInfoDO commentInfoDO) throws Exception;
	
	/**
	 * 分页查询评论信息
	 * @param query 评论查询条件
	 * @return 评论信息
	 * @throws Exception
	 */
	List<CommentInfoDO> listByPage(CommentInfoQuery query) throws Exception;
	
	/**
	 * 根据id查询评论信息
	 * @param id 评论信息id
	 * @return 评论信息
	 * @throws Exception
	 */
	CommentInfoDO getById(Long id) throws Exception;
	
	/**
	 * 更新评论
	 * @param comment 评论信息
	 * @throws Exception
	 */
	void update(CommentInfoDO comment) throws Exception;
	
	/**
	 * 删除评论
	 * @param id 评论id
	 * @throws Exception
	 */
	void remove(Long id) throws Exception;
	
}
