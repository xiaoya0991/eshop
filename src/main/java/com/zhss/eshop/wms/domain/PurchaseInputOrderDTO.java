package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

/**
 * 采购入库单DTO
 * @author zhonghuashishan
 *
 */
public class PurchaseInputOrderDTO {

	/**
	 * id
	 */
	private Long id;
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
	/**
	 * 采购入库单条目集合
	 */
	private List<PurchaseInputOrderItemDTO> items;
	
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
	public List<PurchaseInputOrderItemDTO> getItems() {
		return items;
	}
	public void setItems(List<PurchaseInputOrderItemDTO> items) {
		this.items = items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((expectArrivalTime == null) ? 0 : expectArrivalTime.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purcahseInputOrderStatus == null) ? 0 : purcahseInputOrderStatus.hashCode());
		result = prime * result + ((purchaseContactEmail == null) ? 0 : purchaseContactEmail.hashCode());
		result = prime * result + ((purchaseContactPhoneNumber == null) ? 0 : purchaseContactPhoneNumber.hashCode());
		result = prime * result + ((purchaseContactor == null) ? 0 : purchaseContactor.hashCode());
		result = prime * result + ((purchaseOrderComment == null) ? 0 : purchaseOrderComment.hashCode());
		result = prime * result + ((purchaser == null) ? 0 : purchaser.hashCode());
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
		PurchaseInputOrderDTO other = (PurchaseInputOrderDTO) obj;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
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
		if (purcahseInputOrderStatus == null) {
			if (other.purcahseInputOrderStatus != null)
				return false;
		} else if (!purcahseInputOrderStatus.equals(other.purcahseInputOrderStatus))
			return false;
		if (purchaseContactEmail == null) {
			if (other.purchaseContactEmail != null)
				return false;
		} else if (!purchaseContactEmail.equals(other.purchaseContactEmail))
			return false;
		if (purchaseContactPhoneNumber == null) {
			if (other.purchaseContactPhoneNumber != null)
				return false;
		} else if (!purchaseContactPhoneNumber.equals(other.purchaseContactPhoneNumber))
			return false;
		if (purchaseContactor == null) {
			if (other.purchaseContactor != null)
				return false;
		} else if (!purchaseContactor.equals(other.purchaseContactor))
			return false;
		if (purchaseOrderComment == null) {
			if (other.purchaseOrderComment != null)
				return false;
		} else if (!purchaseOrderComment.equals(other.purchaseOrderComment))
			return false;
		if (purchaser == null) {
			if (other.purchaser != null)
				return false;
		} else if (!purchaser.equals(other.purchaser))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		
		if(this.getPurchaseInputOrderItemDTOs() != null && other.getPurchaseInputOrderItemDTOs() != null) { 
			if(this.getPurchaseInputOrderItemDTOs().size() != 
					other.getPurchaseInputOrderItemDTOs().size()) {
				return false;
			}
			
			for(PurchaseInputOrderItemDTO item : this.getPurchaseInputOrderItemDTOs()) {
				Boolean result = false;
				
				for(PurchaseInputOrderItemDTO otherItem : other.getPurchaseInputOrderItemDTOs()) {
					if(item.equals(otherItem)) {
						result =true;
						break;
					}
				}
				
				if(!result) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
