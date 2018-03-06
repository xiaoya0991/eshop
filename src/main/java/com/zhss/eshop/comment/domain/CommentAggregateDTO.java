package com.zhss.eshop.comment.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 评论聚合统计信息
 * @author zhonghuashishan
 *
 */
public class CommentAggregateDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 总评论数
	 */
	private Long totalCommentCount;
	/**
	 * 好评数
	 */
	private Long goodCommentCount;
	/**
	 * 好评率
	 */
	private Double goodCommentRate;
	/**
	 * 晒图评论数
	 */
	private Long showPicturesCommentCount;
	/**
	 * 中评评论数
	 */
	private Long mediumCommentCount;
	/**
	 * 差评评论数
	 */
	private Long badCommentCount;
	/**
	 * 评论聚合统计信息的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 评论聚合统计信息的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getTotalCommentCount() {
		return totalCommentCount;
	}
	public void setTotalCommentCount(Long totalCommentCount) {
		this.totalCommentCount = totalCommentCount;
	}
	public Long getGoodCommentCount() {
		return goodCommentCount;
	}
	public void setGoodCommentCount(Long goodCommentCount) {
		this.goodCommentCount = goodCommentCount;
	}
	public Double getGoodCommentRate() {
		return goodCommentRate;
	}
	public void setGoodCommentRate(Double goodCommentRate) {
		this.goodCommentRate = goodCommentRate;
	}
	public Long getShowPicturesCommentCount() {
		return showPicturesCommentCount;
	}
	public void setShowPicturesCommentCount(Long showPicturesCommentCount) {
		this.showPicturesCommentCount = showPicturesCommentCount;
	}
	public Long getMediumCommentCount() {
		return mediumCommentCount;
	}
	public void setMediumCommentCount(Long mediumCommentCount) {
		this.mediumCommentCount = mediumCommentCount;
	}
	public Long getBadCommentCount() {
		return badCommentCount;
	}
	public void setBadCommentCount(Long badCommentCount) {
		this.badCommentCount = badCommentCount;
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
		result = prime * result + ((badCommentCount == null) ? 0 : badCommentCount.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((goodCommentCount == null) ? 0 : goodCommentCount.hashCode());
		result = prime * result + ((goodCommentRate == null) ? 0 : goodCommentRate.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mediumCommentCount == null) ? 0 : mediumCommentCount.hashCode());
		result = prime * result + ((showPicturesCommentCount == null) ? 0 : showPicturesCommentCount.hashCode());
		result = prime * result + ((totalCommentCount == null) ? 0 : totalCommentCount.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentAggregateDTO other = (CommentAggregateDTO) obj;
		if (badCommentCount == null) {
			if (other.badCommentCount != null)
				return false;
		} else if (!badCommentCount.equals(other.badCommentCount))
			return false;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (goodCommentCount == null) {
			if (other.goodCommentCount != null)
				return false;
		} else if (!goodCommentCount.equals(other.goodCommentCount))
			return false;
		if (goodCommentRate == null) {
			if (other.goodCommentRate != null)
				return false;
		} else if (!goodCommentRate.equals(other.goodCommentRate))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mediumCommentCount == null) {
			if (other.mediumCommentCount != null)
				return false;
		} else if (!mediumCommentCount.equals(other.mediumCommentCount))
			return false;
		if (showPicturesCommentCount == null) {
			if (other.showPicturesCommentCount != null)
				return false;
		} else if (!showPicturesCommentCount.equals(other.showPicturesCommentCount))
			return false;
		if (totalCommentCount == null) {
			if (other.totalCommentCount != null)
				return false;
		} else if (!totalCommentCount.equals(other.totalCommentCount))
			return false;
		return true;
	}
	
}
