package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 物流单
 * @author zhonghuashishan
 *
 */
public class LogisticOrderDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 销售出库单id
	 */
	private Long saleDeliveryOrderId;
	/**
	 * 物流单号
	 */
	private String logisticCode;
	/**
	 * 物流单内容
	 */
	private String content;
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
	public Long getSaleDeliveryOrderId() {
		return saleDeliveryOrderId;
	}
	public void setSaleDeliveryOrderId(Long saleDeliveryOrderId) {
		this.saleDeliveryOrderId = saleDeliveryOrderId;
	}
	public String getLogisticCode() {
		return logisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logisticCode == null) ? 0 : logisticCode.hashCode());
		result = prime * result + ((saleDeliveryOrderId == null) ? 0 : saleDeliveryOrderId.hashCode());
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
		LogisticOrderDO other = (LogisticOrderDO) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
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
		if (logisticCode == null) {
			if (other.logisticCode != null) {
				return false;
			}
		} else if (!logisticCode.equals(other.logisticCode)) {
			return false;
		}
		if (saleDeliveryOrderId == null) {
			if (other.saleDeliveryOrderId != null) {
				return false;
			}
		} else if (!saleDeliveryOrderId.equals(other.saleDeliveryOrderId)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "LogisticOrderDO [id=" + id + ", saleDeliveryOrderId=" + saleDeliveryOrderId + ", logisticCode="
				+ logisticCode + ", content=" + content + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ "]";
	}
	
}
