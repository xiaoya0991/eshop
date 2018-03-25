package com.zhss.eshop.purchase.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购单DTO
 * @author zhonghuashishan
 *
 */
public class PurchaseOrderDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 供应商id
	 */
	private Long supplierId;
	/**
	 * 预期到货时间
	 */
	private Date expectArrivalTime;
	/**
	 * 采购联系人
	 */
	private String contactor;
	/**
	 * 采购联系人电话号码
	 */
	private String contactorPhoneNumber;
	/**
	 * 采购联系人邮箱地址
	 */
	private String contactorEmail;
	/**
	 * 采购单备注
	 */
	private String remark;
	/**
	 * 采购员
	 */
	private String purchaser;
	/**
	 * 采购单的状态
	 */
	private Integer status;
	/**
	 * 采购单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 采购单的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Date getExpectArrivalTime() {
		return expectArrivalTime;
	}
	public void setExpectArrivalTime(Date expectArrivalTime) {
		this.expectArrivalTime = expectArrivalTime;
	}
	public String getContactor() {
		return contactor;
	}
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	public String getContactorPhoneNumber() {
		return contactorPhoneNumber;
	}
	public void setContactorPhoneNumber(String contactorPhoneNumber) {
		this.contactorPhoneNumber = contactorPhoneNumber;
	}
	public String getContactorEmail() {
		return contactorEmail;
	}
	public void setContactorEmail(String contactorEmail) {
		this.contactorEmail = contactorEmail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
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
		result = prime * result + ((contactor == null) ? 0 : contactor.hashCode());
		result = prime * result + ((contactorEmail == null) ? 0 : contactorEmail.hashCode());
		result = prime * result + ((contactorPhoneNumber == null) ? 0 : contactorPhoneNumber.hashCode());
		result = prime * result + ((expectArrivalTime == null) ? 0 : expectArrivalTime.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchaser == null) ? 0 : purchaser.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
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
		PurchaseOrderDO other = (PurchaseOrderDO) obj;
		if (contactor == null) {
			if (other.contactor != null)
				return false;
		} else if (!contactor.equals(other.contactor))
			return false;
		if (contactorEmail == null) {
			if (other.contactorEmail != null)
				return false;
		} else if (!contactorEmail.equals(other.contactorEmail))
			return false;
		if (contactorPhoneNumber == null) {
			if (other.contactorPhoneNumber != null)
				return false;
		} else if (!contactorPhoneNumber.equals(other.contactorPhoneNumber))
			return false;
		if (expectArrivalTime == null) {
			if (other.expectArrivalTime != null)
				return false;
		} else if (!expectArrivalTime.equals(other.expectArrivalTime))
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
		if (purchaser == null) {
			if (other.purchaser != null)
				return false;
		} else if (!purchaser.equals(other.purchaser))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		return true;
	}
	
}
