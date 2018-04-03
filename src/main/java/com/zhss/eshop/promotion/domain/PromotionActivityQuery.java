package com.zhss.eshop.promotion.domain;

/**
 * 促销活动查询条件
 * @author zhonghuashishan
 *
 */
public class PromotionActivityQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 分页查询记录数
	 */
	private Integer size;
	/**
	 * 促销活动名称
	 */
	private String name;
	/**
	 * 促销活动开始时间
	 */
	private String startTime;
	/**
	 * 促销活动结束时间
	 */
	private String endTime;
	/**
	 * 促销活动状态
	 */
	private Integer status;
	/**
	 * 促销活动类型
	 */
	private Integer type;
	
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
