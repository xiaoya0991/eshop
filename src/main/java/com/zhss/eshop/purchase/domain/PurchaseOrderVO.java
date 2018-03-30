package com.zhss.eshop.purchase.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 采购单
 * @author zhonghuashishan
 *
 */
public class PurchaseOrderVO extends AbstractObject {

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
	/**
	 * 采购条目集合
	 */
	private List<PurchaseOrderItemVO> items;
	
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
	public List<PurchaseOrderItemVO> getItems() {
		return items;
	}
	public void setItems(List<PurchaseOrderItemVO> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "PurchaseOrderVO [id=" + id + ", supplierId=" + supplierId + ", expectArrivalTime=" + expectArrivalTime
				+ ", contactor=" + contactor + ", contactorPhoneNumber=" + contactorPhoneNumber + ", contactorEmail="
				+ contactorEmail + ", remark=" + remark + ", purchaser=" + purchaser + ", status=" + status
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", items=" + items + "]";
	}
	
}
