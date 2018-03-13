package com.zhss.eshop.promotion.domain;

/**
 * 优惠券查询条件
 * @author zhonghuashishan
 *
 */
public class CouponQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示的数据条数
	 */
	private Integer size;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 优惠群类型
	 */
	private Integer type;
	/**
	 * 有效期开始时间
	 */
	private String validStartTime;
	/**
	 * 有效期结束时间
	 */
	private String validEndTime;
	/**
	 * 发放类型
	 */
	private Integer giveOutType;
	/**
	 * 优惠券状态
	 */
	private Integer status;
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getValidStartTime() {
		return validStartTime;
	}
	public void setValidStartTime(String validStartTime) {
		this.validStartTime = validStartTime;
	}
	public String getValidEndTime() {
		return validEndTime;
	}
	public void setValidEndTime(String validEndTime) {
		this.validEndTime = validEndTime;
	}
	public Integer getGiveOutType() {
		return giveOutType;
	}
	public void setGiveOutType(Integer giveOutType) {
		this.giveOutType = giveOutType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
