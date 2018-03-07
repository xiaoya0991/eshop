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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aliasName == null) ? 0 : aliasName.hashCode());
		result = prime * result + ((authVoucherPath == null) ? 0 : authVoucherPath.hashCode());
		result = prime * result + ((chineseName == null) ? 0 : chineseName.hashCode());
		result = prime * result + ((englishName == null) ? 0 : englishName.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((logoPath == null) ? 0 : logoPath.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		BrandDO other = (BrandDO) obj;
		if (aliasName == null) {
			if (other.aliasName != null)
				return false;
		} else if (!aliasName.equals(other.aliasName))
			return false;
		if (authVoucherPath == null) {
			if (other.authVoucherPath != null)
				return false;
		} else if (!authVoucherPath.equals(other.authVoucherPath))
			return false;
		if (chineseName == null) {
			if (other.chineseName != null)
				return false;
		} else if (!chineseName.equals(other.chineseName))
			return false;
		if (englishName == null) {
			if (other.englishName != null)
				return false;
		} else if (!englishName.equals(other.englishName))
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
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (logoPath == null) {
			if (other.logoPath != null)
				return false;
		} else if (!logoPath.equals(other.logoPath))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}
	
}
