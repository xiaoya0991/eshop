package com.zhss.eshop.purchase.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 供应商
 * @author zhonghuashishan
 *
 */
public class SupplierDTO extends AbstractObject {

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
	
}
