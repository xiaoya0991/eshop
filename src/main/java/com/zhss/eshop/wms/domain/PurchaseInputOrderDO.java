package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购入库单
 * @author zhonghuashishan
 *
 */
public class PurchaseInputOrderDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 采购单id
	 */
	private Long purchaseOrderId;
	/**
	 * 供应商id
	 */
	private Long supplierId;
	/**
	 * 预期到达时间
	 */
	private Date expectArrivalTime;
	/**
	 * 实际到达时间
	 */
	private Date actualArrivalTime;
	/**
	 * 采购联系人
	 */
	private String purchaseContactor;
	/**
	 * 采购联系人电话号码
	 */
	private String purchaseContactorPhoneNumber;
	/**
	 * 采购联系人邮箱地址
	 */
	private String purchaseContactorEmail;
	/**
	 * 采购单备注
	 */
	private String purchaseOrderRemark;
	/**
	 * 采购员
	 */
	private String purchaser;
	/**
	 * 采购入库单的状态
	 */
	private Integer status;
	/**
	 * 采购入库单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 采购入库单的修改时间
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
	public Date getActualArrivalTime() {
		return actualArrivalTime;
	}
	public void setActualArrivalTime(Date actualArrivalTime) {
		this.actualArrivalTime = actualArrivalTime;
	}
	public String getPurchaseContactor() {
		return purchaseContactor;
	}
	public void setPurchaseContactor(String purchaseContactor) {
		this.purchaseContactor = purchaseContactor;
	}
	public String getPurchaseContactorPhoneNumber() {
		return purchaseContactorPhoneNumber;
	}
	public void setPurchaseContactorPhoneNumber(String purchaseContactorPhoneNumber) {
		this.purchaseContactorPhoneNumber = purchaseContactorPhoneNumber;
	}
	public String getPurchaseContactorEmail() {
		return purchaseContactorEmail;
	}
	public void setPurchaseContactorEmail(String purchaseContactorEmail) {
		this.purchaseContactorEmail = purchaseContactorEmail;
	}
	public String getPurchaseOrderRemark() {
		return purchaseOrderRemark;
	}
	public void setPurchaseOrderRemark(String purchaseOrderRemark) {
		this.purchaseOrderRemark = purchaseOrderRemark;
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
	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actualArrivalTime == null) ? 0 : actualArrivalTime.hashCode());
		result = prime * result + ((expectArrivalTime == null) ? 0 : expectArrivalTime.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchaseContactor == null) ? 0 : purchaseContactor.hashCode());
		result = prime * result + ((purchaseContactorEmail == null) ? 0 : purchaseContactorEmail.hashCode());
		result = prime * result
				+ ((purchaseContactorPhoneNumber == null) ? 0 : purchaseContactorPhoneNumber.hashCode());
		result = prime * result + ((purchaseOrderId == null) ? 0 : purchaseOrderId.hashCode());
		result = prime * result + ((purchaseOrderRemark == null) ? 0 : purchaseOrderRemark.hashCode());
		result = prime * result + ((purchaser == null) ? 0 : purchaser.hashCode());
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
		PurchaseInputOrderDO other = (PurchaseInputOrderDO) obj;
		if (actualArrivalTime == null) {
			if (other.actualArrivalTime != null)
				return false;
		} else if (!actualArrivalTime.equals(other.actualArrivalTime))
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
		if (purchaseContactor == null) {
			if (other.purchaseContactor != null)
				return false;
		} else if (!purchaseContactor.equals(other.purchaseContactor))
			return false;
		if (purchaseContactorEmail == null) {
			if (other.purchaseContactorEmail != null)
				return false;
		} else if (!purchaseContactorEmail.equals(other.purchaseContactorEmail))
			return false;
		if (purchaseContactorPhoneNumber == null) {
			if (other.purchaseContactorPhoneNumber != null)
				return false;
		} else if (!purchaseContactorPhoneNumber.equals(other.purchaseContactorPhoneNumber))
			return false;
		if (purchaseOrderId == null) {
			if (other.purchaseOrderId != null)
				return false;
		} else if (!purchaseOrderId.equals(other.purchaseOrderId))
			return false;
		if (purchaseOrderRemark == null) {
			if (other.purchaseOrderRemark != null)
				return false;
		} else if (!purchaseOrderRemark.equals(other.purchaseOrderRemark))
			return false;
		if (purchaser == null) {
			if (other.purchaser != null)
				return false;
		} else if (!purchaser.equals(other.purchaser))
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
	
	@Override
	public String toString() {
		return "PurchaseInputOrderDO [id=" + id + ", purchaseOrderId=" + purchaseOrderId + ", supplierId=" + supplierId
				+ ", expectArrivalTime=" + expectArrivalTime + ", actualArrivalTime=" + actualArrivalTime
				+ ", purchaseContactor=" + purchaseContactor + ", purchaseContactorPhoneNumber="
				+ purchaseContactorPhoneNumber + ", purchaseContactorEmail=" + purchaseContactorEmail
				+ ", purchaseOrderRemark=" + purchaseOrderRemark + ", purchaser=" + purchaser + ", status=" + status
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
