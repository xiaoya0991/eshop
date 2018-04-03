package com.zhss.eshop.purchase.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 供应商
 * @author zhonghuashishan
 *
 */
public class SupplierDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 供应商名称
	 */
	private String name;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 公司地址
	 */
	private String companyAddress;
	/**
	 * 联系人
	 */
	private String contactor;
	/**
	 * 联系人电话号码
	 */
	private String contactorPhoneNumber;
	/**
	 * 结算周期
	 */
	private Integer settlementPeriod;
	/**
	 * 开户银行名称
	 */
	private String bankName;
	/**
	 * 开户银行账号
	 */
	private String bankAccount;
	/**
	 * 开户银行账号持有人
	 */
	private String bankAccountHolder;
	/**
	 * 发票抬头
	 */
	private String invoiceTitle;
	/**
	 * 纳税人识别号
	 */
	private String taxpayerId;
	/**
	 * 经营范围
	 */
	private String businessScope;
	/**
	 * 备注
	 */
	private String remark;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	public Integer getSettlementPeriod() {
		return settlementPeriod;
	}
	public void setSettlementPeriod(Integer settlementPeriod) {
		this.settlementPeriod = settlementPeriod;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankAccountHolder() {
		return bankAccountHolder;
	}
	public void setBankAccountHolder(String bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
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
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((bankAccountHolder == null) ? 0 : bankAccountHolder.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((businessScope == null) ? 0 : businessScope.hashCode());
		result = prime * result + ((companyAddress == null) ? 0 : companyAddress.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((contactor == null) ? 0 : contactor.hashCode());
		result = prime * result + ((contactorPhoneNumber == null) ? 0 : contactorPhoneNumber.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceTitle == null) ? 0 : invoiceTitle.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((settlementPeriod == null) ? 0 : settlementPeriod.hashCode());
		result = prime * result + ((taxpayerId == null) ? 0 : taxpayerId.hashCode());
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
		SupplierDO other = (SupplierDO) obj;
		if (bankAccount == null) {
			if (other.bankAccount != null) {
				return false;
			}
		} else if (!bankAccount.equals(other.bankAccount)) {
			return false;
		}
		if (bankAccountHolder == null) {
			if (other.bankAccountHolder != null) {
				return false;
			}
		} else if (!bankAccountHolder.equals(other.bankAccountHolder)) {
			return false;
		}
		if (bankName == null) {
			if (other.bankName != null) {
				return false;
			}
		} else if (!bankName.equals(other.bankName)) {
			return false;
		}
		if (businessScope == null) {
			if (other.businessScope != null) {
				return false;
			}
		} else if (!businessScope.equals(other.businessScope)) {
			return false;
		}
		if (companyAddress == null) {
			if (other.companyAddress != null) {
				return false;
			}
		} else if (!companyAddress.equals(other.companyAddress)) {
			return false;
		}
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (contactor == null) {
			if (other.contactor != null) {
				return false;
			}
		} else if (!contactor.equals(other.contactor)) {
			return false;
		}
		if (contactorPhoneNumber == null) {
			if (other.contactorPhoneNumber != null) {
				return false;
			}
		} else if (!contactorPhoneNumber.equals(other.contactorPhoneNumber)) {
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
		if (invoiceTitle == null) {
			if (other.invoiceTitle != null) {
				return false;
			}
		} else if (!invoiceTitle.equals(other.invoiceTitle)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (settlementPeriod == null) {
			if (other.settlementPeriod != null) {
				return false;
			}
		} else if (!settlementPeriod.equals(other.settlementPeriod)) {
			return false;
		}
		if (taxpayerId == null) {
			if (other.taxpayerId != null) {
				return false;
			}
		} else if (!taxpayerId.equals(other.taxpayerId)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "SupplierDO [id=" + id + ", name=" + name + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", contactor=" + contactor + ", contactorPhoneNumber=" + contactorPhoneNumber
				+ ", settlementPeriod=" + settlementPeriod + ", bankName=" + bankName + ", bankAccount=" + bankAccount
				+ ", bankAccountHolder=" + bankAccountHolder + ", invoiceTitle=" + invoiceTitle + ", taxpayerId="
				+ taxpayerId + ", businessScope=" + businessScope + ", remark=" + remark + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
