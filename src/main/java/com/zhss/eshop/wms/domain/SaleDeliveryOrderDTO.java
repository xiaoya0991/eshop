package com.zhss.eshop.wms.domain;

import java.util.Date;
import java.util.List;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 销售出库单DTO
 * @author zhonghuashishan
 *
 */
public class SaleDeliveryOrderDTO extends AbstractObject {
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 收货地址
	 */
	private String deliveryAddress;
	/**
	 * 收货人手机号码
	 */
	private String consigneeCellPhoneNumber;
	/**
	 * 运费
	 */
	private Double freight;
	/**
	 * 支付方式
	 */
	private Integer payType;
	/**
	 * 订单总金额
	 */
	private Double totalAmount;
	/**
	 * 折扣金额
	 */
	private Double discountAmount;
	/**
	 * 优惠券抵扣金额
	 */
	private Double couponAmount;
	/**
	 * 应付金额
	 */
	private Double payableAmount;
	/**
	 * 发票抬头
	 */
	private String invoiceTitle;
	/**
	 * 纳税人识别号
	 */
	private String taxpayerId;
	/**
	 * 订单备注
	 */
	private String orderComment;
	/**
	 * 销售出库单的状态
	 */
	private Integer status;
	/**
	 * 实际发货时间
	 */
	private Date deliveryTime;
	/**
	 * 销售出库单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 销售出库单的修改时间
	 */
	private Date gmtModified;
	/**
	 * 销售出库单条目
	 */
	private List<SaleDeliveryOrderItemDTO> saleDeliveryOrderItems;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getConsigneeCellPhoneNumber() {
		return consigneeCellPhoneNumber;
	}
	public void setConsigneeCellPhoneNumber(String consigneeCellPhoneNumber) {
		this.consigneeCellPhoneNumber = consigneeCellPhoneNumber;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Double getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(Double couponAmount) {
		this.couponAmount = couponAmount;
	}
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public String getTaxpayerId() {
		return taxpayerId;
	}
	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
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
	public List<SaleDeliveryOrderItemDTO> getSaleDeliveryOrderItems() {
		return saleDeliveryOrderItems;
	}
	public void setSaleDeliveryOrderItems(List<SaleDeliveryOrderItemDTO> saleDeliveryOrderItems) {
		this.saleDeliveryOrderItems = saleDeliveryOrderItems;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consignee == null) ? 0 : consignee.hashCode());
		result = prime * result + ((consigneeCellPhoneNumber == null) ? 0 : consigneeCellPhoneNumber.hashCode());
		result = prime * result + ((couponAmount == null) ? 0 : couponAmount.hashCode());
		result = prime * result + ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
		result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((freight == null) ? 0 : freight.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceTitle == null) ? 0 : invoiceTitle.hashCode());
		result = prime * result + ((orderComment == null) ? 0 : orderComment.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((payType == null) ? 0 : payType.hashCode());
		result = prime * result + ((payableAmount == null) ? 0 : payableAmount.hashCode());
		result = prime * result + ((saleDeliveryOrderStatus == null) ? 0 : saleDeliveryOrderStatus.hashCode());
		result = prime * result + ((taxpayerId == null) ? 0 : taxpayerId.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((userAccountId == null) ? 0 : userAccountId.hashCode());
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
		SaleDeliveryOrderDTO other = (SaleDeliveryOrderDTO) obj;
		if (consignee == null) {
			if (other.consignee != null)
				return false;
		} else if (!consignee.equals(other.consignee))
			return false;
		if (consigneeCellPhoneNumber == null) {
			if (other.consigneeCellPhoneNumber != null)
				return false;
		} else if (!consigneeCellPhoneNumber.equals(other.consigneeCellPhoneNumber))
			return false;
		if (couponAmount == null) {
			if (other.couponAmount != null)
				return false;
		} else if (!couponAmount.equals(other.couponAmount))
			return false;
		if (deliveryAddress == null) {
			if (other.deliveryAddress != null)
				return false;
		} else if (!deliveryAddress.equals(other.deliveryAddress))
			return false;
		if (deliveryTime == null) {
			if (other.deliveryTime != null)
				return false;
		} else if (!deliveryTime.equals(other.deliveryTime))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (freight == null) {
			if (other.freight != null)
				return false;
		} else if (!freight.equals(other.freight))
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
		if (invoiceTitle == null) {
			if (other.invoiceTitle != null)
				return false;
		} else if (!invoiceTitle.equals(other.invoiceTitle))
			return false;
		if (orderComment == null) {
			if (other.orderComment != null)
				return false;
		} else if (!orderComment.equals(other.orderComment))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (payType == null) {
			if (other.payType != null)
				return false;
		} else if (!payType.equals(other.payType))
			return false;
		if (payableAmount == null) {
			if (other.payableAmount != null)
				return false;
		} else if (!payableAmount.equals(other.payableAmount))
			return false;
		if (saleDeliveryOrderStatus == null) {
			if (other.saleDeliveryOrderStatus != null)
				return false;
		} else if (!saleDeliveryOrderStatus.equals(other.saleDeliveryOrderStatus))
			return false;
		if (taxpayerId == null) {
			if (other.taxpayerId != null)
				return false;
		} else if (!taxpayerId.equals(other.taxpayerId))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (userAccountId == null) {
			if (other.userAccountId != null)
				return false;
		} else if (!userAccountId.equals(other.userAccountId))
			return false;
		
		for(SaleDeliveryOrderItemDTO saleDeliveryOrderItem : this.getSaleDeliveryOrderItems()) {
			Boolean result = false;
			
			for(SaleDeliveryOrderItemDTO otherSaleDeliveryOrderItem : other.getSaleDeliveryOrderItems()) {
				if(saleDeliveryOrderItem.equals(otherSaleDeliveryOrderItem)) {
					result = true;
					break;
				}
			}
			
			if(!result) {
				return result;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "SaleDeliveryOrderDTO [id=" + id + ", orderId=" + orderId + ", orderNo=" + orderNo + ", userAccountId="
				+ userAccountId + ", consignee=" + consignee + ", deliveryAddress=" + deliveryAddress
				+ ", consigneeCellPhoneNumber=" + consigneeCellPhoneNumber + ", freight=" + freight + ", payType="
				+ payType + ", totalAmount=" + totalAmount + ", discountAmount=" + discountAmount + ", couponAmount="
				+ couponAmount + ", payableAmount=" + payableAmount + ", invoiceTitle=" + invoiceTitle + ", taxpayerId="
				+ taxpayerId + ", orderComment=" + orderComment + ", saleDeliveryOrderStatus=" + saleDeliveryOrderStatus
				+ ", deliveryTime=" + deliveryTime + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ ", saleDeliveryOrderItems=" + saleDeliveryOrderItems + ", sendOutOrder=" + sendOutOrder
				+ ", logisticOrder=" + logisticOrder + "]";
	}
	
}
