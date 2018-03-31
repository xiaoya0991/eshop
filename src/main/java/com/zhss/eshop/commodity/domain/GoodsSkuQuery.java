package com.zhss.eshop.commodity.domain;

/**
 * 商品sku查询条件
 * @author zhonghuashishan
 *
 */
public class GoodsSkuQuery {

	/**
	 * 分页查询起始位置
	 */
	private Integer offset;
	/**
	 * 每页显示数据条数
	 */
	private Integer size;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品sku编号
	 */
	private String goodsSkuCode;
	
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
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsSkuCode() {
		return goodsSkuCode;
	}
	public void setGoodsSkuCode(String goodsSkuCode) {
		this.goodsSkuCode = goodsSkuCode;
	}
	
}
