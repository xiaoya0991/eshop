package com.zhss.eshop.purchase.domain;

import java.util.Date;
import java.util.List;

/**
 * 采购单DTO
 * @author zhonghuashishan
 *
 */
public class PurchaseOrderDTO {

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
	private String purchaseContactor;
	/**
	 * 采购联系人电话号码
	 */
	private String purchaseContactPhoneNumber;
	/**
	 * 采购联系人邮箱地址
	 */
	private String purchaseContactEmail;
	/**
	 * 采购单备注
	 */
	private String purchaseOrderComment;
	/**
	 * 采购员
	 */
	private String purchaser;
	/**
	 * 采购单的状态
	 */
	private Integer purcahseOrderStatus;
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
	private List<PurchaseOrderItemDTO> items;
	
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
	public String getPurchaseContactor() {
		return purchaseContactor;
	}
	public void setPurchaseContactor(String purchaseContactor) {
		this.purchaseContactor = purchaseContactor;
	}
	public String getPurchaseContactPhoneNumber() {
		return purchaseContactPhoneNumber;
	}
	public void setPurchaseContactPhoneNumber(String purchaseContactPhoneNumber) {
		this.purchaseContactPhoneNumber = purchaseContactPhoneNumber;
	}
	public String getPurchaseContactEmail() {
		return purchaseContactEmail;
	}
	public void setPurchaseContactEmail(String purchaseContactEmail) {
		this.purchaseContactEmail = purchaseContactEmail;
	}
	public String getPurchaseOrderComment() {
		return purchaseOrderComment;
	}
	public void setPurchaseOrderComment(String purchaseOrderComment) {
		this.purchaseOrderComment = purchaseOrderComment;
	}
	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	public Integer getPurcahseOrderStatus() {
		return purcahseOrderStatus;
	}
	public void setPurcahseOrderStatus(Integer purcahseOrderStatus) {
		this.purcahseOrderStatus = purcahseOrderStatus;
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
	public List<PurchaseOrderItemDTO> getItems() {
		return items;
	}
	public void setItems(List<PurchaseOrderItemDTO> items) {
		this.items = items;
	}
	
}
