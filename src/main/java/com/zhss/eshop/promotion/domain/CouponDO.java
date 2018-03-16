package com.zhss.eshop.promotion.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 优惠券
 * @author zhonghuashishan
 *
 */
public class CouponDO extends AbstractObject {

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((giveOutCount == null) ? 0 : giveOutCount.hashCode());
		result = prime * result + ((giveOutType == null) ? 0 : giveOutType.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((receivedCount == null) ? 0 : receivedCount.hashCode());
		result = prime * result + ((rule == null) ? 0 : rule.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((validEndTime == null) ? 0 : validEndTime.hashCode());
		result = prime * result + ((validStartTime == null) ? 0 : validStartTime.hashCode());
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
		CouponDO other = (CouponDO) obj;
		if (giveOutCount == null) {
			if (other.giveOutCount != null)
				return false;
		} else if (!giveOutCount.equals(other.giveOutCount))
			return false;
		if (giveOutType == null) {
			if (other.giveOutType != null)
				return false;
		} else if (!giveOutType.equals(other.giveOutType))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (receivedCount == null) {
			if (other.receivedCount != null)
				return false;
		} else if (!receivedCount.equals(other.receivedCount))
			return false;
		if (rule == null) {
			if (other.rule != null)
				return false;
		} else if (!rule.equals(other.rule))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (validEndTime == null) {
			if (other.validEndTime != null)
				return false;
		} else if (!validEndTime.equals(other.validEndTime))
			return false;
		if (validStartTime == null) {
			if (other.validStartTime != null)
				return false;
		} else if (!validStartTime.equals(other.validStartTime))
			return false;
		return true;
	}
	
}
