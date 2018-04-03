package com.zhss.eshop.customer.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货工单
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsWorksheetDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 退货工单的状态
	 */
	private Integer status;
	/**
	 * 退货原因
	 */
	private Integer returnGoodsReason;
	/**
	 * 退货备注
	 */
	private String returnGoodsRemark;
	/**
	 * 退货物流单号
	 */
	private String returnGoodsLogisticsCode;
	/**
	 * 退货工单的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 退货工单的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReturnGoodsReason() {
		return returnGoodsReason;
	}
	public void setReturnGoodsReason(Integer returnGoodsReason) {
		this.returnGoodsReason = returnGoodsReason;
	}
	public String getReturnGoodsRemark() {
		return returnGoodsRemark;
	}
	public void setReturnGoodsRemark(String returnGoodsRemark) {
		this.returnGoodsRemark = returnGoodsRemark;
	}
	public String getReturnGoodsLogisticsCode() {
		return returnGoodsLogisticsCode;
	}
	public void setReturnGoodsLogisticsCode(String returnGoodsLogisticsCode) {
		this.returnGoodsLogisticsCode = returnGoodsLogisticsCode;
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
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderInfoId == null) ? 0 : orderInfoId.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((returnGoodsLogisticsCode == null) ? 0 : returnGoodsLogisticsCode.hashCode());
		result = prime * result + ((returnGoodsReason == null) ? 0 : returnGoodsReason.hashCode());
		result = prime * result + ((returnGoodsRemark == null) ? 0 : returnGoodsRemark.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ReturnGoodsWorksheetDO other = (ReturnGoodsWorksheetDO) obj;
		if (gmtCreate == null) {
			if (other.gmtCreate != null) {
				return false;
			}
		} else if (!gmtCreate.equals(other.gmtCreate)) {
			return false;
		}
		if (gmtModified == null) {
			if (other.gmtModified != null) {
				return false;
			}
		} else if (!gmtModified.equals(other.gmtModified)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orderInfoId == null) {
			if (other.orderInfoId != null) {
				return false;
			}
		} else if (!orderInfoId.equals(other.orderInfoId)) {
			return false;
		}
		if (orderNo == null) {
			if (other.orderNo != null) {
				return false;
			}
		} else if (!orderNo.equals(other.orderNo)) {
			return false;
		}
		if (returnGoodsLogisticsCode == null) {
			if (other.returnGoodsLogisticsCode != null) {
				return false;
			}
		} else if (!returnGoodsLogisticsCode.equals(other.returnGoodsLogisticsCode)) {
			return false;
		}
		if (returnGoodsReason == null) {
			if (other.returnGoodsReason != null) {
				return false;
			}
		} else if (!returnGoodsReason.equals(other.returnGoodsReason)) {
			return false;
		}
		if (returnGoodsRemark == null) {
			if (other.returnGoodsRemark != null) {
				return false;
			}
		} else if (!returnGoodsRemark.equals(other.returnGoodsRemark)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "ReturnGoodsWorksheetDO [id=" + id + ", orderInfoId=" + orderInfoId + ", orderNo=" + orderNo
				+ ", status=" + status + ", returnGoodsReason=" + returnGoodsReason + ", returnGoodsRemark="
				+ returnGoodsRemark + ", returnGoodsLogisticsCode=" + returnGoodsLogisticsCode + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
