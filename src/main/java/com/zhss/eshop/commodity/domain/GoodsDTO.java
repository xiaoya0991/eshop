package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品
 * @author zhonghuashishan
 *
 */
public class GoodsDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 类目id
	 */
	private Long categoryId;
	/**
	 * 品牌id
	 */
	private Long brandId;
	/**
	 * 商品编号
	 */
	private String code;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品副名称
	 */
	private String subName;
	/**
	 * 商品毛重
	 */
	private Double grossWeight;
	/**
	 * 商品长度
	 */
	private Double length;
	/**
	 * 商品宽度
	 */
	private Double width;
	/**
	 * 商品高度
	 */
	private Double height;
	/**
	 * 商品状态
	 */
	private Integer status;
	/**
	 * 服务保证
	 */
	private String serviceGuarantees;
	/**
	 * 包装清单
	 */
	private String packageList;
	/**
	 * 运费模板id
	 */
	private Long freightTemplateId;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getServiceGuarantees() {
		return serviceGuarantees;
	}
	public void setServiceGuarantees(String serviceGuarantees) {
		this.serviceGuarantees = serviceGuarantees;
	}
	public String getPackageList() {
		return packageList;
	}
	public void setPackageList(String packageList) {
		this.packageList = packageList;
	}
	public Long getFreightTemplateId() {
		return freightTemplateId;
	}
	public void setFreightTemplateId(Long freightTemplateId) {
		this.freightTemplateId = freightTemplateId;
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
	public String toString() {
		return "GoodsDTO [id=" + id + ", categoryId=" + categoryId + ", brandId=" + brandId + ", code=" + code
				+ ", name=" + name + ", subName=" + subName + ", grossWeight=" + grossWeight + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", status=" + status + ", serviceGuarantees="
				+ serviceGuarantees + ", packageList=" + packageList + ", freightTemplateId=" + freightTemplateId
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
