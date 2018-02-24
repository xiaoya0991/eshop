package com.zhss.eshop.comment.domain;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhss.eshop.common.util.BeanCopierUtils;

/**
 * 评论信息
 * @author zhonghuashishan
 *
 */
public class CommentInfoDTO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentInfoDTO.class);

	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 订单信息id
	 */
	private Long orderInfoId;
	/**
	 * 订单条目id
	 */
	private Long orderItemId;
	/**
	 * 订单条目对应的商品id
	 */
	private Long goodsId;
	/**
	 * 订单条目对应的商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku销售属性
	 */
	private String goodsSkuSaleProperties;
	/**
	 * 总评分：商品评分 + 客服评论 + 物流评分 / 3
	 */
	private Integer totalScore;
	/**
	 * 商品评分
	 */
	private Integer goodsScore;
	/**
	 * 客服评分
	 */
	private Integer customerServiceScore;
	/**
	 * 物流评分
	 */
	private Integer logisticsScore;
	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 是否晒图
	 */
	private Integer showPictures;
	/**
	 * 是否是默认评论
	 */
	private Integer defaultComment;
	/**
	 * 评论状态
	 */
	private Integer commentStatus;
	/**
	 * 评论类型
	 */
	private Integer commentType;
	/**
	 * 评论的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 评论的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getGoodsSkuId() {
		return goodsSkuId;
	}
	public void setGoodsSkuId(Long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}
	public String getGoodsSkuSaleProperties() {
		return goodsSkuSaleProperties;
	}
	public void setGoodsSkuSaleProperties(String goodsSkuSaleProperties) {
		this.goodsSkuSaleProperties = goodsSkuSaleProperties;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getGoodsScore() {
		return goodsScore;
	}
	public void setGoodsScore(Integer goodsScore) {
		this.goodsScore = goodsScore;
	}
	public Integer getCustomerServiceScore() {
		return customerServiceScore;
	}
	public void setCustomerServiceScore(Integer customerServiceScore) {
		this.customerServiceScore = customerServiceScore;
	}
	public Integer getLogisticsScore() {
		return logisticsScore;
	}
	public void setLogisticsScore(Integer logisticsScore) {
		this.logisticsScore = logisticsScore;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	/**
	 * 将自己的数据克隆到指定类型的对象中
	 * @param clazz 指定类型
	 * @return 指定类型的对象
	 */
	public <T> T clone(Class<T> clazz) {
		T target = null;
		try {
			target = clazz.newInstance();
			BeanCopierUtils.copyProperties(this, target);  
		} catch (Exception e) {
			logger.error("error", e); 
			return null;
		}
		return target;
	}
	
}
