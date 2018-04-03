package com.zhss.eshop.pay.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 支付交易流水
 * @author zhonghuashishan
 *
 */
public class PayTransactionDO extends AbstractObject {

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
	 * 订单应付金额
	 */
	private Double payableAmount;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	/**
	 * 用户支付账号
	 */
	private String userPayAccount;
	/**
	 * 交易渠道
	 */
	private Integer transactionChannel;
	/**
	 * 第三方支付交易编号
	 */
	private String transactionNumber;
	/**
	 * 第三方支付完成支付的时间
	 */
	private Date finishPayTime;
	/**
	 * 第三方支付的响应状态码
	 */
	private String responseCode;
	/**
	 * 支付交易状态
	 */
	private Integer status;
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
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	public String getUserPayAccount() {
		return userPayAccount;
	}
	public void setUserPayAccount(String userPayAccount) {
		this.userPayAccount = userPayAccount;
	}
	public Integer getTransactionChannel() {
		return transactionChannel;
	}
	public void setTransactionChannel(Integer transactionChannel) {
		this.transactionChannel = transactionChannel;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public Date getFinishPayTime() {
		return finishPayTime;
	}
	public void setFinishPayTime(Date finishPayTime) {
		this.finishPayTime = finishPayTime;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
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
		result = prime * result + ((finishPayTime == null) ? 0 : finishPayTime.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderInfoId == null) ? 0 : orderInfoId.hashCode());
		result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
		result = prime * result + ((payableAmount == null) ? 0 : payableAmount.hashCode());
		result = prime * result + ((responseCode == null) ? 0 : responseCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((transactionChannel == null) ? 0 : transactionChannel.hashCode());
		result = prime * result + ((transactionNumber == null) ? 0 : transactionNumber.hashCode());
		result = prime * result + ((userAccountId == null) ? 0 : userAccountId.hashCode());
		result = prime * result + ((userPayAccount == null) ? 0 : userPayAccount.hashCode());
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
		PayTransactionDO other = (PayTransactionDO) obj;
		if (finishPayTime == null) {
			if (other.finishPayTime != null) {
				return false;
			}
		} else if (!finishPayTime.equals(other.finishPayTime)) {
			return false;
		}
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
		if (payableAmount == null) {
			if (other.payableAmount != null) {
				return false;
			}
		} else if (!payableAmount.equals(other.payableAmount)) {
			return false;
		}
		if (responseCode == null) {
			if (other.responseCode != null) {
				return false;
			}
		} else if (!responseCode.equals(other.responseCode)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (transactionChannel == null) {
			if (other.transactionChannel != null) {
				return false;
			}
		} else if (!transactionChannel.equals(other.transactionChannel)) {
			return false;
		}
		if (transactionNumber == null) {
			if (other.transactionNumber != null) {
				return false;
			}
		} else if (!transactionNumber.equals(other.transactionNumber)) {
			return false;
		}
		if (userAccountId == null) {
			if (other.userAccountId != null) {
				return false;
			}
		} else if (!userAccountId.equals(other.userAccountId)) {
			return false;
		}
		if (userPayAccount == null) {
			if (other.userPayAccount != null) {
				return false;
			}
		} else if (!userPayAccount.equals(other.userPayAccount)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "PayTransactionDO [id=" + id + ", orderInfoId=" + orderInfoId + ", orderNo=" + orderNo
				+ ", payableAmount=" + payableAmount + ", userAccountId=" + userAccountId + ", userPayAccount="
				+ userPayAccount + ", transactionChannel=" + transactionChannel + ", transactionNumber="
				+ transactionNumber + ", finishPayTime=" + finishPayTime + ", responseCode=" + responseCode
				+ ", status=" + status + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
