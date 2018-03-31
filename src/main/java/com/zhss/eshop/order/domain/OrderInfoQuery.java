package com.zhss.eshop.order.domain;

/**
 * 订单查询条件
 * @author zhonghuashishan
 *
 */
public class OrderInfoQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示数据条数
	 */
	private Integer size;
	/**
	 * 用户账号id
	 */
	private Long userAccountId;
	
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
	public Long getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}
	
}
