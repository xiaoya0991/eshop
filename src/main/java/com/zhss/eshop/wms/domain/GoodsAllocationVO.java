package com.zhss.eshop.wms.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 货位
 * @author zhonghuashishan
 *
 */
public class GoodsAllocationVO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 货位编号
	 */
	private String code;
	/**
	 * 货位备注
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String toString() {
		return "GoodsAllocationVO [id=" + id + ", code=" + code + ", remark=" + remark + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
