package com.zhss.eshop.customer.domain;

/**
 * 退货工单查询条件
 * @author zhonghuashishan
 *
 */
public class ReturnGoodsWorksheetQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示的数据条数
	 */
	private Integer size;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 退货工单状态
	 */
	private Integer status;
	/**
	 * 退货原因
	 */
	private Integer returnGoodsReason;
	/**
	 * 退货快递单号
	 */
	private String returnGoodsLogisticsCode;
	
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReturnGoodsReason() {
		return returnGoodsReason;
	}
	public void setReturnGoodsReason(Integer returnGoodsReason) {
		this.returnGoodsReason = returnGoodsReason;
	}
	public String getReturnGoodsLogisticsCode() {
		return returnGoodsLogisticsCode;
	}
	public void setReturnGoodsLogisticsCode(String returnGoodsLogisticsCode) {
		this.returnGoodsLogisticsCode = returnGoodsLogisticsCode;
	}
	
}
