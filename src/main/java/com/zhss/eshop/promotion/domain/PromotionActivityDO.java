package com.zhss.eshop.promotion.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 促销活动DTO
 * @author zhonghuashishan
 *
 */
public class PromotionActivityDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 促销活动名称
	 */
	private String name;
	/**
	 * 促销活动开始时间
	 */
	private Date startTime;
	/**
	 * 促销活动结束时间
	 */
	private Date endTime;
	/**
	 * 促销活动备注
	 */
	private String remark;
	/**
	 * 促销活动状态
	 */
	private Integer status;
	/**
	 * 促销活动规则
	 */
	private String rule;
	/**
	 * 促销活动类型
	 */
	private Integer type;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
