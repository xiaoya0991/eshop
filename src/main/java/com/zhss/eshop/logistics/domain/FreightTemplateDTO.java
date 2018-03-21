package com.zhss.eshop.logistics.domain;

import java.util.Date;

import com.zhss.eshop.common.util.AbstractObject;

/**
 * 运费模板
 * @author zhonghuashishan
 *
 */
public class FreightTemplateDTO extends AbstractObject {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 运费模板的名称
	 */
	private String name;
	/**
	 * 运费模板的类型
	 */
	private Integer type;
	/**
	 * 运费模板的规则
	 */
	private String rule;
	/**
	 * 运费模板的备注
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
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
