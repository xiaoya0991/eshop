package com.zhss.eshop.order.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 订单操作日志
 * @author zhonghuashishan
 *
 */
public class OrderOperateLogDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderInfoId;
	/**
	 * 操作类型
	 */
	private Integer operateType;
	/**
	 * 操作内容
	 */
	private String operateContent;
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
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public String getOperateContent() {
		return operateContent;
	}
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
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
		result = prime * result + ((operateContent == null) ? 0 : operateContent.hashCode());
		result = prime * result + ((operateType == null) ? 0 : operateType.hashCode());
		result = prime * result + ((orderInfoId == null) ? 0 : orderInfoId.hashCode());
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
		OrderOperateLogDO other = (OrderOperateLogDO) obj;
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
		if (operateContent == null) {
			if (other.operateContent != null) {
				return false;
			}
		} else if (!operateContent.equals(other.operateContent)) {
			return false;
		}
		if (operateType == null) {
			if (other.operateType != null) {
				return false;
			}
		} else if (!operateType.equals(other.operateType)) {
			return false;
		}
		if (orderInfoId == null) {
			if (other.orderInfoId != null) {
				return false;
			}
		} else if (!orderInfoId.equals(other.orderInfoId)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "OrderOperateLogDO [id=" + id + ", orderInfoId=" + orderInfoId + ", operateType=" + operateType
				+ ", operateContent=" + operateContent + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ "]";
	}
	
}
