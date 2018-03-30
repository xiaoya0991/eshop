package com.zhss.eshop.commodity.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 商品
 * @author zhonghuashishan
 *
 */
public class GoodsDO extends AbstractObject {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((freightTemplateId == null) ? 0 : freightTemplateId.hashCode());
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((grossWeight == null) ? 0 : grossWeight.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((packageList == null) ? 0 : packageList.hashCode());
		result = prime * result + ((serviceGuarantees == null) ? 0 : serviceGuarantees.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subName == null) ? 0 : subName.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
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
		GoodsDO other = (GoodsDO) obj;
		if (brandId == null) {
			if (other.brandId != null) {
				return false;
			}
		} else if (!brandId.equals(other.brandId)) {
			return false;
		}
		if (categoryId == null) {
			if (other.categoryId != null) {
				return false;
			}
		} else if (!categoryId.equals(other.categoryId)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (freightTemplateId == null) {
			if (other.freightTemplateId != null) {
				return false;
			}
		} else if (!freightTemplateId.equals(other.freightTemplateId)) {
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
		if (grossWeight == null) {
			if (other.grossWeight != null) {
				return false;
			}
		} else if (!grossWeight.equals(other.grossWeight)) {
			return false;
		}
		if (height == null) {
			if (other.height != null) {
				return false;
			}
		} else if (!height.equals(other.height)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (length == null) {
			if (other.length != null) {
				return false;
			}
		} else if (!length.equals(other.length)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (packageList == null) {
			if (other.packageList != null) {
				return false;
			}
		} else if (!packageList.equals(other.packageList)) {
			return false;
		}
		if (serviceGuarantees == null) {
			if (other.serviceGuarantees != null) {
				return false;
			}
		} else if (!serviceGuarantees.equals(other.serviceGuarantees)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (subName == null) {
			if (other.subName != null) {
				return false;
			}
		} else if (!subName.equals(other.subName)) {
			return false;
		}
		if (width == null) {
			if (other.width != null) {
				return false;
			}
		} else if (!width.equals(other.width)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "GoodsDO [id=" + id + ", categoryId=" + categoryId + ", brandId=" + brandId + ", code=" + code
				+ ", name=" + name + ", subName=" + subName + ", grossWeight=" + grossWeight + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", status=" + status + ", serviceGuarantees="
				+ serviceGuarantees + ", packageList=" + packageList + ", freightTemplateId=" + freightTemplateId
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
