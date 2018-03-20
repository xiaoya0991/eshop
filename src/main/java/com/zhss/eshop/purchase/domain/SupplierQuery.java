package com.zhss.eshop.purchase.domain;

/**
 * 供应商查询条件
 * @author zhonghuashishan
 *
 */
public class SupplierQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示的数据条数
	 */
	private Integer size;
	/**
	 * 供应商名称
	 */
	private String name;
	/**
	 * 结算周期
	 */
	private Integer settlementPeriod;
	
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
	public Integer getSettlementPeriod() {
		return settlementPeriod;
	}
	public void setSettlementPeriod(Integer settlementPeriod) {
		this.settlementPeriod = settlementPeriod;
	}
	
}
