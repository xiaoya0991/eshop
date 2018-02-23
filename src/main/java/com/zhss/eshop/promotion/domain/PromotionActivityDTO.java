package com.zhss.eshop.promotion.domain;

import java.util.Date;

/**
 * 促销活动DTO
 * @author zhonghuashishan
 *
 */
public class PromotionActivityDTO {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 促销活动名称
	 */
	private String promotionActivityName;
	/**
	 * 促销活动开始时间
	 */
	private Date promotionActivityStartTime;
	/**
	 * 促销活动结束时间
	 */
	private Date promotionActivityEndTime;
	/**
	 * 促销活动备注
	 */
	private String promotionActivityComment;
	/**
	 * 促销活动状态
	 */
	private Integer promotionActivityStatus;
	/**
	 * 促销活动规则
	 */
	private String promotionActivityRule;
	/**
	 * 促销活动的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 促销活动的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPromotionActivityName() {
		return promotionActivityName;
	}
	public void setPromotionActivityName(String promotionActivityName) {
		this.promotionActivityName = promotionActivityName;
	}
	public Date getPromotionActivityStartTime() {
		return promotionActivityStartTime;
	}
	public void setPromotionActivityStartTime(Date promotionActivityStartTime) {
		this.promotionActivityStartTime = promotionActivityStartTime;
	}
	public Date getPromotionActivityEndTime() {
		return promotionActivityEndTime;
	}
	public void setPromotionActivityEndTime(Date promotionActivityEndTime) {
		this.promotionActivityEndTime = promotionActivityEndTime;
	}
	public String getPromotionActivityComment() {
		return promotionActivityComment;
	}
	public void setPromotionActivityComment(String promotionActivityComment) {
		this.promotionActivityComment = promotionActivityComment;
	}
	public Integer getPromotionActivityStatus() {
		return promotionActivityStatus;
	}
	public void setPromotionActivityStatus(Integer promotionActivityStatus) {
		this.promotionActivityStatus = promotionActivityStatus;
	}
	public String getPromotionActivityRule() {
		return promotionActivityRule;
	}
	public void setPromotionActivityRule(String promotionActivityRule) {
		this.promotionActivityRule = promotionActivityRule;
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
	
}
