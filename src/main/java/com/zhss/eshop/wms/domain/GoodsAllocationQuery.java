package com.zhss.eshop.wms.domain;

/**
 * 货位查询条件
 * @author zhonghuashishan
 *
 */
public class GoodsAllocationQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示的数据条数
	 */
	private Integer size;
	/**
	 * 货位编号
	 */
	private String code;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
