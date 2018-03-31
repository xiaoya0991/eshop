package com.zhss.eshop.comment.constant;

/**
 * 评论状态的常量类
 * @author zhonghuashishan
 *
 */
public class CommentStatus {

	/**
	 * 待审核
	 */
	public static final Integer APPROVING = 1;
	/**
	 * 审核通过
	 */
	public static final Integer APPROVED = 2;
	/**
	 * 审核未通过
	 */
	public static final Integer APPROVE_REJECTED = 3;
	
	private CommentStatus() {
		
	}
	
}
