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
	private Date arrivalTime;
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
	 * 采购入库单备注
	 */
	private String purchaseOrderComment;
	/**
	 * 采购员
	 */
	private String purchaser;
	/**
	 * 采购入库单的状态
	 */
	private Integer purcahseInputOrderStatus;
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
	private List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs;
	/**
	 * 采购入库单商品上架条目集合
	 */
	private List<PurchaseInputOrderPutOnItemDTO> purchaseInputOrderPutOnItemDTOs;
	
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
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	public Integer getPurcahseInputOrderStatus() {
		return purcahseInputOrderStatus;
	}
	public void setPurcahseInputOrderStatus(Integer purcahseInputOrderStatus) {
		this.purcahseInputOrderStatus = purcahseInputOrderStatus;
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
	public List<PurchaseInputOrderItemDTO> getPurchaseInputOrderItemDTOs() {
		return purchaseInputOrderItemDTOs;
	}
	public void setPurchaseInputOrderItemDTOs(List<PurchaseInputOrderItemDTO> purchaseInputOrderItemDTOs) {
		this.purchaseInputOrderItemDTOs = purchaseInputOrderItemDTOs;
	}
	public List<PurchaseInputOrderPutOnItemDTO> getPurchaseInputOrderPutOnItemDTOs() {
		return purchaseInputOrderPutOnItemDTOs;
	}
	public void setPurchaseInputOrderPutOnItemDTOs(List<PurchaseInputOrderPutOnItemDTO> purchaseInputOrderPutOnItemDTOs) {
		this.purchaseInputOrderPutOnItemDTOs = purchaseInputOrderPutOnItemDTOs;
	}
	
}
