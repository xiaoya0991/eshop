package com.zhss.eshop.comment.domain;

import java.util.Date;

/**
 * 评论信息的查询条件
 * @author zhonghuashishan
 *
 */
public class CommentInfoQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页查询记录数
	 */
	private Integer size;
	/**
	 * 起始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 总评分
	 */
	private Integer totalScore;
	/**
	 * 评论状态
	 */
	private Integer commentStatus;
	/**
	 * 评论类型
	 */
	private Integer commentType;
	/**
	 * 是否晒图
	 */
	private Integer showPictures;
	/**
	 * 是否为默认评论
	 */
	private Integer defaultComment;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Integer getCommentType() {
		return commentType;
	}
	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}
	public Integer getShowPictures() {
		return showPictures;
	}
	public void setShowPictures(Integer showPictures) {
		this.showPictures = showPictures;
	}
	public Integer getDefaultComment() {
		return defaultComment;
	}
	public void setDefaultComment(Integer defaultComment) {
		this.defaultComment = defaultComment;
	}
	
}
