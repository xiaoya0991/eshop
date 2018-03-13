package com.zhss.eshop.membership.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 会员积分变更明细
 * @author zhonghuashishan
 *
 */
public class MemberPointDetailDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 本次变更之前的积分
	 */
	private Long oldMemberPoint;
	/**
	 * 本次变更的积分
	 */
	private Long updatedMemberPoint;
	/**
	 * 本次变更之后的积分
	 */
	private Long newMemberPoint;
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
	public Long getOldMemberPoint() {
		return oldMemberPoint;
	}
	public void setOldMemberPoint(Long oldMemberPoint) {
		this.oldMemberPoint = oldMemberPoint;
	}
	public Long getUpdatedMemberPoint() {
		return updatedMemberPoint;
	}
	public void setUpdatedMemberPoint(Long updatedMemberPoint) {
		this.updatedMemberPoint = updatedMemberPoint;
	}
	public Long getNewMemberPoint() {
		return newMemberPoint;
	}
	public void setNewMemberPoint(Long newMemberPoint) {
		this.newMemberPoint = newMemberPoint;
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
