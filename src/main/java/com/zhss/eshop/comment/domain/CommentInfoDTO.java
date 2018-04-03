package com.zhss.eshop.comment.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 评论信息
 * @author zhonghuashishan
 *
 */
public class CommentInfoDTO extends AbstractObject {
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentStatus == null) ? 0 : commentStatus.hashCode());
		result = prime * result + ((commentType == null) ? 0 : commentType.hashCode());
		result = prime * result + ((customerServiceScore == null) ? 0 : customerServiceScore.hashCode());
		result = prime * result + ((defaultComment == null) ? 0 : defaultComment.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsScore == null) ? 0 : goodsScore.hashCode());
		result = prime * result + ((goodsSkuId == null) ? 0 : goodsSkuId.hashCode());
		result = prime * result + ((goodsSkuSaleProperties == null) ? 0 : goodsSkuSaleProperties.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logisticsScore == null) ? 0 : logisticsScore.hashCode());
		result = prime * result + ((orderInfoId == null) ? 0 : orderInfoId.hashCode());
		result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
		result = prime * result + ((showPictures == null) ? 0 : showPictures.hashCode());
		result = prime * result + ((totalScore == null) ? 0 : totalScore.hashCode());
		result = prime * result + ((userAccountId == null) ? 0 : userAccountId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CommentInfoDTO other = (CommentInfoDTO) obj;
		if (commentContent == null) {
			if (other.commentContent != null) {
				return false;
			}
		} else if (!commentContent.equals(other.commentContent)) {
			return false;
		}
		if (commentStatus == null) {
			if (other.commentStatus != null) {
				return false;
			}
		} else if (!commentStatus.equals(other.commentStatus)) {
			return false;
		}
		if (commentType == null) {
			if (other.commentType != null) {
				return false;
			}
		} else if (!commentType.equals(other.commentType)) {
			return false;
		}
		if (customerServiceScore == null) {
			if (other.customerServiceScore != null) {
				return false;
			}
		} else if (!customerServiceScore.equals(other.customerServiceScore)) {
			return false;
		}
		if (defaultComment == null) {
			if (other.defaultComment != null) {
				return false;
			}
		} else if (!defaultComment.equals(other.defaultComment)) {
			return false;
		}
		if (gmtCreate == null) {
			if (other.gmtCreate != null) {
				return false;
			}
		} else if (!gmtCreate.equals(other.gmtCreate)) {
			return false;
		}
		if (gmtModified == null) {
			if (other.gmtModified != null) {
				return false;
			}
		} else if (!gmtModified.equals(other.gmtModified)) {
			return false;
		}
		if (goodsId == null) {
			if (other.goodsId != null) {
				return false;
			}
		} else if (!goodsId.equals(other.goodsId)) {
			return false;
		}
		if (goodsScore == null) {
			if (other.goodsScore != null) {
				return false;
			}
		} else if (!goodsScore.equals(other.goodsScore)) {
			return false;
		}
		if (goodsSkuId == null) {
			if (other.goodsSkuId != null) {
				return false;
			}
		} else if (!goodsSkuId.equals(other.goodsSkuId)) {
			return false;
		}
		if (goodsSkuSaleProperties == null) {
			if (other.goodsSkuSaleProperties != null) {
				return false;
			}
		} else if (!goodsSkuSaleProperties.equals(other.goodsSkuSaleProperties)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (logisticsScore == null) {
			if (other.logisticsScore != null) {
				return false;
			}
		} else if (!logisticsScore.equals(other.logisticsScore)) {
			return false;
		}
		if (orderInfoId == null) {
			if (other.orderInfoId != null) {
				return false;
			}
		} else if (!orderInfoId.equals(other.orderInfoId)) {
			return false;
		}
		if (orderItemId == null) {
			if (other.orderItemId != null) {
				return false;
			}
		} else if (!orderItemId.equals(other.orderItemId)) {
			return false;
		}
		if (showPictures == null) {
			if (other.showPictures != null) {
				return false;
			}
		} else if (!showPictures.equals(other.showPictures)) {
			return false;
		}
		if (totalScore == null) {
			if (other.totalScore != null) {
				return false;
			}
		} else if (!totalScore.equals(other.totalScore)) {
			return false;
		}
		if (userAccountId == null) {
			if (other.userAccountId != null) {
				return false;
			}
		} else if (!userAccountId.equals(other.userAccountId)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "CommentInfoDTO [id=" + id + ", userAccountId=" + userAccountId + ", username=" + username
				+ ", orderInfoId=" + orderInfoId + ", orderItemId=" + orderItemId + ", goodsId=" + goodsId
				+ ", goodsSkuId=" + goodsSkuId + ", goodsSkuSaleProperties=" + goodsSkuSaleProperties + ", totalScore="
				+ totalScore + ", goodsScore=" + goodsScore + ", customerServiceScore=" + customerServiceScore
				+ ", logisticsScore=" + logisticsScore + ", commentContent=" + commentContent + ", showPictures="
				+ showPictures + ", defaultComment=" + defaultComment + ", commentStatus=" + commentStatus
				+ ", commentType=" + commentType + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
