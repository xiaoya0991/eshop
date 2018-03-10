package com.zhss.eshop.promotion.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 优惠券
 * @author zhonghuashishan
 *
 */
public class CouponDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 优惠券类型
	 */
	private Integer type;
	/**
	 * 优惠券使用规则
	 */
	private String rule;
	/**
	 * 有效期开始时间
	 */
	private Date validStartTime;
	/**
	 * 有效期结束时间
	 */
	private Date validEndTime;
	/**
	 * 发行总数量
	 */
	private Long giveOutCount;
	/**
	 * 已经领取的数量
	 */
	private Long receivedCount;
	/**
	 * 发行方式
	 */
	private Integer giveOutType;
	/**
	 * 优惠券状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public Date getValidStartTime() {
		return validStartTime;
	}
	public void setValidStartTime(Date validStartTime) {
		this.validStartTime = validStartTime;
	}
	public Date getValidEndTime() {
		return validEndTime;
	}
	public void setValidEndTime(Date validEndTime) {
		this.validEndTime = validEndTime;
	}
	public Long getGiveOutCount() {
		return giveOutCount;
	}
	public void setGiveOutCount(Long giveOutCount) {
		this.giveOutCount = giveOutCount;
	}
	public Long getReceivedCount() {
		return receivedCount;
	}
	public void setReceivedCount(Long receivedCount) {
		this.receivedCount = receivedCount;
	}
	public Integer getGiveOutType() {
		return giveOutType;
	}
	public void setGiveOutType(Integer giveOutType) {
		this.giveOutType = giveOutType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
