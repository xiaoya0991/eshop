package com.zhss.eshop.order.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 退货申请
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsApplyDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 退货原因
	 */
	private Integer returnGoodsReason;
	/**
	 * 退货备注
	 */
	private String returnGoodsComment;
	/**
	 * 退货申请状态
	 */
	private Integer returnGoodsApplyStatus;
	/**
	 * 退货物流单号
	 */
	private String returnGoodsLogisticCode;
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
	public Integer getReturnGoodsReason() {
		return returnGoodsReason;
	}
	public void setReturnGoodsReason(Integer returnGoodsReason) {
		this.returnGoodsReason = returnGoodsReason;
	}
	public String getReturnGoodsComment() {
		return returnGoodsComment;
	}
	public void setReturnGoodsComment(String returnGoodsComment) {
		this.returnGoodsComment = returnGoodsComment;
	}
	public Integer getReturnGoodsApplyStatus() {
		return returnGoodsApplyStatus;
	}
	public void setReturnGoodsApplyStatus(Integer returnGoodsApplyStatus) {
		this.returnGoodsApplyStatus = returnGoodsApplyStatus;
	}
	public String getReturnGoodsLogisticCode() {
		return returnGoodsLogisticCode;
	}
	public void setReturnGoodsLogisticCode(String returnGoodsLogisticCode) {
		this.returnGoodsLogisticCode = returnGoodsLogisticCode;
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
		result = prime * result + ((returnGoodsApplyStatus == null) ? 0 : returnGoodsApplyStatus.hashCode());
		result = prime * result + ((returnGoodsComment == null) ? 0 : returnGoodsComment.hashCode());
		result = prime * result + ((returnGoodsLogisticCode == null) ? 0 : returnGoodsLogisticCode.hashCode());
		result = prime * result + ((returnGoodsReason == null) ? 0 : returnGoodsReason.hashCode());
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
		ReturnGoodsApplyDO other = (ReturnGoodsApplyDO) obj;
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
		if (returnGoodsApplyStatus == null) {
			if (other.returnGoodsApplyStatus != null) {
				return false;
			}
		} else if (!returnGoodsApplyStatus.equals(other.returnGoodsApplyStatus)) {
			return false;
		}
		if (returnGoodsComment == null) {
			if (other.returnGoodsComment != null) {
				return false;
			}
		} else if (!returnGoodsComment.equals(other.returnGoodsComment)) {
			return false;
		}
		if (returnGoodsLogisticCode == null) {
			if (other.returnGoodsLogisticCode != null) {
				return false;
			}
		} else if (!returnGoodsLogisticCode.equals(other.returnGoodsLogisticCode)) {
			return false;
		}
		if (returnGoodsReason == null) {
			if (other.returnGoodsReason != null) {
				return false;
			}
		} else if (!returnGoodsReason.equals(other.returnGoodsReason)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "ReturnGoodsApplyDO [id=" + id + ", orderInfoId=" + orderInfoId + ", returnGoodsReason="
				+ returnGoodsReason + ", returnGoodsComment=" + returnGoodsComment + ", returnGoodsApplyStatus="
				+ returnGoodsApplyStatus + ", returnGoodsLogisticCode=" + returnGoodsLogisticCode + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
