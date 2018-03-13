package com.zhss.eshop.membership.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 会员等级变更明细
 * @author zhonghuashishan
 *
 */
public class MemberLevelDetailDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 本次变更之前的成长值
	 */
	private Long oldGrowthValue;
	/**
	 * 本次变更的成长值
	 */
	private Long updatedGrowthValue;
	/**
	 * 本次变更之后的成长值
	 */
	private Long newGrowthValue;
	/**
	 * 本次变更之前的会员等级
	 */
	private Integer oldMemberLevel;
	/**
	 * 本次变更之后的会员等级
	 */
	private Integer newMemberLevel;
	/**
	 * 本次变更原因
	 */
	private String updateReason;
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
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Long getOldGrowthValue() {
		return oldGrowthValue;
	}
	public void setOldGrowthValue(Long oldGrowthValue) {
		this.oldGrowthValue = oldGrowthValue;
	}
	public Long getUpdatedGrowthValue() {
		return updatedGrowthValue;
	}
	public void setUpdatedGrowthValue(Long updatedGrowthValue) {
		this.updatedGrowthValue = updatedGrowthValue;
	}
	public Long getNewGrowthValue() {
		return newGrowthValue;
	}
	public void setNewGrowthValue(Long newGrowthValue) {
		this.newGrowthValue = newGrowthValue;
	}
	public Integer getOldMemberLevel() {
		return oldMemberLevel;
	}
	public void setOldMemberLevel(Integer oldMemberLevel) {
		this.oldMemberLevel = oldMemberLevel;
	}
	public Integer getNewMemberLevel() {
		return newMemberLevel;
	}
	public void setNewMemberLevel(Integer newMemberLevel) {
		this.newMemberLevel = newMemberLevel;
	}
	public String getUpdateReason() {
		return updateReason;
	}
	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
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
