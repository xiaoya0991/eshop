package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 品牌
 * @author zhonghuashishan
 *
 */
public class BrandDO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 品牌的中文名
	 */
	private String chineseName;
	/**
	 * 品牌的英文名
	 */
	private String englishName;
	/**
	 * 品牌的别名
	 */
	private String aliasName;
	/**
	 * 品牌介绍
	 */
	private String introduction;
	/**
	 * 品牌所在地
	 */
	private String location;
	/**
	 * 品牌logo的图片存储路径
	 */
	private String logoPath;
	/**
	 * 品牌授权认证的图片存储路径
	 */
	private String authVoucherPath;
	/**
	 * 品牌说明备注
	 */
	private String remark;
	/**
	 * 品牌的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 品牌的修改时间
	 */
	private Date gmtModified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getAuthVoucherPath() {
		return authVoucherPath;
	}
	public void setAuthVoucherPath(String authVoucherPath) {
		this.authVoucherPath = authVoucherPath;
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
